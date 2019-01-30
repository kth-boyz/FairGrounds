package FairGrounds.Repository;

import FairGrounds.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByName(String Username);

}
