package FairGrounds.Presentation;

import FairGrounds.Domain.Availability;
import FairGrounds.Domain.ExpertiseProfile;

import java.util.List;

public class ApplicationForm {
    private List<ExpertiseProfile> expertiseProfiles;
    private List<Availability> availabilities;


    public List<ExpertiseProfile> getExpertiseProfiles() {
        return expertiseProfiles;
    }

    public void setExpertiseProfiles(List<ExpertiseProfile> expertiseProfiles) {
        this.expertiseProfiles = expertiseProfiles;
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }
}
