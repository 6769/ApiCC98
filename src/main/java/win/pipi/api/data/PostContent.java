package win.pipi.api.data;

import java.util.List;

public class PostContent {


    /**
     * id : 793968758
     * parentId : 0
     * boardId : 182
     * userName : 0b046c
     * userId : null
     * title :
     * content :
     * * time : 2018-01-09T16:29:10.317
     * length : 0
     * topicId : 4747357
     * isBest : false
     * ip : *
     * state : 0
     * isAnonymous : true
     * awardInfo : null
     * floor : 1
     * allowedViewers : null
     * isAllowedOnly : false
     * contentType : 0
     * lastUpdateTime : null
     * lastUpdateAuthor : null
     * isDeleted : false
     * likeCount : 1
     * dislikeCount : 0
     * isLZ : true
     * likeState : 0
     * awards : []
     */

    private int id;
    private int parentId;
    private int boardId;
    private String userName;
    private int userId;
    private String title;
    private String content;
    private String time;
    private int length;
    private int topicId;
    private boolean isBest;
    private String ip;
    private int state;
    private boolean isAnonymous;
    private Object awardInfo;
    private int floor;
    private Object allowedViewers;
    private boolean isAllowedOnly;
    private int contentType;
    private Object lastUpdateTime;
    private Object lastUpdateAuthor;
    private boolean isDeleted;
    private int likeCount;
    private int dislikeCount;
    private boolean isLZ;
    private int likeState;
    private List<?> awards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public boolean isIsBest() {
        return isBest;
    }

    public void setIsBest(boolean isBest) {
        this.isBest = isBest;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Object getAwardInfo() {
        return awardInfo;
    }

    public void setAwardInfo(Object awardInfo) {
        this.awardInfo = awardInfo;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Object getAllowedViewers() {
        return allowedViewers;
    }

    public void setAllowedViewers(Object allowedViewers) {
        this.allowedViewers = allowedViewers;
    }

    public boolean isIsAllowedOnly() {
        return isAllowedOnly;
    }

    public void setIsAllowedOnly(boolean isAllowedOnly) {
        this.isAllowedOnly = isAllowedOnly;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public Object getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Object lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Object getLastUpdateAuthor() {
        return lastUpdateAuthor;
    }

    public void setLastUpdateAuthor(Object lastUpdateAuthor) {
        this.lastUpdateAuthor = lastUpdateAuthor;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public boolean isIsLZ() {
        return isLZ;
    }

    public void setIsLZ(boolean isLZ) {
        this.isLZ = isLZ;
    }

    public int getLikeState() {
        return likeState;
    }

    public void setLikeState(int likeState) {
        this.likeState = likeState;
    }

    public List<?> getAwards() {
        return awards;
    }

    public void setAwards(List<?> awards) {
        this.awards = awards;
    }
}
