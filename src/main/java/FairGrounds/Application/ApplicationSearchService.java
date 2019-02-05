package FairGrounds.Application;

import FairGrounds.Domain.ApplicationDTO;
import FairGrounds.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class ApplicationSearchService {

    @Autowired
    ApplicationRepository applicationRepository;

    public ApplicationDTO getQueriedApplications(String name, String date,
                                                 String workFrom, String workTo) {
        return applicationRepository.findPersonByfname(name);
    }
}
