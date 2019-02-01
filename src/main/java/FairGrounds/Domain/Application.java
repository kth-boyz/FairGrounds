package FairGrounds.Domain;
//This is backend
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Application")
public class Application {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="application_id")
    private Integer applicationId;

    @OneToOne
    @JoinColumn (name="person_id")
    private Person person;

    @OneToMany
    @JoinColumn (name="expertize_id")
    private List<ExpertiseProfile> expertixeprofileList;

    @OneToMany
    @JoinColumn (name="availability_id")
    private List<Availability> avalabilityList;

}
