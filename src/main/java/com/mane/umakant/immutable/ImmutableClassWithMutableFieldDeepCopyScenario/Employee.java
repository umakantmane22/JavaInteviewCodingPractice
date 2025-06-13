package com.mane.umakant.immutable.ImmutableClassWithMutableFieldDeepCopyScenario;

import java.util.Date;

public final class Employee {
    private final String name;
    private final Date joinDate; // mutable object

    public Employee(String name, Date joinDate) {
        this.name = name;
        this.joinDate = new Date(joinDate.getTime()); // Defensive copy
    }

    public String getName() {
        return name;
    }

    public Date getJoinDate() {
        return new Date(joinDate.getTime()); // Return copy
    }
}

