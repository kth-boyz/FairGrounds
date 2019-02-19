package FairGrounds.Presentation;

import FairGrounds.Application.LoginService;
import FairGrounds.Domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Scope("session")
public class LoginController {

    private static final String DEFAULT_PAGE_URL = "/";
    private static final String LOGIN_PAGE = "login";
    private static final String LOG_IN_USER = "loginUser";
    private static final String LOGIN_FORM_NAME = "loginDTO";
    private static final String REGISTER_USER_PAGE = "registerUser";
    private static final String REGISTER_NEW_USER = "registerNewUser";
    public static final String MSG_TO_USER = "msg";
    private static final String REGISTRATION_FORM_NAME = "registerDTO";
    private static final String SUCCSESSFUL_LOGIN_MSG = "Your user profile has been created. Log in to proceed.";

    @Autowired
    private LoginService loginService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private Person currentUser;



    @GetMapping(DEFAULT_PAGE_URL)
    public String showDefaultView(LoginDTO loginDTO, Model model) {
        return LOGIN_PAGE;
    }

    @GetMapping("/" + LOGIN_PAGE)
    public String showLoginPage(LoginDTO loginDTO, Model model) {
        return LOGIN_PAGE;
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
        this.currentUser  = loginService.findUserAccount(registerDTO);
        if(this.currentUser != null) {
            model.addAttribute(ExceptionHandler.ERROR_TYPE_KEY, ExceptionHandler.USERNAME_TAKEN);
            return ExceptionHandler.ERROR_PAGE_URL;
        }
        registerDTO.setUserPwd(passwordEncoder.encode(registerDTO.getUserPwd()));
        this.currentUser = loginService.saveNewUser(registerDTO);
        System.out.println("New user saved");
        model.addAttribute(MSG_TO_USER, SUCCSESSFUL_LOGIN_MSG);
        model.addAttribute(LOGIN_FORM_NAME, new LoginDTO());
        return LOGIN_PAGE;
    }

    @GetMapping ("/logintestUser")
    public String showtestPage1() {
        return "logintestUser";
    }

    @GetMapping ("/logintestAdmin")
    public String showtestPage2() {
        return "logintestAdmin";
    }

}
