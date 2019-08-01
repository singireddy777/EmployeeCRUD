package com.hcl.employee.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
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

	/*@Before
	public Employee getEmployee() {
		Employee employee = new Employee();

		employee.setEmpId(1L);
		employee.setDesignation("Support Engineer");
		employee.setEmpAddress("BTM");
		employee.setEmpEmail("abc@gmail");
		employee.setEmpMobileNo(974322L);
		employee.setEmpName("venkat");
		return employee;
	}*/

	@Test
	public void createEmplyeeTest() {

		Employee employee = new Employee();

		employee.setEmpId(1L);
	employee.setDesignation("Support Engineer");
		employee.setEmpAddress("BTM");
		employee.setEmpEmail("abc@gmail");
		employee.setEmpMobileNo(974322L);
	employee.setEmpName("venkat");
		Mockito.when(empRepository.save(Mockito.any())).thenReturn(employee);
		String result = empServiceImpl.createEmployee(employee);
		assertEquals("employee details are saved successfully.....", result);
	}

	@Test
	public void fetchEmployeebyIdTest() {

		Employee employee = new Employee();
		employee.setEmpId(1L);
		employee.setEmpMobileNo(973799);
		employee.setEmpName("venky");
		employee.setEmpAddress("btm");
		employee.setEmpEmail("abc@gmail");
		employee.setDesignation("developer");

		Mockito.when(empRepository.findByEmpId((long) Mockito.anyLong())).thenReturn(employee);
		// Mockito.when(empRepository.findByEmpId(Mockito.anyInt())).thenReturn(employee);

		Employee actualValue = empServiceImpl.fetchEmployeebyId(1L);

		assertEquals(employee, actualValue);

	}

	@Test
	public void deleteEmpByIdTest() {
		Employee employee = new Employee();
		employee.setDesignation("supprt Engg");
		employee.setEmpId(2L);
		employee.setEmpAddress("kdp");
		employee.setEmpEmail("pqr@gmail");
		employee.setEmpMobileNo(799612L);
		employee.setEmpName("papa");
		
		Mockito.when(empRepository.findByEmpId(Mockito.anyInt())).thenReturn(employee);

		String actualValue = empServiceImpl.deleteEmpById(Mockito.anyLong());

		assertEquals("employee deleted", actualValue);

	}
	@Test
	public void updateEmpByIdTest() {
		Employee employee =  new Employee();
		
		
	employee.setEmpId(1L);	
	employee.setDesignation("developoer");
	employee.setEmpAddress("btm");
	employee.setEmpEmail("abc@gmail");
     employee.setEmpMobileNo(973799L);
     employee.setEmpName("venky");

    Mockito.when(empRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(employee));
    Mockito.when(empRepository.save(employee)).thenReturn(employee);
    String result = empServiceImpl.updateEmpById(Mockito.anyLong());
    assertEquals("employee updated Successfully.....", result);
	}

	@Test
	public void getEmployeeListTest() {
		
		List<Employee> empList = new ArrayList<>();
		
		Employee employee = new Employee();
		
		employee.setDesignation("dev");
		employee.setEmpAddress("btm");
		employee.setEmpEmail("xyz@gmail");
		employee.setEmpId(2L);
		employee.setEmpMobileNo(973923L);
		employee.setEmpName("vensee");
		
		empList.add(employee);
		
		Employee employee1 = new Employee();
		
		employee1.setDesignation("test");
		employee1.setEmpAddress("ecity");
		employee1.setEmpEmail("pqr@gmail");
		employee1.setEmpId(2L);
		employee1.setEmpMobileNo(973923L);
		employee1.setEmpName("venky");
		empList.add(employee1);
		
		Mockito.when(empRepository.findAll()).thenReturn(empList);

		List<Employee> empList1 = empServiceImpl.getEmployeeList();
		assertEquals(2, empList1.size());
	}
}

