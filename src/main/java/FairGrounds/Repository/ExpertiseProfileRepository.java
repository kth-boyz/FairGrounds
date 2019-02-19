package FairGrounds.Repository;

import FairGrounds.Domain.Expertise;
import FairGrounds.Domain.ExpertiseProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpertiseProfileRepository extends JpaRepository<ExpertiseProfile, Integer> {
    @Override
    List<ExpertiseProfile> findAll();
}