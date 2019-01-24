package FairGrounds.Domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table (name = "Person")
public class Applicant extends Person {

    private Application application;
    private String status;

    public Application getApplication() {
        return application;
    }

    public String getStatus() {
        return status;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
