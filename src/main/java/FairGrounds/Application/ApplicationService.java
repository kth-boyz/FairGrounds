package FairGrounds.Application;

import FairGrounds.Domain.*;
import FairGrounds.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
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
        UserDetails userDetails =
                (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
           return personRepository.findByUsername(userDetails.getUsername());
        }

        System.out.println("NULLLLLLLLL");
        return null;
    }

    /**
     * Stores application and all expertiseprofiles and availabilities connected to it
     * @param application - Stored Application
     */
    public void storeApplication(Application application){


        Application check = registerApplicationRepository.findApplicationByPerson(application.getPerson());
        if(check!=null){
            System.out.println("IT FUCKING EXISTS OKKKKKKKKKKKKKK: " + check.getId().intValue());
            check=application;
            registerApplicationRepository.save(check);
        }

        else {
            Date date = new Date();
            date.setHours(0);
            date.setMinutes(0);
            date.setSeconds(0);
            application.setApplicationdate(date);
            registerApplicationRepository.save(application);
        }
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
    }

    public Application getApplication(Long id){
        return registerApplicationRepository.findApplicationById(id);
    }
}
