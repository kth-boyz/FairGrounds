package FairGrounds.Domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "EXPERTISEPROFILE")
public class ExpertiseProfile{
    public ExpertiseProfile(){
    }


    public ExpertiseProfile(Expertise expertise, Double years, Application application){
        this.expertise = expertise;
        this.years=years;
        this.application = application;
    }
    public ExpertiseProfile(Expertise expertise){
        this.expertise = expertise;
        this.years= (double) 0;
    }


    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long expertiseprofile_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "expertise")
    private Expertise expertise;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "application")
    private Application application;

    @Column (name = "years")
    private Double years;

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

    public Double getYears() {
        return years;
    }

    public void setYears(Double years) {
        this.years = years;
    }
}
