package FairGrounds.Domain;

import javax.persistence.*;

@Entity
@Table (name = "EXPERTISEPROFILE")
public class ExpertiseProfile {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int expertiseprofile_id;

    @ManyToOne
    @JoinColumn (name = "expertise")
    private Expertise expertise;

    @ManyToOne
    @JoinColumn (name = "person")
    private Person person;

    @Column (name = "yearsOfEx")
    private long yearsOfEx;
}
