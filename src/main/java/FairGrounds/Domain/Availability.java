package FairGrounds.Domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Availability")
public class Availability {
    public Availability(Date fromDate, Date toDate, Application application){
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.application=application;
    }
    public Availability(){

    }
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "application")
    private Application application;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column (name = "fd")
    private Date fromDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column (name = "td")
    private Date toDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
