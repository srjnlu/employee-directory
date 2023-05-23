/**
 * 
 */
package day1.task2.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import day1.task2.demo.entity.Employee;

/**
 * @author Abhishek_Singh6
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
