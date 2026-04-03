package com.mane.umakant.solid.SingleResponsibilityPrinciple;

public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee("Amit", 10);

        SalaryCalculator calculator = new SalaryCalculator();
        double salary = calculator.calculateSalary(emp);

        EmployeeRepository repository = new EmployeeRepository();
        repository.save(emp);

        ReportPrinter printer = new ReportPrinter();
        printer.print(emp, salary);
    }
}
