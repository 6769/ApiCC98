package win.pipi.api.authorization;

import win.pipi.api.authorization.beans.AccessTokenPayload;

public class AuthorizationInfo {
    private final static int port = 8090;
    private final static String appid = "9a1fd200-8687-44b1-4c20-08d50a96e5cd";
    private final static String appsec = "8b53f727-08e2-4509-8857-e34bf92b27f2";
    private final static String scope = "cc98-api openid";
    private final static String grant_type = "password";
    private final static String local_node = "oauth";
    private final static String redirect_uri = String.format("http://localhost:%d/%s", port, local_node);

    public static final String OPENID_URL = "https://openid.cc98.org/";


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


    public static class PostPasswordPayload {
        final String grant_type = AuthorizationInfo.grant_type;
        final String client_id = appid;
        final String client_secret = appsec;
        final String scope = AuthorizationInfo.scope;
        String username;
        String password;

        public PostPasswordPayload(String username, String password) {
            this.username = username;
            this.password = password;
        }

    }


}
