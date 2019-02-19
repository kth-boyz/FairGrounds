package FairGrounds.Domain;

import FairGrounds.Presentation.RegisterDTO;

import javax.persistence.*;


@Entity
@Table(name = "Person")
public class Person{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="person_id")
    private Integer personId;

    @Column (name = "fname")
    private String fname;

    @Column (name = "lname")
    private String lname;

    @Column (name = "ssnr")
    private String ssnr;

    @Column (name = "email")
    private String email;

    @Column (name = "username")
    private String username;

    @Column (name = "pwd")
    private String pwd;

    @Column (name = "role")
    private String role;

    @OneToOne
    @JoinColumn (name="application")
    private Application application;

    public Person(){};

    public Person (RegisterDTO registerDTO) {
        this.fname = registerDTO.getfName();
        this.lname = registerDTO.getlName();
        this.username = registerDTO.getUserName();
        this.pwd = registerDTO.getUserPwd();
        this.email = registerDTO.getEmail();
        this.ssnr = registerDTO.getUserSsnr();
        this.personId = 1;
        this.role = "USER";
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getRole() {

        return role;
    }

    public void setRole(String roleId) {
        this.role = roleId;
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

    public String getUname() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

}
