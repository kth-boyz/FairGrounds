package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationSearchService;
import FairGrounds.Application.LoginService;
import FairGrounds.Domain.Application;
import FairGrounds.Domain.ApplicationDTO;
import FairGrounds.Domain.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @PostMapping("/applications")
    public String queryApplications(ApplicationSearchForm applicationSearchForm, Model model) {
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        String name = applicationSearchForm.getName();
        String applicationDate = applicationSearchForm.getAppDate();
        String expertise = applicationSearchForm.getExpertise();

        try {
            Date dateFrom = format.parse(applicationSearchForm.getWorkAvailabilityFrom());
            Date dateTo = format.parse(applicationSearchForm.getWorkAvailabilityTo());
            this.applicationSearchService.getQueriedApplications(name, expertise, applicationDate, dateFrom, dateTo);
        } catch (Exception e) {
            List<ApplicationDTO> applications = this.applicationSearchService.getQueriedApplications(name, expertise, applicationDate, null, null);
            model.addAttribute("applications", applications);
        }
        return "list-application";
    }
}
