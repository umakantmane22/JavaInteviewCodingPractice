package com.mane.umakant.java8.departmentEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
    int empId;
    String empName;
    Department department;
    double salary;

    public Employee(int empId, String empName, Department department, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public static void main(String args[]) {
        List<Employee> emplist = new ArrayList<>();
        emplist.add(new Employee(1, "umesh1", new Department(3, "Sales"), 1200));
        emplist.add(new Employee(2, "umesh2", new Department(2, "It"), 1200));
        emplist.add(new Employee(3, "umesh3", new Department(3, "Sales"), 1200));
        emplist.add(new Employee(4, "umesh4", new Department(1, "Hr"), 1200));
        emplist.add(new Employee(5, "umesh5", new Department(2, "It"), 1200));
        emplist.add(new Employee(6, "umesh6", new Department(3, "Sales"), 1200));
        emplist.add(new Employee(7, "umesh7", new Department(1, "Hr"), 1200));
        emplist.add(new Employee(8, "umesh8", new Department(2, "It"), 1200));
        emplist.add(new Employee(9, "umesh9", new Department(1, "Hr"), 1200));
        emplist.add(new Employee(10, "umesh10", new Department(1, "Hr"), 1200));
        emplist.add(new Employee(11, "umesh11", new Department(2, "It"), 1200));
        emplist.add(new Employee(12, "umesh12", new Department(3, "Sales"), 1200));
        emplist.add(new Employee(13, "umesh13", new Department(1, "Hr"), 1200));
        emplist.add(new Employee(14, "umesh14", new Department(3, "Sales"), 1200));
        emplist.add(new Employee(15, "umesh15", new Department(1, "Hr"), 1200));

        //Q1: find department names which contains more than 4 emp;

        List<Map.Entry<String, Long>> department_names_with_count_which_contains_more_than_4_emp = emplist.stream()
                .collect(Collectors.groupingBy(e -> e.department.depName, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 4)
                // .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("department_names_with_count_which_contains_more_than_4_emp:: " + department_names_with_count_which_contains_more_than_4_emp);

        List<String> department_names_with_count_which_more_than_4_emp = emplist.stream()
                .collect(Collectors.groupingBy(e -> e.department.depName, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 4)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("department_names_with_count_which_more_than_4_emp:: "+department_names_with_count_which_more_than_4_emp);
    }
}
