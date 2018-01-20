package win.pipi.api.network;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;
import win.pipi.api.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CC98APIInterface {

    public final String BASE_URL = "https://api-v2.cc98.org/";

    @GET("Topic/Hot")
    Observable<ArrayList<HotTopicInfo>> getTopicHot();

    //page split limit to 20 per list;
    //  eg:1-20,21-40;41-60;61-80;81-100;
    //@Headers("range:bytes=21-40")
    @GET("Topic/New")
    Observable<ArrayList<TopicInfo>> getTopicNewRaw(@Header("range") String paging);

    @GET("topic/new")
    Observable<ArrayList<TopicInfo>> getTopicNew(@Query("from") Integer from,
                                                 @Query("size") Integer size);

    @GET("board/{boardId}/topic")
    Observable<ArrayList<TopicInfo>> getTopicBoard(@Path("boardId") Integer boardId,
                                                   @Query("from") Integer from,
                                                   @Query("size") Integer size);


    @GET("Topic/{topicId}/Post")
    Observable<ArrayList<PostContent>> getTopicPost(@Path("topicId")Integer id,
                                              @Query("from") Integer from,
                                              @Query("size")Integer size
                                              );
    @GET("Topic/{topicId}/Post")
    Call<ArrayList<PostContent>> getTopicPostCall(@Path("topicId")Integer id,
                                                    @Query("from") Integer from,
                                                    @Query("size")Integer size
    );


    @GET("Topic/{topicId}")
    Observable<TopicInfo>               getTopicInfo(@Path("topicId")Integer id);

    @GET("Topic/{topicId}")
    Call<TopicInfo>               getTopicInfoCall(@Path("topicId")Integer id);


    //create new topic;
    // need OAuth
    @POST("Board/{boardId}/Topic")
    Observable<String>            postTopicBoard(@Path("boardId") Integer boardId,
                                           @Body NewPostInfo newPostInfo);

    //append post to an existed topic;
    // need Oauth;
    @POST("topic/{topicId}/post")
    Observable<String> postReplyTopic(@Path("topicId") Integer id,
                                      @Body NewPostInfo newPost);

    @GET("User/{id}")
    Observable<UserInfo>              getUserInfoViaId(@Path("id")Integer id);

    @GET("user/basic/")
    Call<ArrayList<BasicUserInfo>>      getBasicUserInfos(@QueryMap Map<String,Integer> idsmap);

    @GET("User/Name/{name}")
    Observable<UserInfo>              getUserInfoViaName(@Path("name")String name);

    @GET("Me")
    Observable<UserInfo>              getMe();


    @GET("Board/All")
    Observable<ArrayList<GroupBoardInfo>> getBoardAll();

    @GET("Board/Root")
    Observable<ArrayList<RootBoardInfo>> getBoardRoot();


    @GET("Board/{id}")
    Observable<BoardInfo> getBoardId(@Path("id")Integer id);



    @GET ("Message/{id}")
    Observable<MessageInfo>           getMessage(@Path("id")Integer id);

    @POST ("Message")
    Observable<String>                postMessage(@Body MessageInfo.NewMessageInfo mess);


    @DELETE ("Message/{id}")
    Observable<String>                deleteMessage(@Path("id")Integer id);


    @GET("topic/search")
    Observable<ArrayList<TopicInfo>> searchTopicGlobal(@Query("keyword") String keywords,
                                                       @Query("from") Integer from,
                                                       @Query("size") Integer size);

    @GET("topic/search/board/{boardId}")
    Observable<ArrayList<TopicInfo>> searchTopicUnderBoard(@Path("boardId") Integer boardId,
                                                           @Query("keyword") String keywords,
                                                           @Query("from") Integer from,
                                                           @Query("size") Integer size);

    @GET("notification/reply")
    Observable notifyReplyMe(@Query("from") Integer from,
                             @Query("size") Integer size);

    @GET("notification/at")
    Observable notifyAtMe(@Query("from") Integer from,
                          @Query("size") Integer size);

    @GET("notification/system")
    Observable notifyViaSystem(@Query("from") Integer from,
                               @Query("size") Integer size);


    @Multipart
    @POST("file")
    Call<List<String>> uploadFileSync(@Part MultipartBody.Part file);


    @Multipart
    @POST("file")
    Observable<List<String>> uploadFile(@Part MultipartBody.Part file);


}