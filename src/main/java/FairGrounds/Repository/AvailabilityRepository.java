package FairGrounds.Repository;

import FairGrounds.Domain.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
    @Override
    List<Availability> findAll();
}
