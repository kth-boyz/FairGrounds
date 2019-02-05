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
    public static final String USER_NOT_FOUND = "user-not-found";
    public static final String INVALID_PWD = "invalid.password";

    @Override
    public String getErrorPath() {
        return "/" + ERROR_PATH;
    }
}
