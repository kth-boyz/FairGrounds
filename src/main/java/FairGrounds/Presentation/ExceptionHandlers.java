package FairGrounds.Presentation;


import FairGrounds.Domain.IllegalApplicationException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
@ControllerAdvice
public class ExceptionHandlers implements ErrorController{

    private static final String ERROR_PATH = "failure";
    public static final String ERROR_PAGE_URL = "pub/error";
    public static final String ERROR_TYPE_KEY = "errorType";
    public static final String INTERNAL_GENERIC_ERROR = "internalGeneric";
    public static final String USERNAME_TAKEN = "userTaken";
    public static final String PAGE_NOT_FOUND = "pagenotfound";
    public static final String APPLICATION_ERROR = "appError";

    /**
     *
     * @return error page
     */
    @Override
    public String getErrorPath() {
        return "/" + ERROR_PATH;
    }

    @ExceptionHandler (Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception exception, Model model) {
        model.addAttribute(ERROR_TYPE_KEY, INTERNAL_GENERIC_ERROR);
        return ERROR_PAGE_URL;
    }

    @ExceptionHandler(IllegalApplicationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String applicationError(Exception exception, Model model) {
        model.addAttribute(ERROR_TYPE_KEY, APPLICATION_ERROR);
        return ERROR_PAGE_URL;
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pageNotFound(Exception exception, Model model) {
        model.addAttribute(ERROR_TYPE_KEY, PAGE_NOT_FOUND);
        return ERROR_PAGE_URL;
    }


}
