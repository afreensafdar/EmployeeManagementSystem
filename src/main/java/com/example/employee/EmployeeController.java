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


//    @PostMapping("/employee")
//    public String employeeSubmit(@ModelAttribute Employee employee){
//        model.addAttribute("employee",employeeService.
//                getAllEmployees());
//        return "result";
//    }

//
//
//
//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
//            throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//        return ResponseEntity.ok().body(employee);
//    }
//
//    @PostMapping("/employees")
//    public Employee createEmployee(@Valid @RequestBody Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
//                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employee.setEmailId(employeeDetails.getEmailId());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setFirstName(employeeDetails.getFirstName());
//        final Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
//            throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employeeRepository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }




//
//
//
//
//
//    ///
//    @GetMapping("/employees/{id}")
//    public Employee getEmployee(@PathVariable int id){
//        return employeeService.getEmployee(id);
//    }
//
//    // inserting employee
//    @PostMapping("/employees")
//    public void addEmployees(@RequestBody Employee employee){
//        employeeService.addEmployee(employee);
//    }
//
//    //updating employee by id
//    @PutMapping("/employees/{id}")
//    public void updateEmployee(@RequestBody Employee e, @PathVariable int id){
//        employeeService.updateEmployee(e, id);
//    }
//
//    // deleting all employees
//    @DeleteMapping("/employees")
//    public void deleteAllEmployees(){
//        employeeService.deleteAllEmployees();
//    }
//
//    // deleting employee by id
//    @DeleteMapping("employees/{id}")
//    public void deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id){
//        employeeService.deleteEmployeeByID(id);
//    }



}
