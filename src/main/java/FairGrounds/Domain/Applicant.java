package FairGrounds.Domain;

import FairGrounds.Presentation.RegisterDTO;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 * This class is not used, but it keeps reappearing when merging
 * */
public class Applicant extends Person {

    private Application application;
    private String status;

    public Applicant(RegisterDTO registerDTO) {
        super(registerDTO);
    }

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
