package win.pipi.api.data;

public class TopicInfo implements TopicInfoInterface {



    private int id;
    private int boardId;
    private String title;
    private String time;
    private int userId;
    private String userName;
    private boolean isAnonymous;
    private boolean disableHot;
    private String lastPostTime;
    private int state;
    private int type;
    private int replyCount;
    private int hitCount;
    private int totalVoteUserCount;
    private String lastPostUser;
    private String lastPostContent;
    private int topState;
    private int bestState;
    private boolean isVote;
    private boolean isPosterOnly;
    private int allowedViewerState;
    private int dislikeCount;
    private int likeCount;
    private Object highlightInfo;
    private int tag1;
    private int tag2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return Utility.getDefaultDateStr(time);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAuthorName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public boolean isDisableHot() {
        return disableHot;
    }

    public void setDisableHot(boolean disableHot) {
        this.disableHot = disableHot;
    }

    public String getLastPostTime() {
        return lastPostTime;
    }

    public void setLastPostTime(String lastPostTime) {
        this.lastPostTime = lastPostTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getTotalVoteUserCount() {
        return totalVoteUserCount;
    }

    public void setTotalVoteUserCount(int totalVoteUserCount) {
        this.totalVoteUserCount = totalVoteUserCount;
    }

    public String getLastPostUser() {
        return lastPostUser;
    }

    public void setLastPostUser(String lastPostUser) {
        this.lastPostUser = lastPostUser;
    }

    public String getLastPostContent() {
        return lastPostContent;
    }

    public void setLastPostContent(String lastPostContent) {
        this.lastPostContent = lastPostContent;
    }

    public int getTopState() {
        return topState;
    }

    public void setTopState(int topState) {
        this.topState = topState;
    }

    public int getBestState() {
        return bestState;
    }

    public void setBestState(int bestState) {
        this.bestState = bestState;
    }

    public boolean isIsVote() {
        return isVote;
    }

    public void setIsVote(boolean isVote) {
        this.isVote = isVote;
    }

    public boolean isIsPosterOnly() {
        return isPosterOnly;
    }

    public void setIsPosterOnly(boolean isPosterOnly) {
        this.isPosterOnly = isPosterOnly;
    }

    public int getAllowedViewerState() {
        return allowedViewerState;
    }

    public void setAllowedViewerState(int allowedViewerState) {
        this.allowedViewerState = allowedViewerState;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Object getHighlightInfo() {
        return highlightInfo;
    }

    public void setHighlightInfo(Object highlightInfo) {
        this.highlightInfo = highlightInfo;
    }

    public int getTag1() {
        return tag1;
    }

    public void setTag1(int tag1) {
        this.tag1 = tag1;
    }

    public int getTag2() {
        return tag2;
    }

    public void setTag2(int tag2) {
        this.tag2 = tag2;
    }
}
