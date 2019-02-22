package FairGrounds.Application;

import FairGrounds.Domain.Person;
import FairGrounds.Presentation.RegisterDTO;
import FairGrounds.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Arrays;


@Transactional
@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Person person = personRepository.findByUsername(username);
        if(person == null) {
            throw new UsernameNotFoundException(username);
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(person.getRole());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(person.getEmail(), person.getPwd(), Arrays.asList(authority));
        return userDetails;
    }

    public Person findUserAccount(RegisterDTO registerDTO) {
        return personRepository.findByUsername(registerDTO.getUserName());
    }

    public Person saveNewUser(RegisterDTO registerDTO) {
        Person newUser = new Person(registerDTO);
        return personRepository.save(newUser);
    }
}
