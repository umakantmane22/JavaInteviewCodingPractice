// Start https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
package com.mane.umakant.java8;

import java.util.*;
import java.util.function.DoubleUnaryOperator;
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
        System.out.println("How_many_male_and_female_employees_are_there_in_the_organization:: " + How_many_male_and_female_employees_are_there_in_the_organization);

        // 2: Print the name of all departments in the organization?
        List<String> name_of_all_departments_in_the_organization = employeeList.stream()
                // .map(e -> e.getDepartment())
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("name_of_all_departments_in_the_organization:: " + name_of_all_departments_in_the_organization);
        // Or
        //employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        // 3 : What is the average age of male and female employees?
        Map<String, Double> average_age_of_male_and_female_employees = employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge))
                );
        System.out.println("average_age_of_male_and_female_employees:: " + average_age_of_male_and_female_employees);

        // 4 : Get the details of highest paid employee in the organization?
        Optional<Employee> highest_paid_employee = employeeList.stream()
                .max(Comparator.comparing(employee -> employee.getSalary()));
        System.out.println("highest_paid_employee:: " + highest_paid_employee);
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
        System.out.println("names_of_all_employees_who_have_joined_after_2015:: " + names_of_all_employees_who_have_joined_after_2015);

        // 6 : Count the number of employees in each department?
        Map<String, Long> Count_the_number_of_employees_in_each_department = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count_the_number_of_employees_in_each_department:: " + Count_the_number_of_employees_in_each_department);
        // or
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        // 7 : What is the average salary of each department?
        Map<String, Double> average_salary_of_each_department = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("average_salary_of_each_department:: " + average_salary_of_each_department);
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
        System.out.println("details_of_youngest_male_employee_in_the_product_development_department:: " + details_of_youngest_male_employee_in_the_product_development_department);
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
        System.out.println("most_working_experience_in_the_organization:: " + most_working_experience_in_the_organization);
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
        System.out.println("How_many_male_and_female_employees_are_there_in_the_sales_and_marketing_team:: " + How_many_male_and_female_employees_are_there_in_the_sales_and_marketing_team);
    }
}
