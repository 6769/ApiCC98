package win.pipi.api.authorizationserver;

public class AuthorizationInfo {
    private final static int port = 8090;
    private final static String appid = "916b6d48-f419-4e1c-0aae-08d5511c3131";
    private final static String appsec = "f90249e8-4deb-4874-90a6-0185127e8cef";
    private final static String scope = "cc98-api openid";
    private final static String grant_type = "authorization_code";
    private final static String local_node = "oauth";
    private final static String redirect_uri = String.format("http://localhost:%d/%s", port, local_node);

    public static final String OPENID_URL = "https://openid.cc98.org/";

    public static final String INIT_AUTHOR_URL = "https://openid.cc98.org/connect/authorize?" +
            "client_id=916b6d48-f419-4e1c-0aae-08d5511c3131&scope=cc98-api+openid&response_type=code&redirect_uri=http%3A%2F%2Flocalhost%3A8090%2Foauth&state=1234";


    public static String getLocal_node() {
        return local_node;
    }

    public static int getPort() {
        return port;
    }

    public static String getAppid() {
        return appid;
    }

    public static String getAppsec() {
        return appsec;
    }

    public static String getScope() {
        return scope;
    }

    public static String getGrant_type() {
        return grant_type;
    }

    public static String getRedirect_uri() {
        return redirect_uri;
    }

    private static AccessTokenPayload userToken;

    public static AccessTokenPayload getUserToken() {
        return userToken;
    }

    public static void setUserToken(AccessTokenPayload userToken) {
        AuthorizationInfo.userToken = userToken;
    }

    public static class InitRequestPayload {
        //init url build,if need more improvement;
    }


    public static class PostCodePayload {
        String grant_type = AuthorizationInfo.grant_type;
        String client_id = appid;
        String client_secret = appsec;
        String code;
        String redirect_uri = AuthorizationInfo.redirect_uri;

        public PostCodePayload(String code) {
            this.code = code;
        }
    }

    public static class PostRefreshPayload {
    }

    public static class AccessTokenPayload {

        /**
         * id_token : eyJhbGciOiJSUzI1NiIsImtpZCI6IkU0MTJ
         * access_token : eyJhbGciOiJSUzI1NiIsImtpZCI6IkU0M
         * expires_in : 3600
         * token_type : Bearer
         */

        private String id_token;
        private String access_token;
        private int expires_in;
        private String token_type;

        public String getId_token() {
            return id_token;
        }

        public void setId_token(String id_token) {
            this.id_token = id_token;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }

        public String getToken_type() {
            return token_type;
        }

        public void setToken_type(String token_type) {
            this.token_type = token_type;
        }
    }


}
