package co.pragra.learning.guestbookservice.repositories;

import co.pragra.learning.guestbookservice.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    //Optional<Employee> findEmployeeByFaName(String fName);
    Optional<Employee> findEmployeeByFirstName(String firstName);


}
