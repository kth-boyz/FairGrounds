package FairGrounds.Domain;

import javax.persistence.*;

@MappedSuperclass
public class Person{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int personId;

    @Column (name = "")
    private String fname;

    @Column (name = "")
    private String lname;

    @Column (name = "")
    private String scn;

    @Column (name = "")
    private String email;

    @Column (name = "")
    private String uname;

    @Column (name = "")
    private String pwd;

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

    public void setScn(String scn) {
        this.scn = scn;
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

    public String getScn() {
        return scn;
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
