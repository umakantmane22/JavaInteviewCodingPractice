package com.mane.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Score {

    private Integer subId;
    private String subName;
    private Double subMarks;

    public Score(Integer subId, String subName, Double subMarks) {
        this.subId = subId;
        this.subName = subName;
        this.subMarks = subMarks;
    }

    public Integer getSubId() {
        return subId;
    }

    public String getSubName() {
        return subName;
    }

    public Double getSubMarks() {
        return subMarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score score)) return false;

        return Objects.equals(subId, score.subId)
                && Objects.equals(subName, score.subName)
                && Objects.equals(subMarks, score.subMarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subId, subName, subMarks);
    }

    @Override
    public String toString() {
        return "Score{" +
                "subId=" + subId +
                ", subName='" + subName + '\'' +
                ", subMarks=" + subMarks +
                '}';
    }
}

public class StudentScore {

    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private Score studentScore;

    public StudentScore(Integer studentId,
                        String studentName,
                        Integer studentAge,
                        Score studentScore) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentScore = studentScore;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public Score getStudentScore() {
        return studentScore;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof StudentScore that)) return false;

        return Objects.equals(studentId, that.studentId)
                && Objects.equals(studentName, that.studentName)
                && Objects.equals(studentAge, that.studentAge)
                && Objects.equals(studentScore, that.studentScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId,
                studentName,
                studentAge,
                studentScore);
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

    //  for ASC order StudentScore class primitives
    final static Comparator<StudentScore> BY_STUDENT_ID_ASC = Comparator.comparing(
            StudentScore::getStudentId,
            Comparator.nullsLast(Integer::compareTo)
    );
    public static final Comparator<StudentScore> BY_STUDENT_NAME_ASC = Comparator.comparing(
            StudentScore::getStudentName,
            Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
    );
    public static final Comparator<StudentScore> BY_STUDENT_AGE_ASC = Comparator.comparing(
            StudentScore::getStudentAge,
            Comparator.nullsLast(Integer::compareTo)
    );

    // ASC order comparators for nested Score wrapper fields
    public static final Comparator<StudentScore> BY_SUBJECT_ID_ASC = Comparator.comparing(
            StudentScore::getStudentScore,
            Comparator.nullsLast(
                    Comparator.comparing(
                            Score::getSubId,
                            Comparator.nullsLast(Integer::compareTo)
                    )
            )
    );
    public static final Comparator<StudentScore> BY_SUBJECT_NAME_ASC3 =
            Comparator.comparing(
                    StudentScore::getStudentScore,
                    Comparator.nullsLast(
                            Comparator.comparing(
                                    Score::getSubName,
                                    Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                            )
                    )
            );


    public static final Comparator<StudentScore> BY_SUBJECT_MARKS_ASC1 =
            Comparator.comparing(
                    student -> student.getStudentScore() != null
                            ? student.getStudentScore().getSubMarks()
                            : null,
                    Comparator.nullsLast(Double::compareTo)
            );
    public static final Comparator<StudentScore> BY_SUBJECT_MARKS_ASC2 =
            Comparator.comparing(
                    StudentScore::getStudentScore,
                    Comparator.nullsLast(
                            Comparator.comparing(
                                    Score::getSubMarks,
                                    Comparator.nullsLast(Double::compareTo)
                            )
                    )
            );

    //  DESC order comparators for nested Score wrapper fields
    /*
    Best Enterprise Pattern
    ASC:
    Comparator.nullsLast(Integer::compareTo)
    DESC:
    Comparator.nullsLast(Comparator.reverseOrder())
    This is the cleanest and safest pattern.
     */
    public final static Comparator<StudentScore> BY_STUDENT_ID_DESC =
            Comparator.comparing(
                    StudentScore::getStudentId,
                    Comparator.nullsLast(
                            Comparator.reverseOrder()
                    )
            );
    public static final Comparator<StudentScore> BY_STUDENT_NAME_DESC =
            Comparator.comparing(
                    StudentScore::getStudentName,
                    Comparator.nullsLast(
                            String.CASE_INSENSITIVE_ORDER.reversed()
                    )
            );
    public static final Comparator<StudentScore> BY_STUDENT_AGE_DESC =
            Comparator.comparing(
                    StudentScore::getStudentAge,
                    Comparator.nullsLast(
                            Comparator.reverseOrder()
                    )
            );

    //  for DESC order Score class primitives
    public static final Comparator<StudentScore> BY_SUBJECT_ID_DESC =
            Comparator.comparing(
                    StudentScore::getStudentScore,
                    Comparator.nullsLast(
                            Comparator.comparing(
                                    Score::getSubId,
                                    Comparator.nullsLast(
                                            Comparator.reverseOrder()
                                    )
                            )
                    )
            );
    public static final Comparator<StudentScore> BY_SUBJECT_NAME_DESC =
            Comparator.comparing(
                    StudentScore::getStudentScore,
                    Comparator.nullsLast(
                            Comparator.comparing(
                                    Score::getSubName,
                                    Comparator.nullsLast(
                                            String.CASE_INSENSITIVE_ORDER.reversed()
                                    )
                            )
                    )
            );
    public static final Comparator<StudentScore> BY_SUBJECT_MARKS_DESC =
            Comparator.comparing(
                    StudentScore::getStudentScore,
                    Comparator.nullsLast(
                            Comparator.comparing(
                                    Score::getSubMarks,
                                    Comparator.nullsLast(
                                            Comparator.reverseOrder()
                                    )
                            )
                    )
            );

    public static void main(String[] args) {
        List<StudentScore> studentScoreList = new ArrayList<>();

        studentScoreList.add(
                new StudentScore(
                        7,
                        "Shinde",
                        35,
                        new Score(101, "C", 75.0)
                )
        );

        studentScoreList.add(
                new StudentScore(
                        1,
                        "Umesh",
                        35,
                        new Score(102, "Java", 80.0)
                )
        );

        studentScoreList.add(
                new StudentScore(
                        3,
                        "Ramesh",
                        28,
                        new Score(103, "C++", 90.0)
                )
        );

        studentScoreList.add(
                new StudentScore(
                        2,
                        "Sane",
                        20,
                        new Score(104, "C", 60.0)
                )
        );

        studentScoreList.add(
                new StudentScore(
                        6,
                        "Umakant",
                        35,
                        new Score(105, "Java", 80.0)
                )
        );

        studentScoreList.add(
                new StudentScore(
                        5,
                        "Ramesh",
                        29,
                        new Score(106, "C++", 90.0)
                )
        );

        studentScoreList.add(
                new StudentScore(
                        4,
                        "Tanuja",
                        35,
                        new Score(107, "SQL", 76.0)
                )
        );

        studentScoreList.add(
                new StudentScore(
                        8,
                        "Shinde",
                        35,
                        new Score(108, "Java", 85.0)
                )
        );
        // Q1  Ascending sort on:   studentId-> studentName-> studentAge-> subId-> subName -> subMarks
        //BY_STUDENT_ID_STUDENT_NAME_STUDENT_AGE_SUBJECT_ID_SUB_NAME_SUB_MARKS_Asc3 : Excellent.
        //This is the first truly enterprise-grade fully null-safe version.
        List<StudentScore> BY_STUDENT_ID_STUDENT_NAME_STUDENT_AGE_SUBJECT_ID_SUB_NAME_SUB_MARKS_Asc3 =
                studentScoreList.stream()
                        .sorted(
                                Comparator.comparing(
                                                StudentScore::getStudentId,
                                                Comparator.nullsLast(
                                                        Integer::compareTo
                                                )
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentName,
                                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentAge,
                                                Comparator.nullsLast(Integer::compareTo)
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentScore,
                                                Comparator.nullsLast(
                                                        Comparator.comparing(
                                                                Score::getSubId,
                                                                Comparator.nullsLast(
                                                                        Integer::compareTo
                                                                )
                                                        )
                                                )
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentScore,
                                                Comparator.nullsLast(
                                                        Comparator.comparing(
                                                                Score::getSubName,
                                                                Comparator.nullsLast(
                                                                        String.CASE_INSENSITIVE_ORDER
                                                                )
                                                        )
                                                )
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentScore,
                                                Comparator.nullsLast(
                                                        Comparator.comparing(
                                                                Score::getSubMarks,
                                                                Comparator.nullsLast(
                                                                        Double::compareTo
                                                                )
                                                        )
                                                )
                                        )
                        )
                        .toList();
        //BY_STUDENT_ID_STUDENT_NAME_STUDENT_AGE_SUBJECT_ID_SUB_NAME_SUB_MARKS_Asc4 : BEST VERSION.
        /*
        This is what senior developers usually prefer.
        Why?
        Because:
        reusable comparators
        centralized logic
        cleaner stream
        easier testing
        easier maintenance
        consistent null handling

        This is the strongest implementation.

        Final Recommendation in production code.:
        Keep Only: BY_STUDENT_ID_STUDENT_NAME_STUDENT_AGE_SUBJECT_ID_SUB_NAME_SUB_MARKS_Asc4

         */
        List<StudentScore> BY_STUDENT_ID_STUDENT_NAME_STUDENT_AGE_SUBJECT_ID_SUB_NAME_SUB_MARKS_Asc4 =
                studentScoreList.stream()
                        .sorted(
                                BY_STUDENT_ID_ASC
                                        .thenComparing(BY_STUDENT_NAME_ASC)
                                        .thenComparing(BY_STUDENT_AGE_ASC)
                                        .thenComparing(BY_SUBJECT_ID_ASC)
                                        .thenComparing(BY_SUBJECT_NAME_ASC3)
                                        .thenComparing(BY_SUBJECT_MARKS_ASC2)
                        )
                        .toList();

        // Q2  Descending sort on:   studentId-> studentName-> studentAge-> subId-> subName -> subMarks

        // review for BY_STUDENT_ID_STUDENT_NAME_STUDENT_AGE_SUBJECT_ID_SUB_NAME_SUB_MARKS_Desc3
        /*
        Excellent.
        This is the first fully correct inline implementation.
        Handles:
        wrapper nulls
        nested object nulls
        descending order
        case-insensitive strings
        null ordering
        Very strong implementation.
         */

        List<StudentScore> BY_STUDENT_ID_STUDENT_NAME_STUDENT_AGE_SUBJECT_ID_SUB_NAME_SUB_MARKS_Desc3 =
                studentScoreList.stream()
                        .sorted(
                                Comparator.comparing(
                                                StudentScore::getStudentId,
                                                Comparator.nullsLast(
                                                        Comparator.reverseOrder()
                                                )
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentName,
                                                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER.reversed())
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentAge,
                                                Comparator.nullsLast(Comparator.reverseOrder())
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentScore,
                                                Comparator.nullsLast(
                                                        Comparator.comparing(
                                                                Score::getSubId,
                                                                Comparator.nullsLast(
                                                                        Comparator.reverseOrder()
                                                                )
                                                        )
                                                )
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentScore,
                                                Comparator.nullsLast(
                                                        Comparator.comparing(
                                                                Score::getSubName,
                                                                Comparator.nullsLast(
                                                                        String.CASE_INSENSITIVE_ORDER.reversed()
                                                                )
                                                        )
                                                )
                                        )
                                        .thenComparing(
                                                StudentScore::getStudentScore,
                                                Comparator.nullsLast(
                                                        Comparator.comparing(
                                                                Score::getSubMarks,
                                                                Comparator.nullsLast(
                                                                        Comparator.reverseOrder()
                                                                )
                                                        )
                                                )
                                        )
                        )
                        .toList();

        // review for BY_STUDENT_ID_STUDENT_NAME_STUDENT_AGE_SUBJECT_ID_SUB_NAME_SUB_MARKS_Desc4
        /*
        BEST VERSION.
        This is the most enterprise-grade implementation.
        Why?
        Because:
        reusable comparators
        centralized null handling
        consistent logic
        cleaner stream pipeline
        maintainable
        easy testing
        readable
        This is exactly how comparator utility classes are commonly used in enterprise Java projects.
         */
        List<StudentScore> BY_STUDENT_ID_STUDENT_NAME_STUDENT_AGE_SUBJECT_ID_SUB_NAME_SUB_MARKS_Desc4 =
                studentScoreList.stream()
                        .sorted(
                                BY_STUDENT_ID_DESC
                                        .thenComparing(BY_STUDENT_NAME_DESC)
                                        .thenComparing(BY_STUDENT_AGE_DESC)
                                        .thenComparing(BY_SUBJECT_ID_DESC)
                                        .thenComparing(BY_SUBJECT_NAME_DESC)
                                        .thenComparing(BY_SUBJECT_MARKS_DESC)
                        )
                        .toList();
        System.out.println("Done");
    }

}
