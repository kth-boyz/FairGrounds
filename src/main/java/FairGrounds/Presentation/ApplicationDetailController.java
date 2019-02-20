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
    private final static String APPLICATION_PAGE = "applicationDetail";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat( "yyyy-MM-dd"), true));
    }

    @Autowired
    ApplicationForm applicationForm;
    @Autowired
    ApplicationService applicationService;

    @RequestMapping("/"+APPLICATION_URL+"/{appid}")
    public String showExpertiseView(@ModelAttribute("ApplicationForm") ApplicationDetailForm applicationDetailForm, Model model,@PathVariable("appid") int appid) {
        Long id = new Long(appid);
        Application app = applicationService.getApplication(id);
        applicationDetailForm.setApplication(app);
        model.addAttribute(id.toString(), "id");
        model.addAttribute(applicationDetailForm);
        return APPLICATION_PAGE;
    }

    @PostMapping(value="/"+APPLICATION_URL+"/{appid}" ,params={"accept"})
    public String acceptApplication(@ModelAttribute("ApplicationForm") ApplicationDetailForm applicationDetailForm, Model model,@PathVariable("appid") int appid) {
        applicationDetailForm.getApplication().setStatus("ACCEPTED");
        applicationService.storeApplication(applicationDetailForm.getApplication());
        System.out.printf("check dbase");
        return "/";

    }
}
