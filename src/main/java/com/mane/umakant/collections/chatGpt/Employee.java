package com.mane.umakant.collections.chatGpt;

import java.util.Date;

public final class Employee {
    private final int id;
    private final String name;
    private final Date joinDate; // Mutable field

    public Employee(int id, String name, Date joinDate) {
        this.id = id;
        this.name = name;
        // Defensive copy for mutable field
        this.joinDate = new Date(joinDate.getTime());
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Return a copy to prevent external modification
    public Date getJoinDate() {
        return new Date(joinDate.getTime());
    }
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', joinDate=" + joinDate + '}';
    }

}
