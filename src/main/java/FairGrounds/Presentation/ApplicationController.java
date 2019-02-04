package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationService;
import FairGrounds.Domain.ExpertiseProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Scope("session")
public class ApplicationController {
    static final String EXPERTISE_URL = "/expertise";
    static final String AVAILABILITY_URL = "/availability";


    @Autowired
    ApplicationService applicationService;

    @GetMapping(EXPERTISE_URL)
    public String showExpertiseView(ApplicationForm applicationForm, Model model) {
        List<ExpertiseProfile> expertises = applicationService.getExpertises();
        applicationForm.setExpertiseProfiles(expertises);
        model.addAttribute(applicationForm);
        return EXPERTISE_URL;
    }

    @PostMapping(AVAILABILITY_URL)
    public String showAvailabilityView(ApplicationForm applicationForm, Model model){
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }


}
