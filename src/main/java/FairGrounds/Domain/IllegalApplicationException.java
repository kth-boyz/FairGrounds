
package FairGrounds.Domain;

/**
 * Exception for if something goes wrong in the application
 */
public class IllegalApplicationException extends Exception {
    public IllegalApplicationException(String msg){
        super(msg);
    }
}

