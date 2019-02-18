package FairGrounds.Domain;

import FairGrounds.Presentation.RegisterDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "Person")
public class Person{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer personId;

    @Column (name = "fname")
    private String fname;

    @Column (name = "lname")
    private String lname;

    @Column (name = "ssnr")
    private String ssnr;

    @Column (name = "email")
    private String email;

    @Column (name = "uname")
    private String uname;

    @Column (name = "pwd")
    private String pwd;

    @Column (name = "roleId")
    private String roleId;

    @OneToOne(mappedBy = "person")
    private Application application;

    public Person(){};

    public Person (RegisterDTO registerDTO) {
        this.fname = registerDTO.getfName();
        this.lname = registerDTO.getlName();
        this.uname = registerDTO.getUserName();
        this.pwd = registerDTO.getUserPwd();
        this.email = registerDTO.getEmail();
        this.ssnr = registerDTO.getUserSsnr();
        this.personId = 1;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
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

    public void setUname(String uname) {
        this.uname = uname;
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

    public String getUname() {
        return uname;
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
