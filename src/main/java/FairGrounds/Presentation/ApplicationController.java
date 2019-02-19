package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationService;
import FairGrounds.Domain.Availability;
import FairGrounds.Domain.ExpertiseProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Scope("session")
public class ApplicationController {
    static final String EXPERTISE_URL = "/expertise";
    static final String AVAILABILITY_URL = "/availability";

   /* @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy"), true));
    }*/

    @Autowired
    ApplicationService applicationService;

    @GetMapping(EXPERTISE_URL)
    public String showExpertiseView(ApplicationForm applicationForm, Model model) {
        List<ExpertiseProfile> expertises = applicationService.getExpertises();
        applicationForm.setExpertiseProfiles(expertises);
        model.addAttribute(applicationForm);
        return EXPERTISE_URL;
    }

    @PostMapping(value =AVAILABILITY_URL)
    public String showAvailabilityView(ApplicationForm applicationForm, Model model){
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }

    @PostMapping(value=AVAILABILITY_URL, params={"addAvailability"})
    public String addAvailability(ApplicationForm applicationForm, Model model) {
        applicationForm.getAvailabilities().add(new Availability());
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }

}
