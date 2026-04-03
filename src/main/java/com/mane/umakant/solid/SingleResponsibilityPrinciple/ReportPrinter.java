package com.mane.umakant.solid.SingleResponsibilityPrinciple;

// Report Printer (Printing responsibility)
public class ReportPrinter{
    public void print(Employee emp, double salary) {
        System.out.println("Employee: " + emp.getName());
        System.out.println("Salary: " + salary);
    }
}
