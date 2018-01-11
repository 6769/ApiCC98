package win.pipi.api.data;

import java.util.List;

public class BoardInfo {


    private int id;
    private String name;
    private String bigPaper;
    private String logoUri;
    private int parentId;
    private int anonymousState;
    private int privacyState;
    private int viewerFilterState;
    private int protectionLevel;
    private boolean isLocked;
    private int rootId;
    private String description;
    private int topicCount;
    private int postCount;
    private int todayCount;
    private String lastPostContent;
    private int allowPostOnly;
    private boolean forbidRvpn;
    private boolean canEntry;
    private List<String> boardMasters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBigPaper() {
        return bigPaper;
    }

    public void setBigPaper(String bigPaper) {
        this.bigPaper = bigPaper;
    }

    public String getLogoUri() {
        return logoUri;
    }

    public void setLogoUri(String logoUri) {
        this.logoUri = logoUri;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getAnonymousState() {
        return anonymousState;
    }

    public void setAnonymousState(int anonymousState) {
        this.anonymousState = anonymousState;
    }

    public int getPrivacyState() {
        return privacyState;
    }

    public void setPrivacyState(int privacyState) {
        this.privacyState = privacyState;
    }

    public int getViewerFilterState() {
        return viewerFilterState;
    }

    public void setViewerFilterState(int viewerFilterState) {
        this.viewerFilterState = viewerFilterState;
    }

    public int getProtectionLevel() {
        return protectionLevel;
    }

    public void setProtectionLevel(int protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    public boolean isIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(int topicCount) {
        this.topicCount = topicCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public int getTodayCount() {
        return todayCount;
    }

    public void setTodayCount(int todayCount) {
        this.todayCount = todayCount;
    }

    public String getLastPostContent() {
        return lastPostContent;
    }

    public void setLastPostContent(String lastPostContent) {
        this.lastPostContent = lastPostContent;
    }

    public int getAllowPostOnly() {
        return allowPostOnly;
    }

    public void setAllowPostOnly(int allowPostOnly) {
        this.allowPostOnly = allowPostOnly;
    }

    public boolean isForbidRvpn() {
        return forbidRvpn;
    }

    public void setForbidRvpn(boolean forbidRvpn) {
        this.forbidRvpn = forbidRvpn;
    }

    public boolean isCanEntry() {
        return canEntry;
    }

    public void setCanEntry(boolean canEntry) {
        this.canEntry = canEntry;
    }

    public List<String> getBoardMasters() {
        return boardMasters;
    }

    public void setBoardMasters(List<String> boardMasters) {
        this.boardMasters = boardMasters;
    }
}
