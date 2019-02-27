package FairGrounds.Repository;

import FairGrounds.Domain.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    @Override
    List<Availability> findAll();
}
