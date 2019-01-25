package FairGrounds.Domain;

import javax.persistence.*;

@Entity
@Table (name = "EXPERTISEPROFILE")
public class ExpertiseProfile {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person personId;

    @ManyToOne
    @JoinColumn (name = "expertiseId")
    private Expertise ExpertiseId;

    @Column (name = "yearsOfEx")
    private long yearsOfEx;
}
