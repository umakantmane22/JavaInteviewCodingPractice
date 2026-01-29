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
/*
        6️⃣ Final Verdict (Interview Answer)
        Use averagingInt when the property is int.
                Use averagingDouble when the property is double.
                Both return Double, but averagingInt is clearer and cleaner here.
                employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.averagingInt(Employee::getAge)
                ));
        */

        Map<String, Double> average_age_of_male_and_female_employees = employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))
                );
        System.out.println("Q3: average_age_of_male_and_female_employees:: " + average_age_of_male_and_female_employees);

        // 4 : Get the details of highest paid employee in the organization?
        //✅ BEST OVERALL
       /* Why this is BEST

            ✔ Uses primitive comparison
            ✔ No boxing (double)
            ✔ Single-pass (O(n))
            ✔ Very readable
            ✔ Most efficient
                */

        Optional<Employee> highestPaidEmployee =
                employeeList.stream()
                        .max(Comparator.comparingDouble(Employee::getSalary));
        if (highestPaidEmployee.isPresent()) {
            System.out.println("highestPaidEmployee:: " + highestPaidEmployee.get());
        } else {
            System.out.println("Record not found");
        }
        /*
        How it works
            Uses a collector
            comparingDouble avoids boxing (double → Double)
            Internally reduces the stream to a single max element
            Pros
            ✔ Correct
            ✔ No boxing
            ✔ Works well in complex collect() pipelines

            Cons
            ❌ Verbose
            ❌ Overkill when you just need max
            ❌ Less readable for simple cases

            When to use
            👉 When already using collect() with other downstream collectors
         */
        Optional<Employee> highest_paid_employee1 = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        if (highest_paid_employee1.isPresent()) {
            System.out.println("highest_paid_employee1:: " + highest_paid_employee1.get());
        } else {
            System.out.println("Record not found");
        }
        Optional<Employee> highest_paid_employee2 = employeeList.stream()
                .max(Comparator.comparing(employee -> employee.getSalary()));
        if (highest_paid_employee2.isPresent()) {
            System.out.println("highest_paid_employee2:: " + highest_paid_employee2.get());
        } else {
            System.out.println("Record not found");
        }
        Optional<Employee> highest_paid_employee3 = employeeList.stream()
                .max(Comparator.comparing((Employee::getSalary)));
        if (highest_paid_employee3.isPresent()) {
            System.out.println("highest_paid_employee3:: " + highest_paid_employee3.get());
        } else {
            System.out.println("Record not found");
        }
        // ❌ Worst
        /*
        Cons ❌❌❌

        ❌ Very inefficient (O(n log n))
        ❌ Unnecessary sorting
        ❌ Boxing overhead
        ❌ Worst choice for large data
         */
        Optional<Employee> highest_paid_employee4 = employeeList.stream()
                .sorted(Comparator.comparing((Employee::getSalary)).reversed())
                .findFirst();
        if (highest_paid_employee4.isPresent()) {
            System.out.println("highest_paid_employee4:: " + highest_paid_employee4.get());
        } else {
            System.out.println("Record not found");
        }


        // 5 : Get the names of all employees who have joined after 2015?
        // ⭐ My BEST Suggested Approach (Professional)
        List<String> names_of_all_employees_who_have_joined_after_2015 =
                employeeList.stream()
                        .filter(employee -> employee.getYearOfJoining() > 2015)
                        .map(Employee::getName)
                        //   .toList();   // Java 16+
                        .collect(Collectors.toList());
        System.out.println("Q5: names_of_all_employees_who_have_joined_after_2015_A:: " + names_of_all_employees_who_have_joined_after_2015);
        String result = String.join(", ", names_of_all_employees_who_have_joined_after_2015);
        System.out.println("names_of_all_employees_who_have_joined_after_2015_B:: " + result);

        // 6 : Count the number of employees in each department?
        Map<String, Long> Count_the_number_of_employees_in_each_department = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Q6: Count_the_number_of_employees_in_each_department:: " + Count_the_number_of_employees_in_each_department);
        // or
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
        // or Alternative 3: Imperative (Old-Style)
        Map<String, Integer> map = new HashMap<>();
        for (Employee e : employeeList) {
            map.put(e.getDepartment(), map.getOrDefault(e.getDepartment(), 0) + 1);
        }

        // 7 : What is the average salary of each department?
        // ✅ Your Code (BEST ANSWER)
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
        // 🏆 BEST APPROACH (From My Side – Interview Ready)
        Optional<Employee> youngestMaleInProductDevelopment =
                employeeList.stream()
                        .filter(emp ->
                                "Male".equalsIgnoreCase(emp.getGender()) &&
                                        "Product Development".equalsIgnoreCase(emp.getDepartment()))
                        .min(Comparator.comparingInt(Employee::getAge));

        youngestMaleInProductDevelopment.ifPresentOrElse(
                emp -> System.out.println("Q8: " + emp),
                () -> System.out.println("Q8: No matching employee found")
        );

        // below is also good
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
        //🏆 BEST SOLUTION (FROM MY SIDE)
        Optional<Employee> mostExperiencedEmployee =
                employeeList.stream()
                        .min(Comparator.comparingInt(Employee::getYearOfJoining));

        mostExperiencedEmployee.ifPresentOrElse(
                emp -> System.out.println("Most experienced employee :: " + emp),
                () -> System.out.println("No employee found")
        );
        /*
        🔥 Why THIS is the BEST
            ✔ Uses min() → semantic correctness
            ✔ Uses comparingInt() → no boxing
            ✔ Single pass → O(n)
            ✔ No overflow risk
            ✔ Clean, expressive, interview-grade
            ✔ Production-safe
         */
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
        // ✅ BEST SOLUTION (Most Recommended)
        Map<String, List<String>> employeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Q12: employeesByDepartment :: " + employeesByDepartment);
        // Print the names of employees grouped by department
        employeesByDepartment.forEach((department, names) -> {
            System.out.println("Department: " + department);
            names.forEach(name -> System.out.println("  - " + name));
        });
        // ⭐ Optional Variant (Comma-Separated Names)
        Map<String, String> employeeNamesByDepartment =
                employeeList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(Employee::getName, Collectors.joining(", "))
                        ));
        System.out.println("employeeNamesByDepartment:: " + employeeNamesByDepartment);

        // 13 : What is the average salary and total salary of the whole organization?
        // 🏆 BEST SOLUTION (Recommended)
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
               // .mapToDouble(e -> e.getSalary()).average();
                .mapToDouble(Employee::getSalary).average(); // RECOMMENDED
        if (average_salary_of_employees.isPresent()) {
            System.out.println("average_salary_of_employees:: " + average_salary_of_employees);
        }

        // ⚠ Approach 2 – averagingDouble  Not RECOMMENDED. Prefer terminal oparator e.g. average
        Double avg = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        /*
        ✔ What it gives you
        ONLY average salary
        ❌ Limitations
        Cannot get total salary
        If you later need sum → another stream traversal
         */

        // Approch 3 - Manual sum / count (NOT recommended)
        double totalSalary =
                employeeList.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum();

        double averageSalary =
                totalSalary / employeeList.size();


        // 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        // Partition employees into two groups: <= 25 years old and > 25 years old
        Map<Boolean, List<Employee>> partitionedEmployees = employeeList.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() <= 25));
        List<Employee> ageLessThanOrEqual25 = partitionedEmployees.get(true);
        List<Employee> ageGreaterThan25 = partitionedEmployees.get(false);

        System.out.println("Age <= 25 :: " + ageLessThanOrEqual25);
        System.out.println("Age > 25  :: " + ageGreaterThan25);
        // Print employees who are 25 or younger
        System.out.println("Q14: employees who are 25 years old or younger:");
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
        //🏆 BEST SOLUTION (Recommended)
        /*
                Uses primitive comparator
                comparingInt(Employee::getAge)
                Avoids boxing (int → Integer)
                Better performance

                Clear intention: comparing int age
                Type-safe & efficient
                No unnecessary object creation
                Preferred by Java documentation
                Interview-standard
                This is exactly what interviewers expect
         */
        Optional<Employee> youngestEmployee =
                employeeList.stream()
                        .min(Comparator.comparingInt(Employee::getAge));

        youngestEmployee.ifPresent(emp -> {
            System.out.println("Youngest Employee Name : " + emp.getName());
            System.out.println("Age                    : " + emp.getAge());
            System.out.println("Department             : " + emp.getDepartment());
        });

        Optional<Employee> smallest_record_based_on_age = employeeList.stream()
                .min(Comparator.comparing(Employee::getAge));
        System.out.println("Q16: smallest_record_based_on_age:: " + smallest_record_based_on_age);
        // or
        /*
        ⚠ Issues / Limitations
        Autoboxing happens
        int → Integer
        Comparator.comparing() works with objects
        Slight performance overhead
        Less explicit
        Not obvious that age is primitive
        Less expressive than comparingInt
         */

        Optional<Employee> smallest_record_based_on_age2 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge)).findFirst();
        System.out.println("smallest_record_based_on_age2:: " + smallest_record_based_on_age2);
        //or
        Optional<Employee> smallest_record_based_on_age3 = employeeList.stream()
                .sorted((e1, e2) -> e1.age - e2.getAge())
                .findFirst();
        System.out.println("smallest_record_based_on_age3:: " + smallest_record_based_on_age3);

        // 17: find the highest age of a employee details?
        /*
        🏆 BEST SOLUTION (Recommended)
        ✅ Use max() with Comparator.comparingInt
         */
        Optional<Employee> highestAgeEmployee =
                employeeList.stream()
                        .max(Comparator.comparingInt(Employee::getAge));

        highestAgeEmployee.ifPresent(emp -> {
            System.out.println("Highest Age Employee Name : " + emp.getName());
            System.out.println("Age                       : " + emp.getAge());
            System.out.println("Department                : " + emp.getDepartment());
            System.out.println("Salary                    : " + emp.getSalary());
        });

        Optional<Employee> highest_age_of_a_employee_details = employeeList.stream()
                .max(Comparator.comparing(Employee::getAge)); // ❌ Causes autoboxing (int → Integer) 📌 Acceptable, but not best
        System.out.println("Q17: highest_age_of_a_employee_details:: " + highest_age_of_a_employee_details);
        // or
        Optional<Employee> highest_age_of_a_employee_details2 = employeeList.stream()
                .sorted((e1, e2) -> e2.age - e1.getAge()) // ❌ 2. Custom sort with subtraction (VERY BAD)
                .findFirst();
        System.out.println("highest_age_of_a_employee_details2:: " + highest_age_of_a_employee_details2);
        // or
        Optional<Employee> highest_age_of_a_employee_details3 = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed()) // ❌ Sorting is unnecessary ❌ Slower than max()
                .findFirst();
        System.out.println("highest_age_of_a_employee_details3:: " + highest_age_of_a_employee_details3);
        // or highest only age of a employee
        /*
        ✔ Best if you need only age
        ❌ Does NOT give employee details
        📌 Use only when employee object is not needed
         */
        OptionalInt highest_age_of_a_employee_details4 = employeeList.stream()
                .mapToInt(e -> e.getAge())
                .max();
        System.out.println("highest_age_of_a_employee:: " + highest_age_of_a_employee_details4);


        // 18: find the largest record based on Salary
        //🏆 BEST SOLUTION (Strongly Recommended)
        /*
        | Aspect               | Reason                               |
        | -------------------- | ------------------------------------ |
        | Correct semantic     | `max()` directly expresses “largest” |
        | Performance          | O(n) — single traversal              |
        | Primitive comparator | `comparingDouble` avoids boxing      |
        | Readability          | Very clear and expressive            |
        | Safety               | Uses `Optional`                      |
        | Interview standard   | ✔ Yes                                |

         */
        Optional<Employee> highestSalaryEmployee =
                employeeList.stream()
                        .max(Comparator.comparingDouble(Employee::getSalary));

        highestSalaryEmployee.ifPresent(emp -> {
            System.out.println("Highest Salary Employee Name : " + emp.getName());
            System.out.println("Salary                       : " + emp.getSalary());
            System.out.println("Department                   : " + emp.getDepartment());
            System.out.println("Age                           : " + emp.getAge());
        });
        // Below ❌ Approaches to Avoid
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
        /*
        🏆 BEST SOLUTION (Recommended)
        ✅ Use sorted() + skip(1) (clear & interview-friendly)
         */
        Optional<Employee> secondHighestSalaryEmployee =
                employeeList.stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .skip(1)
                        .findFirst();

        secondHighestSalaryEmployee.ifPresent(emp -> {
            System.out.println("Second Highest Salary Employee Name : " + emp.getName());
            System.out.println("Salary                              : " + emp.getSalary());
            System.out.println("Department                          : " + emp.getDepartment());
        });
        /*
        ⚠ Important Improvement (Handle Duplicate Salaries)
        If multiple employees have the same highest salary, the above may return the same salary again.
        🔹 Key Rule to Remember (Most Important)
            Use map() when your lambda returns a NORMAL value
            Use flatMap() when your lambda returns an Optional (or Stream)
        ✅ Best with distinct() on salary
        Interview-ready explanation (⭐ VERY IMPORTANT)
        We use .get(0) because groupingBy returns a list of employees for each salary.
        Since all employees in the list share the same salary and the requirement is to fetch any one employee, the first element is selected.
        Index 0 is safe because groupingBy never produces empty lists.
         */
        // ✅ BEST for PERFORMANCE
        Optional<Employee> secondHighestSalaryEmployeeDistinct1 =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getSalary))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<Double, List<Employee>>comparingByKey().reversed())
                        .skip(1)
                        .findFirst()
                        //  .map(entry -> entry.getValue().get(0));
                        // .map(entry -> entry.getValue().stream().findFirst().get());
                        .flatMap(entry -> entry.getValue().stream().findFirst());
        System.out.println("secondHighestSalaryEmployeeDistinct1:: " + secondHighestSalaryEmployeeDistinct1);
        // ✅ BEST for INTERVIEWS & CLARITY
        Optional<Employee> secondHighestSalaryEmployeeDistinct2 =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getSalary))
                        .keySet()
                        .stream()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .flatMap(
                                salary -> employeeList.stream()
                                        .filter(e -> e.getSalary() == salary)
                                        .findFirst()
                        );
        System.out.println("secondHighestSalaryEmployeeDistinct2:: " + secondHighestSalaryEmployeeDistinct2);

        // Belows needs some improvements

        Optional<Employee> second_largest_record_based_on_Salary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // Sort by salary in descending order
                .skip(1)  // Skip the first (highest) element
                .findFirst();   // Get the second element (second highest salary)
        System.out.println("Q19: second_largest_record_based_on_Salary:: " + second_largest_record_based_on_Salary);
        // Print the result
        second_largest_record_based_on_Salary.ifPresent(employee ->
                System.out.println("Employee with second highest salary: " + employee));

        /*
        Below is for knowlede pupose:
        🔍 Code-1 Analysis (⚠️ LOGICALLY FLAWED)
        Optional<Employee> second_largest_record_based_on_Salary =
        employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .distinct()
                .skip(1)
                .findFirst();
            ❌ Why this is PROBLEMATIC
            1️⃣ distinct() does NOT work as you expect
            distinct() uses equals() and hashCode()
            Your Employee class does NOT override equals() and hashCode()
            So:
            Two employees with the same salary are still different objects
            distinct() does NOT remove salary duplicates
            📌 This means:
            You may still get the same salary again, not the true 2nd highest distinct salary
            2️⃣ Sorting + distinct = misleading
            Looks correct
            But logically incorrect unless equals/hashCode are salary-based
            🚫 This is a classic interview trap
         */

        // 20: ascending sort based on age
        // ⭐ BEST & RECOMMENDED SOLUTION
        List<Employee> ascending_sort_based_on_age = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList()); // Sort by age in ascending order
        System.out.println("Q20: ascending_sort_based_on_age:: " + ascending_sort_based_on_age);
        //or  Belows are not best
        List<Employee> ascending_sort_based_on_age1 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList()); // Sort by age in ascending order  Causes autoboxing (int → Integer) Minor performance impact (usually negligible)
        System.out.println("ascending_sort_based_on_age1:: " + ascending_sort_based_on_age1);
        //or
        /*
        ❌ Belpw Not recommended (manual subtraction)
        .sorted((e1, e2) -> e1.getAge() - e2.getAge())
        ❌ Why avoid?
        Risk of integer overflow
        Less readable
        Not best practice
         */
        List<Employee> ascending_sort_based_on_age2 = employeeList.stream()
                .sorted((e1, e2) -> e1.age - e2.age)
                .collect(Collectors.toList());
        System.out.println("ascending_sort_based_on_age2:: " + ascending_sort_based_on_age2);
        //or
        // employeeList.stream()
        //       .sorted(Comparator.comparingInt(Employee::getAge))
        //     .forEach(System.out::println); // Print each employee

        // 21: descending sort based on age
        // ⭐ Recommended (clean, readable, efficient) (BEST way)
        /*
        ✔ Why this is BEST
            Uses method reference (Employee::getAge)
            Uses primitive comparator (comparingInt) → avoids boxing
            Clear intent: sort by age descending
            No unnecessary operations
         */
        List<Employee> employeesSortedByAgeDesc =
                employeeList.stream()
                        .sorted(Comparator.comparingInt(Employee::getAge).reversed()) // comparingInt this in important
                        .collect(Collectors.toList());

        System.out.println("Q21: employeesSortedByAgeDesc:: " + employeesSortedByAgeDesc);
        // or Belows are not best
        // Alternative (works, but less clean)
        List<Employee> employeesSortedByAgeDesc1 =
                employeeList.stream()
                        .sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                        .collect(Collectors.toList());

        List<Employee> descending_sort_based_on_age = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("Q21: descending_sort_based_on_age:: " + descending_sort_based_on_age);
        //or
        /*
        3️⃣ ❌ NOT recommended (overflow risk)
        ❌ Integer subtraction can overflow
        ❌ Bad interview impression
         */
        List<Employee> descending_sort_based_on_age1 = employeeList.stream()
                .sorted((e1, e2) -> e2.age - e1.getAge())
                .collect(Collectors.toList());
        System.out.println("descending_sort_based_on_age1:: " + descending_sort_based_on_age1);

        // 22: ascending sort based on salary
        // ⭐ Recommended (production + interview ready)
        /*
        🔍 Why this is the BEST
            comparingDouble → avoids boxing (Double)
            Clear intent: sort by salary ascending
            Safe (no subtraction / overflow issues)
            Most readable & maintainable
         */
        List<Employee> ascending_sort_based_on_salary1 = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))// Sort by salary in ascending order
                .collect(Collectors.toList());
        System.out.println("ascending_sort_based_on_salary1:: " + ascending_sort_based_on_salary1);
        // Below are 2️⃣ Alternative (works, but not ideal)
        /*
        ⚠ Uses boxing (Double)
        ⚠ Slightly less efficient (still acceptable)
         */
        List<Employee> ascending_sort_based_on_salary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("Q22: ascending_sort_based_on_salary:: " + ascending_sort_based_on_salary);
        //or
        /*
        3️⃣ ❌ Avoid this (bad practice)
        .sorted((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
        ❌ Precision loss
        ❌ Wrong ordering for close values
        ❌ Interview red flag 🚫
         */
        List<Employee> ascending_sort_based_on_salary2 = employeeList.stream()
                .sorted((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
                .collect(Collectors.toList());
        System.out.println("ascending_sort_based_on_salary2:: " + ascending_sort_based_on_salary2);

        // 23: descending sort based on salary
        /*
        ⭐ Recommended (BEST / production / interview)
        🔍 Why this is the BEST
            comparingDouble → avoids boxing (Double)
            .reversed() → clear descending intent
            No arithmetic subtraction (no precision loss)
            Clean, readable, safe
         */
        List<Employee> employeesSortedBySalaryDesc =
                employeeList.stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .collect(Collectors.toList());

        System.out.println("Q23: employeesSortedBySalaryDesc:: " + employeesSortedBySalaryDesc);

        // belows 2️⃣ Alternative (works, but slightly less optimal)
        /*
        ⚠ Uses boxing
        ⚠ Still acceptable, but not ideal
         */
        List<Employee> descending_sort_based_on_salary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("Q23: descending_sort_based_on_salary:: " + descending_sort_based_on_salary);
        //or
        /*
        3️⃣ ❌ Avoid below (very common mistake)
        .sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
        ❌ Precision loss
        ❌ Incorrect ordering for close salaries
        ❌ Interview red flag 🚫
         */
        List<Employee> descending_sort_based_on_salary1 = employeeList.stream()
                .sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
                .collect(Collectors.toList());
        System.out.println("descending_sort_based_on_salary1:: " + descending_sort_based_on_salary1);

        // 24: ascending Sort Based on Name
        /*
        ⭐ Recommended (clean + interview-ready) (BEST solution)
        🔍 Why this is the BEST
            Uses method reference → clean & readable
            String already implements Comparable
            Natural alphabetical (A → Z) order
            No unnecessary complexity

         */

        List<Employee> ascendingSortBasedOnName = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("Q24: ascendingSortBasedOnName:: " + ascendingSortBasedOnName);
        //2️⃣ Case-insensitive sort (very common requirement)
        /*
        ✔ When to use
        If "Rahul" and "rahul" should be treated the same
         */
        List<Employee> employeesSortedByNameAscIgnoreCase =
                employeeList.stream()
                        .sorted(Comparator.comparing(e -> e.getName().toLowerCase()))
                        .collect(Collectors.toList());
        // 3️⃣ Below is Better case-insensitive version (recommended)
        /*
        ✔ No extra object creation
        ✔ Cleaner and faster
         */
        // below is best as per my understanding.
        List<Employee> employeesSortedByNameAscIgnoreCase1 =
                employeeList.stream()
                        .sorted(Comparator.comparing(
                                Employee::getName,
                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                                )
                        )
                        .collect(Collectors.toList());
        // or
        /*
        4️⃣ ❌ Avoid below (not clean)
        .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
            ❌ Verbose
            ❌ Easy to mess up
            ❌ Poor interview impression
         */
        List<Employee> ascendingSortBasedOnName1 = employeeList.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
        System.out.println("ascendingSortBasedOnName1:: " + ascendingSortBasedOnName1);

        // 25 descending Sort Based on Name
        /*
        ⭐ BEST / Recommended (clean + readable) (BEST ways)
        ✔ Why this is BEST
        Uses method reference
        Very readable intent (A → Z reversed)
        No manual compareTo
        Safe and maintainable

         */
        List<Employee> descendingSortBasedOnName = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("Q25: descendingSortBasedOnName:: " + descendingSortBasedOnName);
        /*
        2️⃣ Case-insensitive descending sort (VERY COMMON)
        ✔ Handles Rahul vs rahul correctly
        ✔ No toLowerCase() overhead
         */
        List<Employee> employeesSortedByNameDescIgnoreCase =
                employeeList.stream()
                        .sorted(
                                Comparator.comparing(
                                        Employee::getName,
                                        String.CASE_INSENSITIVE_ORDER
                                ).reversed()
                        )
                        .collect(Collectors.toList());

        //or
        /*
         For below
         3️⃣ ❌ Avoid this (poor practice)
         .sorted((e1, e2) -> e2.getName().compareTo(e1.getName()))
            ❌ Verbose
            ❌ Error-prone
            ❌ Bad interview impression
         */
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
         /* Comparator<Employee> byAgeAscOrder = Comparator.comparingInt(e -> e.age);
        Comparator<Employee> byNameAscOrder = (e1, e2) -> e1.getName().compareTo(e2.getName());
        Comparator<Employee> byAgeDescOrder = (e1, e2) -> e2.getAge() - e1.getAge();
        Comparator<Employee> byNameDescOrder = (e1, e2) -> e2.getName().compareTo(e1.getName());
        // Comparator<Employee> bySalryDescOrder = (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary());
        Comparator<Employee> bySalryDescOrder = (e1, e2) -> (int) (e2.getSalary() - e1.getSalary());
        */

        /*
        Feed back from ChatGpt as below
            2️⃣ Feedback & Improvements
            🔹 1. Minor improvement: Name sorting should often be case-insensitive
            Current:
            Comparator<Employee> nameSort = Comparator.comparing(Employee::getName);
            Better (recommended in real projects):
            Comparator<Employee> nameSort = Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER);

            Why?
            "rahul" and "Rahul" sort together
            Avoids toLowerCase() overhead
         */

        /*
            3️⃣ ✅ BEST Recommended Version (Final)
            🧠 Interview-ready explanation
                Defining reusable comparators improves readability, avoids duplication, and makes multi-level sorting easier and safer.
                Using thenComparing expresses priority clearly and keeps the code maintainable.
                🏁 Final Verdict
                | Version               | Verdict                  |
                | --------------------- | ------------------------ |
                | Inline comparator     | ✅ Correct                |
                | Reusable comparators  | ⭐ **BEST**               |
                | Case-insensitive name | ⭐ **Highly recommended** |

         */

        // ASCENDING   From ChatGpt
        Comparator<Employee> ageSort = Comparator.comparingInt(Employee::getAge);
        Comparator<Employee> nameSort = Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER);
        Comparator<Employee> salarySort = Comparator.comparingDouble(Employee::getSalary);

        // DESCENDING   From ChatGpt
        Comparator<Employee> ageDescSort = Comparator.comparingInt(Employee::getAge).reversed();
        Comparator<Employee> nameDescSort = Comparator.comparing(Employee::getName).reversed();
        Comparator<Employee> salaryDescSort = Comparator.comparingDouble(Employee::getSalary).reversed();


        // 26 ascending sort based on age and name
        List<Employee> ascending_sort_based_on_age_and_name = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(Employee::getAge) // Sort by age
                                .thenComparing(Employee::getName) // Sort by  name
                ) // Then sort by name
                .collect(Collectors.toList());
        System.out.println("Q26: ascending_sort_based_on_age_and_name:: " + ascending_sort_based_on_age_and_name);
        // ✅ Below is BEST Recommended
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
        // Below is ✅ BEST Recommended Version (FINAL)
        List<Employee> ascending_sort_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(
                        ageSort
                                .thenComparing(nameSort)
                                .thenComparing(salarySort)
                )
                .collect(Collectors.toList());

        // 28 descending sort based on age and name and salary


        //5️⃣ ⭐ Below are BEST RECOMMENDED SOLUTION (Final) From ChatGpt
        //     ✅ Cleanest + Most Maintainable
        /*
        Rule you must remember (golden rule 🧠)
        reversed() applies to whatever comparator comes immediately before it
            If applied at the end → reverses the whole chain
            If applied inside thenComparing → reverses only that field
         */
        List<Employee> resultDescending_sort_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(Employee::getAge).reversed()
                                .thenComparing(
                                        Comparator.comparing(
                                                Employee::getName,
                                                String.CASE_INSENSITIVE_ORDER
                                        ).reversed()
                                )
                                .thenComparing(
                                        Comparator.comparingDouble(Employee::getSalary).reversed()
                                )
                )
                .collect(Collectors.toList());
        // 🏆 OR (My Personal Choice – Professional Style)
        // This is exact as ✔ WAY–2: (descending_sort_based_on_age_and_name_and_salary2)
        List<Employee> resultDescending_sort_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(ageDescSort
                        .thenComparing(nameDescSort)
                        .thenComparing(salaryDescSort))
                .collect(Collectors.toList());

        // ✔ WAY–1:
        /*
        Feedback for Way1:
        🔍 What happens?
            Uses boxed types (Integer, String, Double)
            Comparator is reversed per field
            Works correctly
            ⚠ Drawbacks
            Boxing overhead (int → Integer)
            Name comparison is case-sensitive
            Less readable for long chains
            ✅ Correct but not optimal
         */

        List<Employee> descending_sort_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(
                        Comparator.comparing(Employee::getAge, Comparator.reverseOrder())
                                .thenComparing(Employee::getName, Comparator.reverseOrder())
                                .thenComparing(Employee::getSalary, Comparator.reverseOrder())
                )
                .collect(Collectors.toList());
        System.out.println("descending_sort_based_on_age_and_name_and_salary1::  " + descending_sort_based_on_age_and_name_and_salary1);

        //✔ WAY–2: Using comparing() + reversed() (common pattern)
        /*
        Feedback for Way2:  BEST
        🔍 What happens?
            Uses primitive comparators
            Case-insensitive name sorting
            Fully reusable
            Very readable
            ✅ Verdict
            ✔ Production-ready
            ✔ Interview-perfect
            ✔ Recommended

         */
        List<Employee> descending_sort_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(ageDescSort.
                        thenComparing(nameDescSort)
                        .thenComparing(salaryDescSort))
                .collect(Collectors.toList());
        System.out.println("Q28:  descending_sort_based_on_age_and_name_and_salary2:: " + descending_sort_based_on_age_and_name_and_salary2);

        //✔ WAY–3:
        /*
        Feedback for Way3:
        🔍 What happens?
            Correct descending chain
            Name comparison is case-sensitive
            More verbose than necessary
            ⚠ Slight readability issue
            ⚠ No case-insensitive handling
            ✅ Correct but not ideal
         */
        List<Employee> descending_sort_based_on_age_and_name_and_salary3 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(Employee::getAge).reversed()
                                .thenComparing(Comparator.comparing(Employee::getName).reversed())
                                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
                )
                .collect(Collectors.toList());
        System.out.println("descending_sort_based_on_age_and_name_and_salary3::  " + descending_sort_based_on_age_and_name_and_salary3);

        // 29 Find first ascending record based on age and name and salary
        /*
            Feedback for below (first_ascending_record_based_on_age_and_name_and_salary1)
            🔹 Case 1 – sorted() + findFirst()
            ✅ Correct
            ❌ Not optimal
            Why?
            sorted() sorts entire list
            findFirst() only needs minimum element
            ⏱ Time Complexity: O(n log n)
            📌 Works fine for small lists, not ideal for large data
         */
        // Below is not recommended because of sort
        Optional<Employee> first_ascending_record_based_on_age_and_name_and_salary1 =
                employeeList.stream()
                        .sorted(
                                Comparator.comparingInt(Employee::getAge)
                                        .thenComparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
                                        .thenComparingDouble(Employee::getSalary)
                        )
                        .findFirst();

        System.out.println("Q29: first_ascending_record_based_on_age_and_name_and_salary1:: " + first_ascending_record_based_on_age_and_name_and_salary1);
        /*
        Feedback for below: (first_ascending_record_based_on_age_and_name_and_salary2)
        🔹 Case 2 – Reusable comparators + sorted()
        ✅ Correct
        👍 Better readability
        ❌ Same performance issue
        This is cleaner than Case-1, but still suffers from full sorting.
         */
        // Below is not recommended because of sort
        Optional<Employee> first_ascending_record_based_on_age_and_name_and_salary2 =
                employeeList.stream()
                        .sorted(
                                ageSort
                                        .thenComparing(nameSort)
                                        .thenComparing(salarySort)
                        )
                        .findFirst();
        System.out.println("Q29: first_ascending_record_based_on_age_and_name_and_salary2:: " + first_ascending_record_based_on_age_and_name_and_salary2);

        // using min
        /*
        Feedback for below (first_ascending_record_based_on_age_and_name_and_salary3)
        🔹 Case 3 – min() with reusable comparators
        ⏱ Time Complexity: O(n)
        🎯 This is what interviewers expect. If statement is expected from interviewer.
         */
        Optional<Employee> first_ascending_record_based_on_age_and_name_and_salary3 = employeeList.stream()
                .min(
                        ageSort
                                .thenComparing(nameSort)
                                .thenComparing(salarySort)
                );
        if (first_ascending_record_based_on_age_and_name_and_salary3.isPresent()) {
            System.out.println("Q29: first_ascending_record_based_on_age_and_name_and_salary3:: " + first_ascending_record_based_on_age_and_name_and_salary3.get());
        }
        /*
        Feedback for below. first_ascending_record_based_on_age_and_name_and_salary4
        ✅ Correct
        ✅ Efficient
        ✅ Safe (if Optional handled properly)
        ❌ Slight duplication
        Good when:
        Comparator is used only once
        You want compact code
         */

        /*
        🏆 FINAL RECOMMENDATION (BEST WAY)
        🔥 Production-quality + Interview-ready
        ❓ Then why did I not mark #3 as “best”?
            Because #3 depends on external comparator definitions
            Comparator<Employee> ageSort;
            Comparator<Employee> nameSort;
            Comparator<Employee> salarySort;
            This creates hidden risks in real projects.
            🚨 Hidden Problems with Code 3 (Real-World)
            1️⃣ Comparator inconsistency risk
            If someone later changes:
            nameSort = Comparator.comparing(Employee::getName);
            instead of
            Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
            ➡ Behavior silently changes
            Code 4 is self-contained and explicit.
            2️⃣ Debugging difficulty
            When a bug appears:
            Code 3 → you must inspect 3 separate comparator definitions
            Code 4 → comparator logic is right there
            Senior devs prefer local clarity when logic is business-critical.
            3️⃣ Readability for reviewers & interviewers
            Interviewers often think like this:
            “Can I understand the full logic without scrolling?”
            ✔ Code 4 → Yes
            ❌ Code 3 → Depends on earlier code
            4️⃣ Accidental reuse risk
            Suppose someone reuses ageSort elsewhere:
            .sorted(ageSort.thenComparing(salarySort))
            Now salary order differs from Q29 logic → subtle bug.
            🟢 When Code 3 IS actually BETTER
            Now important part 👇
            Code 3 becomes the BEST choice when:
            ✔ Same comparator is used in many places
            ✔ Comparator represents a business rule
            ✔ Comparator is final & well-named

         */
        // Below is BETTER, winner
        Optional<Employee> first_ascending_record_based_on_age_and_name_and_salary4 = employeeList.stream()
                .min(
                        Comparator.comparingInt(Employee::getAge)
                                .thenComparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
                                .thenComparingDouble(Employee::getSalary)
                );
        System.out.println("Q29: first_ascending_record_based_on_age_and_name_and_salary4:: " + first_ascending_record_based_on_age_and_name_and_salary4.get());


        // 30 Find Second ascending record based on age and name and salary
        /*
        Below is BEST PERFORMANCE VERSION (No full sort)
        If the list is large, sorting the entire list is unnecessary.
        Still sorts, but stops early.
         */
        Optional<Employee> second_ascending_record_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(
                        Comparator.comparingInt(Employee::getAge)
                                .thenComparing(Employee::getName,String.CASE_INSENSITIVE_ORDER)
                                .thenComparingDouble(Employee::getSalary)
                )
                .limit(2)
                .skip(1)
                .findFirst();
        System.out.println("Q30: second_ascending_record_based_on_age_and_name_and_salary1:: " + second_ascending_record_based_on_age_and_name_and_salary1);
        /* 🧠 MOST CORRECT ENTERPRISE WAY (Named Comparator)
        ✔ Reusable
        ✔ Clean
        ✔ Production-ready*/
        Comparator<Employee> AGE_NAME_SALARY_ASC =
                Comparator.comparingInt(Employee::getAge)
                        .thenComparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
                        .thenComparingDouble(Employee::getSalary);

        Optional<Employee> secondAscendingEmployee =
                employeeList.stream()
                        .sorted(AGE_NAME_SALARY_ASC)
                        .skip(1)
                        .findFirst();
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
❓ Should we use distinct()?
❌ Usually NO
Because:
Two employees can have same age, name, salary but still be different records
distinct() depends on equals() & hashCode()
✅ Use distinct() only if business says:
“Ignore duplicate age-name-salary combinations”
Example:
 */
        // 🟡 If business wants distinct by age+name+salary
        Optional<Employee> secondAscendingDistinctEmployee =
                employeeList.stream()
                        .collect(
                                Collectors.collectingAndThen(
                                        Collectors.toMap(
                                                e -> e.getAge() + "|" + e.getName().toLowerCase() + "|" + e.getSalary(),
                                                e -> e,
                                                (e1, e2) -> e1
                                        ),
                                        mapp -> mapp.values().stream()
                                )
                        )
                        .sorted(
                                Comparator.comparingInt(Employee::getAge)
                                        .thenComparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
                                        .thenComparingDouble(Employee::getSalary)
                        )
                        .skip(1)
                        .findFirst();


        // 31 Find first descending record based on age and name and salary
       /*
        Below is correct code.
        ✅ What is GOOD about this code
        1️⃣ Logically Correct
        ✔ Sorts by:
        Age → DESC
        Name → DESC
        Salary → DESC
        ✔ findFirst() returns the top descending record
        So output is correct.
        2️⃣ Readable & Fluent
        This style:
        Comparator.comparing(key, Comparator.reverseOrder())
        is perfectly valid and expressive.
        Many senior devs actually like this style 👍
        ⚠️ Where it is NOT the BEST
        ❌ 1️⃣ Full Sorting Is Unnecessary
        .sorted(...)
        .findFirst();
        This sorts the entire list, which is O(n log n).
        But your requirement is:
        “Find first descending record”
        ➡ Only one element is needed, not the whole order.
        ❌ 2️⃣ max() Is More Semantically Correct
        This problem is conceptually:
        “Give me the maximum employee based on (age, name, salary)”
        So this reads better:
        employeeList.stream().max(comparator)
        ❌ 3️⃣ Name Comparator Is Case-Sensitive
        Your version:
        Comparator.comparing(Employee::getName, Comparator.reverseOrder())
        ⚠️ If names differ only by case ("adam" vs "Adam"), ordering may be inconsistent.

         */
        // Below not recommende because of sort
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
    /*
    ⭐ Below is BEST VERSION (My Recommendation)
    ✔ Most Efficient
    ✔ Most Readable
    ✔ Interview-Grade
     */
        Comparator<Employee> DESC_COMPARATOR =
                Comparator.comparingInt(Employee::getAge).reversed()
                        .thenComparing(
                                Comparator.comparing(
                                        Employee::getName,
                                        String.CASE_INSENSITIVE_ORDER
                                ).reversed()
                        )
                        .thenComparingDouble(Employee::getSalary).reversed();
        Optional<Employee> firstDescendingEmployee =
                employeeList.stream().max(DESC_COMPARATOR);
        if (firstDescendingEmployee.isPresent()){
            System.out.println("Q31: first_descending_record_based_on_age_and_name_and_salary3:: " + firstDescendingEmployee.get());
        }



        // 32 Find second descending record based on age and name and salary
        //  age DESC, name DESC, salary DESC,
        // Below is correct code
        Optional<Employee> second_descending_record_based_on_age_and_name_and_salary1 = employeeList.stream()
                .sorted(ageDescSort.
                        thenComparing(nameDescSort)
                        .thenComparing(salaryDescSort)
                )
                .distinct() // distinct() uses equals() & hashCode() So, dont use if interviewer not asking about it..
                .skip(1)
                .findFirst();

        System.out.println("second_descending_record_based_on_age_and_name_and_salary1:: " + second_descending_record_based_on_age_and_name_and_salary1.get());
        /* Below Approch Best:
			 ⭐ The Most Important Rule
            Never use .reversed() at the end of a multi-step comparator chain
            It will reverse the whole comparator, not just the last field.
            Instead, reverse each field individually (Approach-2).
		*/
        Comparator<Employee> DESC_AGE_NAME_SALARY =
                Comparator.comparingInt(Employee::getAge).reversed()
                        .thenComparing(
                                Comparator.comparing(
                                        Employee::getName,
                                        String.CASE_INSENSITIVE_ORDER
                                ).reversed()
                        )
                        .thenComparingDouble(Employee::getSalary).reversed();

        Optional<Employee> second_descending_record_based_on_age_and_name_and_salary2 = employeeList.stream()
                .sorted(DESC_AGE_NAME_SALARY)
                .distinct()
                .limit(2)        // optional micro-optimization: only need first two distinct
                .skip(1)
                .findFirst();

        System.out.println("second_descending_record_based_on_age_and_name_and_salary2::  " + second_descending_record_based_on_age_and_name_and_salary2.get());
