package win.pipi.api.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import win.pipi.api.authorization.LoginCC98;
import win.pipi.api.authorization.LoginException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CC98APIManager {

    private static final String AUTH_PARA_HEADER = "authorization";
    private static final int DEFAULT_TIMEOUT = 10;
    private static final String MAGIC1 = "Bearer ";
    private String accessToken;
    private LoginCC98 loginCC98;

    public CC98APIManager(LoginCC98 loginCC98) {
        this.loginCC98 = loginCC98;
    }

    public CC98APIManager() {
        this.loginCC98 = new LoginCC98();
    }

    public CC98APIInterface createApiClient() {
        accessToken = loginCC98.getSavedAccessToken();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CC98APIInterface.BASE_URL)
                .client(genericClient(accessToken))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(CC98APIInterface.class);
    }


    protected OkHttpClient genericClient(String accessToken) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //System.out.println("Conduct Each time");
                        Request request = chain.request()
                                .newBuilder()
                                //.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                //.addHeader("Accept-Encoding", "gzip, deflate")
                                .header("Connection", "keep-alive")
                                .header("Cache-Control", "no-cache")
                                //.addHeader("Accept", "*/*")
                                //.addHeader("Cookie", "add cookies here")
                                .header(AUTH_PARA_HEADER, MAGIC1 + loginCC98.getSavedAccessToken())
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(new TokenInterceptor())
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        return httpClient;
    }

    public class TokenInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            if (isTokenExpired(response)) {//根据和服务端的约定判断token过期
                System.out.println("refreshToken");

                //同步请求方式，获取最新的Token
                String newSession = getNewToken();
                //使用新的Token，创建新的请求
                Request newRequest = chain.request()
                        .newBuilder()
                        .header(AUTH_PARA_HEADER, MAGIC1 + newSession)
                        .build();
                //重新请求
                return chain.proceed(newRequest);
            }
            return response;
        }

        /**
         * 根据Response，判断Token是否失效
         *
         * @param response
         * @return
         */
        private boolean isTokenExpired(Response response) {
            if (response.code() == 401) {
                return true;
            }
            return false;
        }

        /**
         * 同步请求方式，获取最新的Token
         *
         * @return
         */
        private String getNewToken() throws IOException {
            if (loginCC98.login() == 200) {
                return loginCC98.getSavedAccessToken();
            }
            throw new IOException("Login Error", new LoginException());
        }
    }
}