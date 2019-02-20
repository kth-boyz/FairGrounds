package FairGrounds.Repository;

        import FairGrounds.Domain.Application;
        import FairGrounds.Domain.Expertise;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import org.springframework.transaction.annotation.Transactional;

        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import java.util.List;

@Repository
public interface RegisterApplicationRepository extends JpaRepository<Application, Integer> {

    @Override
    List<Application> findAll();
    Application findApplicationById(Long id);
}
