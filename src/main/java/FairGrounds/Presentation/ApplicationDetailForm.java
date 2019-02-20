package FairGrounds.Presentation;

import FairGrounds.Domain.Application;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDetailForm {
    private Application application;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
