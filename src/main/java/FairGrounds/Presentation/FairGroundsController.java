package FairGrounds.Presentation;

import FairGrounds.Application.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope("session")
public class FairGroundsController {

    static final String EXAMPLE_PAGE = "/pub/testpage";

    @GetMapping(EXAMPLE_PAGE)
    public String showDefaultView() {
        return EXAMPLE_PAGE;
    }
}
