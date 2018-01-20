import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import win.pipi.api.authorization.LoginCC98;
import win.pipi.api.network.CC98APIInterface;
import win.pipi.api.network.CC98APIManager;

import java.io.File;
import java.util.List;

public class UploadTest {
    public static String[] getUserNamePass() {
        String fname = "username.keys";
        String str = CC98ApiTest.getAuthKeys(fname);
        return str.split("\\s");
    }

    @Test
    public void testUploadFile() throws Exception {

        String[] userpass = getUserNamePass();

        LoginCC98 loginCC98 = new LoginCC98(userpass[0], userpass[2]);

        CC98APIManager manager = new CC98APIManager(loginCC98);
        CC98APIInterface apiInterface = manager.createApiClient();

        File file = new File("README.md.jpg");
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("files", file.getName(), requestFile);
//image/png text/plain


        Call<List<String>> call = apiInterface.uploadFileSync(body);
        Response<List<String>> response = call.execute();
        List<String> list = response.body();
        ResponseBody err = response.errorBody();
        System.out.println(list);
    }
}


//http://dev.qq.com/topic/591aa71ae315487c53deeca9