package FairGrounds.Application;

import FairGrounds.Domain.*;
import FairGrounds.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class ApplicationSearchService {

    @Autowired
    ApplicationRepository applicationRepository;

    public List<ApplicationDTO> getQueriedApplications(String name, String expertise, String date,
                                              Date workFrom, Date workTo) {
        List <Application> applications = this.applicationRepository.findAll(name, expertise);
        System.out.println(applications);
        List<ApplicationDTO> applicationData = new ArrayList<>();

        for (Application a : applications) {
            applicationData.add(new ApplicationDTO(a.getPerson().getFname(), a.getPerson().getLname()));
        }

        return applicationData;
    }
}
