package FairGrounds.Repository;

import FairGrounds.Domain.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface ApplicationRepository  extends JpaRepository<Application, Integer> {


    String query = "SELECT DISTINCT a " +
            "FROM Application a " +
            "JOIN a.person p " +
            "JOIN a.expertiseProfile ep " +
            "LEFT OUTER JOIN a.availabilities aa " +
            "WHERE ep.expertise.name LIKE CONCAT('%', :expertise, '%')" +
            "AND p.fname LIKE CONCAT('%', :name, '%') " +
            "AND (:appDate is null or a.applicationdate = :appDate) " +
            "AND (:fDate is null or aa.fromDate <= :fDate) " +
            "AND (:tDate is null or aa.toDate >= :tDate)";
    @Query(query)
    Page<Application> findAll(@Param("name") String name,
                              @Param("expertise") String expertise,
                              @Param("appDate") Date applicationDate,
                              @Param("fDate") Date fromDate,
                              @Param("tDate") Date toDate,
                              Pageable pageable);
}
