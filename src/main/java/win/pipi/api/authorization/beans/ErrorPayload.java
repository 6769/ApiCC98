package win.pipi.api.authorization.beans;

public class ErrorPayload {

    /**
     * error : invalid_grant
     * error_description : invalid_username_or_password
     */

    private String error;
    private String error_description;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }
}
