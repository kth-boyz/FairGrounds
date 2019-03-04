package FairGrounds.Domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table (name="application")
public class Application {

    public Application(){}

    /**
     * Constructor
     * @param profiles - expertise profiles for the application
     * @param availabilities - availabilities for the application
     * @param person - person that applied
     */
    public Application(List<ExpertiseProfile> profiles , List<Availability> availabilities, Person person){
        this.status = "unchecked";
        this.expertiseProfile = profiles;
        this.availabilities = availabilities;
        this.person = person;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    public Application(String status) {
        this.status = status;
    }

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="applicationdate")
    private Date applicationdate;

    @OneToOne
    @JoinColumn (name = "person", unique = true)
    private Person person;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "application")
    @Fetch(value = FetchMode.SUBSELECT)
    List<Availability> availabilities;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "application")
    @Fetch(value = FetchMode.SUBSELECT)
    List<ExpertiseProfile> expertiseProfile;

    @NotNull
    @Column (name="status")
    private String status;

    public Long getId() {
        return id;
    }

    public Date getApplicationdate() { return this.applicationdate; }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Availability> getAvailabilities(){
        return this.availabilities;
    }

    public List<ExpertiseProfile> getExpertiseProfile(){
        return this.expertiseProfile;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public void setApplicationdate(Date applicationdate) { this.applicationdate = applicationdate; }


    public void setExpertiseProfile(List<ExpertiseProfile> expertiseProfiles) {
        this.expertiseProfile = expertiseProfiles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
