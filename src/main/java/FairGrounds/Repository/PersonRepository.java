package FairGrounds.Repository;

import FairGrounds.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByUsername(String Username);

    @Override
    Person save(Person person);
<<<<<<< HEAD

    @Override
    Person save(Person person);
=======
>>>>>>> 558fd643e661dd430f6dbcb06b58e049e5a89eb3

}
