package FairGrounds.Presentation;

import FairGrounds.Domain.Availability;
import FairGrounds.Domain.Expertise;
import FairGrounds.Domain.ExpertiseProfile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope("session")
public class ApplicationForm {
    private List<ExpertiseProfile> expertiseProfiles = new ArrayList<>();
    private List<Availability> availabilities = new ArrayList<>();
    private List<Expertise> expertize = new ArrayList<>();


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

    public List<Expertise> getExpertize() {
        return expertize;
    }

    public void setExpertize(List<Expertise> expertise) {
        this.expertize = expertise;
    }
}
