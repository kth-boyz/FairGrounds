package FairGrounds.Repository;

import FairGrounds.Domain.Expertise;
import FairGrounds.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface ExpertiseRepository  extends JpaRepository<Expertise, Integer> {

    /**
     *Fins all Expertise
     * @return a list of Expertise
     */
    @Override
    List<Expertise> findAll();

    /**
     * Finds an expertise by its name
     * @param name the name of the expertise
     * @return an expertise
     */
    Expertise findByName(String name);
}
