package FairGrounds.Domain;

import javax.persistence.*;

@Entity
@Table (name = "EXPERTISEPROFILE")
public class Expertise {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "personId")
    private int personId;

    @ManyToOne
    @JoinColumn (name = "ExId")
    private int ExpertiseId;

    @Column (name = "yearsOfEx")
    private double yearsOfEx;
}
