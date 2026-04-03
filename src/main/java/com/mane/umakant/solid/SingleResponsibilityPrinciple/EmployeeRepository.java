package com.mane.umakant.solid.SingleResponsibilityPrinciple;

// Employee Repository (Database logic)
public class EmployeeRepository {
    public void save(Employee emp) {
        System.out.println("Saving employee " + emp.getName() + " to database");
    }
}
