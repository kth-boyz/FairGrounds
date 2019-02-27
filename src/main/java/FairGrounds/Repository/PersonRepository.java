package FairGrounds.Repository;

import FairGrounds.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByUsername(String Username);

    @Override
    Person save(Person person);

}
