package FairGrounds.Presentation;

import javax.validation.constraints.*;

public class RegisterDTO {

    @NotBlank (message = "{register.error.username.missing}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{register.error.username.regex}")
    private String userName;

    @NotBlank (message = "{register.error.password.missing}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{register.error.password.regex}")
    @Size (min = 6, message = "{register.error.password.short}")
    private String userPwd;

    @NotBlank (message = "{register.error.fname.missing}")
    @Pattern(regexp = "^[\\p{L}\\p{M}*]*$", message = "{register.error.param.regex}")
    private String fName;

    @NotBlank (message = "{register.error.lname.missing}")
    @Pattern(regexp = "^[\\p{L}\\p{M}*]*$", message = "{register.error.param.regex}")
    private String lName;

    @NotBlank (message = "{register.error.ssn.missing}")
    @NotNull (message = "{register.error.ssn.missing}")
    @Pattern(regexp = "^[0-9]+$", message = "{register.error.ssn.regex}")
    @Size (min = 10, max = 10, message = "{register.error.ssn.length}")
    private String userSsnr;

    @NotBlank (message = "{register.error.email.missing}")
    @Email (message = "{register.error.email.regex}")
    private String email;

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getUserSsnr() {
        return userSsnr;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setUserSsnr(String userSsnr) {
        this.userSsnr = userSsnr;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
