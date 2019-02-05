package FairGrounds.Presentation;

import FairGrounds.Application.LoginService;
import FairGrounds.Domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Scope("session")
public class LoginController {

    private static final String DEFAULT_PAGE_URL = "/fakeLogin";
    private static final String LOGIN_PAGE = "fakeLogin";
    private static final String LOG_IN_USER = "loginUser";
    private static final String LOGIN_FORM_NAME = "loginDTO";
    private static final String REGISTER_USER_PAGE = "registerUser";
    private static final String REGISTER_NEW_USER = "registerNewUser";
    private static final String REGISTRATION_FORM_NAME = "registerDTO";

    @Autowired
    private LoginService loginService;
    private Person currentUser;

    @GetMapping(DEFAULT_PAGE_URL)
    public String showDefaultView(LoginDTO loginDTO, Model model) {
        return LOGIN_PAGE;
    }

    @PostMapping("/" + LOG_IN_USER)
    public String loginUser(@Valid LoginDTO loginDTO, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getErrorCount() + " Error found");
            return DEFAULT_PAGE_URL;
        }
        this.currentUser = loginService.findUserAccount(loginDTO);
        if (this.currentUser == null) {
            model.addAttribute(ExceptionHandler.ERROR_TYPE_KEY, ExceptionHandler.USER_NOT_FOUND);
            return ExceptionHandler.ERROR_PAGE_URL;
        }
        if (!this.currentUser.getPwd().equals(loginDTO.getUserLoginPwd())) {
            model.addAttribute(ExceptionHandler.ERROR_TYPE_KEY, ExceptionHandler.INVALID_PWD);
            return ExceptionHandler.ERROR_PAGE_URL;
        }
        System.out.println("User logged in");
        model.addAttribute(LOGIN_FORM_NAME, new LoginDTO());
        return DEFAULT_PAGE_URL;
    }

    @GetMapping ("/" + REGISTER_USER_PAGE)
    public String showRegistrationPage (RegisterDTO registerDTO) {
        return REGISTER_USER_PAGE;
    }

    @PostMapping ("/" + REGISTER_NEW_USER)
    public String registerNewUser(@Valid RegisterDTO registerDTO, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return REGISTER_USER_PAGE;
        }
        this.currentUser  = loginService.validateNewUser(registerDTO);
        if(this.currentUser != null) {
            //handle username taken
        }
        this.currentUser = loginService.saveNewUser(registerDTO);
        System.out.println("New user saved");
        model.addAttribute(LOGIN_FORM_NAME, new LoginDTO());
        return DEFAULT_PAGE_URL;
    }
}
