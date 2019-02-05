package FairGrounds.Application;

import FairGrounds.Domain.Person;
import FairGrounds.Presentation.ExceptionHandler;
import FairGrounds.Presentation.LoginDTO;
import FairGrounds.Presentation.RegisterDTO;
import FairGrounds.Repository.PersonRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LoginService {

    @Autowired
    PersonRepository personRepository;

    public Person findUserAccount(LoginDTO loginDTO) {
        return personRepository.findByUname(loginDTO.getUserLoginName());
    }

    public Person saveNewUser(RegisterDTO registerDTO) {
        Person newUser = new Person(registerDTO);
        return personRepository.save(newUser);
    }

    public Person validateNewUser(RegisterDTO registerDTO) {
        return personRepository.findByUname(registerDTO.getUserName());
    }
}
