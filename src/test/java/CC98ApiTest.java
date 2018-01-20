import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import win.pipi.api.authorization.AuthorizationInfo;
import win.pipi.api.authorization.LoginCC98;
import win.pipi.api.authorization.OpenIDConnect;
import win.pipi.api.authorization.beans.AccessTokenPayload;
import win.pipi.api.authorization.beans.ErrorPayload;
import win.pipi.api.data.GroupBoardInfo;
import win.pipi.api.data.HotTopicInfo;
import win.pipi.api.data.TopicInfo;
import win.pipi.api.data.TopicInfoInterface;
import win.pipi.api.network.CC98APIInterface;
import win.pipi.api.network.CC98APIManager;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class CC98ApiTest {


    private static CC98APIInterface request;
    private static OpenIDConnect openIDConnect;
    private static Type type;
    private static LoginCC98 loginCC98;

    static {
        loginCC98 = new LoginCC98();
        request = new CC98APIManager(loginCC98).createApiClient();
        type = new TypeToken<Map<String, String>>() {
        }.getType();
    }

    @Test
    public void testPassWordToken() throws Exception {
        String username = "";
        String password = "";


        AuthorizationInfo.PostPasswordPayload payload = new AuthorizationInfo.PostPasswordPayload(username, password);
        Gson gson = new Gson();
        String json = gson.toJson(payload);
        Map<String, String> postpayload = gson.fromJson(json, type);
        Call<AccessTokenPayload> call = openIDConnect.postPasword(postpayload);
        Response<AccessTokenPayload> tokenPayload = call.execute();
        AccessTokenPayload realtokenPayload = tokenPayload.body();
        if (tokenPayload.code() > 200) {
            String err = tokenPayload.errorBody().string();
            ErrorPayload errorPayload = gson.fromJson(err, ErrorPayload.class);
            print(errorPayload.getError_description());
            return;
        }

        String accesstoken = realtokenPayload.getAccess_token();
        System.out.println(realtokenPayload);
    }

    @Test
    public void testHotTopic() throws Exception {


        Observable<ArrayList<HotTopicInfo>> call = request.getTopicHot();
        usedCall(call);

    }

    @Test
    public void testDupHotTopic() throws Exception {


        Observable<ArrayList<HotTopicInfo>> call = request.getTopicHot();
        Observable<ArrayList<HotTopicInfo>> call2 = request.getTopicHot();
        usedCall(call);
        usedCall(call2);

    }

    @Test
    public void testSearchGlob() throws Exception {
        String key = "时间";
        Observable<ArrayList<TopicInfo>> call = request.searchTopicGlobal(key, 0, 20);
        usedCall(call);
    }

    @Test
    public void testSearchSpecic() throws Exception {
        String key = "时间";
        Observable<ArrayList<TopicInfo>> call = request.searchTopicUnderBoard(100, key, 0, 20);
        usedCall(call);
    }

    @Test
    public void testEmptySearch() throws Exception {
        String key = "时间000";
        Observable<ArrayList<TopicInfo>> call = request.searchTopicUnderBoard(100, key, 0, 20);
        usedCall(call);
    }


    @Test
    public void testBoardTopic() throws Exception {

        Observable<ArrayList<TopicInfo>> call = request.getTopicBoard(68, 0, 20);
        usedCall(call);
    }

    @Test
    public void testNewTopic() throws Exception {

        Observable<ArrayList<TopicInfo>> call = request.getTopicNew(0, 20);
        usedCall(call);
    }

    @Test
    public void testGroupedBoardInfo() throws Exception {
        Observable<ArrayList<GroupBoardInfo>> call = request.getBoardAll();
        call.subscribe(new Subscriber<ArrayList<GroupBoardInfo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();

            }

            @Override
            public void onNext(ArrayList<GroupBoardInfo> allBoardInfos) {
                for (GroupBoardInfo i : allBoardInfos) {
                    System.out.println(i.getId() + i.getName() + i.getBoards().size());
                }

            }
        });

    }

    public static String getAuthKeys(String path) {
        if (path==null)
        path = "auth.test.keys";
        try {
            byte[] encoded = Files.readAllBytes(Paths.get("src", "test", "resources", path));
            String keys = new String(encoded);
            return keys;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public <T extends TopicInfoInterface> void usedCall(Observable<ArrayList<T>> acall) throws Exception {
        acall.subscribe(new Subscriber<ArrayList<T>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                //throw new Exception(e.toString());
                e.printStackTrace();
                System.out.println("Token Changes every hour");
            }

            @Override
            public void onNext(ArrayList<T> TopicInfos) {
                System.out.println(TopicInfos.size());
                for (T i : TopicInfos) {
                    System.out.println(i.getTitle() + "_" + i.getAuthorName());
                }

            }
        });
    }

    void print(Object m) {
        System.out.println(m);
    }
}
