package com.mane.umakant.immutable.ImmutableClassWithCollection;

import java.util.*;

public final class Department {
    private final String deptName;
    private final List<String> employees;

    public Department(String deptName, List<String> employees) {
        this.deptName = deptName;
        this.employees = new ArrayList<>(employees); // Defensive copy
    }

    public String getDeptName() {
        return deptName;
    }

    public List<String> getEmployees() {
        return new ArrayList<>(employees); // Return copy
    }
}
