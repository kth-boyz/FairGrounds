package FairGrounds.Repository;

import FairGrounds.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface PersonRepository extends JpaRepository<Person, Integer> {

    /**
     * Fins a person by its username
     * @param Username - the username of the person
     * @return - an object of Person
     */
    Person findByUsername(String Username);

    /**
     * Save an object of Person
     * @param person the Person to be saved
     * @return the saved Person object
     */
    @Override
    Person save(Person person);

}
