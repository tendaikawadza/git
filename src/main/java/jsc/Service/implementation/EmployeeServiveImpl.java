package jsc.Service.implementation;

import jakarta.transaction.Transactional;
import jsc.Service.EmployeeService;
import jsc.model.Employee;
import jsc.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiveImpl implements EmployeeService {
    public final EmployeeRepo employeeRepo;


    @Override
    public Employee createEmployee(Employee employee) {
    employee.setCreatedAt(new Date());
        return employeeRepo.save(employee);
    }


//    @Override.
//    public Customer createCustomer(Customer customer) {
//        customer.setCreatedAt(new Date());
//        return customerRepository.save(customer);
//    }


    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public Page<Employee> getEmployee(int page, int size) {
        return null;
    }

    @Override
    public Iterable<Employee> getEmployees() {
        return null;
    }

    @Override
    public Employee getEmployee(Long id) {
        return null;
    }

    @Override
    public Page<Employee> searchEmployees(String name, int page, int size) {
        return null;
    }

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return Optional.empty();
    }


}
