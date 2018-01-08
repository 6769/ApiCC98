package win.pipi.api.authorization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import retrofit2.Call;
import retrofit2.Response;
import win.pipi.api.authorization.beans.AccessTokenPayload;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;

public class LoginCC98 {
    private final static Type type;
    private final static OpenIDConnect openIDConnect;
    private final static Gson gson = new Gson();

    static {
        type = new TypeToken<Map<String, String>>() {
        }.getType();
        openIDConnect = OpenIDConnect.openIDConnectRequestBuilder();
    }

    private AccessTokenPayload accessTokenPayload;
    private long lastSuccessLogin = 0;
    private String username;
    private String password;

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

    public String getSavedAccessToken() {

        String no = "";
        if (accessTokenPayload == null)
            return no;
        else if (!isInValidPeriod())
            return no;
        else
            return accessTokenPayload.getAccess_token();
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

}
