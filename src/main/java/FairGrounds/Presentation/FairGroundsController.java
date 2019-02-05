package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationSearchService;
import FairGrounds.Application.LoginService;
import FairGrounds.Domain.Application;
import FairGrounds.Domain.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        ApplicationDTO dto = this.applicationSearchService.
                getQueriedApplications(applicationSearchForm.getName(),
                applicationSearchForm.getAppDate(), applicationSearchForm.getWorkAvailabilityFrom(),
                applicationSearchForm.getWorkAvailabilityTo());
        String name = dto.getFname();
        System.out.println(name);
        return "list-application";
    }
}
