package FairGrounds.Application;

import FairGrounds.Domain.Person;
import FairGrounds.Presentation.LoginDTO;
import FairGrounds.Presentation.RegisterDTO;
import FairGrounds.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonService extends UserDetailsService {

    UserDetails findUserAccount(LoginDTO loginDTO);

    Person findUserAccount(RegisterDTO registerDTO);

    Person saveNewUser(RegisterDTO registerDTO);

}
