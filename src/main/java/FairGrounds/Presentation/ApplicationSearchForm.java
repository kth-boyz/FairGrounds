package FairGrounds.Presentation;

public class ApplicationSearchForm {
    private String name;
    private String appDate;
    private String workAvailabilityFrom;
    private String workAvailabilityTo;
    private String expertise;

    public String getName() { return this.name; }

    public String getAppDate() {
        return this.appDate;
    }

    public String getWorkAvailabilityFrom() {
        return this.workAvailabilityFrom;
    }

    public String getWorkAvailabilityTo() {
        return this.workAvailabilityTo;
    }

    public String getExpertise() { return this.expertise; }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpertise(String expertise) { this.expertise = expertise; }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public void setWorkAvailabilityFrom(String workAvailabilityFrom) {
        this.workAvailabilityFrom = workAvailabilityFrom;
    }

    public void setWorkAvailabilityTo(String workAvailabilityTo) {
        this.workAvailabilityTo = workAvailabilityTo;
    }
}
