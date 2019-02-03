package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationService;
import FairGrounds.Domain.ExpertiseProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Scope("session")
public class ApplicationController {
    static final String APPLICATION_URL = "/expertise";


    @Autowired
    ApplicationService applicationService;

    @GetMapping(APPLICATION_URL)
    public String showExpertiseView(ApplicationForm applicationForm, Model model) {
        List<ExpertiseProfile> expertises = applicationService.getExpertises();
        applicationForm.setExpertiseProfiles(expertises);
        model.addAttribute(applicationForm);
        return APPLICATION_URL;
    }


}
