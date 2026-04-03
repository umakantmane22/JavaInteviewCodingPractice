package com.mane.umakant.java.interviewQuestions.testComparable;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TestComparableFlow {
    // Q: what is output of below code
    public static void main(String[] args) {
        NavigableSet<Movie> movieList = new TreeSet<Movie>();
        movieList.add(new Movie("Bahubali", 8.3, 2015));

        movieList.add(new Movie("Janbar", 8.7, 1977));

        movieList.add(new Movie("Mr.India", 8.8, 1980));

        movieList.add(new Movie("Amar Akbar Anthony", 8.4, 1983));

        System.out.println("Movies after sorting: ");
        for (Movie movie : movieList) {
            System.out.println(movie.getName() + " " +

                    movie.getRating() + " " +

                    movie.getYear());
        }
    }


}
