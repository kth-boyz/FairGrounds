package FairGrounds.Repository;

import FairGrounds.Domain.Application;
import FairGrounds.Domain.ApplicationDTO;
import FairGrounds.Domain.ExpertiseProfile;
import FairGrounds.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Person, ApplicationDTO> {

    /*Person findPersonByfname(String name);

    String query1 = "SELECT ep " +
            "FROM ExpertiseProfile ep inner join ep.expertise e where e.name = :expertise";
    @Query(query1)
    List<ExpertiseProfile> findAll(@Param("expertise") String expertise); */

    String query = "SELECT DISTINCT a " +
            "FROM Application a " +
            "INNER JOIN a.person p " +
            "INNER JOIN a.expertiseProfile ep "+
            "WHERE ep.expertise.name LIKE CONCAT('%', :expertise, '%')" +
            "AND p.fname LIKE CONCAT('%', :name, '%')";
    @Query(query)
    List<Application> findAll(@Param("name") String name, @Param("expertise") String expertise);
}

    /*String query = "SELECT a " +
            "FROM Application a " +
            "INNER JOIN a.person p WHERE (p.fname = :name OR p.fname IS NULL) " +
            "INNER JOIN a.expertiseProfile ep " +
            "WHERE (ep.expertise.name = :expertise OR ep.expertise.name IS NULL) " +
            "INNER JOIN a.availability aa " +
            "WHERE (aa.fd = :fromDate OR aa.fd IS NULL) AND (aa.td = :toDate OR aa.td IS NULL)"

            ,
                              @Param("expertise") String expertise,
                              @Param("fromDate") Date fromDate,
                              @Param("toDate") Date toDate*/

