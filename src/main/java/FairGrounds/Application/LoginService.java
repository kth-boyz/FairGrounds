package FairGrounds.Application;

import FairGrounds.Domain.Person;
import FairGrounds.Presentation.RegisterDTO;
import FairGrounds.Repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Arrays;


@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class LoginService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     *  Fetches user data bound to the username
     * @param username - user to be logged in as
     * @return - Object that holds user information
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        Person person = personRepository.findByUsername(username);
        if(person == null) {
            throw new UsernameNotFoundException(username);
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(person.getRole());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(person.getUsername(), person.getPwd(), Arrays.asList(authority));
        logger.trace(person.getUsername() + " logged in");
        return userDetails;
    }

    /**
     * tries to find user in databaase
     * @param registerDTO - object holder with user details
     * @return - returns the found user
     */
    public Person findUserAccount(RegisterDTO registerDTO) {
        return personRepository.findByUsername(registerDTO.getUserName());
    }

    /**
     *
     * @param registerDTO - object holder with user details
     * @return - object Person
     */
    public Person saveNewUser(RegisterDTO registerDTO) {
        Person newUser = new Person(registerDTO);
        return personRepository.save(newUser);
    }
}
