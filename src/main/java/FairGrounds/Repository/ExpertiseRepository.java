package FairGrounds.Repository;

import FairGrounds.Domain.Expertise;
import FairGrounds.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpertiseRepository  extends JpaRepository<Expertise, Integer> {
    @Override
    List<Expertise> findAll();
}
