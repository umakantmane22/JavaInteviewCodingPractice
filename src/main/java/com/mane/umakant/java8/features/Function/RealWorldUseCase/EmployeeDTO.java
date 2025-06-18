package com.mane.umakant.java8.features.Function.RealWorldUseCase;

public class EmployeeDTO {
    String name;
    String info;
    EmployeeDTO(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String toString() {
        return name + " -> " + info;
    }
}
