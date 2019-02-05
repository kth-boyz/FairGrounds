package FairGrounds.Presentation;

import javax.validation.constraints.*;

public class RegisterDTO {

    @NotBlank (message = "Please enter a username")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "User name can only contain letters and digits")
    private String userName;

    @NotBlank (message = "Please enter a a password")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "User name can only contain letters and digits")
    @Size (min = 6, message = "Password must be at least 6 characters")
    private String userPwd;

    @NotBlank (message = "Please enter your first name")
    @Pattern(regexp = "^[\\p{L}\\p{M}*]*$", message = "Only letters allowed")
    private String fName;

    @NotBlank (message = "Please enter your last name")
    @Pattern(regexp = "^[\\p{L}\\p{M}*]*$", message = "Only letters allowed")
    private String lName;

    @NotBlank (message = "Please enter your social security number")
    @NotNull (message = "Please enter your social security number")
    @Pattern(regexp = "^[0-9]+$", message = "Can only contain digits")
    @Size (min = 10, max = 10, message = "Number must be 10 digits")
    private String userSsnr;

    @NotBlank (message = "Please enter your email address")
    @Email (message = "Email must be in valid form")
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
