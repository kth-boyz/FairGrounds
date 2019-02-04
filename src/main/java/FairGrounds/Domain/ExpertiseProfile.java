package FairGrounds.Domain;

import javax.persistence.*;

@Entity
@Table (name = "EXPERTISEPROFILE")
public class ExpertiseProfile implements ExpertiseProfileDTO{

    public ExpertiseProfile(){

    }

    public ExpertiseProfile(Expertise expertise,Person person){
        this.expertise = expertise;
        this.person = person;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int expertixeprofile_id;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @ManyToOne
    @JoinColumn (name = "expertiseId")
    private Expertise expertise;

    @Column (name = "yearsOfEx")
    private long yearsOfEx;

    public int getExpertixeprofile_id() {
        return expertixeprofile_id;
    }

    public void setExpertixeprofile_id(int expertixeprofile_id) {
        this.expertixeprofile_id = expertixeprofile_id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Expertise getExpertise() {
        return expertise;
    }

    public void setExpertise(Expertise expertise) {
        this.expertise = expertise;
    }

    public long getYearsOfEx() {
        return yearsOfEx;
    }

    public void setYearsOfEx(long yearsOfEx) {
        this.yearsOfEx = yearsOfEx;
    }
}
