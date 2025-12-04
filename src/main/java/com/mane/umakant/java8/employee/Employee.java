// Start https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
package com.mane.umakant.java8.employee;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }

    public static void main(String args[]) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Nitin Joshi", 31, "Male", "Product Development", 2012, 35700.0));


        // 1: How many male and female employees are there in the organization?
        Map<String, Long> How_many_male_and_female_employees_are_there_in_the_organization = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Q1: How_many_male_and_female_employees_are_there_in_the_organization:: " + How_many_male_and_female_employees_are_there_in_the_organization);

        // 2: Print the name of all departments in the organization?
        List<String> name_of_all_departments_in_the_organization = employeeList.stream()
                // .map(e -> e.getDepartment())
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Q2: name_of_all_departments_in_the_organization:: " + name_of_all_departments_in_the_organization);
        // Or
        //employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        // 3 : What is the average age of male and female employees?
        Map<String, Double> average_age_of_male_and_female_employees = employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge))
                );
        System.out.println("Q3: average_age_of_male_and_female_employees:: " + average_age_of_male_and_female_employees);

        // 4 : Get the details of highest paid employee in the organization?
        Optional<Employee> highest_paid_employee = employeeList.stream()
                .max(Comparator.comparing(employee -> employee.getSalary()));
        System.out.println("Q4: highest_paid_employee:: " + highest_paid_employee);
        //or
        System.out.println("highest_paid_employee1:: " +
                employeeList.stream()
                        .max(Comparator.comparing(employee -> employee.getSalary())).get()
        );
        //or
        System.out.println("highest_paid_employee2:: " +
                employeeList.stream()
                        .max(Comparator.comparing((Employee::getSalary)))
        );
        //or
        System.out.println(
                "highest_paid_employee3:: " +
                        employeeList.stream()
                                .sorted(Comparator.comparing((Employee::getSalary)).reversed()).findFirst()
        );
        System.out.println("highest_paid_employee4:: " +
                employeeList.stream()
                        .max(Comparator.comparing(Employee::getSalary))
        );
        Employee highest_paid_employee5 = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println("highest_paid_employee5 id:: " + highest_paid_employee5.getId() + " name:: " + highest_paid_employee5.getName()
                + "gender:: " + highest_paid_employee5.gender);

        // 5 : Get the names of all employees who have joined after 2015?
        List<String> names_of_all_employees_who_have_joined_after_2015 =
                employeeList.stream()
                        .filter(employee -> employee.getYearOfJoining() > 2015)
                        .map(Employee::getName)
                        .collect(Collectors.toList());
        System.out.println("Q5: names_of_all_employees_who_have_joined_after_2015:: " + names_of_all_employees_who_have_joined_after_2015);

        // 6 : Count the number of employees in each department?
        Map<String, Long> Count_the_number_of_employees_in_each_department = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Q6: Count_the_number_of_employees_in_each_department:: " + Count_the_number_of_employees_in_each_department);
        // or
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        // 7 : What is the average salary of each department?
        Map<String, Double> average_salary_of_each_department = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Q7: average_salary_of_each_department:: " + average_salary_of_each_department);
        // or
        System.out.println("average_salary_of_each_department1:: ");
        employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().forEach(System.out::println);
        // or
        System.out.println("average_salary_of_each_department2:: ");
        employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // 8 : Get the details of youngest male employee in the product development department?
        Optional<Employee> details_of_youngest_male_employee_in_the_product_development_department = employeeList.stream()
                .filter(employee -> employee.gender.equals("Male") && employee.department.equalsIgnoreCase("Product Development"))
                .min(Comparator.comparing(Employee::getAge));
        System.out.println("Q8: details_of_youngest_male_employee_in_the_product_development_department:: " + details_of_youngest_male_employee_in_the_product_development_department);
        // or
        Optional<Employee> details_of_youngest_male_employee_in_the_product_development_department1 = employeeList.stream()
                .filter(employee -> employee.gender.equals("Male") && employee.department.equalsIgnoreCase("Product Development"))
                .sorted((e1, e2) -> e1.getAge() - e2.age)
                .findFirst();
        System.out.println("details_of_youngest_male_employee_in_the_product_development_department1:: " + details_of_youngest_male_employee_in_the_product_development_department1);

        // 9 : Who has the most working experience in the organization?
        Optional<Employee> most_working_experience_in_the_organization = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getYearOfJoining))
                .findFirst();
        System.out.println("Q9: most_working_experience_in_the_organization:: " + most_working_experience_in_the_organization);
        // or
        Optional<Employee> most_working_experience_in_the_organization1 = employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining));
        System.out.println("most_working_experience_in_the_organization1:: " + most_working_experience_in_the_organization1);
        // or
        Optional<Employee> most_working_experience_in_the_organization2 = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
        System.out.println("most_working_experience_in_the_organization2:: " + most_working_experience_in_the_organization2);
        //or
        Optional<Employee> most_working_experience_in_the_organization3 = employeeList.stream()
                .sorted((e1, e2) -> e1.getYearOfJoining() - e2.getYearOfJoining())
                .findFirst();
        System.out.println("most_working_experience_in_the_organization3:: " + most_working_experience_in_the_organization3);

        // 10 : How many male and female employees are there in the sales and marketing team?
        Map<String, Long> How_many_male_and_female_employees_are_there_in_the_sales_and_marketing_team = employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Q10: How_many_male_and_female_employees_are_there_in_the_sales_and_marketing_team:: " + How_many_male_and_female_employees_are_there_in_the_sales_and_marketing_team);

        // 11 : What is the average salary of male and female employees?
        Map<String, Double> average_salary_of_male_and_female_employees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Q11: average_salary_of_male_and_female_employees:: " + average_salary_of_male_and_female_employees);

        // 12 : List down the names of all employees in each department? list_down_the_names_of_all_employees_in_each_department
        Map<String, List<String>> employeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Q12: employeesByDepartment :: " + employeesByDepartment);
        // Print the names of employees grouped by department
        employeesByDepartment.forEach((department, names) -> {
            System.out.println("Department: " + department);
            names.forEach(name -> System.out.println("  - " + name));
        });

        // 13 : What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics average_salary_and_total_salary_of_the_whole_organization = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Q13: average_salary_and_total_salary_of_the_whole_organization: " + average_salary_and_total_salary_of_the_whole_organization);
        System.out.println("count: " + average_salary_and_total_salary_of_the_whole_organization.getCount());
        System.out.println("sum: " + average_salary_and_total_salary_of_the_whole_organization.getSum());
        System.out.println("min: " + average_salary_and_total_salary_of_the_whole_organization.getMin());
        System.out.println("average: " + average_salary_and_total_salary_of_the_whole_organization.getAverage());
        System.out.println("max: " + average_salary_and_total_salary_of_the_whole_organization.getMax());
        //or
        OptionalDouble average_salary_of_employees = employeeList.stream()
                .mapToDouble(e -> e.getSalary()).average();
        if (average_salary_of_employees.isPresent()) {
            System.out.println("average_salary_of_employees:: " + average_salary_of_employees);
        }

        // 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        // Partition employees into two groups: <= 25 years old and > 25 years old
        Map<Boolean, List<Employee>> partitionedEmployees = employeeList.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() <= 25));

        // Print employees who are 25 or younger
        System.out.println("EQ14: mployees who are 25 years old or younger:");
        partitionedEmployees.get(true).forEach(emp ->
                System.out.println(emp.getName() + " (Age: " + emp.getAge() + ")"));

        // Print employees who are older than 25
        System.out.println("\nEmployees who are older than 25 years old:");
        partitionedEmployees.get(false).forEach(emp ->
                System.out.println(emp.getName() + " (Age: " + emp.getAge() + ")"));
        Set<Map.Entry<Boolean, List<Employee>>> entrySet = partitionedEmployees.entrySet();
        for (Map.Entry<Boolean, List<Employee>> entry : entrySet) {
            System.out.println("---");
            if (entry.getKey()) {
                System.out.println("Employees who are 25 years old or younger:");
            } else {
                System.out.println("Employees who are older than 25");
            }
            List<Employee> list = entry.getValue();
            for (Employee e : list
            ) {
                System.out.println("name:: " + e.name + ", age::" + e.getAge());
            }
        }
        // or
        List<Employee> who_are_25_or_younger = employeeList.stream()
                .filter(e -> e.getAge() < 25)
                .collect(Collectors.toList());
        System.out.println("who_are_25_or_younger:: " + who_are_25_or_younger);

        // 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<Employee> oldest_employee_in_the_organization = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge));
        System.out.println("Q15: oldest_employee_in_the_organization:: " + oldest_employee_in_the_organization);
        if (oldest_employee_in_the_organization.isPresent()) {
            System.out.println("oldest_employee_in_the_organization age: " + oldest_employee_in_the_organization.get().name);
            System.out.println("oldest_employee_in_the_organization name: " + oldest_employee_in_the_organization.get().age);
        } else {
            System.out.println("oldest_employee_in_the_organization not found.");
        }

        // End https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
        // 16: find the smallest record based on age
        Optional<Employee> smallest_record_based_on_age = employeeList.stream()
                .min(Comparator.comparing(Employee::getAge));
        System.out.println("Q16: smallest_record_based_on_age:: " + smallest_record_based_on_age);
        // or
        Optional<Employee> smallest_record_based_on_age2 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge)).findFirst();
        System.out.println("smallest_record_based_on_age2:: " + smallest_record_based_on_age2);
        //or
        Optional<Employee> smallest_record_based_on_age3 = employeeList.stream()
                .sorted((e1, e2) -> e1.age - e2.getAge())
                .findFirst();
        System.out.println("smallest_record_based_on_age3:: " + smallest_record_based_on_age3);

        // 17: find the highest age of a employee details?
        Optional<Employee> highest_age_of_a_employee_details = employeeList.stream()
                .max(Comparator.comparing(Employee::getAge));
        System.out.println("Q17: highest_age_of_a_employee_details:: " + highest_age_of_a_employee_details);
        // or
        Optional<Employee> highest_age_of_a_employee_details2 = employeeList.stream()
                .sorted((e1, e2) -> e2.age - e1.getAge())
                .findFirst();
        System.out.println("highest_age_of_a_employee_details2:: " + highest_age_of_a_employee_details2);
        // or
        Optional<Employee> highest_age_of_a_employee_details3 = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .findFirst();
        System.out.println("highest_age_of_a_employee_details3:: " + highest_age_of_a_employee_details3);
        // or highest only age of a employee
        OptionalInt highest_age_of_a_employee_details4 = employeeList.stream()
                .mapToInt(e -> e.getAge())
                .max();
        System.out.println("highest_age_of_a_employee:: " + highest_age_of_a_employee_details4);


        // 18: find the largest record based on Salary
        Optional<Employee> largest_record_based_on_Salary = employeeList.stream()
                .max(Comparator.comparing((Employee::getSalary)));
        System.out.println("Q18: largest_record_based_on_Salary:: " + largest_record_based_on_Salary);
        //or
        Optional<Employee> largest_record_based_on_Salary1 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst();
        System.out.println("largest_record_based_on_Salary:: " + largest_record_based_on_Salary);
        //or
        Employee largest_record_based_on_Salary2 = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
        System.out.println("largest_record_based_on_Salary2:: " + largest_record_based_on_Salary2);

        // 19: find the second largest record based on Salary
        Optional<Employee> second_largest_record_based_on_Salary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // Sort by salary in descending order
                .skip(1)  // Skip the first (highest) element
                .findFirst();   // Get the second element (second highest salary)
        System.out.println("Q19: second_largest_record_based_on_Salary:: " + second_largest_record_based_on_Salary);
        // Print the result
        second_largest_record_based_on_Salary.ifPresent(employee ->
                System.out.println("Employee with second highest salary: " + employee));

        // 20: ascending sort based on age

        List<Employee> ascending_sort_based_on_age = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList()); // Sort by age in ascending order
        System.out.println("Q20: ascending_sort_based_on_age:: " + ascending_sort_based_on_age);
        //or
        List<Employee> ascending_sort_based_on_age1 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList()); // Sort by age in ascending order
        System.out.println("ascending_sort_based_on_age1:: " + ascending_sort_based_on_age1);
        //or
        List<Employee> ascending_sort_based_on_age2 = employeeList.stream()
                .sorted((e1, e2) -> e1.age - e2.age)
                .collect(Collectors.toList());
        System.out.println("ascending_sort_based_on_age2:: " + ascending_sort_based_on_age2);
        //or
        // employeeList.stream()
        //       .sorted(Comparator.comparingInt(Employee::getAge))
        //     .forEach(System.out::println); // Print each employee

        // 21: descending sort based on age
        List<Employee> descending_sort_based_on_age = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("Q21: descending_sort_based_on_age:: " + descending_sort_based_on_age);
        //or
        List<Employee> descending_sort_based_on_age1 = employeeList.stream()
                .sorted((e1, e2) -> e2.age - e1.getAge())
                .collect(Collectors.toList());
        System.out.println("descending_sort_based_on_age1:: " + descending_sort_based_on_age1);

        // 22: ascending sort based on salary
        List<Employee> ascending_sort_based_on_salary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("Q22: ascending_sort_based_on_salary:: " + ascending_sort_based_on_salary);
        //or
        List<Employee> ascending_sort_based_on_salary1 = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))// Sort by salary in ascending order
                .collect(Collectors.toList());
        System.out.println("ascending_sort_based_on_salary1:: " + ascending_sort_based_on_salary1);
        // or
        List<Employee> ascending_sort_based_on_salary2 = employeeList.stream()
                .sorted((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
                .collect(Collectors.toList());
        System.out.println("ascending_sort_based_on_salary2:: " + ascending_sort_based_on_salary2);

        // 23: descending sort based on salary
        List<Employee> descending_sort_based_on_salary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("Q23: descending_sort_based_on_salary:: " + descending_sort_based_on_salary);
        //or
        List<Employee> descending_sort_based_on_salary1 = employeeList.stream()
                .sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
                .collect(Collectors.toList());
        System.out.println("descending_sort_based_on_salary1:: " + descending_sort_based_on_salary1);

        // 24: ascending Sort Based On Name
        List<Employee> ascendingSortBasedOnName = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("Q24: ascendingSortBasedOnName:: " + ascendingSortBasedOnName);
        // or
        List<Employee> ascendingSortBasedOnName1 = employeeList.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
        System.out.println("ascendingSortBasedOnName1:: " + ascendingSortBasedOnName1);

        // 25 descending Sort Based On Name
        List<Employee> descendingSortBasedOnName = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("Q25: descendingSortBasedOnName:: " + descendingSortBasedOnName);
        //or
        List<Employee> descendingSortBasedOnName1 = employeeList.stream()
                .sorted((e1, e2) -> e2.getName().compareTo(e1.getName()))
                .collect(Collectors.toList());
        System.out.println("descendingSortBasedOnName1:: " + descendingSortBasedOnName1);

        /* ✅ 1. Ascending Comparators
        Below is correct
        Comparator<Employee> nameSort=(e1,e2)->e1.name.compareTo(e2.name);
        Better: Comparator<Employee> nameSort = Comparator.comparing(Employee::getName);

        ❌ Salary comparator — WRONG
        (int)(e1.salary - e2.getSalary());
❗      Problems:
        1️⃣ Double → int loses precision
        Example:
        salary = 20000.50 - 20000.40 = 0.10
        Casting to int gives 0, meaning the comparator returns 0 even when salaries are different.
        2️⃣ Comparator contract can break
        Returning 0 incorrectly causes sorting errors.
        ⭐ Correct version:
        ✔ Salary ascending — below both versions correct for salary
        Comparator<Employee> salarySort=Comparator.comparingDouble(e->e.salary);
        Comparator<Employee> salarySort1 = (e1, e2) -> Double.compare(e1.salary, e2.salary);
        // Use comparingDouble, cleaner and optimized:
        Better: Comparator<Employee> salarySort = Comparator.comparingDouble(Employee::getSalary);
        ✅ 2. Descending Comparators
        ✔ Age descending
        Comparator<Employee> ageDescSort = Comparator.comparingInt(e -> e.age).reversed();
        Better: Comparator<Employee> ageDescSort = Comparator.comparingInt(Employee::getAge).reversed();
        ✔ Name descending
        Better & consistent:
        Comparator<Employee> nameDescSort = Comparator.comparing(Employee::getName).reversed();
        ✔ Salary descending
        Better:
        Comparator<Employee> salaryDescSort = Comparator.comparingDouble(Employee::getSalary).reversed();



         */

        // ASCENDING   From ChatGpt
        Comparator<Employee> ageSort = Comparator.comparingInt(Employee::getAge);
        Comparator<Employee> nameSort = Comparator.comparing(Employee::getName);
        Comparator<Employee> salarySort = Comparator.comparingDouble(Employee::getSalary);

// DESCENDING   From ChatGpt
        Comparator<Employee> ageDescSort = Comparator.comparingInt(Employee::getAge).reversed();
        Comparator<Employee> nameDescSort = Comparator.comparing(Employee::getName).reversed();
        Comparator<Employee> salaryDescSort = Comparator.comparingDouble(Employee::getSalary).reversed();

        /* Comparator<Employee> byAgeAscOrder = Comparator.comparingInt(e -> e.age);
        Comparator<Employee> byNameAscOrder = (e1, e2) -> e1.getName().compareTo(e2.getName());
        Comparator<Employee> byAgeDescOrder = (e1, e2) -> e2.getAge() - e1.getAge();
        Comparator<Employee> byNameDescOrder = (e1, e2) -> e2.getName().compareTo(e1.getName());
        // Comparator<Employee> bySalryDescOrder = (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary());
        Comparator<Employee> bySalryDescOrder = (e1, e2) -> (int) (e2.getSalary() - e1.getSalary());
        */

        // 26 ascending sort based on age and name
        List<Employee> ascending_sort_based_on_age_and_name = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(Employee::getAge) // Sort by age
                                .thenComparing(Employee::getName) // Sort by  name
                ) // Then sort by name
                .collect(Collectors.toList());
        System.out.println("Q26: ascending_sort_based_on_age_and_name:: " + ascending_sort_based_on_age_and_name);

        List<Employee> ascending_sort_based_on_age_and_name1 = employeeList.stream()
                .sorted(ageSort.thenComparing(nameSort))
                .collect(Collectors.toList());
        System.out.println("ascending_sort_based_on_age_and_name1:: " + ascending_sort_based_on_age_and_name1);

        // 27 ascending sort based on age and name and salary
        List<Employee> ascending_sort_based_on_age_and_name_and_salary = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(Employee::getAge) // Sort by age first
                                .thenComparing(Employee::getName) // Then sort by name
                                .thenComparingDouble(Employee::getSalary)) // Then sort by salary
                .collect(Collectors.toList());
        System.out.println("Q27: ascending_sort_based_on_age_and_name_and_salary:: " + ascending_sort_based_on_age_and_name_and_salary);
        Comparator<Employee> bySalryAscOrder = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
        List<Employee> ascending_sort_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(ageSort
                        .thenComparing(nameSort)
                        .thenComparing(salarySort))
                .collect(Collectors.toList());

        // 28 descending sort based on age and name and salary

        // ✔ WAY–1: Cleanest & Recommended (using reverseOrder)
        List<Employee> descending_sort_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(
                        Comparator.comparing(Employee::getAge, Comparator.reverseOrder())
                                .thenComparing(Employee::getName, Comparator.reverseOrder())
                                .thenComparing(Employee::getSalary, Comparator.reverseOrder())
                )
                .collect(Collectors.toList());
        System.out.println("descending_sort_based_on_age_and_name_and_salary1::  " + descending_sort_based_on_age_and_name_and_salary1);
        //✔ WAY–2: Using comparing() + reversed() (common pattern)
        List<Employee> descending_sort_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(ageDescSort.
                        thenComparing(nameDescSort)
                        .thenComparing(salaryDescSort))
                .collect(Collectors.toList());
        System.out.println("Q28:  descending_sort_based_on_age_and_name_and_salary2:: " + descending_sort_based_on_age_and_name_and_salary2);
        //✔ WAY–3: One-liner using comparingInt + comparingDouble
        List<Employee> descending_sort_based_on_age_and_name_and_salary3 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(Employee::getAge).reversed()
                                .thenComparing(Comparator.comparing(Employee::getName).reversed())
                                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
                )
                .collect(Collectors.toList());
        System.out.println("descending_sort_based_on_age_and_name_and_salary3::  " + descending_sort_based_on_age_and_name_and_salary3);

        // 29 Find first ascending record based on age and name and salary
        Optional<Employee> first_ascending_record_based_on_age_and_name_and_salary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge)   // Sort by age (ascending)
                        .thenComparing(Employee::getName)   // Then by name (ascending)
                        .thenComparing(Employee::getSalary))    // Then by salary (ascending)
                .findFirst();
        System.out.println("Q29: first_ascending_record_based_on_age_and_name_and_salary:: " + first_ascending_record_based_on_age_and_name_and_salary);

        // 30 Find Second ascending record based on age and name and salary
        // Based on ChatGpt
        /*
        🟩 Approach 1 — Using comparing() everywhere
        Comparator.comparing(Employee::getAge)
          .thenComparing(Employee::getName)
          .thenComparing(Employee::getSalary)
        ✔ Pros
        Most readable
        Very easy for beginners to understand
        Works for int, String, double (auto-boxing)
        ✘ Cons
        Uses Integer, Double → causes autoboxing
        Slightly slower when processing large datasets

        🟧 Approach 2 — using comparingInt() + comparingDouble()
        Comparator.comparingInt(Employee::getAge)
          .thenComparing(Employee::getName)
          .thenComparingDouble(Employee::getSalary)
        ✔ Pros
        No autoboxing → more efficient & optimized
        Best practice for numeric fields
        Minimal code
        ✘ Cons
        None. This is the most optimal approach.

        🟨 Approach 3 — mixing comparators
        Comparator.comparingInt(Employee::getAge)
          .thenComparing(Comparator.comparing(Employee::getName))
          .thenComparing(Comparator.comparingDouble(Employee::getSalary))
        ✔ Pros
        Works fine
        Shows flexibility
        ✘ Cons
        Not clean
        Mixing comparator styles unnecessarily
        same performance as approach 2

        🟩 Winner → Approach 2 (Best Practice)
        ✔ No autoboxing
        ✔ Fastest
        ✔ Standard Java style
        ✔ Clean & consistent
        🚀 This is the version most developers prefer
        Optional<Employee> secondRecord = employeeList.stream()
        .sorted(
                Comparator.comparingInt(Employee::getAge)
                        .thenComparing(Employee::getName)
                        .thenComparingDouble(Employee::getSalary)
        )
        .distinct()
        .skip(1)
        .findFirst();

        ⭐ EXTRA BEST Approach (You Missed This One)
        Instead of sorting whole list then skipping,
        use limit(2) for better performance:
        Optional<Employee> secondRecordOptimized = employeeList.stream()
        .sorted(
                Comparator.comparingInt(Employee::getAge)
                        .thenComparing(Employee::getName)
                        .thenComparingDouble(Employee::getSalary)
        )
        .distinct()
        .limit(2)
        .skip(1)
        .findFirst();
        ✔ Why this is better?
        .limit(2) stops stream early
        Avoids full list sorting in some cases
        Saves CPU for large data
        Pure functional and clean
        This is the most efficient approach.

        | Approach      | Readability    | Performance   | Best use case                    |
        | ------------- | -------------- | ------------- | -------------------------------- |
        | **1**         | 👍 Easy        | ⚠️ Autoboxing | OK for small codebases           |
        | **2**         | ⭐ Clean + Fast | ⭐ Best        | **Use this approach**            |
        | **3**         | Normal         | No benefit    | Avoid mixing styles              |
        | **Optimized** | Best           | 🚀 Highest    | **Use when performance matters** |


        */
        Optional<Employee> second_ascending_record_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(Employee::getAge)
                                .thenComparing(Employee::getName)
                                .thenComparingDouble(Employee::getSalary)
                )
                .distinct()
                .limit(2)
                .skip(1)
                .findFirst();
        System.out.println("Q30: second_ascending_record_based_on_age_and_name_and_salary1:: " + second_ascending_record_based_on_age_and_name_and_salary1);
        Optional<Employee> second_ascending_record_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(
                        ageSort
                                .thenComparing(nameSort)
                                .thenComparing(salarySort)
                )
                .distinct()
                .limit(2)
                .skip(1)
                .findFirst();
        System.out.println("Q30: second_ascending_record_based_on_age_and_name_and_salary2:: " + second_ascending_record_based_on_age_and_name_and_salary2);
