package FairGrounds.Domain;

import java.util.Date;

public class ApplicationDTO {
    private Long id;
    private String fname;
    private String lname;
    private Date applicationDate;

    /**
     * Constructor - initialises an instance of the object ApplicationDTO
     * Purpose of this object is due to the session closing of the transaction. Since data has to be fetched from
     * different relation tables, this data is stored in this data transfer object to be passed on to the templating
     * engine Thymeleaf.
     * @param fname - first name of applicant
     * @param lname - last name of applicant
     * @param applicationDate - date when application submitted
     * @param id - primary key of application from DB
     */
    public ApplicationDTO(String fname, String lname, Date applicationDate, Long id) {
        this.fname = fname;
        this.lname = lname;
        this.applicationDate = applicationDate;
        this.id = id;
    }

    public Long getId() { return this.id; }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public Date getApplicationDate() { return this.applicationDate; }

    public void setFname(String fname) { this.fname = fname; }

    public void setId(Long id) { this.id = id; }

    public void setLname(String lname) { this.lname = lname; }

    public void setApplicationDate(Date applicationDate) { this.applicationDate = applicationDate; }

}
