package FairGrounds.Application;

import FairGrounds.Domain.*;
import FairGrounds.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ApplicationService {

    @Autowired
    ExpertiseRepository expertiseRepository;
    @Autowired
    PersonRepository personRepository;

    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    ExpertiseProfileRepository expertiseProfileRepository;
    @Autowired
    AvailabilityRepository availabilityRepository;

    public List<Expertise> getExpertises(){
        List<Expertise> expertises =  expertiseRepository.findAll();
        return expertises;
    }
    public Person getUser(){
        return personRepository.findByUname("tods");
    }

    public void storeApplication(Application application){
        for (ExpertiseProfile profile:application.getExpertiseProfiles()) {
            Expertise expertise = expertiseRepository.findByName(profile.getExpertise().getName());
            profile.setExpertise(expertise);
            profile.setApplication(application);
            expertiseProfileRepository.save(profile);
        }
        for (Availability availability:application.getAvailabilities()) {
            availability.setApplication(application);
            availabilityRepository.save(availability);
        }
        applicationRepository.save(application);
    }
}
