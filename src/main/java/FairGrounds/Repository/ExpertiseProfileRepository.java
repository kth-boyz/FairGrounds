package FairGrounds.Repository;

import FairGrounds.Domain.Expertise;
import FairGrounds.Domain.ExpertiseProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface ExpertiseProfileRepository extends JpaRepository<ExpertiseProfile, Long> {
    @Override
    List<ExpertiseProfile> findAll();
}