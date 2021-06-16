package com.example.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
    @GetMapping("/employee")
    public String employeeForm(Model model) {
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "employee";
    }

    @PostMapping("/employee")
    public String employeeSubmit(@ModelAttribute Employee employee,Model model){
        model.addAttribute("employee",employeeService.
                getAllEmployees());
        return "result";
    }


}
