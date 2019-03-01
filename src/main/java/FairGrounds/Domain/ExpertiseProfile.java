package FairGrounds.Domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "EXPERTISEPROFILE")
public class ExpertiseProfile{

    /**
     * Required default constructor for Spring Framework
     */
    public ExpertiseProfile(){
    }


    /**
     * Constructor, an applicant creates an instance of expertise profile
     * This profile links the expertise with the application together with years of experience
     * This is used for database
     * @param expertise - the chosen expertise by applicant from list in view
     * @param years - the years of expertise
     * @param application - the application associated with the current expertise
     */
    public ExpertiseProfile(Expertise expertise, Double years, Application application){
        this.expertise = expertise;
        this.years=years;
        this.application = application;
    }

    /**
     *Constructor, an applicant creates an instance of expertise
     * This is used for the form
     * @param expertise - the chosen expertise from list in the view
     */
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
