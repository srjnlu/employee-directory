package day1.task2.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abhishek_Singh6
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id	
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String department;
	private Integer YOJ;
	private Double salary;
	

}
