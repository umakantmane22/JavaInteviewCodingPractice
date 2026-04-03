package com.mane.umakant.java8.chatGptStreamImp;

import java.util.List;
import java.util.Objects;

public class Employee {

	private int id;
	private String name;
	private int age;
	private String gender;
	private double salary;
	private Department department;
	private List<String> skills;
	private List<String> projects;

	public Employee(int id, String name, int age, String gender, double salary, Department department,
			List<String> skills, List<String> projects) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.department = department;
		this.skills = skills;
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public double getSalary() {
		return salary;
	}

	public Department getDepartment() {
		return department;
	}

	public List<String> getSkills() {
		return skills;
	}

	public List<String> getProjects() {
		return projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary=" + salary
				+ ", department=" + department + ", skills=" + skills + ", projects=" + projects + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Employee))
			return false;
		return id == ((Employee) o).id;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}