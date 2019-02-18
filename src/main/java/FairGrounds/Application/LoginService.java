package FairGrounds.Application;

import FairGrounds.Domain.Person;
import FairGrounds.Presentation.LoginDTO;
import FairGrounds.Presentation.RegisterDTO;
import FairGrounds.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class LoginService implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String uName) {
        Person person = personRepository.findByUname(uName);
        return new org.springframework.security.core.userdetails.User(person.getEmail(), person.getPwd(), getAuthorities(person.getRoleId()));
    }

    public UserDetails findUserAccount(LoginDTO loginDTO) {
        return loadUserByUsername(loginDTO.getUserLoginName());
    }

    public Person findUserAccount(RegisterDTO registerDTO) {
        return personRepository.findByUname(registerDTO.getUserName());
    }

    public Person saveNewUser(RegisterDTO registerDTO) {
        Person newUser = new Person(registerDTO);
        return personRepository.save(newUser);
    }

    private static List<GrantedAuthority> getAuthorities (String roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roles));
        return authorities;
    }
}
