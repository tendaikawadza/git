package jsc.service;

import jsc.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {


    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Long employeeId);

    Page<Employee> getAllEmployees(Pageable pageable);
}
