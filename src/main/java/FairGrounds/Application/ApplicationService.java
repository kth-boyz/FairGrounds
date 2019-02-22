package FairGrounds.Application;

import FairGrounds.Domain.*;
import FairGrounds.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class ApplicationService {

    @Autowired
    ExpertiseRepository expertiseRepository;
    @Autowired
    PersonRepository personRepository;

    @Autowired
    RegisterApplicationRepository registerApplicationRepository;
    @Autowired
    ExpertiseProfileRepository expertiseProfileRepository;
    @Autowired
    AvailabilityRepository availabilityRepository;

    /**
     *
     * @return - returns all expertises in database
     */
    public List<Expertise> getExpertises(){
        List<Expertise> expertises =  expertiseRepository.findAll();
        return expertises;
    }

    /**
     *
     * @return - returns logged in user (TODO)
     */
    public Person getUser(){
        return personRepository.findByUsername("tods");
    }

    /**
     * Stores application and all expertiseprofiles and availabilities connected to it
     * @param application - Stored Application
     */
    public void storeApplication(Application application){
        for (ExpertiseProfile profile:application.getExpertiseProfile()) {
            Expertise expertise = expertiseRepository.findByName(profile.getExpertise().getName());
            profile.setExpertise(expertise);
            profile.setApplication(application);
            expertiseProfileRepository.save(profile);
        }
        for (Availability availability:application.getAvailabilities()) {
            availability.setApplication(application);
            availabilityRepository.save(availability);
        }
        registerApplicationRepository.save(application);
    }

    public Application getApplication(Long id){
        return registerApplicationRepository.findApplicationById(id);
    }
}
