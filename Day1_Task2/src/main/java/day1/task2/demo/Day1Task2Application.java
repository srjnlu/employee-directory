package day1.task2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"day1.task2.demo","day1.task2.demo.config"})
public class Day1Task2Application {

	public static void main(String[] args) {
		SpringApplication.run(Day1Task2Application.class, args);
	}

}
