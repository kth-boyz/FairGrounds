package FairGrounds.Domain;

import java.util.Date;
import java.util.List;

public class ApplicationDTO {
    private String fname;
    private String lname;
    private Date applicationDate;

    public ApplicationDTO(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public Date getApplicationDate() { return this.applicationDate; }

    public void setFname(String fname) { this.fname = fname; }

    public void setLname(String lname) { this.lname = lname; }

    public void setApplicationDate(Date applicationDate) { this.applicationDate = applicationDate; }

}
