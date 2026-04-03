package com.mane.umakant.solid.SingleResponsibilityPrinciple;

// Salary Calculator (Only salary logic)
public class SalaryCalculator {
    public double calculateSalary(Employee emp) {
        return emp.getHours() * 500;
    }
}
