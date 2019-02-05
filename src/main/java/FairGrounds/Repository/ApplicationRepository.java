package FairGrounds.Repository;

import FairGrounds.Domain.ApplicationDTO;
import FairGrounds.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Person, ApplicationDTO> {

    ApplicationDTO findPersonByfname(String name);
}
