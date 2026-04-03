package com.mane.umakant.java8.chatGptStreamImp;

import java.util.List;

public class EmployeeDataFactory {

	public static List<Employee> getEmployees() {

		Department hr = new Department(1, "HR");
		Department it = new Department(2, "IT");

		Employee e1 = new Employee(1, "Amit", 30, "Male", 50000, it, List.of("Java", "Spring"),
				List.of("ProjectA", "ProjectB"));

		Employee e2 = new Employee(2, "Neha", 28, "Female", 60000, hr, List.of("Excel", "Communication"),
				List.of("HRTool"));

		Employee e3 = new Employee(3, "Raj", 35, "Male", 70000, it, List.of("Java", "Kafka"), List.of("ProjectA"));

		Employee e4 = new Employee(4, "Priya", 32, "Female", 55000, it, List.of("React", "JS"), List.of("FrontendX"));

		// Link employees to departments
		it.addEmployee(e1);
		it.addEmployee(e3);
		it.addEmployee(e4);
		hr.addEmployee(e2);

		return List.of(e1, e2, e3, e4);
	}
}