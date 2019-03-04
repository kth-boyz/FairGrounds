package FairGrounds.Domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table (name = "Availability")
public class Availability {
    /**
     * Constructor - initialises an instance of the object Availability
     * Is used to encapsulate when an applicant is available for work to his/hers application
     * @param fromDate - the date when a person is available from
     * @param toDate - the date when a person is available to
     * @param application - which application the availability is related to
     */
    public Availability(Date fromDate, Date toDate, Application application) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.application = application;
    }

    /**
     * Required default constructor for Spring Framework
     */
    public Availability() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application")
    private Application application;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fd")
    private Date fromDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "td")
    private Date toDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
