package com.mane.umakant.java8.studentScore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentScore {
    private int studentId;
    private String studentName;
    private int studentAge;
    private Score studentScore;

    public StudentScore(int studentId, String studentName, int studentAge, Score studentScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentScore = studentScore;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public Score getStudentScore() {
        return studentScore;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", studentScore=" + studentScore +
                '}';
    }

    public static void main(String args[]) {
        List<StudentScore> studentScoreList = new ArrayList<>();
        studentScoreList.add(new StudentScore(7, "Shinde", 35, new Score("C", 75)));
        studentScoreList.add(new StudentScore(1, "Umesh", 35, new Score("Java", 80)));
        studentScoreList.add(new StudentScore(3, "Ramesh", 28, new Score("C++", 90)));
        studentScoreList.add(new StudentScore(2, "Sane", 20, new Score("C", 60)));
        studentScoreList.add(new StudentScore(6, "Umakant", 35, new Score("Java", 80)));
        studentScoreList.add(new StudentScore(5, "Ramesh", 29, new Score("C++", 90)));
        studentScoreList.add(new StudentScore(4, "Tanuja", 35, new Score("SQL", 76)));
        studentScoreList.add(new StudentScore(8, "Shinde", 35, new Score("Java", 85)));

        // ✅ Corrected version (minimal change, same structure)  Belows for ASC order
        //  1 ASC byStudentAgeAsc
        Comparator<StudentScore> byStudentAgeAsc = Comparator.comparingInt(StudentScore::getStudentAge);
        //  2 ASC byStudentNameAsc
        Comparator<StudentScore> byStudentNameAsc =
                Comparator.comparing(
                        StudentScore::getStudentName,
                        Comparator.nullsLast(
                                String.CASE_INSENSITIVE_ORDER
                        )
                );
        //  3 ASC bySubjectMarksAsc
       /* Comparator<StudentScore> bySubjectMarksAsc =
                Comparator.comparingDouble(
                        s -> s.getStudentScore().getSubMarks()
                );*/
        Comparator<StudentScore> bySubjectMarksAsc =
                Comparator.comparing(
                        StudentScore::getStudentScore,
                        Comparator.nullsLast(
                                Comparator.comparingDouble(Score::getSubMarks)
                        )
                );
        //  4 ASC bySubjectNameAsc
/*        Comparator<StudentScore> bySubjectNameAsc =
                Comparator.comparing(
                        s -> s.getStudentScore().getSubName(),
                        String.CASE_INSENSITIVE_ORDER
                );*/
        Comparator<StudentScore> bySubjectNameAsc =
                Comparator.comparing(
                       StudentScore::getStudentScore,
                        Comparator.nullsLast(
                                Comparator.comparing(
                                        Score::getSubName,
                                        String.CASE_INSENSITIVE_ORDER
                                )
                        )
                );
        //  5 ASC byStudentIdAsc
        Comparator<StudentScore> byStudentIdAsc =
                Comparator.comparingInt(StudentScore::getStudentId);

        // ✅ Corrected version (minimal change, same structure)  Belows for DESC order
        //  1 DESC byStudentAgeDesc
        Comparator<StudentScore> byStudentAgeDesc = Comparator.comparingInt(StudentScore::getStudentAge).reversed();
        //  2 DESC byStudentNameDesc
        /*
        What actually happens
        Original: nullsLast + ASC
        After .reversed() → nullsFirst + DESC
        So behavior becomes:
        Names in descending order (correct)
        null values move to the front
        Is that OK?
        ✅ Yes, if you WANT nulls first in DESC order
        But in many production systems, we still want:
        “Descending order, but nulls always last”
         */
       /* Comparator<StudentScore> byStudentNameDesc = Comparator.comparing(
                StudentScore::getStudentName,
                Comparator.nullsLast(
                        String.CASE_INSENSITIVE_ORDER
                )
        ).reversed();*/
        // ⭐ BEST PRACTICE (recommended for production)
        // If you want DESC + nullsLast, do this instead:
        Comparator<StudentScore> byStudentNameDesc = Comparator.comparing(
                StudentScore::getStudentName,
                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER.reversed())
        );
        //  3 DESC bySubjectMarksDesc
        /*
        Below code are not working due to IDE limitation not code Issue as per ChatGpt
         Comparator<StudentScore> bySubjectMarksDesc=
                Comparator.comparingDouble(
                        s->s.getStudentScore().getSubMarks()
                ).reversed();

              // Below code are working but I have not follwing this type of code.

              Comparator<StudentScore> bySubjectMarksDesc=
                Comparator.comparing(
                        s->s.getStudentScore().getSubMarks(),
                        Comparator.reverseOrder()
                );

         */
       // Comparator<StudentScore> bySubjectMarksDesc = bySubjectMarksAsc.reversed();

        Comparator<StudentScore> bySubjectMarksDesc=Comparator.comparing(
                StudentScore::getStudentScore,
                Comparator.nullsLast(
                        Comparator.comparingDouble(
                                Score::getSubMarks
                        ).reversed()
                )
        );


        //  4 DESC bySubjectNameDesc
        /*
        Below code are not working due to IDE limitation not code Issue as per ChatGpt
        Comparator<StudentScore> bySubjectNameDesc = Comparator.comparing(
                s->s.getStudentScore().getSubName(),
                String.CASE_INSENSITIVE_ORDER
        ).reversed();
        // Below code are working but I have not follwing this type of code.
        Comparator<StudentScore> bySubjectNameDesc =
                Comparator.<StudentScore, String>comparing(
                        s -> s.getStudentScore().getSubName(),
                        String.CASE_INSENSITIVE_ORDER
                ).reversed();
         */
       // Comparator<StudentScore> bySubjectNameDesc = bySubjectNameAsc.reversed();
        Comparator<StudentScore> bySubjectNameDesc = Comparator.comparing(
                StudentScore::getStudentScore,
                Comparator.nullsLast(
                        Comparator.comparing(
                                Score::getSubName,
                                String.CASE_INSENSITIVE_ORDER
                        ).reversed()
                )
        );


        //  5 DESC byStudentIdDesc
        Comparator<StudentScore> byStudentIdDesc = Comparator.comparingInt(StudentScore::getStudentId).reversed();

        // Q1  Ascending sort on:   studentAge-> studentName-> subMarks-> subName-> studentId
        // 👉 Priority order matters (first age, if equal then name, and so on).
        List<StudentScore> studentAgeStudentNameSubMarksSubNameStudentIdAsc1 = studentScoreList.stream()
                .sorted(
                        // 1. studentAge (primitive int → null-safe). int age primitive have default value as zero.
                        Comparator.comparingInt(StudentScore::getStudentAge)
                                // 2. studentName (String → null-safe + case-insensitive)
                                .thenComparing(
                                        StudentScore::getStudentName,
                                        Comparator.nullsLast(
                                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                                        )
                                )
                                // 3. subMarks (primitive double, but Score may be null)
                                // Here, private double subMarks this primitive value come from "StudentScore()" method. So, Here We need to check this data collection is null or not?                                .thenComparingDouble(
                                /*.thenComparing(s->s.getStudentScore() == null
                                                ? Double.MIN_VALUE:s.getStudentScore().getSubMarks()
                                )*/
                                .thenComparing(
                                        StudentScore::getStudentScore,
                                        Comparator.nullsLast(
                                                Comparator.comparingDouble(
                                                        Score::getSubMarks
                                                )
                                        )
                                )
                                // 4. subName (nested String → null-safe + case-insensitive)
                                /*   .thenComparing(
                                           s-> s.getStudentScore()==null
                                           ? null
                                                   : s.getStudentScore().getSubName(),
                                           Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                                   )*/
                                .thenComparing(
                                        StudentScore::getStudentScore,
                                        Comparator.nullsLast(
                                                Comparator.comparing(
                                                        Score::getSubName,
                                                        String.CASE_INSENSITIVE_ORDER
                                                )
                                        )
                                )
                                // 5. studentId (primitive int → final deterministic tie-breaker)
                                .thenComparingInt(StudentScore::getStudentId)

                )
                .collect(Collectors.toList());
        System.out.println("studentAgeStudentNameSubMarksSubNameStudentIdAsc1:: " + studentAgeStudentNameSubMarksSubNameStudentIdAsc1);
        List<StudentScore> studentAgeStudentNameSubMarksSubNameStudentIdAsc2 = studentScoreList.stream()
                .sorted(
                        byStudentAgeAsc
                                .thenComparing(byStudentNameAsc)
                                .thenComparing(bySubjectMarksAsc)
                                .thenComparing(bySubjectNameAsc)
                                .thenComparing(byStudentAgeAsc)
                )
                .collect(Collectors.toList());

        System.out.println("studentAgeStudentNameSubMarksSubNameStudentIdAsc2:: " + studentAgeStudentNameSubMarksSubNameStudentIdAsc2);
        System.out.println("*****************");
        // Q2  Descending sort on:   studentAge-> studentName-> subMarks-> subName-> studentId
        /*
        Note VIMP:
        ✅ Correct mental model (important)
            -   Never call .reversed() at the end of a comparator chain unless you want to reverse EVERYTHING.
            For field-level DESC:
                -   Reverse inside the individual comparator
                -   NOT after thenComparing
         */
       List<StudentScore> studentAgeStudentNameSubMarksSubNameStudentIdDesc1= studentScoreList.stream()
                .sorted(
                        // 1. studentAge DESC (primitive, safe)
                        Comparator.comparingInt(StudentScore::getStudentAge)
                                .reversed()
                                // 2. studentName DESC, case-insensitive, nulls last
                                .thenComparing(
                                        StudentScore::getStudentName,
                                        Comparator.nullsLast(
                                                String.CASE_INSENSITIVE_ORDER.reversed()
                                        )
                                )
                                // 3. subMarks DESC, nulls last
                                .thenComparing(
                                        StudentScore::getStudentScore,
                                        Comparator.nullsLast(
                                                Comparator.comparingDouble(
                                                        Score::getSubMarks
                                                ).reversed()
                                        )
                                )
                                // 4. subName DESC, case-insensitive, nulls last
                                .thenComparing(
                                        StudentScore::getStudentScore,
                                        Comparator.nullsLast(
                                                Comparator.comparing(
                                                        Score::getSubName,
                                                        String.CASE_INSENSITIVE_ORDER.reversed()
                                                )
                                        )
                                )
                                // 5. studentId DESC (primitive, safe)
                                .thenComparing(
                                        Comparator.comparingInt(
                                                StudentScore::getStudentId
                                        ).reversed()
                                )
                )
                .collect(Collectors.toList());

        System.out.println("studentAgeStudentNameSubMarksSubNameStudentIdDesc1:: "+studentAgeStudentNameSubMarksSubNameStudentIdDesc1);
        //   Descending sort on:   studentAge-> studentName-> subMarks-> subName-> studentId
        java.util.List <StudentScore> studentAgeStudentNameSubMarksSubNameStudentIdDesc2=studentScoreList.stream()
                .sorted(
                        byStudentAgeDesc
                                .thenComparing(byStudentNameDesc)
                                .thenComparing(bySubjectMarksDesc)
                                .thenComparing(bySubjectNameDesc)
                                .thenComparing(byStudentIdDesc)
                )
                .collect(Collectors.toList());
        System.out.println("studentAgeStudentNameSubMarksSubNameStudentIdDesc2:: "+studentAgeStudentNameSubMarksSubNameStudentIdDesc2);

        // Q3: find fifth largest record based on student age,student name, sub marks, sub name,student id
        /*
        2️⃣ BEST PRACTICE APPROACH (Production + Interview)
        Step 1: Define a single, reusable, correct comparator
        This avoids:
        duplication
        bugs
        inconsistency
        Step 2: Sort once
        Step 3: Skip first 4 records
        Step 4: Get the 5th record safely
         */
        java.util.Optional<StudentScore> fifthLargest  =studentAgeStudentNameSubMarksSubNameStudentIdDesc2.stream()
                .skip(4)
                .findFirst();
        System.out.println("fifthLargest:: "+fifthLargest);

      //  Q4: grouping by subjct name and desending sort by student name then desending sort by student Id;
        // 2️⃣ Best-practice comparator for sorting inside each group
        Comparator<StudentScore> STUDENT_NAME_ID_DESC =
                Comparator
                        // studentName DESC (case-insensitive, nulls last)
                        .comparing(
                                StudentScore::getStudentName,
                                Comparator.nullsLast(
                                        String.CASE_INSENSITIVE_ORDER.reversed()
                                )
                        )
                        // studentId DESC (primitive, safe)
                        .thenComparing(
                                Comparator.comparingInt(
                                        StudentScore::getStudentId
                                ).reversed()
                        );
        // 3️⃣ Best-practice grouping logic
        // ✅ Stream solution (clean & readable)
        Map<String, List<StudentScore>> result =
                studentScoreList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        s -> s.getStudentScore() == null
                                                ? null
                                                : s.getStudentScore().getSubName(),
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                list -> {
                                                    list.sort(STUDENT_NAME_ID_DESC);
                                                    return list;
                                                }
                                        )
                                )
                        );

        // 6️⃣ Optional: Preserve subject order (advanced)
        //
        //If you want subjects sorted DESC as well, use:

        Map<String, List<StudentScore>> result1 =
                studentScoreList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        s -> s.getStudentScore() == null
                                                ? null
                                                : s.getStudentScore().getSubName(),
                                        () -> new TreeMap<>(
                                                Comparator.nullsLast(
                                                        String.CASE_INSENSITIVE_ORDER.reversed()
                                                )
                                        ),
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                list -> {
                                                    list.sort(STUDENT_NAME_ID_DESC);
                                                    return list;
                                                }
                                        )
                                )
                        );


        //  which is best code for getStudentAge DESC?
        // ✅ BEST CODE (Production / Senior Level). This is the best and most commonly accepted solution in real production code.
        /*
        Why this one is BEST
        ✔ Uses primitive comparator (comparingInt)
        ✔ No boxing (int → Integer)
        ✔ No null handling needed (primitive int)
        ✔ Very readable
        ✔ Self-contained (does not depend on another comparator)
        ✔ Clear intent: “sort by age descending”
        This is exactly what a senior Java backend developer is expected to write.
         */
        Comparator<StudentScore> byStudentAgeDesc1 = Comparator.comparingInt(StudentScore::getStudentAge).reversed();

        // 4️⃣ byStudentAgeDesc3 ⚠️ (GOOD, but SECOND BEST)
        /*
        ✔ Clean
        ✔ Reuses comparator
        ⚠ Depends on byStudentAgeASC
        ⚠ Slightly less explicit
        Use this only if byStudentAgeASC is already part of a shared comparator set.
         */
        Comparator<StudentScore> byStudentAgeASC = Comparator.comparingInt(StudentScore::getStudentAge);
        Comparator<StudentScore> byStudentAgeDesc3 = byStudentAgeASC.reversed();

        // 3️⃣ byStudentAgeDesc2 ❌ (DO NOT USE)
        /*
        ❌ Autoboxing (int → Integer)
        ❌ Slower
        ❌ Verbose
        ❌ Poor signal at senior level
        A reviewer will ask:
        “Why are you boxing a primitive just to reverse order?”
         */
        Comparator<StudentScore> byStudentAgeDesc2 =
                Comparator.comparing(
                        StudentScore::getStudentAge,
                        Comparator.reverseOrder()
                );



        //  which is best code for getStudentScore().getSubName() DESC?
        // ✅ 3️⃣ bySubjectNameDesc3 ⭐ BEST (WINNER)
        /*
        Why this is excellent
        ✅ Handles studentScore == null
        ✅ Handles subName == null
        ✅ Case-insensitive
        ✅ No conditional lambdas
        ✅ Clear separation of responsibility
        ✅ Reusable Score comparator
        ✅ Reads like English
        Senior verdict
        🏆 THIS IS THE BEST PRODUCTION-READY CODE
        This is exactly what a senior / lead developer should write.
         */
        Comparator<StudentScore> bySubjectNameDesc3 =
        Comparator.comparing(
                StudentScore::getStudentScore,
                Comparator.nullsLast(
                        Comparator.comparing(
                                Score::getSubName,
                                String.CASE_INSENSITIVE_ORDER
                        )
                )
        );

        //  which is best code for getStudentScore().getSubMarks() DESC?

        // ✅ subjectMarksAsc3 ⭐ (BEST ASC)
        /*
        Why this is excellent
        ✔ Handles studentScore == null
        ✔ Uses primitive comparator (comparingDouble)
        ✔ No boxing
        ✔ Clean separation of concerns
        ✔ Reusable
        ✔ Standard senior pattern
        ✅ Production-ready
         */
        Comparator<StudentScore>  subjectMarksAsc3  =
                Comparator.comparing(
                        StudentScore::getStudentScore,
                        Comparator.nullsLast(
                                Comparator.comparingDouble(Score::getSubMarks)
                        )
                );
       // ✅ subjectMarksDesc3 ⭐⭐ (BEST DESC – WINNER)
        /*
        Why this is the BEST
        ✔ Null-safe
        ✔ Primitive comparator
        ✔ Clean and readable
        ✔ No duplication
        ✔ Easy to maintain
        ✔ Very common in real codebases
        🏆 THIS IS THE BEST PRODUCTION CODE
         */
        Comparator<StudentScore> subjectMarksDesc3=subjectMarksAsc3.reversed();

        /*
        ✅ Is this code CORRECT?
        Yes — functionally it works.
        ✔ studentScore == null → handled
        ✔ subMarks is primitive → safe
        ✔ DESC order applied
        ✔ No NPE risk
        So logically correct.
        ⚠️ BUT — Is this the BEST production-standard code?
        No.
        It’s correct, but not the cleanest or most standard way seniors write this.
        And here’s why.
         */
        Comparator<StudentScore> subjectMarksDesc5 = Comparator.comparing(
                StudentScore::getStudentScore,
                Comparator.nullsLast(
                        Comparator.comparingDouble(Score::getSubMarks)
                ).reversed()
        );



    }
}
/*
IPM: Handle null in "Comparator.nullsLast" inside below.
.thenComparing(
    StudentScore::getStudentScore,
    Comparator.nullsLast(
        Comparator.comparingDouble(
            Score::getSubMarks
        )
    )
)
---------------
Great doubt 👍 — and you’re right to be careful here.
Let’s answer this **very precisely**, like a senior reviewing production code.

---

## The code in question

```java
.thenComparing(
    StudentScore::getStudentScore,
    Comparator.nullsLast(
        Comparator.comparingDouble(
            Score::getSubMarks
        )
    )
)
```

---

## Step-by-step: **how null is handled**

### Step 1: Key extractor is called
```java
StudentScore::getStudentScore
```

This can return:

* ✅ a `Score` object
* ❌ `null`

So we must check **what happens if it returns `null`**.

---

### Step 2: Who handles the `null`?

```java
Comparator.nullsLast(...)
```

This is the **critical line**.

`nullsLast` creates a wrapper comparator that works like this (conceptually):

```java
if (left == null && right == null) return 0;
if (left == null) return 1;   // null goes last
if (right == null) return -1;
return realComparator.compare(left, right);
```

✅ **So if `getStudentScore()` returns null → no NPE occurs**
✅ Null values are placed **at the end**

---

### Step 3: When is `Score::getSubMarks` called?

This method is called **only if both Score objects are non-null**.

That means:

```java
Comparator.comparingDouble(Score::getSubMarks)
```

👉 is **never invoked with a null Score**

So:

* ❌ No `NullPointerException`
* ❌ No need for manual null check
* ✅ Safe and clean

---

## Summary of behavior

| Scenario                                       | Result                 |
| ---------------------------------------------- | ---------------------- |
| Both `StudentScore.getStudentScore()` are null | Equal                  |
| One null, one non-null                         | Null goes last         |
| Both non-null                                  | Compared by `subMarks` |
| `subMarks` is primitive `double`               | Cannot be null         |

---

## Why your second version is easier to “see”

Your manual version:

```java
thenComparing(
    s -> s.getStudentScore() == null
         ? null
         : s.getStudentScore().getSubName(),
    Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
)
```

This makes null handling **explicit**, so it’s visually obvious.

But functionally:

👉 **Both approaches are equivalent in behavior**

---

## Which is better for production?

### ⭐ Best practice (senior-level)

✅ **Prefer the first version** when:

* You’re comparing objects
* Null handling is about the object itself
* You want composable, reusable comparators

```java
.thenComparing(
    StudentScore::getStudentScore,
    Comparator.nullsLast(
        Comparator.comparingDouble(Score::getSubMarks)
    )
)
```

Reasons:

* No lambdas with logic
* No duplication
* Clear intent
* Easy to extend (add `.thenComparing(...)`)

---

### When manual null logic makes sense

Your explicit ternary version is useful when:

* You need **custom fallback values**
* You need **conditional mapping**
* You want **different null behavior per field**

Example:

```java
s -> s.getStudentScore() == null ? "NA" : s.getStudentScore().getSubName()
```

---

## Important pitfall to remember ⚠️

This would be **WRONG** and throw NPE:

```java
.thenComparing(
    s -> s.getStudentScore().getSubMarks(),   // 💥 NPE if studentScore is null
    Comparator.nullsLast(Comparator.reverseOrder())
)
```

Because:

* Lambda is executed **before** comparator
* No null wrapper protecting it

---

## Final verdict (clear and safe)

| Code                 | Null-safe? | Production-ready?  |
| -------------------- | ---------- | ------------------ |
| Your first code      | ✅ Yes      | ✅ Yes              |
| Manual ternary       | ✅ Yes      | ⚠️ Use when needed |
| Direct lambda access | ❌ No       | ❌ No               |

---

### Senior one-liner you can confidently say

> “`Comparator.nullsLast` protects the *key object*, so nested comparators are invoked only when the key is non-null.”

You’re thinking exactly like a **senior Java backend developer** now.
If you want next, we can:

* Inspect JDK source of `nullsLast`
* Discuss null handling strategy standards
* Compare readability vs performance trade-offs
-----------------------------------------
Just say the word 👍

For first you wrote like
// 1. studentAge DESC (primitive, safe)
                        Comparator.comparingInt(StudentScore::getStudentAge)
                                .reversed()

and for 5 th you wrote like
 5. studentId DESC (primitive, safe)
                                .thenComparing(
                                        Comparator.comparingInt(
                                                StudentScore::getStudentId
                                        ).reversed()

Its confusing to me. Why both way are not same like 5 th?

Excellent question 👍
This confusion is **100% valid**, and clearing it will lock your comparator understanding permanently.

Let’s go **slow, precise, and logical**.

---

## Short answer (clear first)

Both are **logically equivalent**, but they are used **in different positions**:

* **First comparator** → starts the chain → no `thenComparing` needed
* **Later comparators** → must be added via `thenComparing(...)`

That’s the *only* difference.

---

## Now let’s break it down properly 🧠

### 1️⃣ First field in the chain (studentAge DESC)

```java
Comparator.comparingInt(StudentScore::getStudentAge).reversed()
```

This creates a **Comparator<StudentScore>**.

Since it’s the **starting comparator**, you just write it directly.

Equivalent expanded form:

```java
Comparator<StudentScore> c =
        Comparator.comparingInt(StudentScore::getStudentAge).reversed();
```

Nothing to attach to yet — this is the base.

---

### 2️⃣ Fifth field in the chain (studentId DESC)

At this point, you already have a comparator chain:

```java
Comparator<StudentScore> base = ...;
```

To add another comparison, Java gives you only **two legal options**:

#### Option A (WRONG in this context ❌)

```java
.thenComparingInt(StudentScore::getStudentId).reversed()
```

❌ This reverses **the entire chain**, not just studentId.

---

#### Option B (CORRECT ✅)

```java
.thenComparing(
    Comparator.comparingInt(StudentScore::getStudentId).reversed()
)
```

✔ This reverses **only studentId**
✔ Keeps previous comparisons untouched

---

## Why you CANNOT write studentId like studentAge

You asked:

> “Why both way are not same like 5th?”

Because **method availability differs**:

### Starting comparator

```java
Comparator.comparingInt(...)
```

→ returns a **Comparator**

### Inside a chain

```java
.thenComparingInt(...)
```

→ appends comparison **and returns the combined comparator**

Calling `.reversed()` **after** that reverses everything before it.

---

## Visual mental model (VERY important)

### What you WANT

```
age DESC
 → name DESC
 → marks DESC
 → subject DESC
 → id DESC
```

### What happens if you do this ❌

```java
.thenComparingInt(...).reversed()
```

```
(age → name → marks → subject → id) ALL reversed
```

---

## Why studentAge does not have this issue

Because there is **nothing before it**.

```java
Comparator.comparingInt(...).reversed()
```

Reversing only affects that comparator.

---

## Are both “ways” logically the same?

### YES — if written in isolation

These two are equivalent **only when standalone**:

```java
Comparator.comparingInt(StudentScore::getStudentAge).reversed();
Comparator.comparingInt(StudentScore::getStudentAge).reversed();
```

But **inside a chain**, context matters.

---

## Rule to remember (senior-level)

> 🔑 **Reverse the smallest possible comparator.**
> 🔑 Never call `.reversed()` on a partially built comparator chain.

If a field is:

* **First** → you may reverse directly
* **Later** → wrap it in `thenComparing(Comparator.reversed())`

---

## Final clarity statement

| Field position | Correct pattern                                          |
| -------------- | -------------------------------------------------------- |
| First          | `Comparator.comparingInt(...).reversed()`                |
| Later          | `thenComparing(Comparator.comparingInt(...).reversed())` |

---

This confusion disappears once you see **where `.reversed()` is applied**.

You’re now asking **senior-review-level questions** — exactly the right direction.
If you want, I can next:

* Draw a **step-by-step comparator execution trace**
* Or refactor everything into **named comparator constants** for readability

Just say 👍

 */
