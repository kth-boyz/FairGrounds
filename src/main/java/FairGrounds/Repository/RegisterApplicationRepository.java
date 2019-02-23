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

    @Override
    List<Application> findAll();
    @Override
    void deleteById(Long integer);
    Application findApplicationById(Long id);
    Application findApplicationByPerson(Person person);
}
