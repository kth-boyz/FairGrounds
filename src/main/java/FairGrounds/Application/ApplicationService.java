package FairGrounds.Application;

import FairGrounds.Domain.Expertise;
import FairGrounds.Domain.ExpertiseProfile;
import FairGrounds.Domain.ExpertiseProfileDTO;
import FairGrounds.Repository.ExpertiseRepository;
import FairGrounds.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ApplicationService {
    @Autowired
    ExpertiseRepository expertiseRepository;
    @Autowired
    PersonRepository personRepository;

    public List<Expertise> getExpertises(){
        List<Expertise> expertises =  expertiseRepository.findAll();

        return expertises;
    }

}
