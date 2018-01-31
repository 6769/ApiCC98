import com.google.gson.Gson;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observer;
import win.pipi.api.data.DailySign;
import win.pipi.api.network.CC98APIInterface;

public class SignTest {
    static Gson gson=new Gson();

    @Test
    public void testGetSignInfo() throws Exception{
        CC98APIInterface iface=UploadTest.getLoginedClient();
        Call<DailySign.Status> call=iface.getDailySignInfoCall();
        Response<DailySign.Status> response=call.execute();
        int code=response.code();
        print("code:"+code);
        DailySign.Status result=response.body();
        print(gson.toJson(result));
    }

    //TODO:need test at 2018/2/1 00:02

    @Test
    public void testPostSignInfo() throws Exception{
        CC98APIInterface iface=UploadTest.getLoginedClient();
        Call<String> call=iface.postDailySignInfoCall(new DailySign.Post("hi"));
        Response<String> response=call.execute();
        String result=response.body();
        int code=response.code();
        print("code:"+code);
        print(result);
    }

    void print(Object s){
        System.out.println(s);
    }
}
