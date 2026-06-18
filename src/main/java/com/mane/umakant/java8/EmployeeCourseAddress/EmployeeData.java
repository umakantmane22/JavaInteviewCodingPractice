package com.mane.umakant.java8.EmployeeCourseAddress;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

record Course(
        int id,
        String name,
        double marks) {
}

record Address(
        int pin,
        String city,
        String state,
        String country) {
}

/*
        Benefits of 'record':
        Immutable
        Less code
        Auto-generated: constructor, getters, equals(), hashCode(), toString()
        This is becoming very common in modern Spring Boot projects.
 */
enum Gender {
    MALE,
    FEMALE,
    OTHER
}

enum Department {
    IT,
    HR,
    FINANCE
}

record Employee(
        int id,
        String name,
        int age,
        Gender gender,
        Department department,
        LocalDate joiningDate,
        BigDecimal salary,
        List<String> skills,
        List<String> projects,
        List<Course> courses,
        Address address
) {
    // This is called a compact constructor in records.
    public Employee {
        skills = List.copyOf(skills);
        projects = List.copyOf(projects);
        courses = List.copyOf(courses);
    }
}

public class EmployeeData {
    // ========================= MAIN =========================
    public static void main(String[] args) {
        List<Employee> empList = List.of(

                new Employee(
                        1,
                        "Amit",
                        28,
                        Gender.MALE,
                        Department.IT,
                        LocalDate.of(2018, 5, 10),
                        new BigDecimal("70000"), // salary
                        List.of("Java", "Spring"),  // skills
                        List.of("ProjectA", "ProjectB"),    // projects
                        List.of( // courses
                                new Course(1, "Java", 85),
                                new Course(2, "SQL", 75)
                        ),
                        new Address(411001, "Pune", "MH", "India")
                ),

                new Employee(
                        2,
                        "Neha",
                        32,
                        Gender.FEMALE,
                        Department.HR,
                        LocalDate.of(2015, 3, 15),
                        new BigDecimal("50000"),
                        List.of("Communication"),   // skills
                        List.of("Hiring"),  // projects
                        List.of(    // courses
                                new Course(3, "HR Basics", 90)
                        ),
                        new Address(400001, "Mumbai", "MH", "India")
                ),

                new Employee(
                        3,
                        "Raj",
                        26,
                        Gender.MALE,
                        Department.IT,
                        LocalDate.of(2020, 7, 20),
                        new BigDecimal("60000"),
                        List.of("Java", "Microservices"), // skills
                        List.of("ProjectC"), // projects
                        List.of(    // courses
                                new Course(1, "Java", 65)
                        ),
                        new Address(560001, "Bangalore", "KA", "India")
                ),

                new Employee(
                        4,
                        "Priya",
                        30,
                        Gender.FEMALE,
                        Department.FINANCE,
                        LocalDate.of(2016, 9, 12),
                        new BigDecimal("80000"),
                        List.of("Accounting"),
                        List.of("Audit"),
                        List.of(
                                new Course(4, "Finance", 88)
                        ),
                        new Address(110001, "Delhi", "DL", "India")
                ),

                new Employee(
                        5,
                        "Karan",
                        35,
                        Gender.MALE,
                        Department.IT,
                        LocalDate.of(2012, 2, 5),
                        new BigDecimal("90000"),
                        List.of("Java", "AWS"),
                        List.of("ProjectD"),
                        List.of(
                                new Course(5, "Cloud", 92)
                        ),
                        new Address(411001, "Pune", "MH", "India")
                ),

                new Employee(
                        6,
                        "Sneha",
                        29,
                        Gender.FEMALE,
                        Department.IT,
                        LocalDate.of(2019, 6, 1),
                        new BigDecimal("75000"),
                        List.of("Spring Boot", "Docker"),
                        List.of("ProjectE"),
                        List.of(
                                new Course(6, "Docker", 89)
                        ),
                        new Address(500001, "Hyderabad", "TS", "India")
                ),

                new Employee(
                        7,
                        "Vikram",
                        38,
                        Gender.MALE,
                        Department.FINANCE,
                        LocalDate.of(2011, 8, 18),
                        new BigDecimal("120000"),
                        List.of("Taxation"),
                        List.of("Audit"),
                        List.of(
                                new Course(7, "Tax", 95)
                        ),
                        new Address(600001, "Chennai", "TN", "India")
                ),

                new Employee(
                        8,
                        "Pooja",
                        27,
                        Gender.FEMALE,
                        Department.HR,
                        LocalDate.of(2021, 4, 11),
                        new BigDecimal("55000"),
                        List.of("Recruitment"),
                        List.of("Campus Hiring"),
                        List.of(
                                new Course(8, "Recruitment", 86)
                        ),
                        new Address(411001, "Pune", "MH", "India")
                ),

                new Employee(
                        9,
                        "Rohit",
                        31,
                        Gender.MALE,
                        Department.IT,
                        LocalDate.of(2017, 11, 30),
                        new BigDecimal("95000"),
                        List.of("Java", "Kafka", "AWS"),
                        List.of("ProjectF"),
                        List.of(
                                new Course(9, "Kafka", 91)
                        ),
                        new Address(700001, "Kolkata", "WB", "India")
                ),

                new Employee(
                        10,
                        "Anjali",
                        34,
                        Gender.FEMALE,
                        Department.FINANCE,
                        LocalDate.of(2014, 1, 25),
                        new BigDecimal("100000"),
                        List.of("Accounting", "SAP"),
                        List.of("FinanceTransformation"),
                        List.of(
                                new Course(10, "SAP", 93)
                        ),
                        new Address(400001, "Mumbai", "MH", "India")
                )
        );
        // System.out.println("empList as below:: ");
        //System.out.println(empList);
        /* empList as below::
        [
            Employee[id=1, name=Amit, age=28, gender=MALE, department=IT, joiningDate=2018-05-10, salary=70000, skills=[Java, Spring], projects=[ProjectA, ProjectB], courses=[Course[id=1, name=Java, marks=85.0], Course[id=2, name=SQL, marks=75.0]], address=Address[pin=411001, city=Pune, state=MH, country=India]],
            Employee[id=2, name=Neha, age=32, gender=FEMALE, department=HR, joiningDate=2015-03-15, salary=50000, skills=[Communication], projects=[Hiring], courses=[Course[id=3, name=HR Basics, marks=90.0]], address=Address[pin=400001, city=Mumbai, state=MH, country=India]],
            Employee[id=3, name=Raj, age=26, gender=MALE, department=IT, joiningDate=2020-07-20, salary=60000, skills=[Java, Microservices], projects=[ProjectC], courses=[Course[id=1, name=Java, marks=65.0]], address=Address[pin=560001, city=Bangalore, state=KA, country=India]],
            Employee[id=4, name=Priya, age=30, gender=FEMALE, department=FINANCE, joiningDate=2016-09-12, salary=80000, skills=[Accounting], projects=[Audit], courses=[Course[id=4, name=Finance, marks=88.0]], address=Address[pin=110001, city=Delhi, state=DL, country=India]],
            Employee[id=5, name=Karan, age=35, gender=MALE, department=IT, joiningDate=2012-02-05, salary=90000, skills=[Java, AWS], projects=[ProjectD], courses=[Course[id=5, name=Cloud, marks=92.0]], address=Address[pin=411001, city=Pune, state=MH, country=India]],
            Employee[id=6, name=Sneha, age=29, gender=FEMALE, department=IT, joiningDate=2019-06-01, salary=75000, skills=[Spring Boot, Docker], projects=[ProjectE], courses=[Course[id=6, name=Docker, marks=89.0]], address=Address[pin=500001, city=Hyderabad, state=TS, country=India]],
            Employee[id=7, name=Vikram, age=38, gender=MALE, department=FINANCE, joiningDate=2011-08-18, salary=120000, skills=[Taxation], projects=[Audit], courses=[Course[id=7, name=Tax, marks=95.0]], address=Address[pin=600001, city=Chennai, state=TN, country=India]],
            Employee[id=8, name=Pooja, age=27, gender=FEMALE, department=HR, joiningDate=2021-04-11, salary=55000, skills=[Recruitment], projects=[Campus Hiring], courses=[Course[id=8, name=Recruitment, marks=86.0]], address=Address[pin=411001, city=Pune, state=MH, country=India]],
            Employee[id=9, name=Rohit, age=31, gender=MALE, department=IT, joiningDate=2017-11-30, salary=95000, skills=[Java, Kafka, AWS], projects=[ProjectF], courses=[Course[id=9, name=Kafka, marks=91.0]], address=Address[pin=700001, city=Kolkata, state=WB, country=India]],
            Employee[
                        id=10, name=Anjali, age=34, gender=FEMALE, department=FINANCE, joiningDate=2014-01-25, salary=100000,
                        skills=[Accounting, SAP],
                        projects=[FinanceTransformation],
                        courses=[Course[id=10, name=SAP, marks=93.0]],
                        address=Address[pin=400001, city=Mumbai, state=MH, country=India]
                    ]
        ]

         */
        // Intermediate
//        Department wise count
//        Department wise average salary
//        Highest salary employee
//        Second highest salary employee
        // Advanced
//        Department wise highest salary
//        Employees having Java skill
//        Most experienced employee
//        Employees joined after 2020
        // Nested Streams
//        All skills
//        Distinct skills
//        All projects
//        Distinct projects
//        All courses
//        Highest course marks
        //  Multi-level Grouping
//        Department -> Gender count
//        City -> Department count
//        Department -> Employees

        // ### Level 1 Questions
        // 1. Get all employee names.
        // Expected Output: [Amit, Neha, Raj, Priya, Karan, Sneha, Vikram, Pooja, Rohit, Anjali]
        List<String> employeeNames =
                empList.stream()
                        .map(Employee::name)
                        .toList();
        //System.out.println("Q1 employeeNames :: "+employeeNames );

        // 2. Get all employee names sorted alphabetically.
        // Expected Output: [Amit, Anjali, Karan, Neha, Pooja, Priya, Raj, Rohit, Sneha, Vikram]
        List<String> employeeNamesSortedAsc = empList.stream()
                .map(Employee::name)
                .sorted(
                        Comparator.nullsLast(
                                String.CASE_INSENSITIVE_ORDER
                        )
                )
                .toList();
        //System.out.println("Q2 employeeNamesSortedAsc:: " + employeeNamesSortedAsc);

        // Q3  Get all employee names in uppercase.
        List<String> all_employee_names_in_uppercase1 = empList.stream()
                .map(Employee::name)
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .toList();
        //System.out.println(all_employee_names_in_uppercase1);
        //Production Version
        List<String> all_employee_names_in_uppercase2 = empList.stream()
                .map(Employee::name)
                .filter(Objects::nonNull)
                .map(name -> name.toUpperCase(Locale.ROOT))
                .toList();
        //System.out.println(all_employee_names_in_uppercase2);

        // Q4 Count total employees
        int total_employees2 = empList.stream().toList().size();
        int total_employees1 = empList.size();
        long total_employees3 = empList.stream().count();

        //Q5 Get all employees from IT department
        List<Employee> all_employees_from_IT_department = empList.stream()
                // For enums, prefer == over equals() because "Enums are singleton instances in Java."
                .filter(employee -> employee.department() == Department.IT)
                .toList();
        // System.out.println(all_employees_from_IT_department);

        //Q6 Let's slightly increase the difficulty.
        //  Find the employee with the highest salary.
        /*
        Fortunately, BigDecimal already implements:Comparable<BigDecimal>
        Therefore: Comparator.comparing(Employee::salary)  works perfectly.
         */
        Optional<Employee> highestSalaryEmployee =
                empList.stream()
                        .max(
                                Comparator.comparing(Employee::salary)
                        );

        // System.out.println(highestSalaryEmployee);
        Optional<Employee> highestSalaryEmployee2 =
                empList.stream()
                        .max(
                                Comparator.comparing(
                                        Employee::salary,
                                        BigDecimal::compareTo
                                )
                        );
        //System.out.println(highestSalaryEmployee2);
        Employee highestSalaryEmployee3 =
                empList.stream()
                        .max(
                                Comparator.comparing(
                                        Employee::salary,
                                        BigDecimal::compareTo
                                )
                        )
                        .orElseThrow(() -> new RuntimeException("No employee found"));
        //System.out.println(highestSalaryEmployee3);

        //Q7 — Find Average Salary of All Employees
        // Recommended: averageSalary1
        BigDecimal totalSalary =
                empList.stream()
                        .map(Employee::salary)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        long employeeCount = empList.size();
        BigDecimal averageSalary1 =
                totalSalary.divide(
                        BigDecimal.valueOf(employeeCount),
                        2,
                        RoundingMode.HALF_UP
                );
        //System.out.println("averageSalary1:: "+averageSalary1);
        // I have comfort in below: averageSalary2
        Double averageSalary2 = empList.stream()
                .collect(
                        Collectors.averagingDouble(
                                emp -> emp.salary().doubleValue()
                        )
                );
        //System.out.println("averageSalary2:: "+averageSalary2);

        //Q8 — Department-wise Employee Count
        Map<Department, Long> departmentWiseEmployeeCount = empList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::department,
                                Collectors.counting()
                        )
                );
        //System.out.println("departmentWiseEmployeeCount:: " + departmentWiseEmployeeCount);
        // 8.1 sort_by_count_desc
        List<Entry<Department, Long>> sortedDepartmentsByCountDesc = empList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::department,
                                Collectors.counting()
                        )
                ).entrySet().stream()
                .sorted(
                        Map.Entry.<Department, Long>comparingByValue().reversed()
                )
                /*.sorted(
                        Comparator.comparing(
                                Entry::getValue,
                                Comparator.reverseOrder() // If want ascending then just remove ',Comparator.reverseOrder()'
                        )
                )*/
                .toList();
        //System.out.println(sortedDepartmentsByCountDesc);

        // Q9  Department-wise Highest Salary Employee
        /*
        Think:
        Department
            ↓
        Employees of that Department
            ↓
        Highest Salary Employee
         */
        Map<Department, Optional<Employee>> departments_wise_high_salry_employee = empList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::department,
                                Collectors.maxBy(
                                        Comparator.comparing(Employee::salary)
                                )
                        )
                );
        //System.out.println(departments_wise_high_salry_employee);
        /*
        Production Improvement
        Many teams don't like:
        Map<Department, Optional<Employee>>
        because the map itself already indicates whether a department exists.
        So we often unwrap the Optional.
        Using collectingAndThen()
         */
        Map<Department, Employee> departmentsWiseHighSalaryEmployee =
                empList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::department,
                                        Collectors.collectingAndThen(
                                                Collectors.maxBy(
                                                        Comparator.comparing(Employee::salary)
                                                ),
                                                Optional::get
                                        )
                                )
                        );
        //System.out.println(departmentsWiseHighSalaryEmployee);
        // Q9.1  Department-wise Highest Salary Employee
        Map<Department, Optional<BigDecimal>> departments_wise_high_salry_amount = empList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::department,
                                Collectors.mapping(
                                        Employee::salary,
                                        Collectors.maxBy(BigDecimal::compareTo)
                                )
                        )
                );
        //System.out.println(departments_wise_high_salry_amount);

        // Q10 — Get All Distinct Skills
        /*
        Problem in 'all_Distinct_Skills1'
            If:
            employee.skills() == null
            then:
            employee.skills().stream()
            throws:
            NullPointerException
            Verdict
            ❌ Not null-safe
            ✅ Fine only if your domain guarantees:
            skills != null
         */
        List<String> all_Distinct_Skills1 = empList.stream()
                .flatMap(
                        employee -> employee.skills().stream()
                )
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        //System.out.println(all_Distinct_Skills1);
        /*
        How it works: 'all_Distinct_Skills2':
        If:
        skills == null
        then:
        List.of()
        is used.
        Result:
        List.of().stream()
        which is an empty stream.
        Verdict
        ✅ Null-safe
        ✅ Functional style
        ⚠️ Slightly more verbose
         */
        List<String> all_Distinct_Skills2 = empList.stream()
                .flatMap(
                        employee ->
                                Optional.ofNullable(
                                                employee.skills()
                                        )
                                        .orElse(List.of())
                                        .stream()
                )
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        //System.out.println(all_Distinct_Skills2);
        /*
        How works: 'all_Distinct_Skills3'
        tep 1:
        .map(Employee::skills)
        Produces:
        Stream<List<String>>
        Step 2:
        .filter(Objects::nonNull)
        removes null lists.
        Step 3:
        .flatMap(List::stream)
        flattens the remaining lists.
        Verdict
        ✅ Null-safe
        ✅ Very readable
        ✅ Easy to debug
         */
        List<String> all_Distinct_Skills3 = empList.stream()
                .map(Employee::skills)
                .filter(Objects::nonNull)   // removes null lists.
                .flatMap(List::stream)
                .distinct()
                .sorted(Collections.reverseOrder())
                .toList();
        //System.out.println(all_Distinct_Skills3);

        //Q11 — Department-wise Distinct Skills
        /*
        Think Like This:
        Department
            ↓
        Employees
            ↓
        Skills Lists
            ↓
        Flatten Skills
            ↓
        Remove Duplicates
            ↓
        Collect into Set
         */
        Map<Department, Set<String>> Department_wise_Distinct_Skills1 = empList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::department,
                                Collectors.flatMapping(
                                        employee -> employee.skills().stream(),
                                        Collectors.toSet()
                                ))

                );
        //System.out.println(Department_wise_Distinct_Skills1);
        Map<Department, Set<String>> Department_wise_Distinct_Skills2 =
                empList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::department,
                                        Collectors.flatMapping(
                                                employee ->
                                                        Optional.ofNullable(employee.skills())
                                                                .orElse(List.of())
                                                                .stream(),
                                                Collectors.toSet()
                                        ))

                        );
        //System.out.println(Department_wise_Distinct_Skills2);
        Map<Department, Set<String>> Department_wise_Distinct_Skills3 =
                empList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::department,
                                        Collectors.mapping(
                                                Employee::skills,
                                                Collectors.collectingAndThen(
                                                        Collectors.toList(),
                                                        lists -> lists.stream()
                                                                .flatMap(List::stream)
                                                                .collect(Collectors.toSet())
                                                )
                                        )
                                )
                        );
        //System.out.println(Department_wise_Distinct_Skills3);

        //Q12 — Department-wise Average Salary
        /*
        Mental Formula
        Whenever you see:
        Department-wise X
        think:
        Collectors.groupingBy(
                Employee::department,
                X
        )
        Examples:
        Department-wise Count
        groupingBy(..., counting())
        Department-wise Highest Salary Employee
        groupingBy(..., maxBy(...))
        Department-wise Distinct Skills
        groupingBy(..., flatMapping(...))
        Department-wise Average Salary
        groupingBy(..., averagingDouble(...))
        Notice the pattern?
        The only thing changing is the downstream collector.

        For groupingBy, remember these 6 downstream collectors:
        counting()
        mapping()
        flatMapping()
        maxBy()
        minBy()
        averagingDouble()
        These six alone solve a huge percentage of Java 8 interview questions.
         */
        Map<Department, Double> departmentWiseAverageSalary1 =
                empList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::department,
                                        Collectors.averagingDouble(
                                                employee -> employee.salary().doubleValue()
                                        )
                                )
                        );
        //System.out.println(departmentWiseAverageSalary1);
        Map<Department, BigDecimal> departmentWiseAverageSalary2 =
                empList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::department,
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                employees -> {
                                                    List<BigDecimal> salaries =
                                                            employees.stream()
                                                                    .map(Employee::salary)
                                                                    .filter(Objects::nonNull)
                                                                    .toList();
                                                    if (salaries.isEmpty()) {
                                                        return BigDecimal.ZERO;
                                                    }

                                                    BigDecimal totalSalry =
                                                            salaries.stream()
                                                                    .reduce(
                                                                            BigDecimal.ZERO,
                                                                            BigDecimal::add
                                                                    );

                                                    return totalSalry.divide(
                                                            BigDecimal.valueOf(salaries.size()),
                                                            2,
                                                            RoundingMode.HALF_UP
                                                    );
                                                }
                                        )
                                )
                        );
        //System.out.println(departmentWiseAverageSalary2);

        //multi-level grouping questions as below
        //Q14: Count employees by Department and Gender.
        Map<Department, Map<Gender, Long>> count_employees_by_Department_and_Gender = empList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::department,
                                Collectors.groupingBy(
                                        Employee::gender
                                        , Collectors.counting()
                                )
                        )
                );
        //System.out.println(count_employees_by_Department_and_Gender);
        //Many interviewers then ask:
        //"Can you flatten the result?" or "Can you find the department having the maximum number of female employees?"
        Map<String, Long> flattenedMap = count_employees_by_Department_and_Gender.entrySet().stream()
                .flatMap(
                        departmentEntry ->
                                departmentEntry.getValue()
                                        .entrySet()
                                        .stream()
                                        .map(
                                                genderEntry ->
                                                        Map.entry(
                                                                departmentEntry.getKey()
                                                                        + " - "
                                                                        + genderEntry.getKey(),
                                                                genderEntry.getValue()

                                                        )
                                        )
                )
                .collect(
                        Collectors.toMap(
                                Entry::getKey,
                                Entry::getValue
                        )
                );
        //System.out.println(flattenedMap);
        /*
        Yes. Since you're preparing for **9+ years Java Backend interviews**, I would recommend mastering the most frequently asked Java 8 Stream questions in a structured order rather than learning random questions.

---

# Level 1: Basic Grouping & Counting

### Q1. Count Employees by Department

Output:

```java
{
 IT=5,
 HR=3,
 Finance=2
}
```

Concept:

```java
groupingBy + counting
```

---

### Q2. Count Employees by Gender

Output:

```java
{
 Male=6,
 Female=4
}
```

Concept:

```java
groupingBy + counting
```

---

### Q3. Count Employees by Department and Gender

Output:

```java
{
 IT={Male=3, Female=2},
 HR={Male=1, Female=2}
}
```

Concept:

```java
groupingBy + groupingBy + counting
```

---

# Level 2: Average, Sum, Statistics

### Q4. Department-wise Average Salary

Output:

```java
{
 IT=85000,
 HR=65000
}
```

Best Solution:

```java
groupingBy + averagingDouble
```

---

### Q5. Department-wise Total Salary

Output:

```java
{
 IT=425000,
 HR=195000
}
```

Best Solution:

```java
groupingBy + summingDouble
```

---

### Q6. Department-wise Salary Statistics

Output:

```java
{
 IT=DoubleSummaryStatistics
}
```

Best Solution:

```java
groupingBy + summarizingDouble
```

Interviewers love this one.

---

# Level 3: Max/Min

### Q7. Highest Salary Employee

Output:

```java
Optional<Employee>
```

Best Solution:

```java
max(Comparator.comparingDouble(Employee::salary))
```

---

### Q8. Lowest Salary Employee

Best Solution:

```java
min(...)
```

---

### Q9. Department-wise Highest Salary Employee

Output:

```java
{
 IT=Employee(...),
 HR=Employee(...)
}
```

Best Solution:

```java
groupingBy + maxBy
```

---

### Q10. Department-wise Lowest Salary Employee

Best Solution:

```java
groupingBy + minBy
```

---

# Level 4: Mapping

### Q11. Department-wise Employee Names

Output:

```java
{
 IT=[John, Mike],
 HR=[Smith]
}
```

Best Solution:

```java
groupingBy +
mapping(Employee::name, toList())
```

---

### Q12. Department-wise Distinct Employee Names

Best Solution:

```java
groupingBy +
mapping(Employee::name, toSet())
```

---

### Q13. Department-wise Employee Count and Names

Output:

```java
IT -> count=5
      names=[A,B,C,D,E]
```

Concept:

```java
teeing()
```

(Java 12+)

or

```java
collectingAndThen()
```

(Java 8)

---

# Level 5: Partitioning

### Q14. Employees with Salary > 50000

Output:

```java
{
 true=[...],
 false=[...]
}
```

Best Solution:

```java
partitioningBy(emp -> emp.getSalary() > 50000)
```

---

### Q15. Count Employees with Salary > 50000

Output:

```java
{
 true=6,
 false=4
}
```

Best Solution:

```java
partitioningBy(..., counting())
```

---

# Level 6: Sorting

### Q16. Sort Employees by Salary Asc

Best Solution:

```java
sorted(
    Comparator.comparingDouble(Employee::getSalary)
)
```

---

### Q17. Sort Employees by Salary Desc

Best Solution:

```java
Comparator.comparingDouble(
    Employee::getSalary
).reversed()
```

---

### Q18. Sort by Department then Salary Desc

Best Solution:

```java
departmentAscSort
.thenComparing(salaryDescSort)
```

Use the comparator style you already prefer.

---

# Level 7: Top-N Problems

### Q19. Highest Paid 3 Employees

Best Solution:

```java
sorted(salaryDescSort)
.limit(3)
```

---

### Q20. Second Highest Salary Employee

Approach:

```java
sorted(salaryDescSort)
.skip(1)
.findFirst()
```

Follow-up:
Handle duplicate salaries.

---

### Q21. Nth Highest Salary

Approach:

```java
sorted(...)
.skip(n-1)
.findFirst()
```

---

# Level 8: Advanced Grouping

### Q22. Department-wise Highest Salary Value

Output:

```java
{
 IT=90000,
 HR=75000
}
```

Best Solution:

```java
groupingBy +
mapping +
maxBy
```

or

```java
collectingAndThen(
    maxBy(...),
    ...
)
```

---

### Q23. Department-wise Highest Salary Employee Name

Output:

```java
{
 IT=John,
 HR=Smith
}
```

Concept:

```java
maxBy +
collectingAndThen
```

---

### Q24. Department-wise Employees Sorted by Salary

Output:

```java
{
 IT=[emp1, emp2, emp3]
}
```

Concept:

```java
groupingBy +
collectingAndThen
```

---

# Level 9: String-Based Questions

### Q25. Find Duplicate Characters

Example:

```java
"programming"
```

Output:

```java
[r, g, m]
```

Concept:

```java
groupingBy + counting
```

---

### Q26. First Non-Repeated Character

Output:

```java
'p'
```

Concept:

```java
LinkedHashMap +
groupingBy +
counting
```

---

### Q27. Longest Common Prefix

You already practiced this.

---

### Q28. Group Words by Length

Output:

```java
{
 3=[cat,dog],
 5=[apple]
}
```

---

# Level 10: Array-Based Questions

### Q29. Find Duplicates

```java
int[] nums={1,2,3,1}
```

Output:

```java
[1]
```

---

### Q30. Frequency of Elements

Output:

```java
{
1=2,
2=1,
3=1
}
```

---

### Q31. Second Highest Number

You already practiced this extensively.

---

### Q32. Missing Number

```java
1,2,4,5
```

Output:

```java
3
```

---

# Level 11: Collectors Mastery

These are very important for senior interviews.

### Q33. `mapping()`

### Q34. `filtering()`

### Q35. `flatMapping()`

### Q36. `collectingAndThen()`

### Q37. `reducing()`

### Q38. `toMap()`

### Q39. `partitioningBy()`

### Q40. `summarizingDouble()`

---

### Recommended Learning Order

Do them in this sequence:

```
Q1  -> Q3
Q4  -> Q6
Q7  -> Q10
Q11 -> Q15
Q16 -> Q18
Q19 -> Q24
Q25 -> Q32
Q33 -> Q40
```

This order builds naturally from basic `groupingBy()` to advanced collector combinations and covers about 80–90% of Java 8 Stream interview questions asked for experienced backend developers.

         */

    }
}
