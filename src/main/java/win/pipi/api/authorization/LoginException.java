package win.pipi.api.authorization;

public class LoginException extends Exception {
    public TYPE getErrtype() {
        return errtype;
    }

    public void setErrtype(TYPE errtype) {
        this.errtype = errtype;
    }

    private TYPE errtype;


    public enum TYPE {
        NETWORK_ERR, PASSWORD_USER_ERR
    }
}
