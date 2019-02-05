package FairGrounds.Presentation;

import javax.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "Please enter username")
    private String userLoginName;

    @NotBlank(message = "Please enter password")
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
