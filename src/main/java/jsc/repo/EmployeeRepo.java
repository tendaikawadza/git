package jsc.repo;

import jsc.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Long> {

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByFirstName(String firstName, Pageable pageable);

    Employee save(Employee employee);
}
