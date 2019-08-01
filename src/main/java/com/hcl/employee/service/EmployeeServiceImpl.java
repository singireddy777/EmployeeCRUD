package com.hcl.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.entity.Employee;
import com.hcl.employee.repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired EmployeeRepository empRepo;

	@Override
	public String createEmployee(Employee employee) {
		if(empRepo.save(employee)!=null) {			
			return "employee details are saved successfully.....";
		}else {
			return "employee details are not saved successfully.....";
		}
	}

	public Employee fetchEmployeebyId(long empId) {
		  return empRepo.findByEmpId(empId);
				 
			
	}

	/*public Employee fetchEmployeebyId(long empId) {
		return empRepo.findById(empId).get();
	}*/
	
	public String deleteEmpById(long empId) {
		empRepo.deleteById(empId);
		return "employee deleted";
	}
	@Override
	public String updateEmpById(long empId) {
		
		Employee employee = empRepo.findById(empId).get();
		
	employee.setDesignation("Support Engineer");
	
	if(empRepo.save(employee) != null) {
		
		return "employee updated Successfully.....";
		
	}else 
		return "unable to update employee.....";
	}
	public List<Employee> getEmployeeList() {
return empRepo.findAll();
	}

}
