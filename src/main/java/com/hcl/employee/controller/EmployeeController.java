package com.hcl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<String>(empService.createEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/employee/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empId) {
		return new ResponseEntity<Employee>(empService.fetchEmployeebyId(empId), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable long empId) {
		
		return new ResponseEntity<String>(empService.deleteEmpById(empId),HttpStatus.OK);
	}
	@PutMapping("/employee/{empId}")
	public ResponseEntity<String> updateEmployeeById(@PathVariable long empId) {
		return new ResponseEntity<String>(empService.updateEmpById(empId), HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployees")
	
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		return new ResponseEntity<List<Employee>>(empService.getEmployeeList(), HttpStatus.OK);
		
	}

}
