package com.mane.umakant.java8.features.Function.RealWorldUseCase;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Employee, EmployeeDTO> converter = e ->
                new EmployeeDTO(e.name, "Salary: " + e.salary);

        Employee emp = new Employee("John", 50000);
        System.out.println(converter.apply(emp)); // John -> Salary: 50000
    }
}
