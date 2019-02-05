package FairGrounds.Domain;

import javax.persistence.*;

@Entity
@Table (name = "EXPERTISEPROFILE")
public class ExpertiseProfile {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long expertiseprofile_id;

    @ManyToOne
    @JoinColumn (name = "expertise")
    private Expertise expertise;

    @ManyToOne
    @JoinColumn (name = "application")
    private Application application;

    @Column (name = "years")
    private long years;

    public Expertise getExpertise() {
        return expertise;
    }

    public void setExpertise(Expertise expertise) {
        this.expertise = expertise;
    }

    public Long getExpertiseprofile_id() {
        return expertiseprofile_id;
    }

    public void setExpertiseprofile_id(Long expertiseprofile_id) {
        this.expertiseprofile_id = expertiseprofile_id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public long getYears() {
        return years;
    }

    public void setYears(long years) {
        this.years = years;
    }
}
