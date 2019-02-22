package FairGrounds.Presentation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Wrapper object for login data
 */
public class LoginDTO {

    @NotBlank(message = "Please enter username")
    private String userLoginName;

    @NotBlank(message = "Please enter password")
    @Size (min = 6, message = "Password must be min 6 characters")
    private String userLoginPwd;

    public void setUserLoginName(String userName) {
        this.userLoginName = userName;
    }

    public void setUserLoginPwd(String userPwd) {
        this.userLoginPwd = userPwd;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public String getUserLoginPwd() {
        return userLoginPwd;
    }
}
