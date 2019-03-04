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
import java.util.Calendar;
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
        return null;
    }

    /**
     * Stores application and all expertiseprofiles and availabilities connected to it
     * @param application - Stored Application
     */
    public void storeApplication(Application application) throws IllegalApplicationException {
        checkApplication(application);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = new Date();
            application.setApplicationdate(calendar.getTime());
            registerApplicationRepository.save(application);

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
    private void checkApplication(Application application) throws IllegalApplicationException {
        if(getUser().getApplication()!=null){
            throw new IllegalApplicationException("User already has application!");
        }
        for (ExpertiseProfile profile:application.getExpertiseProfile()) {
            if(profile.getYears()==null || profile.getYears()<=0){
                throw new IllegalApplicationException("Years is set incorrectly");
            }
            if(profile.getExpertise()==null){
                throw new IllegalApplicationException("Expertise is not set");
            }
        }

        for (Availability availability:application.getAvailabilities()) {
            if(availability.getFromDate()==null || availability.getToDate()==null){
                throw new IllegalApplicationException("Dates must not be null");
            }
            if(availability.getFromDate().after(availability.getToDate())){
                throw new IllegalApplicationException("From date must be after to date");
            }
        }
    }

    public Application getApplication(Long id){
        return registerApplicationRepository.findApplicationById(id);
    }

    public void storeChangedApplication(Application application) throws IllegalApplicationException {
        if(registerApplicationRepository.findApplicationById(application.getId())==null){
            throw new IllegalApplicationException("Application does not exist");
        }
        registerApplicationRepository.save(application);
    }
}
