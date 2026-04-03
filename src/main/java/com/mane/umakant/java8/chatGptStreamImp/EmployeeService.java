package com.mane.umakant.java8.chatGptStreamImp;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

	public static void printAllEmployees(List<Employee> employees) {
		employees.forEach(System.out::println);
	}

	public static void findEmployeesWithJavaSkill(List<Employee> employees) {
		System.out.println("\nEmployees with Java skill:");
		employees.stream().filter(e -> e.getSkills().contains("Java")).forEach(System.out::println);
	}

	public static void getAllUniqueSkills(List<Employee> employees) {
		System.out.println("\nUnique Skills:");
		employees.stream().flatMap(e -> e.getSkills().stream()).distinct().forEach(System.out::println);
	}

	public static void groupByDepartment(List<Employee> employees) {
		System.out.println("\nGroup By Department:");
		Map<String, List<Employee>> map = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment().getName()));

		map.forEach((k, v) -> System.out.println(k + " -> " + v));
	}
}