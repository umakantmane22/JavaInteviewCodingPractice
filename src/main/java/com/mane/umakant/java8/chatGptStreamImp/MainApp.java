package com.mane.umakant.java8.chatGptStreamImp;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MainApp {

	public static void main(String[] args) {

		// 👉 List created here using factory
		List<Employee> employees = EmployeeDataFactory.getEmployees();
		/*
		 * // Basic print EmployeeService.printAllEmployees(employees);
		 * 
		 * // Interview practice EmployeeService.findEmployeesWithJavaSkill(employees);
		 * EmployeeService.getAllUniqueSkills(employees);
		 * EmployeeService.groupByDepartment(employees);
		 */
		// EmployeeService.printAllEmployees(employees);
		// System.out.println("----------");
		// 🟢 1. How to find all employees who belong to a specific department (e.g.,
		// "IT")?
		List<Employee> allEmployeesInITdepartment = employees.stream()
				.filter(e -> "IT".equals(e.getDepartment().getName())).toList();
		// System.out.println("allEmployeesInITdepartment:: " +
		// allEmployeesInITdepartment);

		// 🟢 2. How to count the number of employees in each department?
		Map<String, Long> countEmployeesInEachDepartment = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getName(), Collectors.counting()));
		// System.out.println("countEmployeesInEachDepartment::
		// "+countEmployeesInEachDepartment);

		// 🟢 3. How to find the employee with the highest salary?
		Optional<Employee> highestPaidEmployee = employees.stream()
				.max(Comparator.comparingDouble(Employee::getSalary));
		// System.out.println("highestPaidEmployee:: "+highestPaidEmployee);

		// 🟢 4. How to find the second highest salary employee?
		Optional<Employee> secondHighestSalary = employees.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
		if (secondHighestSalary.isPresent()) {
			// System.out.println(secondHighestSalary.get());
		}

		// 🟢 5. How to get a list of all unique skills across all employees?
		List<String> allUniqueSkills = employees.stream().flatMap(innerList -> innerList.getSkills().stream())
				.distinct().toList();
		// System.out.println("allUniqueSkills:: " + allUniqueSkills);

		// 🟢 6. How to count employees based on gender?
		Map<String, Long> countEmployeesByGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		// System.out.println("countEmployeesByGender:: " + countEmployeesByGender);

		// 🟢 7. How to find all employees whose age is greater than 30?
		List<Employee> employeesOlderThan30 = employees.stream().filter(emp -> emp.getAge() > 30).toList();
		// System.out.println("employeesOlderThan30:: " + employeesOlderThan30);

		// 🟢 8. How to calculate the average salary of employees?
		Double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		// System.out.println("averageSalary:: " + averageSalary);

		// 🟢 9. How to group employees by department?
		Map<String, List<Employee>> groupEmployeesByDepartment1 = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getName()));
		// System.out.println("groupEmployeesByDepartment1:: " +
		// groupEmployeesByDepartment1);

		// 🟢 10. How to sort employees by name?
		List<Employee> sortEmployeesByName = employees.stream().sorted(Comparator.comparing(Employee::getName))
				.toList();
		// System.out.println("sortEmployeesByName:: "+sortEmployeesByName);

		/* 🟡 ADVANCED QUESTIONS */

		// 🟡 11. How to find the highest salary employee in each department?

		Map<String, Employee> fiindDepartmentThenHighestSalaryEmployee = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment().getName(), Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
		// System.out.println("fiindDepartmentThenHighestSalaryEmployee:: " +
		// fiindDepartmentThenHighestSalaryEmployee);

		/*
		 * 💡 Explanation: Group first Then apply max inside each group
		 * 
		 */

		// 🟡 12. How to calculate average salary per department?
		Map<String, Double> averageSalaryPerDepartment = employees.stream().collect(Collectors
				.groupingBy(emp -> emp.getDepartment().getName(), Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println("averageSalaryPerDepartment::
		// "+averageSalaryPerDepartment);

		// 🟡 13. How to count employees per skill?
		Map<String, Long> countEmployeesPerSkill = employees.stream()
				.flatMap(innerlist -> innerlist.getSkills().stream())
				.collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));
		// System.out.println("countEmployeesPerSkill:: " + countEmployeesPerSkill);

		// 🟡 14. How to find employees who have a specific skill (e.g., "Java")?
		List<Employee> employeesWhoHaveSpecificSkill = employees.stream()
				.filter(emp -> emp.getSkills().contains("Java")).toList();
		// System.out.println("employeesWhoHaveSpecificSkill::
		// "+employeesWhoHaveSpecificSkill);

		// 🟡 15. How to group all projects by department?
		Map<String, Set<String>> groupAllProjectsByDepartment = employees.stream()
				.collect(Collectors.groupingBy(innerlist -> innerlist.getDepartment().getName(),
						Collectors.flatMapping(emp -> emp.getProjects().stream(), Collectors.toSet())));

		// System.out.println("groupAllProjectsByDepartment::
		// "+groupAllProjectsByDepartment);
		// 🟡 16. How to find duplicate skills?

		List<String> duplicateSkills = employees.stream().flatMap(innerlist -> innerlist.getSkills().stream())
				.collect(Collectors.groupingBy(skill -> skill, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).toList();
		// System.out.println("duplicateSkills:: " + duplicateSkills);

		// 🟡 17. How to partition employees based on salary (> 60000)?
		Map<Boolean, List<Employee>> empWhoseSalaryGreterThan60000Boolean = employees.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getSalary() > 60000));
		List<Employee> empWhoseSalaryGreterThan60000tTrue = empWhoseSalaryGreterThan60000Boolean.get(true);
		List<Employee> empWhoseSalaryGreterThan60000False = empWhoseSalaryGreterThan60000Boolean.get(false);
		// System.out.println("empWhoseSalaryGreterThan60000tTrue::
		// "+empWhoseSalaryGreterThan60000tTrue);

		// 🟡 18. How to get a flat list of all projects?

		List<String> flatListOfAllProjects = employees.stream().flatMap(emp -> emp.getProjects().stream()).distinct()
				.toList();
		// System.out.println("flatListOfAllProjects:: "+flatListOfAllProjects);

		// 🟡 19. How to find employee having maximum number of skills?
		Optional<Employee> employeeWithMaxSkills = employees.stream().filter(e -> e.getSkills() != null) // safety check
				.max(Comparator.comparingInt(emp -> emp.getSkills().size()));
		// System.out.println("employeesWithMaxSkills:: "+employeeWithMaxSkills);
		/*
		 * 
		 * 🔍 How it works internally: Stream compares elements pair by pair Keeps track
		 * of the current maximum If values are equal → keeps the first encountered
		 * 
		 * 👉 In your case:
		 * 
		 * All employees have skills.size() = 2 So no one is “greater” than others
		 * Hence, first element wins → Amit
		 */
