package FairGrounds.Domain;

import javax.persistence.*;

@MappedSuperclass
public class Person{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int personId;

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
    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
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

}
