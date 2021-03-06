package win.pipi.api.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class CC98APIManager {

    public static final String AUTH_PARA_HEADER="Authorization";
    public static final String MAGIC1="Bearer ";
    private static String AccessToken="";

    public static String getAccessToken() {
        return AccessToken;
    }

    public synchronized static void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }


    public static CC98APIInterface createApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CC98APIInterface.BASE_URL)
                .client(genericClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(CC98APIInterface.class);
    }


    protected static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                //.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                //.addHeader("Accept-Encoding", "gzip, deflate")
                                //.addHeader("Connection", "keep-alive")
                                //.addHeader("Accept", "*/*")
                                //.addHeader("Cookie", "add cookies here")
                                .addHeader(AUTH_PARA_HEADER, MAGIC1+AccessToken)
                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();

        return httpClient;
    }
}