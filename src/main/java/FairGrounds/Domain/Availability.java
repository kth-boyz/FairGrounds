package FairGrounds.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Availability")
public class Availability {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int availability_id;

    @Column (name = "fromDate")
    private Date fromDate;

    @Column (name = "toDate")
    private Date toDate;
}
