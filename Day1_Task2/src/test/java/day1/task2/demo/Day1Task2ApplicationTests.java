package day1.task2.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import day1.task2.demo.dao.EmployeeRepository;
import day1.task2.demo.entity.Employee;
import day1.task2.demo.service.EmployeeService;

@SpringBootTest
class Day1Task2ApplicationTests {

	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	void contextLoads() {
	}
	
	 @Test
	  public void testGetEmpById() {
	    Employee emp = new Employee(1, "John Doe", 21, "Male", "HR", 2011, 5000.0);
	    when(employeeRepository.findById(1)).thenReturn(Optional.of(emp));
	    Employee result = employeeService.getEmpById(1);
	    assertEquals(emp, result);
	  
	 }
	 
	 @Test
	  public void testAddEmp() {
	    Employee emp = new Employee(2, "Alex", 21, "Male", "Sales", 2011, 23000.0);
	    when(employeeRepository.save(emp)).thenReturn(emp);
	    Employee result = employeeService.addEmp(emp);
	    assertEquals(emp, result);
	  }
}
