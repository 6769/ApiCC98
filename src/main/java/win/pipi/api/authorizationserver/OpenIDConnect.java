package win.pipi.api.authorizationserver;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface OpenIDConnect {
    public final String BASE_URL = AuthorizationInfo.OPENIDURL;


    @POST("connect/token")
    @FormUrlEncoded
    Call<AuthorizationInfo.AccessTokenPayload> postGrantedCode(@FieldMap Map<String, String> payload);


    @POST("connect/token")
    Call<String> refreshToken(@Body Object obj);

}
