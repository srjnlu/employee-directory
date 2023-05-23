/**
 * 
 */
package day1.task2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day1.task2.demo.entity.Employee;
import day1.task2.demo.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Abhishek_Singh6
 *
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@ApiOperation(value="Get the user by passing id",response=Employee.class)
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmpById(@ApiParam(value="The id of the user") @PathVariable("id") int id) {
		
		Employee emp = employeeService.getEmpById(id);		
		if(emp!=null) {
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee emp){
		Employee savedEmp = employeeService.addEmp(emp);
		return new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public void getEmpByDept() {
		employeeService.getEmpByDepartment();
		employeeService.getMaxSalByDepartment();
		employeeService.getEmpByAge();
		employeeService.sortEmpByAge();
	}

}
