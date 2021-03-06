package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationService;
import FairGrounds.Domain.Person;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordValidator implements Validator {
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    ApplicationService applicationService;
    @Override
    public boolean supports(Class clazz) {
        return ApplicationForm.class.equals(clazz);
    }

    /**
     * Checks if password is correct
     * @param o ApplicationForm
     * @param errors Error
     */
    @Override
    public void validate(Object o, Errors errors) {
        ApplicationForm form = (ApplicationForm) o;
        if(!encoder.matches(form.getPassword(), applicationService.getPassword())){
            errors.rejectValue("password", "incorrect.password.error");
        }
    }
}
