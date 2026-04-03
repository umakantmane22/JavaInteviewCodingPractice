package com.mane.umakant.java8.chatGptStreamImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {

	private int id;
	private String name;
	private List<Employee> employees = new ArrayList<>();

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void addEmployee(Employee emp) {
		employees.add(emp);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return "Department{" + "id=" + id + ", name='" + name + '\'' + ", empCount=" + employees.size() + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Department))
			return false;
		return id == ((Department) o).id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}