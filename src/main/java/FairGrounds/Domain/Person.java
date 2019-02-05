package FairGrounds.Domain;

import javax.persistence.*;
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

    @Column (name = "role_id")
    private Integer roleId;

    @OneToOne(mappedBy = "person")
    private Application application;

   /** @OneToMany
    @JoinColumn (name="availability")
    private List<Availability> availability;

    @OneToMany
    @JoinColumn (name="expertiseprofile")
    private List<ExpertiseProfile> expertiseProfile;
    **/

   public Integer getRoleId() {

        return roleId;
    }

    public void setRoleId(Integer roleId) {
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
