package FairGrounds.Repository;

import FairGrounds.Domain.Expertise;
import FairGrounds.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpertiseRepository  extends JpaRepository<Expertise, Integer> {
    @Override
    List<Expertise> findAll();
}
