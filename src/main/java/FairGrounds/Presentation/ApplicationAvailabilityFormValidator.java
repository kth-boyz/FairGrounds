package FairGrounds.Presentation;

import FairGrounds.Domain.Availability;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
@Component
public class ApplicationAvailabilityFormValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        return ApplicationForm.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        System.out.println("checking AVAILABILITIES" +
                "--------------");
        ApplicationForm form  = (ApplicationForm) o;
        if(form.getAvailabilities()!=null){
            checkAvailabilities(errors,form);
        }
    }

    private void checkAvailabilities(Errors e, ApplicationForm form) {
        boolean ErrorDateNull = false;
        boolean ErrorDateWrong = false;
        List<Availability> availabilityList = form.getAvailabilities();
        if (form.getAvailabilities().size() <= 0) {
            e.rejectValue("availabilities", "availability.error.empty");
        }
        for (Availability a : availabilityList) {
            if ((a.getFromDate() == null || a.getToDate() == null)) {
                if(!ErrorDateNull) {
                    ErrorDateNull = true;
                    e.rejectValue("availabilities", "availability.error.date.null");
                }
            }
            else if (!ErrorDateWrong && (a.getFromDate().after(a.getToDate()))) {
                ErrorDateWrong=true;
                e.rejectValue("availabilities", "availability.error.date.fromto");
            }
        }
    }
}
