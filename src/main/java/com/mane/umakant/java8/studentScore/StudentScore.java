package com.mane.umakant.java8.studentScore;

import java.util.*;
import java.util.stream.Collectors;

public class StudentScore {
    int studentId;
    String studentName;
    int studentAge;
    Score studentScore;

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

        //  print studentScoreList
        //  System.out.println("original list:: "+studentScoreList);
        // Q1: Asc sort on student age,student name, sub marks, sub name,student id
        List<StudentScore> asc_sort_on_studentAge_studentName_subMarks_subName_studentId =
                studentScoreList.stream()
                        .sorted(Comparator.comparing(StudentScore::getStudentAge)
                                .thenComparing(StudentScore::getStudentName)
                                //    .thenComparing((e1,e2)->(int)(e1.studentScore.getSubMarks()-e2.studentScore.subMarks))
                                .thenComparing((e1, e2) -> Double.compare(e1.studentScore.subMarks, e2.studentScore.subMarks))
                                .thenComparing((e1, e2) -> e1.studentScore.getSubName().compareTo(e2.studentScore.getSubName()))
                                .thenComparing(StudentScore::getStudentId))
                        .collect(Collectors.toList());
        System.out.println("asc_sort_on_studentAge_studentName_subMarks_subName_studentId:: " + asc_sort_on_studentAge_studentName_subMarks_subName_studentId);
        // or
        Comparator<StudentScore> ascSortStudentAge = (e1, e2) -> e1.studentAge - e2.studentAge;
        Comparator<StudentScore> ascSortStudentName = (e1, e2) -> e1.studentName.compareTo(e2.getStudentName());
        Comparator<StudentScore> ascSortStudentSubMarks = (e1, e2) -> Double.compare(e1.studentScore.getSubMarks(), e2.studentScore.getSubMarks());
        Comparator<StudentScore> ascSortStudentSubName = (e1, e2) -> e1.studentScore.getSubName().compareTo(e2.studentScore.getSubName());
        Comparator<StudentScore> acSortStudentId = (e1, e2) -> e1.getStudentId() - e2.getStudentId();
        List<StudentScore> asc_sort_on_studentAge_studentName_subMarks_subName_studentId1 = studentScoreList.stream()
                .sorted(ascSortStudentAge
                        .thenComparing(ascSortStudentName)
                        .thenComparing(ascSortStudentSubMarks)
                        .thenComparing(ascSortStudentSubName)
                        .thenComparing(acSortStudentId))
                .collect(Collectors.toList());
        System.out.println("asc_sort_on_studentAge_studentName_subMarks_subName_studentId1:: " + asc_sort_on_studentAge_studentName_subMarks_subName_studentId1);

        // Q2: find fifth smallest record based on student age,student name, sub marks, sub name,student id
        // ageSortAsc nameSortAsc subMarksSortAsc subNameSortAsc studentIdSortAsc
        Optional<StudentScore> fifth_smallest_record_based_on_studentAge_studentName_subMarks_subName_studentId = studentScoreList.stream()
                .sorted(Comparator.comparing(StudentScore::getStudentAge)
                        .thenComparing(StudentScore::getStudentName)
                        .thenComparing((e1, e2) -> Double.compare(e1.studentScore.getSubMarks(), e2.studentScore.getSubMarks()))
                        .thenComparing((e1, e2) -> e1.studentScore.getSubName().compareTo(e2.studentScore.getSubName()))
                        .thenComparing((e1, e2) -> e1.studentId - e2.studentId))
                .skip(4)
                .findFirst();
        System.out.println("fifth_smallest_record_based_on_studentAge_studentName_subMarks_subName_studentId:: " + fifth_smallest_record_based_on_studentAge_studentName_subMarks_subName_studentId);
        // or
        Optional<StudentScore> fifth_smallest_record_based_on_studentAge_studentName_subMarks_subName_studentId1 = studentScoreList.stream()
                .sorted(ascSortStudentAge
                        .thenComparing(ascSortStudentName)
                        .thenComparing(ascSortStudentSubMarks)
                        .thenComparing(ascSortStudentSubName)
                        .thenComparing(acSortStudentId))
                .skip(4)
                .findFirst();
        System.out.println("fifth_smallest_record_based_on_studentAge_studentName_subMarks_subName_studentId1:: " + fifth_smallest_record_based_on_studentAge_studentName_subMarks_subName_studentId1);

        // Q3: Desc sort on student age,student name, sub marks, sub name,student id

        Comparator<StudentScore> descSortStudentAge = (e1, e2) -> e2.getStudentAge() - e1.getStudentAge();
        Comparator<StudentScore> descSortStudentName = (e1, e2) -> e2.getStudentName().compareTo(e1.getStudentName());
        //Comparator<StudentScore> descSortStudentSubMarks=(e1,e2)->Double.compare(e2.studentScore.subMarks,e1.studentScore.subMarks);
        Comparator<StudentScore> descSortStudentSubMarks = (e1, e2) -> Double.compare(e2.getStudentScore().getSubMarks(), e1.getStudentScore().getSubMarks());
        Comparator<StudentScore> descSortStudentSubName = (e1, e2) -> e2.studentScore.subName.compareTo(e1.studentScore.subName);
        Comparator<StudentScore> descSortStudentId = (e1, e2) -> e2.studentId - e1.studentId;

