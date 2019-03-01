package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationService;
import FairGrounds.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Scope("session")
public class ApplicationController {

    private static final String APPLICATION_PAGE  = "user/apply";
    private static final String EXPERTISE_PAGE = "user/expertise";
    private static final String AVAILABILITY_PAGE = "user/availability";
    private static final String APPLICATION_URL  = "/user/apply";
    private static final String TEST_PAGE  = "pub/home";
    private static final String ALREADY_EXISTS_PAGE = "user/app_exists";

    /**
     * Specifies date format
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat( "yyyy-MM-dd"), true));
    }

    @Autowired
    ApplicationForm applicationForm;
    @Autowired
    ApplicationService applicationService;
    @Autowired
    ApplicationExpertiseFormValidator applicationExpertiseFormValidator;
    @Autowired
    ApplicationAvailabilityFormValidator applicationAvailabilityFormValidator;
    /**
     * Show form of expertises
     * @param applicationForm - Wrapper object for values
     * @param model - model holds all attached objects
     * @return - html page for expertises
     */
    @GetMapping(APPLICATION_URL)
    public String showExpertiseView(@ModelAttribute("applicationForm") ApplicationForm applicationForm, BindingResult bindingResult,Model model) {
        Person user = applicationService.getUser();
        if(user.getApplication()!=null){
            model.addAttribute("name", user.getUsername());
            return ALREADY_EXISTS_PAGE;
        }
        applicationForm.setExpertiseProfiles(this.applicationForm.getExpertiseProfiles());
        applicationForm.setExpertize(applicationService.getExpertises());
        applicationExpertiseFormValidator.validate(applicationForm, bindingResult);
        model.addAttribute(applicationForm);
        return EXPERTISE_PAGE;
    }

    /**
     * Adds a new list element
     * @param applicationForm - Wrapper object for values
     * @param model - model holds all attached objects
     * @return - html page for expertises
     */
    @PostMapping(value=APPLICATION_URL, params={"addExpertise"})
    public String addExpertise(@ModelAttribute("applicationForm") ApplicationForm applicationForm,BindingResult bindingResult, Model model) {
       // this.applicationForm = applicationForm;

        applicationForm.setExpertize(applicationService.getExpertises());

        applicationForm.getExpertiseProfiles().add(new ExpertiseProfile());
        model.addAttribute(applicationForm);
        return EXPERTISE_PAGE;
    }

    /**
     * Delets a list element
     * @param applicationForm - Wrapper object for values
     * @param model - model holds all attached objects
     * @return - html page for expertises
     */
    @PostMapping(value=APPLICATION_URL, params={"deleteExpertise"})
    public String deleteExpertise(@ModelAttribute("applicationForm") ApplicationForm applicationForm, Model model) {

        applicationForm.setExpertize(applicationService.getExpertises());

        int size = applicationForm.getExpertiseProfiles().size();
        if(size>0){
            applicationForm.getExpertiseProfiles().remove(size-1);
        }
        model.addAttribute(applicationForm);
        return EXPERTISE_PAGE;
    }

    /**
     *  Show form of availabilities
     * @param applicationForm - Wrapper object for values
     * @param model - model holds all attached objects
     * @return - html page for availabilities
     */
    @PostMapping(value =APPLICATION_URL, params={"getAvailability"})
    public String showAvailabilityView(@ModelAttribute("applicationForm") @Valid ApplicationForm applicationForm, BindingResult bindingResult, Model model){

        this.applicationForm.setExpertize(applicationForm.getExpertize());
        this.applicationForm.setExpertiseProfiles(applicationForm.getExpertiseProfiles());
        model.addAttribute(applicationForm);
        applicationExpertiseFormValidator.validate(applicationForm, bindingResult);
        if(bindingResult.hasErrors()) {
            for(ObjectError error :bindingResult.getAllErrors()){
                System.out.println("ERROR: "+ error.toString() + " OBJECT: " + error.getObjectName());
            }
            return "redirect:"+APPLICATION_URL;
            //return EXPERTISE_PAGE;
        }
        return AVAILABILITY_PAGE;
    }

    /**
     *  add list element
     * @param applicationForm - Wrapper object for values
     * @param model - model holds all attached objects
     * @return - html page for availabilities
     */
    @PostMapping(value=APPLICATION_URL, params={"addAvailability"})
    public String addAvailability(@ModelAttribute("applicationForm") @Valid ApplicationForm applicationForm, Model model) {

        applicationForm.getAvailabilities().add(new Availability());
        printAll(applicationForm);
        model.addAttribute(applicationForm);
        return AVAILABILITY_PAGE;
    }

    /**
     *delete list element
     * @param applicationForm - Wrapper object for values
     * @param model - model holds all attached objects
     * @return - html page for availabilities
     */
    @PostMapping(value=APPLICATION_URL, params={"deleteAvailability"})
    public String deleteAvailability(@ModelAttribute("applicationForm") @Valid ApplicationForm applicationForm, Model model) {

        int size = applicationForm.getAvailabilities().size();
        if(size>0){
            applicationForm.getAvailabilities().remove(size-1);
        }
        printAll(applicationForm);
        model.addAttribute(applicationForm);
        return AVAILABILITY_PAGE;
    }

    /**
     *  shows all data for the application
     * @param applicationForm - Wrapper object for values
     * @param model - model holds all attached objects
     * @return - html page for applications
     */
    @PostMapping(value=APPLICATION_URL, params={"application"})
    public String showApplication(@ModelAttribute("applicationForm") @Valid ApplicationForm applicationForm, BindingResult bindingResult,Model model) {

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
        applicationAvailabilityFormValidator.validate(applicationForm,bindingResult);


        if(bindingResult.hasErrors()) {
            return AVAILABILITY_PAGE;
        }
        return APPLICATION_PAGE;
    }

    /**
     * Stores application in database and redirects to home page
     * @param applicationForm - Wrapper object for values
     * @param model - model holds all attached objects
     * @return - html page for home page
     */
    @PostMapping(value=APPLICATION_URL, params={"confirm"})
    public String confirmApplication(@ModelAttribute("ApplicationForm") @Valid ApplicationForm applicationForm, Model model) {

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
