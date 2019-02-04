package FairGrounds.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Availability")
public class Availability {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int availability_id;

    @ManyToOne
    @JoinColumn (name = "person")
    private Person Person;

    @Column (name = "fd")
    private Date fromDate;

    @Column (name = "td")
    private Date toDate;
}
