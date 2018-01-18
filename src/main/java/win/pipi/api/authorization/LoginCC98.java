package win.pipi.api.authorization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import win.pipi.api.authorization.beans.AccessTokenPayload;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginCC98 {
    private final static Type type;
    private final static OpenIDConnect openIDConnect;
    private final static Gson gson = new Gson();

    static {
        type = new TypeToken<Map<String, String>>() {
        }.getType();
        openIDConnect = openIDConnectRequestBuilder();
    }

    public void setAccessTokenPayload(AccessTokenPayload accessTokenPayload) {
        this.accessTokenPayload = accessTokenPayload;
    }

    private AccessTokenPayload accessTokenPayload=new AccessTokenPayload();
    private long lastSuccessLogin = 0;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LoginCC98(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginCC98(long lastSuccessLogin, String username, String password) {
        this.lastSuccessLogin = lastSuccessLogin;
        this.username = username;
        this.password = password;
    }

    public LoginCC98() {
    }

    public boolean isInValidPeriod() {

        long currentT = System.currentTimeMillis();
        return (currentT - lastSuccessLogin) / 1000 < 3600;

    }

    public void setSavedToken(String token){
        if (token!=null && !token.isEmpty()){
            accessTokenPayload.setAccess_token(token);
        }
    }

    public String getSavedAccessToken() {

        String no = "";
        if (accessTokenPayload == null)
            return no;
        else if (!isInValidPeriod())
            return no;
        else
            return accessTokenPayload.getAccess_token();
    }

    public Observable<AccessTokenPayload> loginRx(){
        AuthorizationInfo.PostPasswordPayload payload = new AuthorizationInfo.PostPasswordPayload(username, password);

        String json = gson.toJson(payload);
        Map<String, String> postpayload = gson.fromJson(json, type);
        return openIDConnect.postPaswordRx(postpayload);
    }

    public int login() {
        AuthorizationInfo.PostPasswordPayload payload = new AuthorizationInfo.PostPasswordPayload(username, password);

        String json = gson.toJson(payload);
        Map<String, String> postpayload = gson.fromJson(json, type);
        Call<AccessTokenPayload> call = openIDConnect.postPasword(postpayload);

        try {
            Response<AccessTokenPayload> tokenPayload = call.execute();
            accessTokenPayload = tokenPayload.body();
            int code = tokenPayload.code();
            if (code == 200) {
                lastSuccessLogin = System.currentTimeMillis();
            }
            return code;
        } catch (IOException e) {
            return Integer.MAX_VALUE;
        }

    }

    static OpenIDConnect openIDConnectRequestBuilder() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(8, TimeUnit.SECONDS)
                //.addNetworkInterceptor(authorizationInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OpenIDConnect.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(OpenIDConnect.class);
    }

}
