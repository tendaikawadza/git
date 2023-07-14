package jsc.Service;

import jsc.model.Employee;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EmployeeService {


    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Page<Employee> getEmployee(int page, int size);
    Iterable<Employee>getEmployees();
    Employee getEmployee(Long id);

    Page<Employee>searchEmployees(String name,int page,int size );
    Optional<Employee> getEmployeeById(Long employeeId);
}
