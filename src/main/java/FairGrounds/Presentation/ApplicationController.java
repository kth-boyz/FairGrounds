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
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Scope("session")
public class ApplicationController {
    private static final String EXPERTISE_URL = "/expertise";
    private static final String AVAILABILITY_URL = "/availability";
    private static final String APPLICATION_URL  = "/apply";

   /* @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy"), true));
    }*/

    @Autowired
    ApplicationService applicationService;

    @GetMapping(APPLICATION_URL)
    public String showExpertiseView(ApplicationForm applicationForm, Model model) {
        List<ExpertiseProfile> expertises = applicationService.getExpertises();
        applicationForm.setExpertiseProfiles(expertises);
        model.addAttribute(applicationForm);
        return EXPERTISE_URL;
    }

    @PostMapping(value =APPLICATION_URL, params={"getAvailability"})
    public String showAvailabilityView(ApplicationForm applicationForm, Model model){
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }

    @PostMapping(value=APPLICATION_URL, params={"addAvailability"})
    public String addAvailability(ApplicationForm applicationForm, Model model) {
        applicationForm.getAvailabilities().add(new Availability());
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }

    @PostMapping(value=APPLICATION_URL, params={"deleteAvailability"})
    public String deleteAvailability(ApplicationForm applicationForm, Model model) {
        int size = applicationForm.getAvailabilities().size();
        if(size>0){
            applicationForm.getAvailabilities().remove(size-1);
        }
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }

    @PostMapping(value=APPLICATION_URL, params={"application"})
    public String showApplication(ApplicationForm applicationForm, Model model) {
        applicationForm.getAvailabilities().add(new Availability());
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }

}
