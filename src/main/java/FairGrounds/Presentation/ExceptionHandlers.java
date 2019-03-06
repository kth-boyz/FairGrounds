package FairGrounds.Presentation;


import FairGrounds.Domain.IllegalApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
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
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    /**
     *
     * @return error path
     */
    @Override
    public String getErrorPath() {
        return "/" + ERROR_PATH;
    }

    /**
     *
     * @param exception the exception that is thrown on the server
     * @param model the view model
     * @return the default error page
     */
    @ExceptionHandler (Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception exception, Model model) {
        logger.error("INTERNAL SERVER ERROR: " + exception.getMessage());
        model.addAttribute(ERROR_TYPE_KEY, INTERNAL_GENERIC_ERROR);
        return ERROR_PAGE_URL;
    }

    /**
     *  Catches the 404 - page not found error
     * @param exception the exception that is thrown
     * @param model the view model
     * @return the default error page
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pageNotFound(Exception exception, Model model) {
        logger.error("404 NOT FOUND ERROR: " + exception.getMessage());
        model.addAttribute(ERROR_TYPE_KEY, PAGE_NOT_FOUND);
        return ERROR_PAGE_URL;
    }

    /**
     * Catches errors invoked on application submission
     * @param exception exception for when something goes wrong in application submission
     * @param model - binds values to html
     * @return error page
     */
    @ExceptionHandler(IllegalApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String ApplicationError(Exception exception, Model model) {
        logger.error("APPLICATION ERROR: " + exception.getMessage());
        model.addAttribute(ERROR_TYPE_KEY, APPLICATION_ERROR);
        return ERROR_PAGE_URL;
    }
}
