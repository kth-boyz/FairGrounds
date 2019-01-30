package FairGrounds.Application;

import FairGrounds.Domain.Person;
import FairGrounds.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LoginService {

    @Autowired
    PersonRepository personRepository;

    private Person person;

    public void newPerson() {
        this.person = new Person();
        personRepository.save(person);
    }

    public void logInPerson(String username, String pwd) {
        this.person = personRepository.findByUname(username);
        if(this.person.getPwd().equals(pwd)) {
            //do something dddddddddd
        }
    }


}
