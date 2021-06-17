package com.example.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

   @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
   public EmployeeController(EmployeeService employeeService) {
       this.employeeService = employeeService;
   }
    @GetMapping("/employee")
    public String addEmployee(Model model){
       model.addAttribute("employee",new Employee());
        return "employee";
    }
    @PostMapping("/employee")
    public String employeeSubmit(@ModelAttribute Employee employee,
                                 Model model) {
      model.addAttribute("employee",employee);
        return "result";
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();

    }
    @PostMapping
    public void registerEmployee (@RequestBody Employee employee) {
        employeeService.addEmployee(employee);

    }
    @DeleteMapping(path="{employeeId}")
    public void removeStudent(@PathVariable("employeeId") Long employeeId) {
       employeeService.deleteEmployee(employeeId);
    }
    @PutMapping(path="{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestParam(required=false)
            String firstName, @RequestParam(required=false)  String lastName, @RequestParam(required=false) String email)
                              {
        employeeService.updateEmployee(employeeId,firstName,lastName,email);

    }



}
