package FairGrounds.Presentation;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Controller
@ControllerAdvice
public class ExceptionHandler implements ErrorController{

    private static final String ERROR_PATH = "failure";
    public static final String ERROR_PAGE_URL = "error";
    public static final String ERROR_TYPE_KEY = "errorType";
    public static final String USER_NOT_FOUND = "The specified user could not be found";
    public static final String INVALID_PWD = "The password you entered was incorrect";
    public static final String USERNAME_TAKEN = "The username is already taken";

    @Override
    public String getErrorPath() {
        return "/" + ERROR_PATH;
    }
}
