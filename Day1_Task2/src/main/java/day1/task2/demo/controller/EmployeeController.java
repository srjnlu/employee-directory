/**
 * 
 */
package day1.task2.demo.controller;

import java.util.List;

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
	
	@ApiOperation(value = "Get all the user", response = Employee.class)
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmp() {

		List<Employee> allEmp = employeeService.getAllEmp();
		return new ResponseEntity<List<Employee>>(allEmp, HttpStatus.OK);
	}

	@ApiOperation(value = "Get the user by passing id", response = Employee.class)
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmpById(@ApiParam(value = "The id of the user") @PathVariable("id") int id) {

		Employee emp = employeeService.getEmpById(id);
		if (emp != null) {
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/v1/{name}")
	public ResponseEntity<List<Employee>> getEmpByName(@PathVariable("name") String name){
		
		if(name==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		List<Employee> emp = employeeService.getEmpByName(name);
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee emp) {
		Employee savedEmp = employeeService.addEmp(emp);
		return new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
	}

	@GetMapping("/allEmp")
	public void getEmpByDept() {
		employeeService.getEmpByDepartment();
		employeeService.getMaxSalByDepartment();
		employeeService.getEmpByAge();
		employeeService.sortEmpByAge();
	}

}
