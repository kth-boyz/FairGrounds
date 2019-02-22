package FairGrounds.Presentation;

import FairGrounds.Application.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope("session")
public class FairGroundsController {

    private static final String DEFAULT_PAGE_URL = "/";
    static final String HOME_PAGE = "pub/home";

    @GetMapping (DEFAULT_PAGE_URL)
    public String showDefaultView (Model model) {
        return HOME_PAGE;
    }
    @GetMapping("/" + HOME_PAGE)
    public String showHomeView(Model model) {
        return HOME_PAGE;
    }
}