/*
            Below code look loke ok but having isue. Be careful and avoid this.
            Step-by-Step Comparator Construction
            Step 1: Age DESC
            Comparator.comparingInt(Employee::getAge).reversed()
            ✅ Age DESC ✔
            Step 2: Add Name (ASC case-insensitive)
            .thenComparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
            Comparator so far:
            Age DESC
            Name ASC
            Still OK.
            Step 3: .reversed() ← THIS IS THE TRAP
            .thenComparing(...).reversed()
            This reverses everything built so far, not just name.
            So now it becomes:
            Age ASC   ❌
            Name DESC
            Age got flipped back. This is unavoidable behavior.
            Step 4: Salary DESC
            .thenComparingDouble(Employee::getSalary).reversed()
            Final order becomes:
            Age ASC        ❌
            Name DESC
            Salary DESC
            🔍 Why This Is NOT What You Intended
            Your intention was:
            Age DESC
            Name DESC
            Salary DESC
            But the actual result is:
            Age ASC   ❌
            Name DESC
            Salary DESC
            This is 100% per the Java Comparator contract — not opinion.

 */

        Optional<Employee> second_descending_record_based_on_age_and_name_and_salary3 =
                employeeList.stream()
                        .sorted(
                                Comparator.comparingInt(Employee::getAge).reversed()
                                        .thenComparing(Employee::getName,String.CASE_INSENSITIVE_ORDER).reversed() // Step 3: .reversed() ← THIS IS THE TRAP. Wrong approch
                                        .thenComparingDouble(Employee::getSalary).reversed()
                        )
                        .limit(2)
                        .skip(1)
                        .findFirst();
        System.out.println("second_descending_record_based_on_age_and_name_and_salary3::  " + second_descending_record_based_on_age_and_name_and_salary3.get());


        // 33 Find the average salary of employee
        //       ✅ BEST WAY (Recommended – Interview & Production)
        /*
        🔥 Why this is BEST
                Uses primitive stream (DoubleStream)
                No boxing / unboxing
                Most efficient
                Very clear intention
         */
        OptionalDouble averageSalary33 =
                employeeList.stream()
                        .mapToDouble(Employee::getSalary)
                        .average();

        averageSalary33.ifPresent(avg33 ->
                System.out.println("Average salary of employees :: " + avg33)
        );
        // ✅ WAY–2: Using Collectors
        /*
        ✔ Clean
        ✔ Common in real projects
        ❌ Slightly less efficient than mapToDouble
         */
        Double averageSalary2 =
                employeeList.stream()
                        .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println("Average salary of employees :: " + averageSalary2);
        // ✅ WAY–3: When you need more than average. ✔ Useful when you also need sum / max / min / count
        DoubleSummaryStatistics stats =
                employeeList.stream()
                        .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Average salary :: " + stats.getAverage());


        // 34 find all the employee whose age is greater than 30
        //✅ BEST & RECOMMENDED WAY  ✔ Using filter() + collect()
        List<Employee> all_the_employee_whose_age_is_greater_than_30 = employeeList.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println("Q34: all_the_employee_whose_age_is_greater_than_30:: " + all_the_employee_whose_age_is_greater_than_30);

        // 34.1 find all the employee names whose age is greater than 30
        /*
        ✅ BEST & RECOMMENDED SOLUTION
        ✔ filter() → map() → collect()
         */
        List<String> all_the_employee_names_whose_age_is_greater_than_30 = employeeList.stream()
                .filter(e -> e.getAge() > 30)    // condition
              //  .map(e -> e.getName())
                .map(Employee::getName)            // extract only name
                .collect(Collectors.toList());
        System.out.println("Q34.1: all_the_employee_names_whose_age_is_greater_than_30:: " + all_the_employee_names_whose_age_is_greater_than_30);

        // 35 count number of employees with age greater 30?
        long count_number_of_employees_with_age_greater_30 = employeeList.stream()
                .filter(e -> e.getAge() > 30)
                .count();
        System.out.println("Q35: count_number_of_employees_with_age_greater_30:: " + count_number_of_employees_with_age_greater_30);

        long count_number_of_employees_with_age_greater_30_1 = employeeList.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.counting());    // ⚠️ Works, but extra abstraction compared to .count().
        System.out.println("Q35: count_number_of_employees_with_age_greater_30_1:: " + count_number_of_employees_with_age_greater_30_1);

        // 36 find the employee with name “Manu”.
        // ✅ Below is BEST WAY (Recommended)
        /*
        🔥 Why this is BEST
            equalsIgnoreCase → avoids NPE + case-safe
            findFirst() → stops as soon as match is found
            Optional handling is clean and safe
            Most readable and professional
         */
        Optional<Employee> employeeNamedManu =
                employeeList.stream()
                        .filter(e -> "Manu".equalsIgnoreCase(e.getName()))
                        .findFirst();

        employeeNamedManu.ifPresentOrElse(
                emp -> System.out.println("Employee found :: " + emp),
                () -> System.out.println("Employee Manu not found")
        );
        // ✅ WAY–2: If multiple employees named Manu are possible.  ✔ Use this when duplicates are allowed
        List<Employee> employeesNamedManu =
                employeeList.stream()
                        .filter(e -> "Manu".equalsIgnoreCase(e.getName()))
                        .collect(Collectors.toList());

        System.out.println("Employees named Manu :: " + employeesNamedManu);
        /*
        find the employee with name “Manu”. and find employees whose names start with “Manu” both are different requiremnts.
         */
        // Below code is sutable for "find employees whose names start with “Manu”.

        List<Employee> employee_with_name_Manu = employeeList.stream()
                .filter(e -> e.getName().startsWith("Manu"))
                .collect(Collectors.toList());
        System.out.println("Q36: employee_with_name_Manu:: " + employee_with_name_Manu);

        // 37 find maximum age of employee?
        //⭐ BEST & MOST RECOMMENDED WAY
        /*
        🔥 Why this is BEST
            Uses primitive stream (IntStream)
            No boxing / unboxing
            Most efficient & clean
            Interview-friendly
         */
        OptionalInt maxAge =
                employeeList.stream()
                        .mapToInt(Employee::getAge)
                        .max();

        maxAge.ifPresent(age ->
                System.out.println("Maximum age of employee :: " + age)
        );
    // or Using Comparator (when employee details are also needed)
        /*
        When to use this?
        👉 If question is:
        “Who is the oldest employee?”
         */
        Optional<Employee> oldestEmployee =
                employeeList.stream()
                        .max(Comparator.comparingInt(Employee::getAge));

        oldestEmployee.ifPresent(emp -> {
            System.out.println("Name       :: " + emp.getName());
            System.out.println("Age        :: " + emp.getAge());
            System.out.println("Department :: " + emp.getDepartment());
        });


        // 38 Join the all employee names with “,”
        //🌟 BEST & RECOMMENDED WAY

        String joinedNames = employeeList.stream()
                .map(Employee::getName)             // Map each employee to their name
                .collect(Collectors.joining(","));  // Join names with ","
        // ⚠️ IMPORTANT: Handle null names (Real-world safe)
        String joinedEmployeeNames =
                employeeList.stream()
                        .map(Employee::getName)
                        .filter(Objects::nonNull)
                        .collect(Collectors.joining(", "));

        // Print the joined names
        System.out.println("Q38: joinedNames_with_:: " + joinedNames);
        // or
        List<String> employeeNames = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        String employeeNamesStrwith_ = String.join("_", employeeNames);
        System.out.println("employeeNamesStrwith_: " + employeeNamesStrwith_);

        // 39 group employees based on employee name
        //🌟 BEST & MOST COMMON SOLUTION
        Map<String, List<Employee>> group_employees_based_on_employee_name = employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getName)
                );
        System.out.println("Q39: group_employees_based_on_employee_name:: " + group_employees_based_on_employee_name);
        //  ✅ BEST SOLUTION (Case-Insensitive + Duplicate Safe)

        Map<String, List<Employee>> group_employees_based_on_employee_nameCaseSensitive = employeeList.stream()
                .collect(
                        Collectors.groupingBy(  e -> e.getName().toLowerCase())
                );
        System.out.println("Q39: group_employees_based_on_employee_nameCaseSensitive:: " + group_employees_based_on_employee_nameCaseSensitive);


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
        // or 🌟 BEST & MOST RECOMMENDED SOLUTION
        List<String> duplicateNamesEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry  -> entry .getValue() > 1) // count > 1 means duplicate
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("duplicateNamesEmployees:: " + duplicateNamesEmployees);
        //  🌟 BEST & MOST RECOMMENDED SOLUTION for case-insensitive

        List<String> duplicateNamesEmployeesCaseSensitive = employeeList.stream()
                .collect(Collectors.groupingBy(e->e.getName().toLowerCase(),Collectors.counting()))
                .entrySet().stream()
                .filter(v->v.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("duplicateNamesEmployeesCaseSensitive:: " + duplicateNamesEmployeesCaseSensitive);


    }
}
