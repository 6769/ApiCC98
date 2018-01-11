package win.pipi.api.authorization;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import win.pipi.api.authorization.beans.AccessTokenPayload;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface OpenIDConnect {
    String BASE_URL = AuthorizationInfo.OPENID_URL;


    @POST("connect/token")
    @FormUrlEncoded
    Call<AccessTokenPayload> postGrantedCode(@FieldMap Map<String, String> payload);


    @POST("connect/token")
    @FormUrlEncoded
    Call<AccessTokenPayload> postPasword(@FieldMap Map<String, String> payload);

    @POST("connect/token")
    @FormUrlEncoded
    Observable<AccessTokenPayload> postPaswordRx(@FieldMap Map<String, String> payload);



}
