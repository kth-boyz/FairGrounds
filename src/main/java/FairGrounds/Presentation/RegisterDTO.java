package FairGrounds.Presentation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterDTO {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "User name can only contain letters and digits")
    private String userName;

    @NotBlank
    @Size (min = 6, message = "Password must be at least 6 characters")
    private String userPwd;

    @NotBlank
    @Pattern(regexp = "^[\\p{L}\\p{M}*]*$", message = "Only letters allowed")
    private String fName;

    @NotBlank
    @Pattern(regexp = "^[\\p{L}\\p{M}*]*$", message = "Only letters allowed")
    private String lName;

    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    @Size (min = 10, max = 10, message = "Number must be 10 digits")
    private String userSsnr;

    @NotBlank
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