/*
        Note: In below code
        ✔ Correct
        ✔ Equivalent to Approach 1
        ⛔ Slightly less efficient because:
        thenComparing(Employee::getSalary) uses Double boxing
        → Double object comparisons instead of double primitive comparison.
        But still functionally correct.
        */
        Optional<Employee> second_ascending_record_based_on_age_and_name_and_salary3 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(Employee::getAge)
                                .thenComparing(Employee::getName)
                                .thenComparing(Employee::getSalary)
                )
                .distinct()
                .limit(2)
                .skip(1)
                .findFirst();
        System.out.println("Q30: second_ascending_record_based_on_age_and_name_and_salary3:: " + second_ascending_record_based_on_age_and_name_and_salary3);

        // 31 Find first descending record based on age and name and salary
        /*
        Note: below code is not correct.
        ❌ Problem
        .reversed() applies to the entire comparator chain, but the chain itself is ASCENDING:
        Age → ASC
        Name → ASC
        Salary → ASC
        Then .reversed() flips the whole result, producing:
        Salary DESC
        Name DESC
        Age DESC
        👉 This changes the priority order!
        You are not sorting by Age DESC first.
        You are sorting primarily by Salary DESC, which is wrong.
        ❌ So this is NOT “descending by age → name → salary”.
        */
        // Below is wrong code
        Optional<Employee> first_descending_record_based_on_age_and_name_and_salary = employeeList.stream()
                .sorted(
                        Comparator.comparing(Employee::getAge).
                                thenComparing(Employee::getName).
                                thenComparing(Employee::getSalary).reversed()
                )
                .findFirst();
        System.out.println("Q31: first_descending_record_based_on_age_and_name_and_salary:: " + first_descending_record_based_on_age_and_name_and_salary);
        /*
        ✔ Correct Way
        To sort:
        ➡ Age DESC
        ➡ Name DESC
        ➡ Salary DESC
        Use:
        ✅ Correct Approach (Best)
        */
        // Below is correct code
        Optional<Employee> first_descending_record_based_on_age_and_name_and_salary1 =
                employeeList.stream()
                        .sorted(
                                Comparator.comparing(Employee::getAge, Comparator.reverseOrder())
                                        .thenComparing(Employee::getName, Comparator.reverseOrder())
                                        .thenComparing(Employee::getSalary, Comparator.reverseOrder())
                        )
                        .findFirst();

        System.out.println("Q31: first_descending_record_based_on_age_and_name_and_salary1:: " + first_descending_record_based_on_age_and_name_and_salary1);

        Optional<Employee> first_descending_record_based_on_age_and_name_and_salary2 =
                employeeList.stream()
                        .sorted(
                                ageDescSort
                                        .thenComparing(nameDescSort)
                                        .thenComparing(salaryDescSort)
                        )
                        .findFirst();
        System.out.println("Q31: first_descending_record_based_on_age_and_name_and_salary2:: " + first_descending_record_based_on_age_and_name_and_salary2);

        // 32 Find second descending record based on age and name and salary
        // Note Below code equivalent to:
     /*   sort by:
        age ASC
        then name ASC
        then salary ASC
        THEN reverse the entire result list

        our goal is equivalent to:
        age DESC
        name DESC
        salary DESC

*/
        // age ASC,  then name ASC, then salary ASC, THEN reverse the entire result list
        // Below is wrong code
        Optional<Employee> second_descending_record_based_on_age_and_name_and_salary =
                employeeList.stream()
                        .sorted(Comparator.comparing(Employee::getAge)
                                .thenComparing(Employee::getName)
                                .thenComparing(Employee::getSalary)
                                .reversed())
                        .skip(1)
                        .findFirst();
        System.out.println("Q32: second_descending_record_based_on_age_and_name_and_salary:: " + second_descending_record_based_on_age_and_name_and_salary);

        //  age DESC, name DESC, salary DESC,
        // Below is correct code
        Optional<Employee> second_descending_record_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(ageDescSort.
                        thenComparing(nameDescSort)
                        .thenComparing(salaryDescSort)
                )
                .distinct()
                .skip(1)
                .findFirst();

        System.out.println("second_descending_record_based_on_age_and_name_and_salary1:: " + second_descending_record_based_on_age_and_name_and_salary1.get());
        /* Below Approch:
			Correct approaches (several, with pros/cons)
			✅ Best (primitive-friendly, explicit per-field reverse) — my recommended
			Why: each field reversed individually; uses primitive comparator for age and wraps salary comparator reversal properly;
			readable and performant.
			Why below it is correct?
            Because each field is reversed individually:
            ✔ age → DESC
            ✔ name → DESC
            ✔ salary → DESC
            No final .reversed() that flips the entire chain.
            Resulting ordering:
            age DESC → name DESC → salary DESC   ✔ CORRECT
            ⭐ The Most Important Rule
            Never use .reversed() at the end of a multi-step comparator chain
            It will reverse the whole comparator, not just the last field.
            Instead, reverse each field individually (Approach-2).
		*/
        Comparator<Employee> properDesc =
                Comparator.comparingInt(Employee::getAge).reversed()                                 // age DESC
                        .thenComparing(Employee::getName, Comparator.reverseOrder())                      // name DESC
                        .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed());       // salary DESC

        Optional<Employee> second_descending_record_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(properDesc)
                .distinct()
                .limit(2)        // optional micro-optimization: only need first two distinct
                .skip(1)
                .findFirst();

        System.out.println("second_descending_record_based_on_age_and_name_and_salary2::  " + second_descending_record_based_on_age_and_name_and_salary2.get());

        Optional<Employee> second_descending_record_based_on_age_and_name_and_salary3 =
                employeeList.stream()
                        .sorted(
                                Comparator.comparingInt(Employee::getAge).reversed()
                                        .thenComparing(Comparator.comparing(Employee::getName).reversed())
                                        .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
                        )
                        .limit(2)
                        .skip(1)
                        .findFirst();
        System.out.println("second_descending_record_based_on_age_and_name_and_salary3::  " + second_descending_record_based_on_age_and_name_and_salary3.get());


        // 33 Find the average salary of employee
        //        This solusion is coverd in quesion number 13. refer that.

        // 34 find all the employee whose age is greater than 30
        List<Employee> all_the_employee_whose_age_is_greater_than_30 = employeeList.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println("Q34: all_the_employee_whose_age_is_greater_than_30:: " + all_the_employee_whose_age_is_greater_than_30);

        // 34.1 find all the employee names whose age is greater than 30
        List<String> all_the_employee_names_whose_age_is_greater_than_30 = employeeList.stream()
                .filter(e -> e.getAge() > 30)
                .map(e -> e.getName())
                .collect(Collectors.toList());
        System.out.println("Q34.1: all_the_employee_names_whose_age_is_greater_than_30:: " + all_the_employee_names_whose_age_is_greater_than_30);

        // 35 count number of employees with age greater 30?
        long count_number_of_employees_with_age_greater_30 = employeeList.stream()
                .filter(e -> e.getAge() > 30)
                .count();
        System.out.println("Q35: count_number_of_employees_with_age_greater_30:: " + count_number_of_employees_with_age_greater_30);

        // 36 find the employee with name “Manu”.
        List<Employee> employee_with_name_Manu = employeeList.stream()
                .filter(e -> e.getName().startsWith("Manu"))
                .collect(Collectors.toList());
        System.out.println("Q36: employee_with_name_Manu:: " + employee_with_name_Manu);

        // 37 find maximum age of employee?
        // coverd in quesion number 17 refer that.

        // 38 Join the all employee names with “,”
        String joinedNames = employeeList.stream()
                .map(Employee::getName)             // Map each employee to their name
                .collect(Collectors.joining(","));  // Join names with ","

        // Print the joined names
        System.out.println("Q38: joinedNames_with_:: " + joinedNames);
        // or
        List<String> employeeNames = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        String employeeNamesStrwith_ = String.join("_", employeeNames);
        System.out.println("employeeNamesStrwith_: " + employeeNamesStrwith_);

        // 39 group employees based on employee name
        Map<String, List<Employee>> group_employees_based_on_employee_name = employeeList.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println("Q39: group_employees_based_on_employee_name:: " + group_employees_based_on_employee_name);

        // 40 group by department name and find only employee names
        Map<String, List<String>> group_by_department_name_and_find_only_employee_names = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Q40: group_by_department_name_and_find_only_employee_names:: " + group_by_department_name_and_find_only_employee_names);

        // 41 find duplicate name
        // Find duplicate names
        Map<String, Long> nameCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

        List<String> duplicateNames = nameCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)  // Filter names with count > 1 (duplicates)
                .map(Map.Entry::getKey)                 // Extract the name (key)
                .collect(Collectors.toList());          // Collect the duplicates into a list

        // Print duplicate names
        System.out.println("Q41: Duplicate names: " + duplicateNames);
        // or
        List<String> duplicateNamesEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("duplicateNamesEmployees:: " + duplicateNamesEmployees);

    }
}
