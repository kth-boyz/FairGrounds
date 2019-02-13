package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationService;
import FairGrounds.Domain.Application;
import FairGrounds.Domain.Availability;
import FairGrounds.Domain.Expertise;
import FairGrounds.Domain.ExpertiseProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Scope("session")
public class ApplicationController {
    private static final String EXPERTISE_URL = "/expertise";
    private static final String AVAILABILITY_URL = "/availability";
    private static final String APPLICATION_URL  = "/apply";
    private static final String TEST_PAGE  = "/testpage";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat( "yyyy-MM-dd"), true));
    }

    @Autowired
    ApplicationForm applicationForm;
    @Autowired
    ApplicationService applicationService;

    @GetMapping(APPLICATION_URL)
    public String showExpertiseView(@ModelAttribute("ApplicationForm") ApplicationForm applicationForm, Model model) {
       // this.applicationForm = applicationForm;
        applicationForm.setExpertize(applicationService.getExpertises());
        printAll(applicationForm);
        model.addAttribute(applicationForm);
        return EXPERTISE_URL;
    }
    @PostMapping(value=APPLICATION_URL, params={"addExpertise"})
    public String addExpertise(@ModelAttribute("ApplicationForm") ApplicationForm applicationForm, Model model) {
       // this.applicationForm = applicationForm;

        applicationForm.setExpertize(applicationService.getExpertises());

        applicationForm.getExpertiseProfiles().add(new ExpertiseProfile());
        printAll(applicationForm);
        model.addAttribute(applicationForm);
        return EXPERTISE_URL;
    }

    @PostMapping(value=APPLICATION_URL, params={"deleteExpertise"})
    public String deleteExpertise(@ModelAttribute("ApplicationForm") ApplicationForm applicationForm, Model model) {

        applicationForm.setExpertize(applicationService.getExpertises());

        int size = applicationForm.getExpertiseProfiles().size();
        if(size>0){
            applicationForm.getExpertiseProfiles().remove(size-1);
        }
        printAll(applicationForm);
        model.addAttribute(applicationForm);
        return EXPERTISE_URL;
    }

    @PostMapping(value =APPLICATION_URL, params={"getAvailability"})
    public String showAvailabilityView(@ModelAttribute("ApplicationForm") ApplicationForm applicationForm, Model model){
        this.applicationForm.setExpertize(applicationForm.getExpertize());
        this.applicationForm.setExpertiseProfiles(applicationForm.getExpertiseProfiles());

        printAll(applicationForm);
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }

    @PostMapping(value=APPLICATION_URL, params={"addAvailability"})
    public String addAvailability(@ModelAttribute("ApplicationForm") ApplicationForm applicationForm, Model model) {

        applicationForm.getAvailabilities().add(new Availability());
        printAll(applicationForm);
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }

    @PostMapping(value=APPLICATION_URL, params={"deleteAvailability"})
    public String deleteAvailability(@ModelAttribute("ApplicationForm") ApplicationForm applicationForm, Model model) {

        int size = applicationForm.getAvailabilities().size();
        if(size>0){
            applicationForm.getAvailabilities().remove(size-1);
        }
        printAll(applicationForm);
        model.addAttribute(applicationForm);
        return AVAILABILITY_URL;
    }

    @PostMapping(value=APPLICATION_URL, params={"application"})
    public String showApplication(@ModelAttribute("ApplicationForm") ApplicationForm applicationForm, Model model) {

        applicationForm.setExpertize(this.applicationForm.getExpertize());
        applicationForm.setExpertiseProfiles(this.applicationForm.getExpertiseProfiles());

        this.applicationForm.setAvailabilities(applicationForm.getAvailabilities());


        for (Availability availability: applicationForm.getAvailabilities()) {
            System.out.println(availability.getFromDate() + " - " + availability.getToDate());
        }
        for (ExpertiseProfile expertiseProfile: applicationForm.getExpertiseProfiles()) {
            System.out.println(expertiseProfile.getExpertise().getName());
        }
        printAll(applicationForm);
        model.addAttribute(applicationForm);
        return EXPERTISE_URL;
    }

    @PostMapping(value =AVAILABILITY_URL)
    public String showAvailabilityView(ApplicationForm applicationForm, Model model){
        model.addAttribute(applicationForm);
        return APPLICATION_URL;
    }

    @PostMapping(value=APPLICATION_URL, params={"confirm"})
    public String confirmApplication(@ModelAttribute("ApplicationForm") ApplicationForm applicationForm, Model model) {

        applicationForm.setExpertize(this.applicationForm.getExpertize());
        applicationForm.setExpertiseProfiles(this.applicationForm.getExpertiseProfiles());
        applicationForm.setAvailabilities(this.applicationForm.getAvailabilities());

        model.addAttribute(applicationForm);
        printAll(applicationForm);
        return TEST_PAGE;
    }

    @PostMapping(value=APPLICATION_URL, params={"confirm"})
    public String confirmApplication(@ModelAttribute("ApplicationForm") ApplicationForm applicationForm, Model model) {

        applicationForm.setExpertize(this.applicationForm.getExpertize());
        applicationForm.setExpertiseProfiles(this.applicationForm.getExpertiseProfiles());
        applicationForm.setAvailabilities(this.applicationForm.getAvailabilities());
        Application application = new Application(applicationForm.getExpertiseProfiles(), applicationForm.getAvailabilities(),applicationService.getUser());
        applicationService.storeApplication(application);
        System.out.println("check database now");
        model.addAttribute(applicationForm);
        printAll(applicationForm);
        return TEST_PAGE;
    }

    private void printAll(ApplicationForm form){
        System.out.println("-------------------------------------------------");
        if(form!=null) {
            System.out.println("EXPERTISES: ");
            for (Expertise profile : form.getExpertize()) {
                if (profile.getName() != null) {
                        System.out.println("NAME: " + profile.getName());
                }
            }


            System.out.println("EXPERTISEPROFILES: ");
            for (ExpertiseProfile profile : form.getExpertiseProfiles()) {
                if (profile.getExpertise() != null) {
                    if (profile.getExpertise().getName() != null)
                        System.out.println("NAME: " + profile.getExpertise().getName());
                    System.out.println("YEAR: " + profile.getYears());
                }
            }
            System.out.println("AVAILABILITY: ");
            for (Availability availability : form.getAvailabilities()) {
                if (availability.getToDate() != null) {
                    System.out.println("TODATE: " + availability.getToDate());
                }
                if (availability.getFromDate() != null) {
                    System.out.println("FROM: " + availability.getFromDate());
                }
            }
        }
    }
}
