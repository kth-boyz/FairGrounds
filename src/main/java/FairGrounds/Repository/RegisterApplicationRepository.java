package FairGrounds.Repository;

        import FairGrounds.Domain.Application;
        import FairGrounds.Domain.Expertise;
        import FairGrounds.Domain.Person;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import org.springframework.transaction.annotation.Propagation;
        import org.springframework.transaction.annotation.Transactional;

        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface RegisterApplicationRepository extends JpaRepository<Application, Long> {

    /**
     * Finds all Applications
     * @return a list of Applications
     */
    @Override
    List<Application> findAll();

    /**
     * deletes an application
     * @param integer the primary key of the Application
     */
    @Override
    void deleteById(Long integer);

    /**
     * Fins an Application by the primary key
     * @param id the primary key
     * @return an Application
     */
    Application findApplicationById(Long id);

    /**
     *  Fins an Application by the person
     * @param person object of Person
     * @return an object of Application
     */
    Application findApplicationByPerson(Person person);
}
