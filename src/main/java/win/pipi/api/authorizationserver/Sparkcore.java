package win.pipi.api.authorizationserver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import spark.Redirect;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static spark.Spark.*;


public class Sparkcore {

    protected OpenIDConnect openIDConnectHandler;
    protected Gson gsonHandler;

    protected static Type type;

    public Sparkcore() {
        openIDConnectHandler = openIDConnectRequestBuilder();
        gsonHandler = new Gson();
        type = new TypeToken<Map<String, String>>() {
        }.getType();

    }


    public static void main(String[] args) {

        Sparkcore sparkcore = new Sparkcore();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sparkcore.backenAuthServer();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }


    public void backenAuthServer() {


        port(AuthorizationInfo.getPort());

        redirect.any("/", AuthorizationInfo.INIT_AUTHOR_URL, Redirect.Status.MOVED_PERMANENTLY);
        get("/" + AuthorizationInfo.getLocal_node(), (request, response) -> {
            String code = request.queryParams("code");
            if (code.isEmpty()) {
                halt(401, "Authorization Error:No Code Return");
            }
            //invoke http client to request accesstoken;
            AuthorizationInfo.PostCodePayload payload = new AuthorizationInfo.PostCodePayload(code);
            String json = gsonHandler.toJson(payload);

            Map<String, String> formdata = gsonHandler.fromJson(json, type);

            Call<AuthorizationInfo.AccessTokenPayload> call = openIDConnectHandler.postGrantedCode(formdata);

            Response<AuthorizationInfo.AccessTokenPayload> response1 = call.execute();
            if (response1.code() >= 400) {
                halt(402, "Request Token Failed.");
            }
            AuthorizationInfo.AccessTokenPayload accessToken = response1.body();

            AuthorizationInfo.setUserToken(accessToken);

            byte[] tokenbytes = accessToken.getAccess_token().getBytes();
            String path = "auth.test.keys";
            Path fp = Paths.get("src", "test", "resources", path);
            Files.write(fp, tokenbytes);

            response.status(200);
            return gsonHandler.toJson(accessToken);
        });


    }

    public static OpenIDConnect openIDConnectRequestBuilder() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                //.addNetworkInterceptor(authorizationInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OpenIDConnect.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(OpenIDConnect.class);
    }
}
