package FairGrounds.Presentation;

import FairGrounds.Domain.Application;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Wrapper object for application detail
 */
@Component
@Scope("session")
public class ApplicationDetailForm {
    private Application application;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
