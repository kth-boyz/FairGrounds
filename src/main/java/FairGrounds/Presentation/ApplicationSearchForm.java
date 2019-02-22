package FairGrounds.Presentation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Object wrapper for application search form
 */
@Component
@Scope("session")
public class ApplicationSearchForm {
    private String name;
    private Date appDate;
    private Date workAvailabilityFrom;
    private Date workAvailabilityTo;
    private String expertise;

    public String getName() { return this.name; }

    public Date getAppDate() {
        return this.appDate;
    }

    public Date getWorkAvailabilityFrom() {
        return this.workAvailabilityFrom;
    }

    public Date getWorkAvailabilityTo() {
        return this.workAvailabilityTo;
    }

    public String getExpertise() { return this.expertise; }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpertise(String expertise) { this.expertise = expertise; }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public void setWorkAvailabilityFrom(Date workAvailabilityFrom) {
        this.workAvailabilityFrom = workAvailabilityFrom;
    }

    public void setWorkAvailabilityTo(Date workAvailabilityTo) {
        this.workAvailabilityTo = workAvailabilityTo;
    }
}
