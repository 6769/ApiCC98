package win.pipi.api;


import rx.Observable;
import rx.Subscriber;
import win.pipi.api.data.*;
import win.pipi.api.network.CC98APIInterface;
import win.pipi.api.network.CC98APIManager;

import java.util.ArrayList;

public class CC98ApiList {
    public static void main(String[] args) {


        CC98ApiList apiList = new CC98ApiList();
        apiList.request();
    }

    public void request() {


        // 步骤5:创建 网络请求接口 的实例
        CC98APIInterface request = CC98APIManager.createApiClient();

        //对 发送请求 进行封装
        Observable<ArrayList<HotTopicInfo>> call = request.getTopicHot();

        call.subscribe(new Subscriber<ArrayList<HotTopicInfo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ArrayList<HotTopicInfo> hotTopicInfos) {
                for (HotTopicInfo i : hotTopicInfos) {
                    print(i.getTitle());
                }
                //System.exit(1);

            }
        });

        System.out.println();


    }


    private void print(Object msg) {
        System.out.println(msg);
    }


}