// ✅ 3. Correct Approach (Two-Step Solution)
		/*
		 * To handle this properly, we must:
		 * 
		 * ✔️ Step 1: Find maximum skill count ✔️ Step 2: Filter all employees matching
		 * that count
		 */
		// ✅ ✅ Final Solution
		// Step 1: Find max skills count
		int maxSkills = employees.stream().filter(e -> e.getSkills() != null).mapToInt(e -> e.getSkills().size()).max()
				.orElse(0);

		// Step 2: Get all employees with max skills
		List<Employee> employeesListWithMaxSkills = employees.stream().filter(e -> e.getSkills() != null)
				.filter(e -> e.getSkills().size() == maxSkills).toList();

		// Output
		// employeesListWithMaxSkills.forEach(System.out::println);
		// System.out.println("employeesListWithMaxSkills:: " +
		// employeesListWithMaxSkills);

		// 🟡 20. How to group employees by department and then by gender?
		Map<String, Map<String, List<Employee>>> groupEmployeesByDepartmentThenByGender = employees.stream().collect(
				Collectors.groupingBy(emp -> emp.getDepartment().getName(), Collectors.groupingBy(Employee::getGender)

				));
		// System.out.println("groupEmployeesByDepartmentThenByGender::
		// "+groupEmployeesByDepartmentThenByGender);

		// 🔴 EDGE CASE / TRICKY QUESTIONS

		// 🔴 21. How to avoid NullPointerException in streams?
		List<Employee> result = employees.stream()
				.filter(emp -> emp.getSkills() != null && emp.getSkills().contains("Java")).toList();

		// 🔴 22. How to safely handle Optional?
		Employee safelyHandleOptional = employees.stream()
				// .filter(e->e.getId()>1)
				.max(Comparator.comparingDouble(Employee::getSalary))
				.orElseThrow(() -> new RuntimeException("emp not found"));
		// System.out.println("safelyHandleOptional:: "+safelyHandleOptional);

		// 🔴 23. What is problem with List.of()?
		List<String> list = List.of("A", "B");
		// list.add("C"); // Throws UnsupportedOperationException

		// 🔴 24. What is risk of using parallel stream?
		List<String> parallelStream = employees.parallelStream().map(Employee::getName).toList();
		// System.out.println("parallelStream:: "+parallelStream);

		// 🔴 25. How to perform multi-level sorting?
		List<Employee> sortSalaryThenName = employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).toList();
		// System.out.println("sortSalaryThenName:: "+sortSalaryThenName);

		// 26. Asc sort based on name

		List<Employee> ascSortBasedOnName = employees.stream()
				.sorted(Comparator.comparing(Employee::getName, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)))
				.toList();
		// System.out.println("ascSortBasedOnName:: "+ascSortBasedOnName);

		// 27 descending Sort Based on Name
		List<Employee> descendingSortBasedOnName = employees.stream().sorted(
				Comparator.comparing(Employee::getName, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER.reversed())))
				.collect(Collectors.toList());
		System.out.println("Q25: descendingSortBasedOnName:: " + descendingSortBasedOnName);

		Comparator<Employee> nameSortAsc = Comparator.comparing(Employee::getName,
				Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
		Comparator<Employee> nameSortDesc = Comparator.comparing(Employee::getName,
				Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER.reversed()));

// sort based on id in reverse then salary	in reverse	
		List<Employee> idDescThenSalaryDesc = employees.stream().sorted(Comparator.comparingInt(Employee::getId)
				.reversed().thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())).toList();
	}
}