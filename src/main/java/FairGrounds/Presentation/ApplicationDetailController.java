package FairGrounds.Presentation;
import FairGrounds.Application.ApplicationService;
import FairGrounds.Domain.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@Scope("session")
public class ApplicationDetailController {

    private final static String APPLICATION_URL = "/app";
    private final static String APPLICATION_PAGE = "admin/applicationDetail";
    private final static String LIST_URL = "/list-application";
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat( "yyyy-MM-dd"), true));
    }

    @Autowired
    ApplicationForm applicationForm;
    @Autowired
    ApplicationService applicationService;
    @Autowired
    ApplicationDetailForm applicationDetailForm;

    @GetMapping("/"+APPLICATION_URL+"/{appid}")
    public String showExpertiseView(@ModelAttribute("ApplicationDetailForm") ApplicationDetailForm applicationDetailForm, Model model,@PathVariable("appid") int appid) {
        Long id = new Long(appid);
        Application app = applicationService.getApplication(id);
        applicationDetailForm.setApplication(app);
        this.applicationDetailForm=applicationDetailForm;
        model.addAttribute("id",id.toString());
        model.addAttribute(applicationDetailForm);
        return APPLICATION_PAGE;
    }

    @PostMapping(value="/"+APPLICATION_URL+"/{appid}" )
    public String acceptApplication(@ModelAttribute("ApplicationDetailForm") ApplicationDetailForm applicationDetailForm, Model model
            ,@PathVariable("appid") int appid,@RequestParam(value="type",required=false) String type) {
        Long id = new Long(appid);
        Application application = this.applicationDetailForm.getApplication();

        switch (type) {
            case "accept":
                 application.setStatus("ACCEPTED");
                applicationService.storeApplication(application);
                applicationDetailForm=this.applicationDetailForm;
                model.addAttribute("id",id.toString());
                model.addAttribute(applicationDetailForm);
                return APPLICATION_PAGE;
            case "reject":
                application.setStatus("REJECTED");
                applicationService.storeApplication(application);
                applicationDetailForm=this.applicationDetailForm;
                model.addAttribute("id",id.toString());
                model.addAttribute(applicationDetailForm);
                return APPLICATION_PAGE;
            case "goback":
                applicationDetailForm = null;
                return "redirect:" + LIST_URL;

                default:
                    return "redirect:" +APPLICATION_URL + id.toString();

        }
    }
}
