package FairGrounds.Presentation;

import FairGrounds.Domain.Availability;
import FairGrounds.Domain.ExpertiseProfile;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.Validation;
import java.util.List;

@Component
public class ApplicationExpertiseFormValidator implements Validator {
    /**
     * This Validator validates just Person instances
     */
    public boolean supports(Class clazz) {
        return ApplicationForm.class.equals(clazz);
    }

    
    public void validate(Object obj, Errors e) {

        //System.out.println("checking profiles--------------");
        ApplicationForm form = (ApplicationForm) obj;
        if(form.getExpertiseProfiles()!=null) {
            checkProfiles(e, form);
        }
    }

    private void checkProfiles(Errors e, ApplicationForm form){
        boolean ErrorExpertise = false;
        boolean ErrorYear = false;

        for (ExpertiseProfile profile : form.getExpertiseProfiles()) {
            if (!ErrorExpertise && (profile.getExpertise() == null || profile.getExpertise().getName().isEmpty())) {
                System.out.println("EXPERTISE ERROR");
                ErrorExpertise=true;
                e.rejectValue("expertiseProfiles", "application.error.expertise.null");
            }
            if (!ErrorYear && (profile.getYears()==null || profile.getYears() <= 0)) {
                System.out.println("YEARS ERROR");
                ErrorYear=true;
                e.rejectValue("expertiseProfiles", "application.error.years.error");
            }
        }
    }
}
