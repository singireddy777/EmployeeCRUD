package com.hcl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.entity.Employee;
import com.hcl.employee.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired EmployeeServiceImpl empService;
 
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		empService.createEmployee(employee);
		
		return "employee created in table...";
	}
	
	@GetMapping("/employee/{empId}")
	public String getEmployeeById(@PathVariable long empId) {
		return empService.fetchEmployeebyId(empId);
		
	}
	
	@DeleteMapping("/employee/{empId}")
	public String deleteEmployeeById(@PathVariable long empId) {
		
		 empService.deleteEmpById(empId);
		return "deleted employee";
		
	}
	@PutMapping("/employee/{empId}")
	public String updateEmployeeById(@PathVariable long empId) {
		
		 empService.updateEmpById(empId);
		 return "employee updated successfully...";
		
	}
	
	@GetMapping("/getAllEmployees/{empId}")
	
	public List<Employee> getAllEmployees(){
		
		return empService.getEmployeeList();
		
	}

}
