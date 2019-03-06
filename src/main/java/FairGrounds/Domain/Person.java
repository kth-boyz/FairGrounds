package FairGrounds.Domain;

import FairGrounds.Presentation.RegisterDTO;

import javax.persistence.*;

import javax.validation.constraints.*;

import java.util.List;


@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long personId;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[\\p{L}\\p{M}*]*$")
    @Column(name = "fname")
    private String fname;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[\\p{L}\\p{M}*]*$")
    @Column(name = "lname")
    private String lname;

    @NotNull
    @NotBlank
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    @Size(min = 10, max = 10)
    @Column(name = "ssnr")
    private String ssnr;

    @NotNull
    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Column(name = "username",unique=true)
    private String username;

    @NotNull
    @NotBlank
    @Size (min = 6)
    @Column(name = "pwd")
    private String pwd;

    @NotNull
    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "person")
    private Application application;


    public Person() {
    }

    /**
     * creates new person
     * @param registerDTO - holds user data for person
     */
    public Person(RegisterDTO registerDTO) {
        this.fname = registerDTO.getfName();
        this.lname = registerDTO.getlName();
        this.username = registerDTO.getUserName();
        this.pwd = registerDTO.getUserPwd();
        this.email = registerDTO.getEmail();
        this.ssnr = registerDTO.getUserSsnr();
        this.role = "applicant";
    }


    public String getRole() {
        return role;
    }

    public void setRole(String roleId) {
        this.role = roleId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setSsnr(String scn) {
        this.ssnr = scn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String uname) {
        this.username = uname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getSsnr() {
        return ssnr;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Application getApplication() {
        return application;
    }
}
