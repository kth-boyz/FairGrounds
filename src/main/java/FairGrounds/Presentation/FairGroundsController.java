package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationSearchService;
import FairGrounds.Application.LoginService;
import FairGrounds.Domain.Application;
import FairGrounds.Domain.ApplicationDTO;
import FairGrounds.Domain.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@Scope("session")
public class FairGroundsController {

    static final String DEFAULT_PAGE_URL = "/";
    static final String EXAMPLE_PAGE = "testpage";

    @Autowired
    ApplicationSearchService applicationSearchService;
    @Autowired
    LoginService loginService;

    @GetMapping(DEFAULT_PAGE_URL)
    public String showDefaultView() {
        return EXAMPLE_PAGE;
    }

    @GetMapping("/list-application")
    public String searchApplications(Model model) {
        model.addAttribute("applicationSearchForm", new ApplicationSearchForm());
        return "list-application";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat( "yyyy-MM-dd"), true));
    }

    @PostMapping("/applications")
    public String queryApplications(ApplicationSearchForm applicationSearchForm, Model model) {
        String name = applicationSearchForm.getName();
        String expertise = applicationSearchForm.getExpertise();

        Date dateFrom = applicationSearchForm.getWorkAvailabilityFrom();
        Date dateTo = applicationSearchForm.getWorkAvailabilityTo();
        Date appDate = applicationSearchForm.getAppDate();
        System.out.println(dateFrom);
        List<ApplicationDTO> applications =
                this.applicationSearchService.getQueriedApplications(name, expertise, appDate, dateFrom, dateTo);
        System.out.println(applications.size());
        model.addAttribute("applications", applications);

        return "list-application";
    }
}
