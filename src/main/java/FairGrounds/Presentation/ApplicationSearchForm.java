package FairGrounds.Presentation;

public class ApplicationSearchForm {
    private String name;
    private String appDate;
    private String workAvailabilityFrom;
    private String workAvailabilityTo;

    public String getName() {
        return this.name;
    }

    public String getAppDate() {
        return this.appDate;
    }

    public String getWorkAvailabilityFrom() {
        return this.workAvailabilityFrom;
    }

    public String getWorkAvailabilityTo() {
        return this.workAvailabilityTo;
    }

    public void setName(String name) {
        this.name = name;
    }

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
