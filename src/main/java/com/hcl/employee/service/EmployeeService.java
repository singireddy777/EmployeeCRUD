package com.hcl.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.employee.entity.Employee;

@Service
public interface EmployeeService {

	public String createEmployee(Employee employee);
	public Employee fetchEmployeebyId(long empId);
	public String deleteEmpById(long empId);
	public String updateEmpById(@PathVariable long empId);
	public List<Employee> getEmployeeList();

}
