package com.mane.umakant.java8.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeRefine {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;
    private double salary;

    public EmployeeRefine(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeRefine that = (EmployeeRefine) o;
        return id == that.id && age == that.age && yearOfJoining == that.yearOfJoining && Double.compare(salary, that.salary) == 0 && Objects.equals(name, that.name) && Objects.equals(gender, that.gender) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender, department, yearOfJoining, salary);
    }

    @Override
    public String toString() {
        return "EmployeeRefine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';


    }

    // ASCENDING
    final static Comparator<EmployeeRefine> ageAscSort = Comparator.comparingInt(EmployeeRefine::getAge);
    final static Comparator<EmployeeRefine> nameAscSort = Comparator.comparing(EmployeeRefine::getName);
    final static Comparator<EmployeeRefine> salaryAscSort = Comparator.comparingDouble(EmployeeRefine::getSalary);

    // ASCENDING new
    final static Comparator<EmployeeRefine> AGE_ASC_SORT = Comparator.comparingInt(EmployeeRefine::getAge);
    final static Comparator<EmployeeRefine> NAME_ASC_SORT = Comparator.comparing(
            EmployeeRefine::getName,
            Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
    );
    final static Comparator<EmployeeRefine> SALARY_ASC_SORT = Comparator.comparingDouble(EmployeeRefine::getSalary);

    // DESCENDING
    final static Comparator<EmployeeRefine> ageDescSort = Comparator.comparingInt(EmployeeRefine::getAge).reversed();
    final static Comparator<EmployeeRefine> nameDescSort = Comparator.comparing(EmployeeRefine::getName).reversed();
    final static Comparator<EmployeeRefine> salaryDescSort = Comparator.comparingDouble(EmployeeRefine::getSalary).reversed();

    // DESCENDING new
    final static Comparator<EmployeeRefine> AGE_DESC_SORT = Comparator.comparingInt(EmployeeRefine::getAge).reversed();
    final static Comparator<EmployeeRefine> NAME_DESC_SORT = Comparator.comparing(
            EmployeeRefine::getName,
            Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER.reversed()));
    final static Comparator<EmployeeRefine> SALARY_DESC_SORT = Comparator.comparingDouble(EmployeeRefine::getSalary).reversed();

    /*
            Note: In our EmployeeRefine class file we used primitive types not Wrapper class.
            e.g we used int age, not used Integer age. So, default value of int=0 so it is always non null so we dont need to apply null check Comparator
            Now suppose we used "private Integer age" then we need to apply null check Comparator like below
            if private Integer age
            Then
            Comparator.comparing(
            EmployeeRefine::getAge,
            Comparator.nullsLast(Integer::compareTo)
            )
             if private Double salary
            Then
            Comparator.comparing(
            EmployeeRefine::getSalary,
            Comparator.nullsLast(Double::compareTo)
            )
            🔹 1. Integer age (DESC)
            Comparator<EmployeeRefine> ageDesc1 =
        Comparator.comparing(
                EmployeeRefine::getAge,
                Comparator.nullsFirst(Integer::compareTo) // important change
        ).reversed();
        It will produce result like : 30, 20, 10, null

        OR  recommendation
        Comparator<EmployeeRefine> ageDesc2 =
        Comparator.comparing(
                EmployeeRefine::getAge,
                Comparator.nullsLast(Integer::compareTo)
        ).reversed();
        It will produce result like : null, 30, 20, 10

        OR recommendation. This is winner
        Comparator<EmployeeRefine> ageDesc3 =
         Comparator.comparing(
        EmployeeRefine::getAge,
        Comparator.nullsFirst(Comparator.reverseOrder())
       );
       It will produce result like : 30, 20, 10, null

        🔹 2. Double salary (DESC)
       Below  salaryDesc1 is most Recommended then salaryDesc2 then salaryDesc3
       Comparator<EmployeeRefine> salaryDesc1 = Comparator.comparing(
        EmployeeRefine::getSalary,
        Comparator.nullsFirst(Comparator.reverseOrder())
    );
    It will produce result like : 80000.0, 50000.0, 30000.0, null
    Comparator<EmployeeRefine> salaryDesc2 =
        Comparator.comparing(
                EmployeeRefine::getSalary,
                Comparator.nullsFirst(Double::compareTo)
        ).reversed();
    It will produce result like : 80000.0, 50000.0, 30000.0, null

     Comparator<EmployeeRefine> salaryDesc3 =
        Comparator.comparing(
                EmployeeRefine::getSalary,
                Comparator.nullsLast(Double::compareTo)
        ).reversed();
    It will produce result like : null, 80000.0, 50000.0, 30000.0
       */
    public static void main(String[] args) {
        List<EmployeeRefine> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeRefine(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new EmployeeRefine(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new EmployeeRefine(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new EmployeeRefine(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new EmployeeRefine(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new EmployeeRefine(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new EmployeeRefine(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new EmployeeRefine(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new EmployeeRefine(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new EmployeeRefine(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new EmployeeRefine(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new EmployeeRefine(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new EmployeeRefine(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new EmployeeRefine(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new EmployeeRefine(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new EmployeeRefine(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new EmployeeRefine(277, "Nitin Joshi", 31, "Male", "Product Development", 2012, 35700.0));
        // 1: How many male and female employees are there in the organization?
        Map<String, Long> How_many_male_and_female_employees_are_there_in_the_organization = employeeList.stream().collect(Collectors.groupingBy(EmployeeRefine::getGender, Collectors.counting()));
        //  System.out.println("Q1: How_many_male_and_female_employees_are_there_in_the_organization:: " + How_many_male_and_female_employees_are_there_in_the_organization);

        // 2: Print the name of all departments in the organization?
        List<String> name_of_all_departments_in_the_organization = employeeList.stream()
                .map(EmployeeRefine::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        // System.out.println("Q2: name_of_all_departments_in_the_organization:: " + name_of_all_departments_in_the_organization);

        // 3 : What is the average age of male and female employees?
        Map<String, Double> average_age_of_male_and_female_employees1 = employeeList.stream()
                .collect(
                        Collectors.groupingBy(EmployeeRefine::getGender, Collectors.averagingInt(EmployeeRefine::getAge))
                );
        //System.out.println("Q3: average_age_of_male_and_female_employees1:: " + average_age_of_male_and_female_employees1);

        // 4 : Get the details of highest paid employee in the organization?
        Optional<EmployeeRefine> highestPaidEmployee =
                employeeList.stream()
                        .max(Comparator.comparingDouble(EmployeeRefine::getSalary));
        if (highestPaidEmployee.isPresent()) {
            // System.out.println("highestPaidEmployee:: " + highestPaidEmployee.get());
        } else {
            //System.out.println("Record not found");
        }

        // 5 : Get the names of all employees who have joined after 2015?
        List<String> names_of_all_employees_who_have_joined_after_2015 =
                employeeList.stream()
                        .filter(employee -> employee.getYearOfJoining() > 2015)
                        .map(EmployeeRefine::getName)
                        //   .toList();   // Java 16+
                        .collect(Collectors.toList());
        //System.out.println("Q5: names_of_all_employees_who_have_joined_after_2015_A:: " + names_of_all_employees_who_have_joined_after_2015);

        // 6 : Count the number of employees in each department?
        Map<String, Long> Count_the_number_of_employees_in_each_department = employeeList.stream()
                .collect(Collectors.groupingBy(EmployeeRefine::getDepartment, Collectors.counting()));
        // System.out.println("Q6: Count_the_number_of_employees_in_each_department:: " + Count_the_number_of_employees_in_each_department);

        // 7 : What is the average salary of each department?
        Map<String, Double> average_salary_of_each_department = employeeList.stream()
                .collect(Collectors.groupingBy(EmployeeRefine::getDepartment, Collectors.averagingDouble(EmployeeRefine::getSalary)));
        //System.out.println("Q7: average_salary_of_each_department:: " + average_salary_of_each_department);

        // 8 : Get the details of youngest male employee in the product development department?
        Optional<EmployeeRefine> youngestMaleInProductDevelopment =
                employeeList.stream()
                        .filter(emp ->
                                "Male".equalsIgnoreCase(emp.getGender()) &&
                                        "Product Development".equalsIgnoreCase(emp.getDepartment()))
                        .min(Comparator.comparingInt(EmployeeRefine::getAge));
        //System.out.println("youngestMaleInProductDevelopment:: " + youngestMaleInProductDevelopment);

        // 9 : Who has the most working experience in the organization?
        Optional<EmployeeRefine> mostExperiencedEmployee =
                employeeList.stream()
                        .min(Comparator.comparingInt(EmployeeRefine::getYearOfJoining));

        /*mostExperiencedEmployee.ifPresentOrElse(
                emp -> System.out.println("Most experienced employee :: " + emp),
                () -> System.out.println("No employee found"));*/

        // 10 : How many male and female employees are there in the sales and marketing team?
        java.util.Map<String, Long> How_many_male_and_female_employees_are_there_in_the_sales_and_marketing_team = employeeList.stream()
                .filter(employee -> "Sales And Marketing".equalsIgnoreCase(employee.getDepartment()))
                .collect(Collectors.groupingBy(EmployeeRefine::getGender, Collectors.counting()));
        //System.out.println("How_many_male_and_female_employees_are_there_in_the_sales_and_marketing_team:: " + How_many_male_and_female_employees_are_there_in_the_sales_and_marketing_team);

        // 11 : What is the average salary of male and female employees?
        Map<String, Double> average_salary_of_male_and_female_employees = employeeList.stream()
                .collect(Collectors.groupingBy(EmployeeRefine::getGender, Collectors.averagingDouble(EmployeeRefine::getSalary)));
        //System.out.println("Q11: average_salary_of_male_and_female_employees:: " + average_salary_of_male_and_female_employees);

        // 12 : List down the names of all employees in each department? list_down_the_names_of_all_employees_in_each_department
        Map<String, List<String>> employeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(
                        EmployeeRefine::getDepartment, Collectors.mapping(EmployeeRefine::getName, Collectors.toList())));
        //System.out.println("Q12: employeesByDepartment :: " + employeesByDepartment);
        // ⭐ Optional Variant (Comma-Separated Names)
        Map<String, String> employeeNamesByDepartment =
                employeeList.stream()
                        .collect(Collectors.groupingBy(
                                EmployeeRefine::getDepartment,
                                Collectors.mapping(EmployeeRefine::getName, Collectors.joining(", "))
                        ));
        //System.out.println("employeeNamesByDepartment:: " + employeeNamesByDepartment);

        // 13 : What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics average_salary_and_total_salary_of_the_whole_organization = employeeList.stream()
                .collect(Collectors.summarizingDouble(EmployeeRefine::getSalary));
       /* System.out.println("Q13: average_salary_and_total_salary_of_the_whole_organization: " + average_salary_and_total_salary_of_the_whole_organization);
        System.out.println("count: " + average_salary_and_total_salary_of_the_whole_organization.getCount());
        System.out.println("sum: " + average_salary_and_total_salary_of_the_whole_organization.getSum());
        System.out.println("min: " + average_salary_and_total_salary_of_the_whole_organization.getMin());
        System.out.println("average: " + average_salary_and_total_salary_of_the_whole_organization.getAverage());
        System.out.println("max: " + average_salary_and_total_salary_of_the_whole_organization.getMax());*/

        // 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean, List<EmployeeRefine>> partitionedEmployees = employeeList.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() <= 25));

        List<EmployeeRefine> ageLessThanOrEqual25 = partitionedEmployees.get(true);
        List<EmployeeRefine> ageGreaterThan25 = partitionedEmployees.get(false);

        //System.out.println("Age <= 25 :: " + ageLessThanOrEqual25);
        //System.out.println("Age > 25  :: " + ageGreaterThan25);

        // 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<EmployeeRefine> oldest_employee_in_the_organization = employeeList.stream()
                .max(Comparator.comparingInt(EmployeeRefine::getAge));
        //System.out.println("Q15: oldest_employee_in_the_organization:: " + oldest_employee_in_the_organization);
        if (oldest_employee_in_the_organization.isPresent()) {
            //System.out.println("oldest_employee_in_the_organization age: " + oldest_employee_in_the_organization.get().name);
            //System.out.println("oldest_employee_in_the_organization name: " + oldest_employee_in_the_organization.get().age);
        } else {
            //System.out.println("oldest_employee_in_the_organization not found.");
        }

        // 16: find the smallest record based on age
        Optional<EmployeeRefine> smallest_record_based_on_age = employeeList.stream()
                .min(Comparator.comparingInt(EmployeeRefine::getAge));
        if (smallest_record_based_on_age.isPresent()) {
            //System.out.println("Q16: smallest_record_based_on_age:: " + smallest_record_based_on_age.get());
        }

        // 17: find the highest age of a employee details?
        Optional<EmployeeRefine> highest_age_of_a_employee_details = employeeList.stream()
                .max(Comparator.comparingInt(EmployeeRefine::getAge));
        if (highest_age_of_a_employee_details.isPresent()) {
            //System.out.println("Q17: highest_age_of_a_employee_details:: " + highest_age_of_a_employee_details.get());
        }

        // 18: find the largest record based on Salary
        Optional<EmployeeRefine> highestSalaryEmployee =
                employeeList.stream()
                        .max(Comparator.comparingDouble(EmployeeRefine::getSalary));
        if (highestSalaryEmployee.isPresent()) {
            // System.out.println(highestSalaryEmployee.get());
        }

        // 19: find the second largest record based on Salary
        Optional<EmployeeRefine> secondHighestSalaryEmployee =
                employeeList.stream()
                        .sorted(
                                Comparator.comparingDouble(
                                        EmployeeRefine::getSalary
                                ).reversed()
                        )
                        .skip(1)
                        .findFirst();
        if (secondHighestSalaryEmployee.isPresent()) {
            // System.out.println(secondHighestSalaryEmployee);
        }

        // 20: ascending sort based on age
        // Note: Below both are correct
      /*  Why First Version is Better. 1.Reusability, 2. Better Readability, 3. Cleaner for Comparator Chaining, 4. Industry Style
        In real projects:
        -reusable comparators
        -constants
        -utility comparators
        -are common.*/

        List<EmployeeRefine> ascending_sort_based_on_age1 = employeeList.stream()
                .sorted(AGE_ASC_SORT)
                .toList();
        //System.out.println("ascending_sort_based_on_age1:: "+ascending_sort_based_on_age1);
        List<EmployeeRefine> ascending_sort_based_on_age2 = employeeList.stream()
                .sorted(Comparator.comparingInt(EmployeeRefine::getAge)).collect(Collectors.toList());
        //System.out.println("Q20: ascending_sort_based_on_age2:: " + ascending_sort_based_on_age2);

        // 21: descending sort based on age
        List<EmployeeRefine> employeesSortedByAgeDesc1 =
                employeeList.stream()
                        .sorted(AGE_DESC_SORT)
                        .collect(Collectors.toList());
        //System.out.println("Q21: employeesSortedByAgeDesc1:: " + employeesSortedByAgeDesc1);
        List<EmployeeRefine> employeesSortedByAgeDesc2 =
                employeeList.stream()
                        .sorted(
                                Comparator.comparingInt(
                                        EmployeeRefine::getAge
                                ).reversed()
                        ) // comparingInt this in important
                        .collect(Collectors.toList());
        //System.out.println("Q21: employeesSortedByAgeDesc2:: " + employeesSortedByAgeDesc2);

        // 22: ascending sort based on salary
        List<EmployeeRefine> ascending_sort_based_on_salary1 = employeeList.stream()
                .sorted(SALARY_ASC_SORT).toList();
        //System.out.println("ascending_sort_based_on_salary1:: "+ascending_sort_based_on_salary1);
        List<EmployeeRefine> ascending_sort_based_on_salary2 = employeeList.stream()
                .sorted(Comparator.comparingDouble(EmployeeRefine::getSalary)).toList();
        //System.out.println("ascending_sort_based_on_salary2:: "+ascending_sort_based_on_salary2);

        // 23: descending sort based on salary
        List<EmployeeRefine> employeesSortedBySalaryDesc1 = employeeList.stream()
                .sorted(SALARY_DESC_SORT).toList();
        //System.out.println("employeesSortedBySalaryDesc1:: "+employeesSortedBySalaryDesc1);
        List<EmployeeRefine> employeesSortedBySalaryDesc2 = employeeList.stream()
                .sorted(Comparator.comparingDouble(EmployeeRefine::getSalary).reversed())
                .toList();
        //System.out.println("employeesSortedBySalaryDesc2:: "+employeesSortedBySalaryDesc2);

        // 24: ascending Sort Based on Name
        // 1. ascendingSortBasedOnName1 — Correct
        List<EmployeeRefine> ascendingSortBasedOnName1 = employeeList.stream()
                .sorted(nameAscSort).toList();
        //System.out.println("ascendingSortBasedOnName1:: " + ascendingSortBasedOnName1);

        // 2. ascendingSortBasedOnName2 — Correct
        List<EmployeeRefine> ascendingSortBasedOnName2 = employeeList.stream()
                .sorted(Comparator.comparing(EmployeeRefine::getName)).toList();
        //System.out.println("ascendingSortBasedOnName2:: " + ascendingSortBasedOnName2);

        // 3. ascendingSortBasedOnName3 — Very Good
        List<EmployeeRefine> ascendingSortBasedOnName3 = employeeList.stream()
                .sorted(
                        Comparator.comparing(
                                EmployeeRefine::getName,
                                String.CASE_INSENSITIVE_ORDER)
                )
                .toList();
        //System.out.println("ascendingSortBasedOnName3:: " + ascendingSortBasedOnName3);

        // 4. ascendingSortBasedOnName4 — Best Enterprise-Level Version
        List<EmployeeRefine> ascendingSortBasedOnName4 = employeeList.stream()
                .sorted(
                        Comparator.comparing(
                                EmployeeRefine::getName,
                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                        )
                )
                .toList();
        //System.out.println("ascendingSortBasedOnName4:: " + ascendingSortBasedOnName4);

        // 25 descending Sort Based on Name
        // Recommendation is: descendingSortBasedOnName4

        //1. Version 1 — Correct. Good reusable approach.
        List<EmployeeRefine> descendingSortBasedOnName1 = employeeList.stream()
                .sorted(nameDescSort).toList();
        //System.out.println("descendingSortBasedOnName1:: " + descendingSortBasedOnName1);

        // 2. Version 2 — Correct But: case-sensitive, not null-safe
        List<EmployeeRefine> descendingSortBasedOnName2 = employeeList.stream()
                .sorted(
                        Comparator.comparing(EmployeeRefine::getName).reversed()
                ).toList();
        //System.out.println("descendingSortBasedOnName2:: " + descendingSortBasedOnName2);

        // 3. Version 3 — Correct and Better.
        /*
        This is good.
        Meaning:
        case-insensitive ascending comparator created first
        entire comparator reversed
        Perfectly valid.
         */
        List<EmployeeRefine> descendingSortBasedOnName3 = employeeList.stream()
                .sorted(
                        Comparator.comparing(
                                EmployeeRefine::getName,
                                String.CASE_INSENSITIVE_ORDER).reversed()
                ).toList();
        //System.out.println("descendingSortBasedOnName3:: " + descendingSortBasedOnName3);

        // You achieved all 3 things properly: 1. Descending Order, 2. Case-Insensitive Sorting, 3. Nulls Still Last

        List<EmployeeRefine> descendingSortBasedOnName4 = employeeList.stream()
                .sorted(
                        Comparator.comparing(
                                EmployeeRefine::getName,
                                Comparator.nullsLast(
                                        String.CASE_INSENSITIVE_ORDER.reversed()
                                )
                        )
                )
                .toList();
        //System.out.println("descendingSortBasedOnName4:: " + descendingSortBasedOnName4);

        List<EmployeeRefine> descendingSortBasedOnName5 =
                employeeList.stream()
                        .sorted(
                                Comparator.comparing(
                                        EmployeeRefine::getName,
                                        Comparator.nullsFirst(
                                                String.CASE_INSENSITIVE_ORDER
                                        ).reversed()
                                )
                        )
                        .toList();
        /* Note both descendingSortBasedOnName4 and descendingSortBasedOnName5 produce same output as:
        Vijay, Rohit, Ankit, Amit, null
        Most readable is: descendingSortBasedOnName4
        */

        // 26 ascending sort based on age and name
        // Recommended: ascending_sort_based_on_age_and_name3
        // Your first versions are correct.
        List<EmployeeRefine> ascending_sort_based_on_age_and_name1 = employeeList.stream()
                .sorted(
                        ageAscSort
                                .thenComparing(nameAscSort)
                )
                .toList();
        //System.out.println("ascending_sort_based_on_age_and_name1:: "+ascending_sort_based_on_age_and_name1);

        //Your second versions are correct.
        List<EmployeeRefine> ascending_sort_based_on_age_and_name2 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(EmployeeRefine::getAge)
                                .thenComparing(EmployeeRefine::getName)
                )
                .toList();
        //System.out.println("ascending_sort_based_on_age_and_name2:: "+ascending_sort_based_on_age_and_name2);

        // Primitive int can NEVER be null. So: no null handling required
        // this is correct and strong interview-quality code.
        /*
        Why Version 3 is preferred?
        Because it directly expresses below in one statement.:
        Age ASC
        then Name ASC (case-insensitive, nulls last)
        Version 4 introduces an additional comparator object:
         */
        List<EmployeeRefine> ascending_sort_based_on_age_and_name3 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(EmployeeRefine::getAge)
                                .thenComparing(
                                        EmployeeRefine::getName,
                                        Comparator.nullsLast(
                                                String.CASE_INSENSITIVE_ORDER
                                        )
                                )
                )
                .toList();
        //System.out.println("ascending_sort_based_on_age_and_name3:: "+ascending_sort_based_on_age_and_name3);

        List<EmployeeRefine> ascending_sort_based_on_age_and_name4 = employeeList
                .stream()
                .sorted(
                        Comparator.comparingInt(EmployeeRefine::getAge)
                                .thenComparing(
                                        Comparator.comparing(EmployeeRefine::getName,
                                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                                        )
                                )
                )
                .toList();
        //System.out.println("ascending_sort_based_on_age_and_name4:: "+ascending_sort_based_on_age_and_name4);
        /*
        Note:
            ascending_sort_based_on_age_and_name4 :
            First you create a complete comparator:
            Comparator<EmployeeRefine> nameComparator =
            Comparator.comparing(
                EmployeeRefine::getName,
                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
            );
            Then you pass it to: thenComparing(Comparator<EmployeeRefine>)
            When would Version 4 make sense?
            When the secondary comparator is reused.
         */

        // 27 ascending sort based on age and name and salary

        // 27 ascending sort based on age and name and salary
        // Recommended: ascending_sort_based_on_age_and_name_and_salary3
        /* When Null Handling Is Required. Only when using wrapper/object types: e.g private Double salary; private Integer age; private Long id;
         */
        // Version 1 — Correct
        List<EmployeeRefine> ascending_sort_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(
                        ageAscSort
                                .thenComparing(nameAscSort)
                                .thenComparing(salaryAscSort)
                )
                .toList();
        //System.out.println("ascending_sort_based_on_age_and_name_and_salary1:: " + ascending_sort_based_on_age_and_name_and_salary1);

        List<EmployeeRefine> ascending_sort_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(EmployeeRefine::getAge)
                                .thenComparing(EmployeeRefine::getName)
                                .thenComparingDouble(EmployeeRefine::getSalary)
                )
                .toList();
        //System.out.println("ascending_sort_based_on_age_and_name_and_salary2:: " + ascending_sort_based_on_age_and_name_and_salary2);

        //Recommended: ascending_sort_based_on_age_and_name_and_salary3
        List<EmployeeRefine> ascending_sort_based_on_age_and_name_and_salary3 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(EmployeeRefine::getAge)
                                .thenComparing(
                                        EmployeeRefine::getName,
                                        Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                                )
                                .thenComparingDouble(
                                        EmployeeRefine::getSalary
                                )
                )
                .toList();
        //System.out.println("ascending_sort_based_on_age_and_name_and_salary3:: " + ascending_sort_based_on_age_and_name_and_salary3);
        // Recommended 'ascending_sort_based_on_age_and_name_and_salary4' based on condition: Useful if those comparators are reused elsewhere
        /*
        Advantages:
        Useful if those comparators are reused elsewhere
        Otherwise:
        More verbose
        Extra wrapping
        Harder to read
         */
        List<EmployeeRefine> ascending_sort_based_on_age_and_name_and_salary4 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(EmployeeRefine::getAge)
                                .thenComparing(
                                        Comparator.comparing(
                                                EmployeeRefine::getName,
                                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                                        )
                                ).thenComparing(
                                        Comparator.comparingDouble(
                                                EmployeeRefine::getSalary
                                        )
                                )
                )
                .toList();
        //System.out.println("ascending_sort_based_on_age_and_name_and_salary4:: " + ascending_sort_based_on_age_and_name_and_salary4);

        // 28 descending sort based on age and name and salary
        List<EmployeeRefine> descending_sort_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(
                        ageDescSort
                                .thenComparing(nameDescSort)
                                .thenComparing(salaryDescSort)
                )
                .toList();
        //System.out.println("descending_sort_based_on_age_and_name_and_salary1:: " + descending_sort_based_on_age_and_name_and_salary1);
        List<EmployeeRefine> descending_sort_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(EmployeeRefine::getAge)
                                .reversed()
                                .thenComparing(
                                        Comparator.comparing(
                                                EmployeeRefine::getName,
                                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER.reversed()
                                                )
                                        )
                                )
                                .thenComparing(
                                        Comparator.comparingDouble(EmployeeRefine::getSalary)
                                                .reversed()
                                )
                )
                .toList();
        // System.out.println("descending_sort_based_on_age_and_name_and_salary2:: " + descending_sort_based_on_age_and_name_and_salary2);

        // 29 Find first ascending record based on age and name and salary
        /*
        My Final Rule:
        For primitive fields (int, long, double):
        Ascending==>
        .thenComparingInt(...)
        .thenComparingLong(...)
        .thenComparingDouble(...)
        ✅ Preferred

        Descending ==>
        .thenComparing(
        Comparator.comparingInt(...).reversed()
        )
        .thenComparing(
                Comparator.comparingLong(...).reversed()
        )
        .thenComparing(
                Comparator.comparingDouble(...).reversed()
        )
        ✅ Preferred
         */
        Optional<EmployeeRefine> first_ascending_record_based_on_age_and_name_and_salary1 =
                employeeList.stream()
                        .min(
                                Comparator.comparingInt(EmployeeRefine::getAge)
                                        .thenComparing(
                                                EmployeeRefine::getName,
                                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                                        )
                                        .thenComparingDouble(
                                                EmployeeRefine::getSalary
                                        )

                        );
        if (first_ascending_record_based_on_age_and_name_and_salary1.isPresent()) {
            // System.out.println("first_ascending_record_based_on_age_and_name_and_salary1:: "+first_ascending_record_based_on_age_and_name_and_salary1.get());
        }

        Optional<EmployeeRefine> first_ascending_record_based_on_age_and_name_and_salary2 = employeeList.stream()
                .min(
                        AGE_ASC_SORT
                                .thenComparing(NAME_ASC_SORT)
                                .thenComparing(SALARY_ASC_SORT)
                );

        if (first_ascending_record_based_on_age_and_name_and_salary2.isPresent()) {
            // System.out.println("first_ascending_record_based_on_age_and_name_and_salary2:: "+first_ascending_record_based_on_age_and_name_and_salary2.get());
        }
        Optional<EmployeeRefine> first_ascending_record_based_on_age_and_name_and_salary3 = employeeList.stream()
                .max(
                        AGE_DESC_SORT
                                .thenComparing(NAME_DESC_SORT)
                                .thenComparing(SALARY_DESC_SORT)
                );
        if (first_ascending_record_based_on_age_and_name_and_salary3.isPresent()) {
            // System.out.println("first_ascending_record_based_on_age_and_name_and_salary3:: "+first_ascending_record_based_on_age_and_name_and_salary3.get());
        }

        // 30 Find Second ascending record based on age and name and salary
        Optional<EmployeeRefine> second_ascending_record_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(AGE_ASC_SORT
                        .thenComparing(NAME_ASC_SORT)
                        .thenComparing(SALARY_ASC_SORT)
                )
                .skip(1)
                .findFirst();
        if (second_ascending_record_based_on_age_and_name_and_salary1.isPresent()) {
            // System.out.println("second_ascending_record_based_on_age_and_name_and_salary1:: "+second_ascending_record_based_on_age_and_name_and_salary1.get());
        }
        Optional<EmployeeRefine> second_ascending_record_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(EmployeeRefine::getAge)
                                .thenComparing(
                                        EmployeeRefine::getName,
                                        Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                                )
                                .thenComparingDouble(EmployeeRefine::getSalary)
                ).skip(1).findFirst();
        if (second_ascending_record_based_on_age_and_name_and_salary2.isPresent()) {
            //System.out.println("second_ascending_record_based_on_age_and_name_and_salary2:: "+second_ascending_record_based_on_age_and_name_and_salary2.get());
        }

        // 31 Find first descending record based on age and name and salary
         /*
        My Final Rule:
        For primitive fields (int, long, double):
        Ascending==>
        .thenComparingInt(...)
        .thenComparingLong(...)
        .thenComparingDouble(...)
        ✅ Preferred

        Descending ==>
        .thenComparing(
        Comparator.comparingInt(...).reversed()
        )
        .thenComparing(
                Comparator.comparingLong(...).reversed()
        )
        .thenComparing(
                Comparator.comparingDouble(...).reversed()
        )
        ✅ Preferred
         */
        //Find first descending record based on age and name and salary
        Optional<EmployeeRefine> first_descending_record_based_on_age_and_name_and_salary1 =
                employeeList.stream()
                        .min(
                                Comparator.comparingInt(EmployeeRefine::getAge).reversed()
                                        .thenComparing(
                                                EmployeeRefine::getName,
                                                Comparator.nullsLast(
                                                        String.CASE_INSENSITIVE_ORDER.reversed()
                                                )
                                        )
                                        .thenComparing(
                                                EmployeeRefine::getSalary, Comparator.reverseOrder()
                                        )
                        );
        if (first_descending_record_based_on_age_and_name_and_salary1.isPresent()) {
            // System.out.println("first_descending_record_based_on_age_and_name_and_salary1:: "+first_descending_record_based_on_age_and_name_and_salary1);
        }
        Optional<EmployeeRefine> first_descending_record_based_on_age_and_name_and_salary2 = employeeList.stream()
                .min(
                        AGE_DESC_SORT
                                .thenComparing(NAME_DESC_SORT)
                                .thenComparing(SALARY_DESC_SORT)
                );
        if (first_descending_record_based_on_age_and_name_and_salary2.isPresent()) {
            //System.out.println("first_descending_record_based_on_age_and_name_and_salary2:: "+first_descending_record_based_on_age_and_name_and_salary2.get());
        }
        Optional<EmployeeRefine> first_descending_record_based_on_age_and_name_and_salary3 = employeeList.stream()
                .max(
                        AGE_ASC_SORT
                                .thenComparing(NAME_ASC_SORT)
                                .thenComparing(SALARY_ASC_SORT)
                );
        if (first_descending_record_based_on_age_and_name_and_salary3.isPresent()) {
            // System.out.println("first_descending_record_based_on_age_and_name_and_salary3:: "+first_descending_record_based_on_age_and_name_and_salary3.get());
        }

        // 32 Find second descending record based on age and name and salary
        Optional<EmployeeRefine> second_descending_record_based_on_age_and_name_and_salary1 =
                employeeList.stream()
                        .sorted(
                                Comparator.comparingInt(EmployeeRefine::getAge).reversed()
                                        .thenComparing(
                                                EmployeeRefine::getName,
                                                Comparator.nullsLast(
                                                        String.CASE_INSENSITIVE_ORDER.reversed()
                                                )
                                        )
                                        .thenComparing(
                                                EmployeeRefine::getSalary, Comparator.reverseOrder()
                                        )
                        ).skip(1).findFirst();
        if (second_descending_record_based_on_age_and_name_and_salary1.isPresent()) {
            // System.out.println("second_descending_record_based_on_age_and_name_and_salary1:: " + second_descending_record_based_on_age_and_name_and_salary1);
        }
        Optional<EmployeeRefine> second_descending_record_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(AGE_DESC_SORT
                        .thenComparing(NAME_DESC_SORT)
                        .thenComparing(SALARY_DESC_SORT))
                .skip(1).findFirst();
        if (second_descending_record_based_on_age_and_name_and_salary2.isPresent()) {
            //System.out.println("second_descending_record_based_on_age_and_name_and_salary2:: " + second_descending_record_based_on_age_and_name_and_salary2.get());
        }

        // 33 Find the average salary of employee
        // Recommended:: averageSalary1
        OptionalDouble averageSalary1 = employeeList.stream()
                .mapToDouble(EmployeeRefine::getSalary)
                .average();
        if (averageSalary1.isPresent()) {
            //System.out.println("averageSalary1:: "+averageSalary1.getAsDouble());
        }
        Double averageSalary2 = employeeList.stream()
                .collect(Collectors.averagingDouble(EmployeeRefine::getSalary));
        //System.out.println("averageSalary2:: "+averageSalary2);

        // sub que:
        // find the sum of salary of each department.
        // Recommended:: sum_of_salary_of_each_department1
        Map<String, Double> sum_of_salary_of_each_department1 = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeRefine::getDepartment,
                                Collectors.summingDouble( // not summarizingDouble its summingDouble
                                        EmployeeRefine::getSalary
                                )

                        )
                );
        // System.out.println("sum_of_salary_of_each_department1:: "+sum_of_salary_of_each_department1);
        Map<String, DoubleSummaryStatistics> sum_of_salary_of_each_department2 =
                employeeList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        EmployeeRefine::getDepartment,
                                        Collectors.summarizingDouble(
                                                EmployeeRefine::getSalary
                                        )
                                )
                        );
        sum_of_salary_of_each_department2.forEach((department, doubleSummaryStatistics) -> {
            // System.out.println("Dep:: "+department+" Tor sal:: "+doubleSummaryStatistics.getSum());
        });
        // 34 find all the employee whose age is greater than 30
        List<EmployeeRefine> all_the_employee_whose_age_is_greater_than_30 = employeeList.stream()
                .filter(employee -> employee.getAge() > 30)
                .toList();
        //System.out.println("all_the_employee_whose_age_is_greater_than_30 :: "+all_the_employee_whose_age_is_greater_than_30);

        // 35 count number of employees with age greater 30?
        // Recommende:: count_number_of_employees_with_age_greater_30_1
        long count_number_of_employees_with_age_greater_30_1 = employeeList.stream()
                .filter(employee -> employee.getAge() > 30)
                .count();
        //System.out.println("count_number_of_employees_with_age_greater_30_1:: "+count_number_of_employees_with_age_greater_30_1);
        Long count_number_of_employees_with_age_greater_30_2 = employeeList.stream()
                .filter(employeeRefine -> employeeRefine.getAge() > 30)
                .collect(Collectors.counting());
        //System.out.println("count_number_of_employees_with_age_greater_30_2:: "+count_number_of_employees_with_age_greater_30_2);

        // 36 find the employee with name “Manu”.
        // Recommende:: employeeNamedManu1
        List<EmployeeRefine> employeeNamedManu1 = employeeList.stream()
                .filter(
                        employeeRefine ->
                                employeeRefine.getName() != null
                                        &&
                                        employeeRefine.getName().startsWith("Manu")
                )
                .toList();
        //System.out.println("employeeNamedManu1:: " + employeeNamedManu1);
        // 'employeeNamedManu2' is useful if we want strictly '"Manu Sharma"' not just 'Manu'
        List<EmployeeRefine> employeeNamedManu2 = employeeList.stream()
                .filter(
                        employeeRefine ->
                                "Manu Sharma".startsWith(employeeRefine.getName())
                )
                .toList();
        //System.out.println("employeeNamedManu2:: " + employeeNamedManu2);

        // 37 find maximum age of employee?
        OptionalInt age_of_oldestEmployee = employeeList.stream()
                .mapToInt(EmployeeRefine::getAge)
                .max();
        if (age_of_oldestEmployee.isPresent()) {
            //System.out.println("age_of_oldestEmployee:: " + age_of_oldestEmployee.getAsInt());
        }
        // sub question: find employee whose age is maximum?
        Optional<EmployeeRefine> oldestEmployee = employeeList.stream()
                .max(
                        Comparator.comparingInt(
                                EmployeeRefine::getAge
                        )
                );
        //System.out.println("oldestEmployee:: " + oldestEmployee.get());

        // 38 Join the all employee names with “,”
        String joinedNames = employeeList.stream()
                .map(EmployeeRefine::getName)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(","));
        //  .collect(Collectors.joining(",","[","]")); delimiter, prefix, suffix
        // System.out.println("joinedNames:: "+joinedNames);

        // 39 group employees based on employee name
        Map<String, List<EmployeeRefine>> group_employees_based_on_employee_name = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeRefine::getName
                        )
                );
        //System.out.println(group_employees_based_on_employee_name);

        // 40 group employees based on department name along with salary
        Map<String, List<Double>> group_employees_based_on_department_name_along_with_salary = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeRefine::getDepartment
                                , Collectors.mapping(
                                        EmployeeRefine::getSalary
                                        , Collectors.toList())
                        )
                );
        //System.out.println("group_employees_based_on_department_name_along_with_salary:: " + group_employees_based_on_department_name_along_with_salary);
        Map<String, Optional<Double>> department_Wise_Highest_Salary_Amount = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeRefine::getDepartment,
                                Collectors.mapping(
                                        EmployeeRefine::getSalary,
                                        Collectors.maxBy(Double::compare)
                                )
                        )
                );
        //System.out.println("department_Wise_Highest_Salary_Amount:: "+department_Wise_Highest_Salary_Amount);
        Map<String, Double> group_employees_based_on_department_name_along_with_total_salary = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeRefine::getDepartment
                                , Collectors.summingDouble(
                                        EmployeeRefine::getSalary
                                ))
                );
        //System.out.println("group_employees_based_on_department_name_along_with_total_salary:: " + group_employees_based_on_department_name_along_with_total_salary);
        Map<String, List<String>> group_by_department_name_and_find_only_employee_names = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeRefine::getDepartment,
                                Collectors.mapping(
                                        EmployeeRefine::getName,
                                        Collectors.toList()
                                )
                        )
                );
        //System.out.println("group_by_department_name_and_find_only_employee_names:: "+group_by_department_name_and_find_only_employee_names);
        Map<String, Optional<EmployeeRefine>> department_Wise_Highest_Salary_Employee1 = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeRefine::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(
                                                EmployeeRefine::getSalary
                                        )
                                )
                        )
                );
        //System.out.println("department_Wise_Highest_Salary_Employee1:: "+department_Wise_Highest_Salary_Employee1);
        Map<String, EmployeeRefine> department_Wise_Highest_Salary_Employee2 = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeRefine::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparingDouble(
                                                        EmployeeRefine::getSalary
                                                )
                                        ),
                                        Optional::get
                                )
                        )
                );
        //System.out.println("department_Wise_Highest_Salary_Employee2:: "+department_Wise_Highest_Salary_Employee2);


        // 41 find duplicate name
        // Recommended:: duplicateNames1
        List<String> duplicateNames1 =
                employeeList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        EmployeeRefine::getName,
                                        Collectors.counting()
                                )
                        )
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .toList();
        //System.out.println("duplicateNames1:: "+duplicateNames1);
        // below is one of the other way
        Set<String> uniqueNames = new HashSet<>();
        Set<String> duplicateNames2 =
                employeeList.stream()
                        .map(EmployeeRefine::getName)
                        .filter(name -> !uniqueNames.add(name))
                        .collect(Collectors.toSet());
        //System.out.println("duplicateNames2:: "+duplicateNames2);


    }


}


