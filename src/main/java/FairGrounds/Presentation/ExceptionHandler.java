package FairGrounds.Presentation;


import FairGrounds.Domain.IllegalApplicationException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.sun.corba.se.impl.activation.ServerMain.APPLICATION_ERROR;

@Controller
@ControllerAdvice
public class ExceptionHandler implements ErrorController{

    private static final String ERROR_PATH = "failure";
    public static final String ERROR_PAGE_URL = "pub/error";
    public static final String ERROR_TYPE_KEY = "errorType";
    public static final String USER_NOT_FOUND = "The specified user could not be found";
    public static final String INVALID_PWD = "The password you entered was incorrect";
    public static final String USERNAME_TAKEN = "The username is already taken";
    public static final String APPLICATION_ERROR = "appError";

    /**
     *
     * @return error page
     */
    @Override
    public String getErrorPath() {
        return "/" + ERROR_PATH;
    }

    @ExceptionHandler(IllegalApplicationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String applicationError(Exception exception, Model model) {
        model.addAttribute(ERROR_TYPE_KEY, APPLICATION_ERROR);
        return ERROR_PAGE_URL;
    }

}

