package FairGrounds.Domain;

import FairGrounds.Presentation.RegisterDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class not used.
 */
public class Recruiter extends Person {


    public Recruiter(RegisterDTO registerDTO) {
        super(registerDTO);
    }
}
