package com.hcl.employee.test;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.employee.entity.Employee;
import com.hcl.employee.repository.EmployeeRepository;
import com.hcl.employee.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	
	@Mock
	EmployeeRepository empRepository;
	
	@InjectMocks
	EmployeeServiceImpl empServiceImpl;
	@Test
	public void createEmplyeeTest() {
		
		Employee employee = new Employee();
		
		employee.setEmpId(1L);
		employee.setDesignation("Support Engineer");
		employee.setEmpAddress("BTM");
		employee.setEmpEmail("abc@gmail");
		employee.setEmpMobileNo(974322L);
		employee.setEmpName("venkat");
		Mockito.when(empRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
		String result = empServiceImpl.createEmployee(employee);
		assertEquals("employee details are saved successfully.....", result);
	}
	@Test
	public void fetchEmpDetailsByIdTest() {
		
		Employee employee=new Employee();
		employee.setEmpId(1);
		employee.setEmpMobileNo(90308);
		employee.setEmpName("charan");
		employee.setEmpAddress("chennai");
		employee.setEmpEmail("abc@gmail");
		employee.setDesignation("s/w engineer");
		
		Mockito.when(empRepository.findById((long) Mockito.anyInt())).thenReturn(employee).get();
		
		String actualValue=empServiceImpl.fetchEmployeebyId(1L);
		
		assertEquals(employee, actualValue);		
		
	}
}
