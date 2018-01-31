package win.pipi.api.data;

public class DailySign {
    public static class Status{

        /**
         * lastSignInTime : 2018-01-29T19:31:35.957
         * lastSignInCount : 1
         * hasSignedInToday : false
         */

        private String lastSignInTime;
        private int lastSignInCount;
        private boolean hasSignedInToday;

        public String getLastSignInTime() {
            return Utility.getDateStupid(lastSignInTime);
        }

        public void setLastSignInTime(String lastSignInTime) {
            this.lastSignInTime = lastSignInTime;
        }

        public int getLastSignInCount() {
            return lastSignInCount;
        }

        public void setLastSignInCount(int lastSignInCount) {
            this.lastSignInCount = lastSignInCount;
        }

        public boolean isHasSignedInToday() {
            return hasSignedInToday;
        }

        public void setHasSignedInToday(boolean hasSignedInToday) {
            this.hasSignedInToday = hasSignedInToday;
        }
    }
    public static class Post{
        public Post(String message) {
            this.message = message;
        }

        String message;

    }
}
