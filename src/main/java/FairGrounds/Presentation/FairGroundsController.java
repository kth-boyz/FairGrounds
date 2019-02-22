package FairGrounds.Presentation;

import FairGrounds.Application.ApplicationSearchService;
import FairGrounds.Application.LoginService;
import FairGrounds.Domain.Application;
import FairGrounds.Domain.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Scope("session")
public class FairGroundsController {

    private static final String DEFAULT_PAGE_URL = "/";
    static final String HOME_PAGE = "pub/home";

    @Autowired
    private ApplicationSearchForm applicationSearchForm;
    @Autowired
    private ApplicationSearchService applicationSearchService;
    @Autowired
    private LoginService loginService;

    @GetMapping (DEFAULT_PAGE_URL)
    public String showDefaultView (Model model) {
        return HOME_PAGE;
    }
    @GetMapping("/" + HOME_PAGE)
    public String showHomeView(Model model) {
        return HOME_PAGE;
    }

    @GetMapping("/list-application")
    public String searchApplications(@ModelAttribute("ApplicationSearchForm") ApplicationSearchForm applicationSearchForm, Model model) {
        model.addAttribute("applicationSearchForm", new ApplicationSearchForm());
        return "list-application";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("/applications/page/{page}")
    public String queryApplications(ApplicationSearchForm applicationSearchForm, Model model, @PathVariable("page") int page) {
        System.out.println(applicationSearchForm.getName());

        if (applicationSearchForm.getName() == null) {
            applicationSearchForm = this.applicationSearchForm;
        } else {
            this.applicationSearchForm = applicationSearchForm;
        }

        String name = applicationSearchForm.getName();
        String expertise = applicationSearchForm.getExpertise();

        Date dateFrom = applicationSearchForm.getWorkAvailabilityFrom();
        Date dateTo = applicationSearchForm.getWorkAvailabilityTo();
        Date appDate = applicationSearchForm.getAppDate();

        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Application> applications =
                this.applicationSearchService.getQueriedApplications(name, expertise, appDate, dateFrom, dateTo, pageable);

        List<ApplicationDTO> applicationDTOS = new ArrayList<>();

        for (Application a : applications) {
            applicationDTOS.add(
                    new ApplicationDTO(a.getPerson().getFname(),
                            a.getPerson().getLname(),
                            a.getApplicationdate(),
                            a.getId()));
        }

        int nrPages = applications.getTotalPages();

        if (nrPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, nrPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("applicationdtos", applicationDTOS);
        model.addAttribute("applications", applications.getContent());
        return "list-application";
    }
}
