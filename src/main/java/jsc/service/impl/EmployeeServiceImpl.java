package jsc.service.impl;

import jakarta.transaction.Transactional;
import jsc.exception.EntityNotFoundException;
import jsc.service.EmployeeService;
import jsc.model.Employee;
import jsc.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    public final EmployeeRepo employeeRepo;


    @Override
    public Employee createEmployee(Employee employee) {
        employee.setCreatedAt(new Date());
        return employeeRepo.save(employee);
    }


    @Override
    public Employee updateEmployee(Employee employee) {

        Optional<Employee> employeeOptional = employeeRepo.findById(employee.getId());
        if(!employeeOptional.isPresent()){
            throw new EntityNotFoundException("Employee not found with Id : "+employee.getId());
        }

        Employee employee1 = employeeOptional.get();
        employee1.setEmail(employee.getEmail());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee1.getLastName());
        employee1.setCreatedAt(new Date());

        return employeeRepo.save(employee1);
    }



    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if(!employeeOptional.isPresent()){
            return Optional.empty();
        }
        return employeeOptional;
    }

    @Override
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }


}