        List<StudentScore> desc_sort_on_studentAge_studentName_subMarks_subName_studentId = studentScoreList.stream()
                .sorted(descSortStudentAge
                        .thenComparing(descSortStudentName)
                        .thenComparing(descSortStudentSubMarks)
                        .thenComparing(descSortStudentSubName)
                        .thenComparing(descSortStudentId))
                .collect(Collectors.toList());
        System.out.println("desc_sort_on_studentAge_studentName_subMarks_subName_studentId:: " + desc_sort_on_studentAge_studentName_subMarks_subName_studentId);
        //or
        List<StudentScore> desc_sort_on_studentAge_studentName_subMarks_subName_studentId1 = studentScoreList.stream()
                .sorted(Comparator.comparing(StudentScore::getStudentAge)
                        .thenComparing(StudentScore::getStudentName)
                        .thenComparing((e1, e2) -> Double.compare(e1.studentScore.subMarks, e2.studentScore.subMarks))
                        //.thenComparing((e1,e2)->Double.compare(e1.getStudentScore().getSubMarks(),e2.getStudentScore().getSubMarks()))
                        .thenComparing(StudentScore::getStudentId)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("desc_sort_on_studentAge_studentName_subMarks_subName_studentId1:: " + desc_sort_on_studentAge_studentName_subMarks_subName_studentId1);

        // Q4: find fifth largest record based on student age,student name, sub marks, sub name,student id

        Optional<StudentScore> fifth_largest_record_based_on_studentAge_studentName_subMarks_subName_studentId = studentScoreList.stream()
                .sorted(Comparator.comparing(StudentScore::getStudentAge)
                        .thenComparing(StudentScore::getStudentName)
                        .thenComparing((e1, e2) -> Double.compare(e1.studentScore.subMarks, e2.studentScore.subMarks))
                        .thenComparing((e1, e2) -> e1.studentScore.subName.compareTo(e2.studentScore.subName))
                        .thenComparing(StudentScore::getStudentId)
                        .reversed())
                .skip(4)
                .findFirst();
        System.out.println("fifth_largest_record_based_on_studentAge_studentName_subMarks_subName_studentId:: " + fifth_largest_record_based_on_studentAge_studentName_subMarks_subName_studentId);
        // or
        Optional<StudentScore> fifth_largest_record_based_on_studentAge_studentName_subMarks_subName_studentId1 = studentScoreList.stream()
                .sorted(descSortStudentAge
                        .thenComparing(descSortStudentName)
                        .thenComparing(descSortStudentSubMarks)
                        .thenComparing(descSortStudentSubName)
                        .thenComparing(descSortStudentId))
                .skip(4)
                .findFirst();
        System.out.println("fifth_largest_record_based_on_studentAge_studentName_subMarks_subName_studentId1:: " + fifth_largest_record_based_on_studentAge_studentName_subMarks_subName_studentId1);


        // Q5: grouping by subjct name and sort by student name
        // output contains in the form group of "subject name" inside it having student name is ascending order.
        // e.g. Java=[StudentScore [studentId=8, studentName=Shinde, age=35, score=Score [subName=Java, marks=85.0]],
        // StudentScore [studentId=6, studentName=Umakant, age=35, score=Score [subName=Java, marks=80.0]],
        // StudentScore [studentId=1, studentName=Umesh, age=35, score=Score [subName=Java, marks=80.0]]]

        Map<String, List<StudentScore>> groupingBySubjectName = studentScoreList.stream()
                .collect(Collectors.groupingBy(s -> s.studentScore.subName, Collectors.toList()));
        System.out.println("groupingBySubjectName:: " + groupingBySubjectName);

        Comparator<StudentScore> sortByStudentname = (e1, e2) -> e1.studentName.compareTo(e2.studentName);
        Map<String, List<StudentScore>> grouping_by_subjctName_and_then_sortBy_studentName = studentScoreList.stream()
                .sorted(sortByStudentname) // first we sort based on student ascending order.
                .collect(
                        Collectors.groupingBy(
                                e1 -> e1.studentScore.subName, LinkedHashMap::new, Collectors.toList()
                        )
                ); // Appply grouping on subject name and create new LinkedHashMap object and collect data into it using Collectores.tolist method
        System.out.println("grouping_by_subjctName_and_then_sortBy_studentName:: " + grouping_by_subjctName_and_then_sortBy_studentName);

        // Q6: grouping by subjct name in ascending order and then sort by student name also in ascending order
        // output contains in the form group of "subject name" in ascending order also inside it having student name is ascending order.
        // e.g. {C=[StudentScore [studentId=2, studentName=Sane, age=20, score=Score [subName=C, marks=60.0]], StudentScore [studentId=7, studentName=Shinde, age=35, score=Score [subName=C, marks=75.0]]],
        // C++=[StudentScore [studentId=3, studentName=Ramesh, age=28, score=Score [subName=C++, marks=90.0]], StudentScore [studentId=5, studentName=Ramesh, age=29, score=Score [subName=C++, marks=90.0]]],

        Map<String, List<StudentScore>> grouping_by_subjctName_in_ascOrder_and_then_sortBy_studentName_in_ascOrder = studentScoreList.stream()
                .sorted(Comparator.comparing(StudentScore::getStudentName))
                .collect(Collectors.groupingBy(s -> s.studentScore.subName, TreeMap::new, Collectors.toList()));
        System.out.println("grouping_by_subjctName_in_ascOrder_and_then_sortBy_studentName_in_ascOrder:: " + grouping_by_subjctName_in_ascOrder_and_then_sortBy_studentName_in_ascOrder);
    }
}
