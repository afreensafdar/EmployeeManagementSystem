package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeApplication.class, args);

//		ConfigurableApplicationContext configurableApplicationContext =
//				SpringApplication.run(EmployeeApplication.class, args);
//		EmployeeRepository employeeRepository =
//				configurableApplicationContext.getBean(EmployeeRepository.class);
//		Employee employee1 = new Employee("Ben","Harry","leo@gmail");
//
//		Employee employee2 = new Employee("Benny","larry","leo@gmail");
//		employeeRepository.saveAll(List.of(employee1, employee2));
	}
}
