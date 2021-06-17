package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();

    }

    public void addEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("employee already exists");

        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new IllegalStateException("employee not found");
        }
        employeeRepository.deleteById(employeeId);
    }


    // fetching employee by id
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findOne(employeeId);
    }


    // deleting all employees
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

//    // deleting employee by id
    public void deleteEmployeeByID(Long employeeId) {
        employeeRepository.delete(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String firstName, String lastName, String email) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new IllegalStateException("employee not found"));

        if (!employee.getFirstName().equals(firstName) && firstName != null) {
            employee.setFirstName(firstName);
        }

        if (!employee.getLastName().equals(lastName) && lastName != null) {
            employee.setLastName(lastName);
        }
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Email already exists");
        } else if (!employee.getEmail().equals(email) && email != null) {
            employee.setEmail(email);
        }

    }
}

