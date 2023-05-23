package day1.task2.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day1.task2.demo.dao.EmployeeRepository;
import day1.task2.demo.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee getEmpById(Integer id) {

		return employeeRepository.findById(id).orElse(null);

	}

	public List<Employee> getEmpByName(String name) {
		
		List<Employee>emp = employeeRepository.findByName(name);

		return emp;
	}

	public List<Employee> getAllEmp() {
		return employeeRepository.findAll();
	}

	public Employee addEmp(Employee emp) {
		return employeeRepository.save(emp);
	}

	// day1
	public void getEmpByDepartment() {
		List<Employee> allEmp = employeeRepository.findAll();
		System.out.println("========================= group of emp by dept =================================");
		allEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment))
				.forEach((dept, emp) -> System.out.println(dept + ": " + emp));
	}

	// day1
	public void getMaxSalByDepartment() {
		List<Employee> allEmp = employeeRepository.findAll();
		System.out.println("========================= max salary by dept =================================");// collecting().andThen()
		Map<String, Double> maxSalariesByDepartment = allEmp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.mapping(Employee::getSalary, Collectors.maxBy(Double::compare))))
				.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().orElse(null)));
		maxSalariesByDepartment.forEach((dept, salary) -> System.out.println(dept + ":" + salary));
	}

	// day2 task(6.1)
	// Use predicate function to find the age of an employee greater than 28 and
	// print the employee (Note: use method reference )
	public void getEmpByAge() {
		List<Employee> allEmp = employeeRepository.findAll();
		System.out.println("========================= Employee greater than 28 =================================");
		allEmp.stream().filter(e -> e.getAge() > 28).forEach(System.out::println);
	}

	// day2 task(6.2)
	// Sort the employees based on age
	public void sortEmpByAge() {
		List<Employee> allEmp = employeeRepository.findAll();
		System.out.println("========================= Employee Ascending order by age =============================");
		allEmp.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);

	}

}
