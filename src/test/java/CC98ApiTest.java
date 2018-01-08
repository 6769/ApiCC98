import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import win.pipi.api.data.GroupBoardInfo;
import win.pipi.api.data.HotTopicInfo;
import win.pipi.api.data.TopicInfo;
import win.pipi.api.data.TopicInfoInterface;
import win.pipi.api.network.CC98APIInterface;
import win.pipi.api.network.CC98APIManager;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CC98ApiTest {


    private static CC98APIInterface request;

    static {
        CC98APIManager.setAccessToken(getAuthKeys());
        request = CC98APIManager.createApiClient();
    }

    @Test
    public void testHotTopic() throws Exception {


        Observable<ArrayList<HotTopicInfo>> call = request.getTopicHot();
        usedCall(call);

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

    public static String getAuthKeys() {
        String path = "auth.test.keys";
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


}
