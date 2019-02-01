package FairGrounds.Domain;
//This is backend
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="application")
public class Application {

    public Application(){}

    public Application(String status){
        this.status = status;
    }

    @Id
    @Column(name="id")
    private Long id;

    @OneToOne
    @JoinColumn (name = "person")
    private Person person;


    @OneToMany(mappedBy = "application")
    List<Availability> availabilities;


    @OneToMany(mappedBy = "application")
    List<ExpertiseProfile> expertiseProfile;


    @Column (name="status")
    private String status;

    public Long getId() {
        return id;
    }

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

    public List<ExpertiseProfile> getExpertiseProfiles(){
        return this.expertiseProfile;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public void setExpertiseProfiles(List<ExpertiseProfile> expertiseProfiles) {
        this.expertiseProfile = expertiseProfiles;
    }
}
