package jsc.Resource;


import jsc.Service.EmployeeService;
import jsc.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping(path = "/Employee")
@RequiredArgsConstructor
public class EmployeeResource {

    @Autowired
    private final EmployeeService employeeService ;

   @GetMapping("/List")
   public Page<Employee> getEmployees(Pageable pageable) {
       return (Page<Employee>) employeeService.getEmployees();
   }



    @PostMapping("/create")
    public Page<Employee> createEmployees(@RequestBody Employee employee) {
        Pageable pageable = PageRequest.of(0, 10); // Example: set the page number and size
        List<Employee> employees = (List<Employee>) employeeService.getEmployees();
        if (employees == null) {
            return new PageImpl<>(new ArrayList<>(), pageable, 0);
        }
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), employees.size());
        return new PageImpl<>(employees.subList(start, end), pageable, employees.size());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }



}
