package com.mane.umakant.java.interviewQuestions;

import com.mane.umakant.java8.NthHighestSalaryInMap.NthHighestSalaryInMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8FrequentlyAskingProgrammingQuesions {
    public static void main(String args[]) {
        // Q1- Java program to count the occurrence of each character in a string
        // input: ilovejavatechie, output {a=2, c=1, t=1, e=3, v=2, h=1, i=2, j=1, l=1, o=1}
        String input = "ilovejavatechie";
        Map<Character, Integer> map1 = new HashMap<>();
        for (char ch : input.toCharArray()) {
            if (map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) + 1);
            } else {
                map1.put(ch, 1);
            }
        }
        System.out.println("Q1: " + map1);
        Map<Character, Integer> map2 = new HashMap<>();
        for (char ch : input.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        System.out.println("Q1: " + map2);

        // Count the occurrence of each character
        // chars() returns an IntStream of ASCII/Unicode values, not the actual digits.
        // "input.chars() returns the Unicode value of each character, not the digit itself.
        Map<Character, Long> characterCount = input.chars() // Convert string to IntStream of characters.
                .mapToObj(c -> (char) c)                   // Convert each int to char
                .collect(
                        Collectors.groupingBy(            // Group by each character
                                Function.identity(),      //  Returns a function that always returns its input argument. Use the character itself as the key
                                Collectors.counting()     // Count occurrences of each character
                        )
                );

        // Print the occurrence of each character
        // characterCount.forEach((character, count) ->
        //       System.out.println("Character: " + character + ", Occurrence: " + count));
        System.out.println("Q1:: characterCount:: " + characterCount);

        // Another way which I have habitual but below style should be avoid as per ChatGpt

        Map<String, Long> characterCountString = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Q1:: characterCountString:: " + characterCountString);


        // Q2- Java program to find all duplicates elements from a given string
        // String input = "ilovejavatechie";  output [a, e, v, i]
        List<Map.Entry<Character, Long>> duplicatesElementsWithCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), // Returns a function that always returns its input argument
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .toList();
        System.out.println("Q2:: duplicatesElementsWithCount:: " + duplicatesElementsWithCount);
        Set<Character> duplicatesElements = input.chars()// Convert string to IntStream of characters
                .mapToObj(c -> (char) c)// Convert each int to char
                .collect(Collectors.groupingBy(
                                Function.identity(), // Returns a function that always returns its input argument
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("duplicatesElements:: " + duplicatesElements);

        // Q3-  find all uniqueElement elements from a given string");
        // iString input = "Ilovejavatechie"; output  [c, t, h, j, l, o]
        Set<Map.Entry<Character, Long>> uniqueElementWithCount = input.chars()// Convert string to IntStream of characters
                .mapToObj(c -> (char) c)// Convert each int to char
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), // Returns a function that always returns its input argument
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .collect(Collectors.toSet());
        System.out.println("Q3:: uniqueElementWithCount:: " + uniqueElementWithCount);
        Set<Character> uniqueElement = input.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("uniqueElement:: " + uniqueElement);

        // Q4: find first non repeated character from a given string
        // e.g. String input = "ilovejavatechie";  output:: l
        List<Character> first_non_repeated_characterWithCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), // Returns a function that always returns its input argument
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Q4:: first_non_repeated_characterWithCount:: " + first_non_repeated_characterWithCount);
        Optional<Character> first_non_repeated_character = input.chars() // Convert the string to IntStream of characters
                .mapToObj(c -> (char) c)// Convert each int to char
                .collect(Collectors.groupingBy( // Group by character and count occurrences
                        Function.identity(), // Returns a function that always returns its input argument
                        LinkedHashMap::new, // Maintain insertion order
                        Collectors.counting()))// Count occurrences of each character
                .entrySet().stream()// Convert the map to a stream
                .filter(entry -> entry.getValue() == 1)// Filter for characters that appear only once
                .map(Map.Entry::getKey)  // Get the character (key)
                .findFirst(); // Get the first non-repeated character
        System.out.println("first_non_repeated_character:: " + first_non_repeated_character);
        Character first_non_repeated_characterOrElse = input.chars() // Convert the string to IntStream of characters
                .mapToObj(c -> (char) c)// Convert each int to char
                .collect(Collectors.groupingBy( // Group by character and count occurrences
                        Function.identity(), // Returns a function that always returns its input argument
                        LinkedHashMap::new, // Maintain insertion order
                        Collectors.counting()))// Count occurrences of each character
                .entrySet().stream()// Convert the map to a stream
                .filter(entry -> entry.getValue() == 1)// Filter for characters that appear only once
                .map(Map.Entry::getKey)  // Get the character (key)
                .findFirst() // Get the first non-repeated character
                .orElseThrow(() -> new RuntimeException("Character not found"));
        System.out.println("first_non_repeated_characterOrElse:: " + first_non_repeated_characterOrElse);


        // Q5: find first repeated character from a given string
        // e.g. input = "ilovejavatechie" o/p:: i

        Optional<Character> first_repeated_character = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(enntry -> enntry.getValue() > 1)
                .map(entry -> entry.getKey())
                .findFirst();
        System.out.println("Q5:: first_repeated_character:: " + first_repeated_character);
        Character first_repeated_characterOrElse = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(enntry -> enntry.getValue() > 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Character not found"));
        System.out.println("Q5:: first_repeated_characterOrElse:: " + first_repeated_characterOrElse);

        // Q6: find second highest number from given array.
        // refer com.mane.umakant.java.interviewQuestions.SecondHighestNumber.java
        int[] primitiveArray = {5, 9, 11, 2, 8, 21, 21}; //op: 11
        //Integer[] nonPrimitiveArray = {1, 2, 5, 6, 3, 2, 6};  // OP: 5
        int maxNumber = Integer.MIN_VALUE;
        int secondMaxNumber = Integer.MIN_VALUE;

        for (int num : primitiveArray) {
            if (num > maxNumber) {
                secondMaxNumber = maxNumber;
                maxNumber = num;
            } else if (num > secondMaxNumber && num != maxNumber) {
                secondMaxNumber = num;
            }
        }

        if (secondMaxNumber == Integer.MIN_VALUE) {
            System.out.println("No second highest element");
        } else {
            System.out.println("Second highest: " + secondMaxNumber);
            System.out.println(" highest: " + maxNumber);
        }
        // 🚀 2. Using Java 8 Streams
        Optional<Integer> secondMaxNumberJava8 = Arrays.stream(primitiveArray)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        if (secondMaxNumberJava8.isPresent()) {
            System.out.println("Second highest: " + secondMaxNumberJava8.get());
        } else {
            System.out.println("Second highest not present");
        }

        // Q7: find largest string from given array
        // input: String[] strArray={"java","techie","springboot","microservices"}
        // op:: microservices
        String[] inputStringArray = {"java", "techie", "springboot", "microservices"};
        String largestString1 = "";
        for (String string : inputStringArray) {
            if (string.length() > largestString1.length()) {
                largestString1 = string;
            }
        }
        System.out.println("largestString1 :: " + largestString1);

        Optional<String> largestString2 = Arrays.stream(inputStringArray)
                .max(
                        Comparator.comparingInt(String::length)
                );
        System.out.println("largestString2 :: " + largestString2);

        String largestString3 = Arrays.stream(inputStringArray)
                .max(
                        Comparator.comparingInt(String::length)
                ).orElse("");
        System.out.println("largestString3 :: " + largestString3);

        String largestString4 = Arrays.stream(inputStringArray)
                .max(
                        Comparator.comparingInt(String::length)
                ).orElseThrow(() -> new RuntimeException("not found"));
        System.out.println("largestString4 :: " + largestString4);

        String largestString5 = Arrays.stream(inputStringArray)
                .reduce((a, b) -> a.length() > b.length() ? a : b).get();
        System.out.println("largestString5 :: " + largestString5);
        List<String> inputStringArray1 = Arrays.asList("java", "techie", "springboot", "microservices");
        String largestString1inputStringArray1 = "";
        for (String string : inputStringArray1) {
            if (string.length() > largestString1inputStringArray1.length()) {
                largestString1inputStringArray1 = string;
            }
        }
        System.out.println("largestString1inputStringArray1 :: " + largestString1inputStringArray1);

        Optional<String> largestString2inputStringArray1 = inputStringArray1.stream()
                .max(
                        Comparator.comparingInt(String::length)
                );
        System.out.println("largestString2inputStringArray1 :: " + largestString2inputStringArray1);

        // Q8: Find all element from array who start with 1
        // reuse int[] numbers= {5,9,11,2,8,21,1}; op: [11, 1]
        int[] numbers = {5, 9, 11, 2, 8, 21, 1};
        // java 7
        List<Integer> resultQ8 = new ArrayList<>();
        for (int num : numbers) {

            int tempQ8 = num;

            // Reduce number to its first digit
            while (tempQ8 >= 10) {
                tempQ8 /= 10;
            }

            if (tempQ8 == 1) {
                resultQ8.add(num);
            }
        }

        System.out.println("Q8:: " + resultQ8);

        List<Integer> all_element_from_array_who_start_with_1 = Arrays.stream(numbers)
                .mapToObj(String::valueOf) // Convert int → String
                .filter(num -> num.startsWith("1")) // Keep numbers starting with '1'
                .map(Integer::valueOf) // Convert back String → Integer
                .toList(); // Collect as List
        System.out.println("Q8:: all_element_from_array_who_start_with_1:: " + all_element_from_array_who_start_with_1);
        // or
        List<String> all_element_from_array_who_start_with_1_ = Arrays.stream(numbers)
                .boxed()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1")).collect(Collectors.toList());
        System.out.println("all_element_from_array_who_start_with_1_: " + all_element_from_array_who_start_with_1_);

        System.out.println("Q9:  join given string with '-' ");
        // Q9: String.join example
        // In: List<String> nos=Arrays.asList("1","2","3","4");
        // Op: 1-2-3-4

        List<String> nos = Arrays.asList("1", "2", "3", "4");
        // Join the strings with a hyphen using Collectors.joining
        String result = nos.stream()
                .collect(Collectors.joining("-"));

        System.out.println("Q9:: join_given_string_with- " + result);
        // or best approch: joinWithDelimiter
        String joinWithDelimiter = String.join("-", nos);
        System.out.println("join_given_string_witmaxMinNumbers20h1-: " + joinWithDelimiter);

        // Q 10: skip and limit example(2-9)
        // print value from 3 to 8
        List<Integer> value_from_3_to_8 = IntStream.rangeClosed(2, 8).boxed().skip(1).limit(8)
                // .forEach(System.out::println);
                .collect(Collectors.toList());
        System.out.println("Q10:: value_from_3_to_8: " + value_from_3_to_8);

        // Q11 find sum of all numbers from given int arraylist
        // input: List<Integer> list=Arrays.asList(1,2,3,4,5); OP: 15
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum11 = 0;
        for (int num : list) {
            sum11 = sum11 + num;
        }
        System.out.println("sum_of_all_numbers_from_given_int_arraylist11:: " + sum11);
        // or
        int sum_of_all_numbers_from_given_int_arraylist_best =
                list.stream()
                        .reduce(0, (a, b) -> a + b);

        System.out.println("sum_of_all_numbers_from_given_int_arraylist_best:: " + sum_of_all_numbers_from_given_int_arraylist_best);
        // or
        int sum_of_all_numbers_from_given_int_arraylist_sum1 =
                list.stream()
                        .reduce(
                                (a, b) -> a + b
                        ).orElse(0);
        System.out.println("sum_of_all_numbers_from_given_int_arraylist_sum1:: " + sum_of_all_numbers_from_given_int_arraylist_sum1);
        //or
        int sum_of_all_numbers_from_given_int_arraylist1 = list.stream().reduce((a, b) -> a + b).get();
        System.out.println("sum_of_all_numbers_from_given_int_arraylist1: " + sum_of_all_numbers_from_given_int_arraylist1);
        // Using stream and reduce to calculate the sum
        int sum_of_all_numbers_from_given_int_arraylist = list.stream()
                .reduce(0, Integer::sum);

        System.out.println("Q11: sum_of_all_numbers_from_given_int_arraylist:: " + sum_of_all_numbers_from_given_int_arraylist);


        System.out.println("Q12:  find average of given int array");
        // Q 12 find average of given int array
        // input: List<Integer> list=Arrays.asList(1,2,3,4,5);  OP: 3
        OptionalDouble average_of_given_int_array = list.stream()
                .mapToInt(Integer::valueOf)
                .average();
        if (average_of_given_int_array.isPresent()) {
            System.out.println("Q12: average_of_given_int_array:: " + average_of_given_int_array);
        }
        double average_of_given_int_array1 = list.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .getAsDouble();
        System.out.println("average_of_given_int_array1:: " + average_of_given_int_array1);

        // Q13 find square of each element take value >100 and find average.
        // e.g. input: List<Integer> list1=Arrays.asList(10,20,30,15);
        // 100,400,900,225
        // 400,900,225
        // 1525/3=508.33333

        List<Integer> list1 = Arrays.asList(10, 20, 30, 15);
        double square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average = list1.stream()
                .map(num -> num * num)
                .filter(num -> num > 100)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println("Q13: square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average:: " + square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average);
        // or
        OptionalDouble square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average1 = list1.stream()
                .map(num -> num * num)                   // Square each element
                .filter(num -> num > 100)               // Filter values greater than 100
                .mapToInt(Integer::intValue)        // Convert back to int
                .average();                         // Calculate the average
        if (square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average1.isPresent()) {
            System.out.println("square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average1:: " + square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average1);
        }

        // Q14 find odd and even numbers op: oddNumbers:: [11, 3, 45, 67, 9, 87] evenNumbers:: [2, 90, 8, 2, 0]
        List<Integer> oddEvenNumbers = Arrays.asList(11, 2, 3, 45, 67, 9, 90, 87, 8, 2, 0);
        List<Integer> oddNumbers = oddEvenNumbers.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
        List<Integer> evenNumbers = oddEvenNumbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Q14: oddNumbers:: " + oddNumbers + " evenNumbers:: " + evenNumbers);
        Map<Boolean, List<Integer>> partitioned = oddEvenNumbers.stream()
                .collect(
                        Collectors.partitioningBy(
                                num -> num % 2 == 0
                        )
                );
        // Retrieve and print the even and odd numbers
        List<Integer> evenNumbers1 = partitioned.get(true);  // Even numbers
        List<Integer> oddNumbers1 = partitioned.get(false);  // Odd numbers
        System.out.println("Even Numbers: " + evenNumbers1);
        System.out.println("Odd Numbers: " + oddNumbers1);

        // Q15: find numbers which start with 2
        // Ip:2,222,234,567,890,432,236,211,22
        // Op:2,222,234,236,211,22
        List<Integer> numbers1 = Arrays.asList(2, -222, 234, 567, 890, 432, 236, 211, 22);
        List<String> numbers_which_start_with_two = numbers1.stream()
                .map(String::valueOf)
                .filter(num -> num.startsWith("2") || num.startsWith("-2"))
                .collect(Collectors.toList());
        System.out.println("Q15: numbers_which_start_with_two:: " + numbers_which_start_with_two);
        // or
        List<Integer> numbers_which_start_with_two2 = numbers1.stream()
                .filter(num -> String.valueOf(num).startsWith("2"))  // Convert number to string and check if it starts with '2'
                .collect(Collectors.toList());
        System.out.println("numbers_which_start_with_two2:: " + numbers_which_start_with_two2);
        // or
        List<Integer> numbers_which_start_with_two3 = numbers1.stream()
                .map(String::valueOf)
                .filter(num -> num.startsWith("2"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println("numbers_which_start_with_two3:: " + numbers_which_start_with_two3);

        // Q16 find duplicate elements [1, 2, 3, 10, 30]
        List<Integer> elementsList = Arrays.asList(1, 3, 10, 20, 30, 15, 1, 13, 2, 2, 10, 30, 19, 3);
        List<Integer> duplicate_elements = elementsList.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Q16: duplicate_elements:: " + duplicate_elements);
        // or
        Set<Integer> secondWay = elementsList.stream()
                .filter(num -> Collections.frequency(elementsList, num) > 1)
                .collect(Collectors.toSet());
        System.out.println("duplicate_elements1:: " + secondWay);

        Set<Integer> dupNum = new HashSet<>();
        Set<Integer> thirdWay = elementsList.stream()
                .filter(num -> !dupNum.add(num)).collect(Collectors.toSet());
        System.out.println("duplicate_elements3:: " + thirdWay);

        // Q17 find max and min // op Optional[40] min:: Optional[-1]
        List<Integer> maxMinNumbers = Arrays.asList(-1, 0, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
        Optional<Integer> minApproch1 = maxMinNumbers.stream()
                .min(Comparator.naturalOrder()); // Using natural order to find the max
        Optional<Integer> max2Approch1 = maxMinNumbers.stream()
                .max(Comparator.naturalOrder()); // Using natural order to find the max

        Optional<Integer> minApproch2 = maxMinNumbers.stream()
                .min(Comparator.comparingInt(Integer::intValue)); // Best for custom objects using an int field. e.g Employee object
        Optional<Integer> maxApproch2 = maxMinNumbers.stream()
                .max(Comparator.comparingInt(Integer::intValue)); // Best for custom objects using an int field. e.g Employee object

        Optional<Integer> minApproch3 = maxMinNumbers.stream()
                .min(Integer::compareTo);  // Even shorter for Integer
        Optional<Integer> maxApproch3 = maxMinNumbers.stream()
                .max(Integer::compareTo);

        Optional<Integer> minApproch4 = maxMinNumbers.stream()
                .min(Integer::compare); // Even shorter for Integer
        Optional<Integer> maxApproch4 = maxMinNumbers.stream()
                .max(Integer::compare);

        // Q18 sort asc and desc order if given Integer array
        //List<Integer> maxMinNumbers = Arrays.asList(-1, 0, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
        List<Integer> ascSorting = maxMinNumbers.stream()
                .sorted()
                .toList();
        System.out.println("Q18: ascSorting:: " + ascSorting);
        List<Integer> descSorting1 = maxMinNumbers.stream()
                .sorted(Comparator.reverseOrder()) // ChatGpt prefer Comparator.reverseOrder() because:
                .toList();
        System.out.println("Q18: descSorting1:: " + descSorting1);
        List<Integer> descSorting2 = maxMinNumbers.stream()
                .sorted(Collections.reverseOrder())
                .toList();
        System.out.println("Q18: descSorting2:: " + descSorting2);
        /*
            I prefer Comparator.reverseOrder() because:
            It is part of the Comparator API.
            It reads naturally alongside Comparator.naturalOrder().
            It is the style most commonly seen in modern Java (Java 8+).
        */

        // Q19 Skip and Limit example
        // here I used elementsList as input
        // List<Integer>
        // List<Integer> elementsList = Arrays.asList(1, 3, 10, 20, 30, 15, 1, 13, 2, 2, 10, 30, 19, 3); //96

        // skip first 5 numbers
        List<Integer> skip_first_5_elements = elementsList.stream().skip(5).collect(Collectors.toList());
        System.out.println("Q19: skip_first_5_elements:: " + skip_first_5_elements);

        // skip first 5 element find sum of remaining elements
        int skip_first_5_element_find_sum_of_remaining_elements =
                elementsList.stream()
                        .skip(5)
                        .reduce((a, b) -> a + b).get();
        System.out.println("skip_first_5_element_find_sum_of_remaining_elements:: " + skip_first_5_element_find_sum_of_remaining_elements);
        // get first 5 numbers
        List<Integer> first_5_numbers = elementsList.stream().limit(5).collect(Collectors.toList());
        System.out.println("first_5_numbers:: " + first_5_numbers);
        // sum Of first 5 Elements
        Integer sumOffirst5Elements = elementsList.stream().limit(5).reduce((a, b) -> a + b).get();
        System.out.println("sumOffirst5Elements:: " + sumOffirst5Elements);

        // Q 20: find second highest and lowest number.
        // same as  Q6: find second highest number from given array.
        // Find the second minimum element
        Optional<Integer> second_min_element1 = maxMinNumbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst();
        System.out.println("second_min_element1:: " + second_min_element1.get());
        // Find the second maximum element
        Optional<Integer> second_max_element1 = maxMinNumbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println("second_max_element1:: " + second_max_element1.get());

        //Q21:  find NthHighestSalaryDemo from given map
        //refer com.mane.umakant.java8.NthHighestSalaryInMap.NthHighestSalaryInMap.java

        // Q22 form a largest number from given array.
        String arrFormLargestNumber[] = {"1", "34", "3", "98", "9", "76", "45", "4"};
        // Sort the array using a custom comparator

        Arrays.sort(arrFormLargestNumber, (a, b) -> (b + a).compareTo(a + b));
        // Form the largest number by concatenating the sorted array
        String form_a_largest_number_from_given_array = String.join("", arrFormLargestNumber);
        // Print the result
        System.out.println("Q22: form_a_largest_number_from_given_array:: " + form_a_largest_number_from_given_array);
        // or

        String str = "";
        for (String s : arrFormLargestNumber) {
            str = str + s;
        }
        System.out.println("form_a_largest_number_from_given_array1:: " + str);

        // Q 23 Remove special character from given String s = "CloudTech#$@!";
        // OP: Special character removed: CloudTech specialCharacterRemovedCount: 4

        String s = "CloudTech#$@!";
        // Remove special characters using replaceAll()
        String resultT = s.replaceAll("[^a-zA-Z0-9]", "");

        // Print the result
        System.out.println("Q23: String after removing special characters:: " + resultT);
        //or
        String stringAfterRemovedSpecialCharacters = "";
        int specialCharacterRemovedCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) {
                specialCharacterRemovedCount = specialCharacterRemovedCount + 1;
            } else {
                stringAfterRemovedSpecialCharacters = stringAfterRemovedSpecialCharacters + s.charAt(i);
            }
        }
        if (specialCharacterRemovedCount == 0) {
            System.out.println("There is no special character found");
        } else {
            System.out.println("Special character removed:: " + stringAfterRemovedSpecialCharacters);
            System.out.println("specialCharacterRemovedCount:: " + specialCharacterRemovedCount);
        }

        // Q24 Check rotation of String
        // ABCD CDAB here string rotation is true.
        /*
        First Approch::
        ✅ Check if s2 is a rotation of s1
        A string s2 is a rotation of string s1 if and only if:
        s2 is a substring of (s1 + s1)`
        Example:
        s1 = "ABCE" → s1 + s1 = "ABCEABCE"
        Check if "CDAB" is inside "ABCEABCE" → ❌ (it's not)
        So CDAB is not a rotation of ABCE.
        How does .contains() help?
        .contains(s2) checks if string s2 exists inside (s1 + s1).
        Case in your example:
        s1 = "ABCE"
        s2 = "CDAB"
        s1 + s1 = "ABCEABCE"
        Is "CDAB" inside "ABCEABCE"?
        ❌ No → so .contains() returns false


        Second Approch:
        STEP 1 — Understanding the Problem
        We want to check:
        👉 Is s2 a rotated version of s1?
        Example of valid rotations of "ABCE":
        | Rotation | Explanation       |
        | -------- | ----------------- |
        | ABCE     | original          |
        | BCEA     | rotated left by 1 |
        | CEAB     | rotated left by 2 |
        | EABC     | rotated left by 3 |

        A rotation means: characters are shifted circularly.

        🟩 STEP 2 — Check if both strings have same length
        🟩 STEP 3 — Why (s1 + s1) is used
        We do:
        s1 + s1   → "ABCEABCE"
        This is the key trick.
        Why does this work?
        Because all possible rotations of a string appear as substrings of the doubled string.
        Let’s verify:
        Doubled string:
        ABCEABCE
        Look at its substrings of length 4:
        ABCE (start at index 0)
        BCEA (start at index 1)
        CEAB (start at index 2)
        EABC (start at index 3)
        ABCE (start at index 4)
        These are exactly all rotations of "ABCE".
        So:
        👉 If s2 is inside "ABCEABCE", it is a rotation
        👉 If not, it is not a rotation

        🟩 STEP 4 — Check if s2 exists in doubled string
        This part:
        (s1 + s1).indexOf(s2) != -1
        How does .indexOf() work?
        Returns index ≥ 0 if substring is found
        Returns -1 if substring is NOT found
        So:
        If s2 exists in "ABCEABCE" → rotation is present
        If s2 does not exist → rotation is not present
        Let’s check your exact values:
        s1 = "ABCE"
        s2 = "CDAB"
        s1 + s1 = "ABCEABCE"
        Is "CDAB" inside "ABCEABCE"?
        ❌ No
        So .indexOf("CDAB") returns -1
        🟩 STEP 5 — Final if-condition
        Full condition:
        s1.length() == s2.length()
        &&
        (s1 + s1).indexOf(s2) != -1
        If both are true → it's a rotation.
        For your inputs:
        Length: same → ✔️ true
        Substring found: false → ❌
        Final result = false
        🟩 STEP 6 — Output
        So the program prints:
        Q24 A: String rotation is not present

        */
        String s1 = "ABCD";
        String s2 = "CDAB";

        // First Approch:
        if (s1.length() == s2.length() && (s1 + s1).contains(s2)) {
            System.out.println("Q24 Approch A: String rotation is present");
        } else {
            System.out.println("Q24 Approch A: String rotation is not present");
        }

        // Second Approch:
        if (s1.length() == s2.length() && (s1 + s1).indexOf(s2) != -1) {
            System.out.println("Q24 Approch B: String rotation is present");
        } else {
            System.out.println("Q24 Approch B: String rotation is not present");
        }

        String start = "123456";  //String mid = "345612";
        String mid = "524136";
        if (start.length() == mid.length() && (start + start).indexOf(mid) != -1) {
            System.out.println("Q24 Approch B.1: String rotation is present");
        } else {
            System.out.println("Q24 Approch B.1: String rotation is not present");
        }
        /*
        Explanation of above code.
        ✅ Your Code (Correct Logic)
        ✔ Length check — correct
        ✔ Rotation logic using (start + start) — correct
        ✔ indexOf(mid) != -1 — correct
        The program is correct.
        ❌ But the input "524136" is NOT a rotation of "123456"
        Let’s check.
        start:
        1 2 3 4 5 6
        All valid rotations of "123456":
        123456
        234561
        345612
        456123
        561234
        612345
        Your mid string:
        524136  ← this does NOT match any rotation
        Now check using the logic:
        start + start = "123456123456"
        Is "524136" inside "123456123456"?
        ❌ No.
        So output is:
        Q24 Approch B.1: String rotation is not present
        */

        // Q 24.1 Print All Rotations of a String (Beginner Friendly)
        String rotationStrInput = "ABCE";
        for (int i = 0; i < rotationStrInput.length(); i++) {
            String rotation = rotationStrInput.substring(i) + rotationStrInput.substring(0, i);
            System.out.println("Q 24.1: All possible rotations:: " + rotation);
        }

        //✅ Q 24.2. Check Rotation WITHOUT Using contains() or indexOf()
        boolean isRotation = false;

        for (int j = 0; j < s1.length(); j++) {
            String rotation = s1.substring(j) + s1.substring(0, j);
            if (rotation.equals(s2)) {
                isRotation = true;
                break;
            }
        }
        System.out.println("Q 24.2: ");
        System.out.print(isRotation ? "Rotation Present" : "Rotation Not Present");

        //Q 25 How to check first string contain all charcter from second string. Take below as input
        //String first= "123456";
        //String second= "345";
        /*Check if every character in second exists inside first.
        In this case:
        3 → present
        4 → present
        5 → present
        So result = true
        */
        String first = "123456";
        String second = "345";
        String third = "40";
        boolean containsAllChars = false;
        List<Character> commonCharacters = new ArrayList<>();
        for (char ch : first.toCharArray()) {
            if (second.indexOf(ch) != -1 && third.indexOf(ch) != -1) {
                containsAllChars = true;
                commonCharacters.add(ch);
            }
        }
        System.out.println(commonCharacters); // common chars is only 4
        System.out.println("Contains common characters: " + containsAllChars); // Yes because of 4
        /*
        Check if the character exists in the first string
        This is the main logic:
        if (first.indexOf(ch) == -1)
        How .indexOf() works:
        Returns 0 or positive index → character FOUND
        Returns -1 → character NOT FOUND
        Example:
        "123456".indexOf('4') → returns 3
        "123456".indexOf('9') → returns -1
                        */

        // Q 26 Find missing number from given array op:5
        int arrMissingNumber[] = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10};
        // Calculate the total sum of numbers from 1 to 10
        int n = 10;
        int totalSum = (n * (n + 1)) / 2;
        // Calculate the sum of elements in the given array
        int arraySum = 0;
        for (int i = 0; i < arrMissingNumber.length; i++) {
            arraySum += arrMissingNumber[i];
        }
        // The missing number is the difference between the total sum and the array sum
        int missingNumber = totalSum - arraySum;
        // Print the missing number
        System.out.println("Q25: The missing number is: " + missingNumber);
        int sumOfAllElementsJava8 = Arrays.stream(arrMissingNumber).sum();
        System.out.println("The missing number is using Java8:: " + (totalSum - sumOfAllElementsJava8));

        // Q 27 Prime Numbers
        // e.g. prime numbers are 2, 3, 5, 7, and so on.
        // refer com.mane.umakant.java.interviewQuestions.PrimeNumbers.java
        int number = 29;
        // using Java7
        // Prime numbers are greater than 1
        boolean primeFlag = true;
        if (number <= 1) {
            primeFlag = false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    primeFlag = false;
                    break;
                } else {
                    primeFlag = true;
                }
            }
        }
        System.out.println(number + " is prime:: " + primeFlag);
        // print prime numbers upto 17
        int primeNoUpto = 17; // Start checking for primes from 2
        List<Integer> primNumbersUpto = new ArrayList<>();
        for (int i = 2; i < primeNoUpto; i++) {
            boolean primeFlagUpto = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    primeFlagUpto = false;
                    break;
                } else {
                    primeFlagUpto = true;
                }
            }
            if (primeFlagUpto) {
                primNumbersUpto.add(i);
            }
        }
        System.out.println("primNumbersUpto:: " + primNumbersUpto);

        // Q 28 Find vowels count in given string.
        //String vowelsString = "Naveen AutomationLabs";
        // refer com.mane.umakant.java.interviewQuestions.FindOwelsAndCountInGivenString.java
        String vowelsString = "Naveen AutomationLabs";
        List<Character> vowels = Arrays.asList(
                'a', 'A',
                'e', 'E',
                'i', 'I',
                'o', 'O',
                'u', 'U'
        );
        Set<Character> vowelsSet = Set.of(
                'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'
        );
        int count = 0;
        int countSet = 0;
        // Now we will Find and print all vowels and there count from the given string
        Set<Character> foundVowels = new HashSet<>();
        for (char ch : vowelsString.toCharArray()) {
            // System.out.println(ch);
            if (vowels.contains(ch)) {
                count = count + 1;
                foundVowels.add(ch);
            }
            if (vowelsSet.contains(ch)) {
                countSet = countSet + 1;
            }
        }
        System.out.println(count + " " + count);
        System.out.println(countSet + " " + countSet);
        System.out.println("foundVowels:: " + foundVowels);

        long countJava8 = vowelsString
                .toLowerCase()
                .chars()
                .filter(ch -> "aeiou".indexOf(ch) >= 0)
                .count();
        System.out.println("countJava8:: " + countJava8);

        Set<String> foundVowelsSet =
                vowelsString
                        .chars()
                        .filter(ch -> "aAeEiIoOuU".indexOf(ch) >= 0)
                        .mapToObj(ch -> String.valueOf((char) ch))
                        .collect(Collectors.toSet());
        System.out.println("foundVowelsSet:: " + foundVowelsSet);

        // Q 29 Find given string is Palindrome or not?
        String palindromStr = "aba aba aba";
        // refer com.mane.umakant.java.interviewQuestions.Palindrome.java

        //Q30:  remove perticular character from given string
        // remove c from given string "CloudTech".  op: loudTech
        String strQ29 = "CloudTech";
        String repStr = strQ29.replaceAll("C", "");
        System.out.println("String after removing 'c'::  " + repStr);
        // or
        // Remove all occurrences of 'c' (case insensitive)
        result = strQ29.replace("c", "");
        result = result.replace("C", "");  // Optional if you want case-sensitive removal

        System.out.println("String after removing 'c':: " + result);

        //Q31:  compare two different array is same or not. Order of element is no matter
        int[] arrAccenture1 = {3, 2, 5, 7};
        int[] arrAccenture2 = {2, 3, 7, 5};
        // op: array same
        // refer com.mane.umakant.java.interviewQuestions.ArraySameOrNot.java

        // Q32:  from given array sort first even numbers and then odd numbers and show it
        int[] arrEvenOddOrderInput = {1, 2, 5, 4, 7, 8, 11, 20};
        // op:  [2, 4, 8, 20, 1, 5, 7, 11]
        // refer com.mane.umakant.java.interviewQuestions.ArraySortFirstEvenNumbersThenOddNumbersAndShowIt.java
        // Best approch start
        List<Integer> firstEvenThenOddSortNumbersBestApproch = Arrays.stream(arrEvenOddOrderInput)
                .boxed()
                .sorted(
                        Comparator.comparingInt(
                                        (Integer num) -> num % 2
                                )
                                .thenComparing(
                                        Integer::intValue
                                )
                )
                .toList();
        System.out.println("Best approch firstEvenThenOddSortNumbersBestApproch:: " + firstEvenThenOddSortNumbersBestApproch);
        // Best approch end

        // Q33: Write a Java program to count the number of words present in a string
        // input String stringWord = "Sharma is a good player and he is so punctual";
        // op: 10
        // refer com.mane.umakant.java.interviewQuestions.CountTheNumberOfWordsPresentInString.java
        String stringWord = "Sharma is a good player and he is so punctual";
        int count_the_number_of_words_present_in_a_string1 = stringWord.trim().split("\\s+").length;
        System.out.println("count_the_number_of_words_present_in_a_string1:: " + count_the_number_of_words_present_in_a_string1);

        // Q34: Write a program to find common characters from given two string
        // input 123456, 162, 21 op: common chars from first 2 string:1,2,6 & from all 3 is: 1,2
        // refer com.mane.umakant.java.interviewQuestions.FindCommonCharactersFromGivenTwoString.java
        // Q 25 and Q 33 is same.
        /*String first = "123456";
        String second = "162";
        String third = "21";
        boolean containsAllChars = false;
        List<Character> commonCharacters = new ArrayList<>();
        for (char ch : first.toCharArray()) {
            if (second.indexOf(ch) != -1 && third.indexOf(ch) != -1) {
                containsAllChars = true;
                commonCharacters.add(ch);
            }
        }
        System.out.println(commonCharacters); // common chars is only 4
        System.out.println("Contains common characters: " + containsAllChars); // Yes because of 4
       */

        //Q35: Write a program to find reverse of given string
        // input String start = "123456";
        // OP
        //reverseStringJava7: 654321
        // refer com.mane.umakant.java.interviewQuestions.ReverseString.java
        String stringStart = "123456";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringStart.length(); i++) {
            stringBuilder.append(stringStart.charAt(stringStart.length() - i - 1));
        }
        System.out.println("Reverse string:: " + stringBuilder);

        //Q36: Write a program to find min and max number from given integer" // op: Optional[1] Optional[9]
        // int number1 = 3912578;
        // refer com.mane.umakant.java.interviewQuestions.MinMaxNumberFromGivenInteger.java
        int numberMinMax = 3912578;
        int numberMinMaxJava8 = numberMinMax;
        // using java7 logic
        // Initialize min and max with extreme values
        //  int min = 9;  // Maximum possible digit
        //  int max = 0;  // Minimum possible digit
        int min = Integer.MAX_VALUE;  // Maximum possible digit
        int max = Integer.MIN_VALUE;  // Minimum possible digit
        // Iterate through each digit without using predefined functions
        if (numberMinMax == 0) {
            min = max = 0;
        } else {
            while (numberMinMax > 0) {
                int digit = numberMinMax % 10; // Extract the last digit
                // Update min if the current digit is smaller
                if (digit < min) {
                    min = digit;
                }
                // Update max if the current digit is larger
                if (digit > max) {
                    max = digit;
                }
                // Remove the last digit from the number
                numberMinMax = numberMinMax / 10;
            }
        }
        // Output the results
        System.out.println("Min Digit: " + min);
        System.out.println("Max Digit: " + max);
        // Java 8
        int minJava8 = String.valueOf(numberMinMaxJava8)
                .chars()
                // .map(ch -> ch - '0') // It return actual digit number
                // .map(ch->Character.getNumericValue(ch))
                .map(Character::getNumericValue)
                .min()
                .orElseThrow();
        System.out.println(minJava8);
        int maxJava8 = String.valueOf(numberMinMaxJava8)
                .chars()
                .map(Character::getNumericValue)
                .max()
                .orElseThrow();
        System.out.println(maxJava8);

        // Q37 : find occurence of each element from given array
        // input int arr[] = { 1, 90000, 9, 455, 90000, 22, 999, 455, 22, 90000 };
        // op: {90000=3, 1=1, 22=2, 999=1, 455=2, 9=1}
        int inputArr[] = {1, 90000, 9, 455, 90000, 22, 999, 455, 22, 90000};
        // refer com.mane.umakant.java.interviewQuestions.OccurenceOfEachElementFromGivenArray.java
        Map<Integer, Long> map1Q37 = Arrays.stream(inputArr)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
        System.out.println(map1Q37);
        Map<Integer, Integer> map2Q37 = new HashMap<>();
        for (int num : inputArr) {
            map2Q37.put(num, map2Q37.getOrDefault(num, 0) + 1);
        }
        System.out.println(map2Q37);
        /*
         Q37  and Q1 is almost similar
        String input = "ilovejavatechie";
        Map<Character, Long> op1 = input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
        System.out.println(op1);
        Map<Character, Integer> map1 = new HashMap<>();
        for (char ch : input.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map1);
         */

        //Q38 : find 2nd highest odd occured number");
        int[] arrIntviewQue = {13, 13, 13, 13, 13, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 11, 11, 11, 11, 11, 11, 11};
        // op:  occurrenceMap: {1=1, 3=3, 4=3, 5=3, 11=7, 13=5}
        // After decending sort odd occured number : 11=7, 13=5, 3=3, 4=3, 5=3, 1=1
        // .skip(1) then .findFirst() is return : 13=5 e.g. 13(key) is output
        /*
        Odd occurrences are:
        1 -> 1
        3 -> 3
        4 -> 3
        5 -> 3
        11 -> 7
        13 -> 5
         */
        //op: The 2nd highest odd occurred number is: 13
        // refer com.mane.umakant.java.interviewQuestions.SecondHighestOddOccuredNumber.java
        Map<Integer, Long> occurrenceMap = Arrays.stream(arrIntviewQue)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                ).entrySet().stream()
                .filter(
                        entry -> entry.getValue() % 2 != 0
                )
                .collect(
                        Collectors.toMap(
                                Entry::getKey,
                                Entry::getValue
                        )
                );
        System.out.println("occurrenceMap:: " + occurrenceMap);
        Optional<Integer> second_highest_odd_occurred_number = Arrays.stream(arrIntviewQue)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                ).entrySet().stream()
                .filter(
                        entry -> entry.getValue() % 2 != 0
                )
                .sorted(
                        Comparator.comparing(Entry<Integer, Long>::getValue).reversed()
                )
                .map(Entry::getKey)
                .skip(1)
                .findFirst();
        System.out.println("second_highest_odd_occurred_number:: " + second_highest_odd_occurred_number.get());

        // Q 39 input as: int arr[]= {10,15,12,11,18,20};
        // Exp output: if we provide input as 15
        // then find below 15 element from given int array
        // Conditions: 1) Use only one for loop 2) Dont use any existing API methods.
        int arrSyne[] = {10, 15, 12, 11, 18, 20, 15};
        int inputValue = 15;    // op: Optional[12]
        int previousInputValue = 0;
        for (int i = 1; i < arrSyne.length; i++) {
            if (arrSyne[i] < inputValue) {
                if (previousInputValue < arrSyne[i]) {
                    previousInputValue = arrSyne[i];
                }

            }
        }
        // same logic but in differnt way of coding style
        int previous = Integer.MIN_VALUE;
        for (int num : arrSyne) {
            if (num < inputValue && num > previous) {
                previous = num;
            }
        }
        if (previous == Integer.MIN_VALUE) {
            System.out.println("Not Found");
        } else {
            System.out.println("Q38: previousInputValue using java7:: " + previousInputValue);
        }
        // using Java8
        Optional<Integer> previousInputValue1 = Arrays.stream(arrSyne)
                .boxed()
                .filter(arrayData -> arrayData < inputValue)
                .max(Integer::compareTo);
        System.out.println("previousInputValue1 using java8:: " + previousInputValue1);

        // Q 40 Calculate sum of all numbers present in a string. Asked by Epam company
        String inputEpam = "12abc20yz8";
        //Output: 12+20+8=40
        // Best Approch
        int sumBestApproch = 0;
        int numberQ40 = 0;
        for (char ch : inputEpam.toCharArray()) {
            if (Character.isDigit(ch)) {
                /* Mathematical approach.
                No String objects are created.
                Only integer calculations are performed.
                This is:
                Faster ✔
                Uses less memory ✔
                Preferred in coding interviews ✔
                 */
                // number = number * 10 + (ch - '0');
                numberQ40 = numberQ40 * 10 + Character.getNumericValue(ch);
            } else {
                sumBestApproch = sumBestApproch + numberQ40;
                numberQ40 = 0;
            }
        }
        sumBestApproch = sumBestApproch + number;
        System.out.println("sumBestApproch:: " + sumBestApproch);
        //  Approch 1:
        int sumQ40 = 0;
        String digitQ40 = "0";
        int digitNumber = 0;
        //Output: 12+20+8=40
        for (char ch : inputEpam.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Each concatenation creates a new String object because String is immutable. Many temporary objects are created. Avoid it.
                // digit = digit + ch;
                digitQ40 = digitQ40 + ch;
            } else {
                sumQ40 = sumQ40 + Integer.parseInt(digitQ40);
                digitQ40 = "0";
            }
        }
        sumQ40 = sumQ40 + Integer.parseInt(digitQ40);
        System.out.println("sum of all numbers:: " + sumQ40);
        //  Approch 2:
        int sum2 = 0;
        String tempNumber = "0";
        for (int i = 0; i < inputEpam.length(); i++) {
            if (Character.isDigit(inputEpam.charAt(i))) {
                // System.out.println(inputEpam.charAt(i));
                tempNumber = tempNumber + inputEpam.charAt(i);
            } else {
                sum2 = sum2 + Integer.parseInt(tempNumber);
                tempNumber = "0";
            }
        }
        sum2 = sum2 + Integer.parseInt(tempNumber);
        System.out.println("sum of all numbers:: " + sum2);

        // Using Java 8
        // Java 8 Approch 1: Approach 1 (Recommended Java 8) - Using Regex + Stream
        int sumRegixStream1 = Arrays.stream(input.split("[^0-9]+"))
                .filter(stringValue -> !stringValue.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println("sum of all numbers:: :: " + sumRegixStream1);
        // Java 8 Approach 2 - Using Pattern (Java 8)
        Pattern pattern = Pattern.compile("\\d+");
        int sumPattern = pattern.matcher(inputEpam)
                .results()
                .mapToInt(match -> Integer.parseInt(match.group()))
                .sum();
        System.out.println("sum of all numbers:: :" + sumPattern);
        IntSummaryStatistics summaryStatistics = Pattern.compile("\\d+").matcher("12abc20yz8")
                .results()
                .mapToInt(digit -> Integer.parseInt(digit.group()))
                .summaryStatistics();
        System.out.println("getSum: " + summaryStatistics.getSum());
        System.out.println("getAverage: " + summaryStatistics.getAverage());
        System.out.println("getCount: " + summaryStatistics.getCount());
        System.out.println("getMax: " + summaryStatistics.getMax());
        System.out.println("getMin: " + summaryStatistics.getMin());

        // Q 41 Find 3rd highest number from below string. String value = "56834901"; // op:  6
        // Asked by Opus Tech 28-01-2026
        /*
        1️⃣ c - '0' ✅ (Most Standard / Preferred)
        .map(c -> c - '0')
        Why it works
        Characters '0'–'9' are consecutive in ASCII/Unicode
        '5' - '0' = 5
        Pros
        ✔ Fast (no method calls)
        ✔ Clean & readable
        ✔ Interview standard
        ✔ No object creation

        Cons
        ❌ Works only for numeric characters
        👉 Best choice for performance + interviews
        2️⃣ Character.getNumericValue(c) ✅ (Safe & Clear)
        .map(c -> Character.getNumericValue(c))
        Pros
        ✔ Very readable
        ✔ Handles more than just '0'–'9' (e.g. Unicode digits)

        Cons
        ❌ Slightly slower
        ❌ Overkill for simple digit strings
        👉 Good when input source is unknown
        3️⃣ Integer.parseInt(String.valueOf((char)c)) ❌ (Avoid)
        .map(c -> Integer.parseInt(String.valueOf((char) c)))
            Cons
        ❌ Creates String object
        ❌ Slow
        ❌ Verbose
        👉 Not recommended in interviews or production
        4️⃣ Using toCharArray() instead of chars() (Classic way)
        for (char c : value.toCharArray()) {
            int digit = c - '0';
        }
        Pros
        ✔ Very readable
        ✔ Beginner friendly
        👉 Often preferred in non-stream codebases
        5️⃣ Using split("") ❌ (Worst way)
        Arrays.stream(value.split(""))
        .mapToInt(Integer::parseInt)
        Cons
        ❌ Regex overhead
        ❌ Creates many objects
        👉 Never use in interviews

         */
        String value = "56834901"; // op:  6
        int thirdHighest = value.chars()// returns an IntStream of ASCII/Unicode values, not the actual digits.
                .map(c -> c - '0')// convert the ASCII values into numeric digits.
                .distinct()
                .boxed()
                .sorted(Collections.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("record not found")
                );
        System.out.println("thirdHighest:: " + thirdHighest);
        // without stream means Java7

        List<Integer> digitList = new ArrayList();
        // Step 1: Convert characters to digits
        int[] digits = new int[value.length()];
        for (int i = 0; i < value.length(); i++) {
            digitList.add(value.charAt(i) - '0');
            digits[i] = value.charAt(i) - '0';   // STANDARD way
        }
        // Collections.sort(digitList,Collections.reverseOrder());
        // Step 2: Sort
        Arrays.sort(digits);

        // Step 3: Find 3rd highest (from end)
        int thirdHighestChatGpt = digits[digits.length - 3];
        int thirdHighestJava7 = digitList.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("record not found")
                );


        System.out.println("thirdHighestChatGpt:: " + thirdHighestChatGpt + " thirdHighestJava7:: " + thirdHighestJava7);

        // Q 42 Write a program to print all combination of the given String ABC.
        // Ex - ABC: ABC, BCA, CAB, CBA, BAC, ACB
        /*
        Combination vs Permutation:
        Combination: Order does not matter.
        Example:
        ABC
        AB
        AC
        BC
        A
        B
        C
        ABC
        Number of combinations:2^n - 1
        For "ABC":
        A
        B
        C
        AB
        AC
        BC
        ABC
        Total = 7

        Permutation:Order matters.
        For "ABC":
        ABC
        ACB
        BAC
        BCA
        CAB
        CBA
        Total =3! = 6
        Your expected output is Permutation, not Combination.
         */
        // Asked by ZomosoLab 09-02-2026
        String inputStringFroCombination = "ABC";
        List<String> combo = new ArrayList<>();
        for (int i = 0; i < inputStringFroCombination.length(); i++) {
            for (int j = 0; j < inputStringFroCombination.length(); j++) {
                for (int k = 0; k < inputStringFroCombination.length(); k++) {
                    if (i != j && j != k && i != k) {
                        // System.out.println("" + s.charAt(i) + s.charAt(j) + s.charAt(k));
                        combo.add("" + inputStringFroCombination.charAt(i) + inputStringFroCombination.charAt(j) + inputStringFroCombination.charAt(k));
                    }
                }

            }
        }

        System.out.println(combo);
        List<String> comboJava8 = IntStream.range(0, inputStringFroCombination.length()).boxed()
                .flatMap(i -> IntStream.range(0, inputStringFroCombination.length()).boxed()
                        .flatMap(j -> IntStream.range(0, inputStringFroCombination.length()).filter(k -> i != j && j != k && i != k)
                                .mapToObj(k -> "" + inputStringFroCombination.charAt(i) + inputStringFroCombination.charAt(j) + inputStringFroCombination.charAt(k))

                        )).collect(Collectors.toList());
        System.out.println(comboJava8);
        /*
        2️⃣ Hardcoded for length = 3 (Important to mention)
            Your logic works only for 3 characters.
            👉 This is OK if you SAY THIS clearly:
            “This solution is for fixed-length strings like ABC.
            For dynamic length, recursion or next-permutation is required.”
            That honesty scores points.
         */
        // refer package com.mane.umakant.java.interviewQuestions.StringPermutationsRecursive;

        // Q 43 What is output of below program:
        // Asked by LtiMindtree 12-02-2026
        // More details visit package com.mane.umakant.java.interviewQuestions.LtiMindtree
        /*
            public class B {
                B b = new B();
                public int show() {
                    return (true ? null : 0);
                }
                public static void main(String[] args) {
                    B b = new B();
                    b.show();
                }
            }
          ANS:
          🎯 Final Conclusion
            Scenario	Output
            With B b = new B(); inside class	💥 StackOverflowError
            Without it	💥 NullPointerException
        */

        // Q 44
        {
       /* Q 44 input as below:
      input string as:  "Dog","Apple","Java Stream","Hello World","Spring Boot", "Core Java Tutorial", "Advanced Java Concepts".

        Write a Java 8 program to:
        Requirement:
        1-  Sort by number of words (ascending). e.g. Sort the sentences based on the number of words in each sentence (ascending order).
        2-  If the number of words is the same, sort alphabetically. e.g. If two sentences have the same number of words, sort them alphabetically
        Explanation of below code:
        Step 1: Stream is created
        input.stream()
        Current stream:
        Dog
        Apple
        Java Stream
        Hello World
        Spring Boot
        Core Java Tutorial
        Advanced Java Concepts

        Nothing is sorted yet.
        -------------
        Step 2: comparingInt() executes
        Comparator.comparingInt(
                (String s) -> s.trim().split("\\s+").length
        )
        For every sentence, Java executes
        s.trim().split("\\s+").length
        Let's calculate.
        Sentence	split() Result	Length
        Dog	["Dog"]	1
        Apple	["Apple"]	1
        Java Stream	["Java","Stream"]	2
        Hello World	["Hello","World"]	2
        Spring Boot	["Spring","Boot"]	2
        Core Java Tutorial	["Core","Java","Tutorial"]	3
        Advanced Java Concepts	["Advanced","Java","Concepts"]	3
        Internally Java now sees
        Dog                     -> 1
        Apple                   -> 1
        Java Stream             -> 2
        Hello World             -> 2
        Spring Boot             -> 2
        Core Java Tutorial      -> 3
        Advanced Java Concepts  -> 3
        Think of it like attaching a temporary key to every sentence.
        ---------
        Step 3: Sort using the first comparator
        Java sorts only by the integer (word count).
        Result becomes
        Dog
        Apple
        Java Stream
        Hello World
        Spring Boot
        Core Java Tutorial
        Advanced Java Concepts
        Notice something important.
        Inside each group (same word count), the order is not guaranteed to be alphabetical.
        Java only knows
        1 word
        2 words
        3 words
        It does not compare the actual text yet.
        Visual Representation
        After comparingInt()
        ┌──────────────────────────┬──────┐
        │ Dog                      │ 1    │
        ├──────────────────────────┼──────┤
        │ Apple                    │ 1    │
        ├──────────────────────────┼──────┤
        │ Java Stream              │ 2    │
        ├──────────────────────────┼──────┤
        │ Hello World              │ 2    │
        ├──────────────────────────┼──────┤
        │ Spring Boot              │ 2    │
        ├──────────────────────────┼──────┤
        │ Core Java Tutorial       │ 3    │
        ├──────────────────────────┼──────┤
        │ Advanced Java Concepts   │ 3    │
        └──────────────────────────┴──────┘

        Java has completed the first comparison.
        ---------
        Step 4: thenComparing() starts
        Now Java checks
        "Do two elements have the same word count?"
        If NO
        Nothing happens.
        If YES
        Apply the second comparator.
        First Group
        Dog
        Apple
        Both have
        1 word
        Now Java calls
        Comparator.naturalOrder()
        Equivalent to
        String::compareTo
        Comparison
        Dog.compareTo("Apple")
        Alphabetically
        Apple
        Dog
        So Java swaps them.
        Group becomes
        Apple
        Dog
        Second Group
        Current group
        Java Stream
        Hello World
        Spring Boot
        All have
        2 words
        Now alphabetical comparison starts.
        Java compares
        Java Stream
        Hello World
        Spring Boot
        Alphabetically
        Hello World
        Java Stream
        Spring Boot
        Third Group
        Current
        Core Java Tutorial
        Advanced Java Concepts
        Both have
        3 words
        Alphabetically
        Advanced Java Concepts
        Core Java Tutorial
        -------
        Final Output
        Apple
        Dog
        Hello World
        Java Stream
        Spring Boot
        Advanced Java Concepts
        Core Java Tutorial
        */
            List<String> inputQ44 = Arrays.asList(
                    "Dog",  // length:1
                    "Apple", // length:1
                    "Java Stream", // length:2
                    "Hello World", // length:2
                    "Spring Boot", // length:2
                    "Core Java Tutorial", // length:3
                    "Advanced Java Concepts"); // length:3
            List<String> sortByNumberOfWordsThenAlphabetically = inputQ44.stream()
                    .sorted(
                            Comparator
                                    .comparingInt(
                                            (String words) -> words.trim().split("\\s+").length
                                    )
                                    .thenComparing(Comparator.naturalOrder())
                    )
                    .toList();
            System.out.println("sortByNumberOfWordsThenAlphabetically:: " + sortByNumberOfWordsThenAlphabetically);

        }

        // Q 45 if array contains record more than 1 time then return value true otherwise return value false.
        int[] numbersQ45 = {1, 2, 1, 4};
        // Approch: 1
        Set<Integer> visitedSet = new HashSet();
        boolean flagVisitedSet = false;
        for (int num : numbersQ45) {
            if (!visitedSet.add(num)) {
                flagVisitedSet = true;
                break;
            } else {
                flagVisitedSet = false;
            }
        }
        System.out.println("flagVisitedSet:: " + flagVisitedSet);

        // Approch: 2
        boolean flagOnSize = Arrays.stream(numbersQ45)
                .boxed()
                .collect(Collectors.toSet())
                .size() != numbersQ45.length;
        System.out.println("flagOnSize:: " + flagOnSize);
        // Approch: 3

        long countOnGroupingBy = Arrays.stream(numbersQ45)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                ).entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .count();
        if (countOnGroupingBy != 0) {
            System.out.println("true");
        } else {
            System.out.println("fasle");
        }

        // Q 46: find second repeated character from string
        String name = "programming"; // op: g
        // Best Solution for Your Expected Output
        Optional<Character> second_repeated_character_from_string_java8 = name.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println("Q 46 second_repeated_character_from_string_java8:: " + second_repeated_character_from_string_java8);
        // Java 7
        Map<Character, Integer> mapQ46 = new LinkedHashMap<>();
        for (char ch : name.toCharArray()) {
            mapQ46.put(ch, mapQ46.getOrDefault(ch, 0) + 1);
        }
        int repeated = 0;
        Character second_repeated_character_from_string_java7 = null;
        for (Map.Entry<Character, Integer> entry : mapQ46.entrySet()) {
            if (entry.getValue() > 1) {
                repeated++;
                if (repeated == 2) {
                    second_repeated_character_from_string_java7 = entry.getKey();
                    break;
                }
            }
        }
        System.out.println("Q 46 second_repeated_character_from_string_java7:: " + second_repeated_character_from_string_java7);

        // Q 47: input as below and output show like 1,2,3,4,5,6,9,8,7,6,5,4
        // input: [[1,2,3], [4,5,6], [9,8,7], [6,5,4]]
        List<List<Integer>> inputList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(9, 8, 7),
                Arrays.asList(6, 5, 4)
        );
        List<Integer> flatternData = inputList.stream()
                .flatMap(innerList -> innerList.stream())
                .toList();
        System.out.println("Q: 46:: " + flatternData);

        // Q 48: find duplicate from below input String name = " umakant mane ";
        String nameWithDupChar = "umakant mane";
        List<Character> dupChars = nameWithDupChar.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')  // ignore space
                .collect(
                        Collectors.groupingBy(Function.identity()
                                , LinkedHashMap::new, Collectors.counting()
                        )
                )
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Q 47:: " + dupChars);

        // Q 49: immuttable
        // refer package com.mane.umakant.java.interviewQuestions.immutable package

        // Q 50: comparable
        // refer package com.mane.umakant.java.interviewQuestions.testComparable

        // Q 51: Find the output of below program. Its related to static.
        // refer ->package com.mane.umakant.java.interviewQuestions.staticTest.Mindtree and Note file

        // Q52: Reverse a Map using Java 8 Streams"
        // Input Map<String,Integer> as below.{Umakant=101}
        // Exp op: Map<Integer,String> e.g. {101=Umakant}
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 101);
        map.put("B", 101);
        Map<Integer, String> expOutputMap = map.entrySet().stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getValue,
                                Map.Entry::getKey,
                                (oldValue, newValue) -> newValue
                        )
                );
        System.out.println("Q 51:: " + expOutputMap);
        // Q53:
		/* Write a function to find the longest common prefix string amongst an array of strings.
		If there is no common prefix, return an empty string "".
		Example 1
		Input:
		strs = ["flower","flow","flight"]
		Output:
		"fl" */
        String[] input1 = {"flower", "flow", "flight"};
        List<String> input2 = Arrays.asList("flower", "flow", "flight");
        String prefix1 = input1[0];
        for (int i = 0; i < input1.length; i++) { // here we use length
            while (!input1[i].startsWith(prefix1)) {
                prefix1 = prefix1.substring(0, prefix1.length() - 1);
            }
        }
        System.out.println("comms prefix1:: " + prefix1);

        String prefix2 = input2.get(0);
        for (int i = 0; i < input2.size(); i++) { // here we use size
            while (!input2.get(i).startsWith(prefix2)) {
                prefix2 = prefix2.substring(0, prefix2.length() - 1);
            }
        }
        System.out.println("comms prefix2:: " + prefix2);
        // Note: Also you can refer below class: com.mane.umakant.java.interviewQuestions.LongestCommonPrefixString

        // Q54:
        // FunctionalInterface demo code: refer-> com.mane.umakant.java.interviewQuestions.CustomFunctionalInterfaceDemo

        // Q55:
        // Kadane's Algorithm
        // Q: Given an integer array, find the contiguous subarray that has the maximum sum, and return the maximum sum.
        // or Find Maximum Subarray Sum
        int[] inputSubArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // exp out: 6
        int currentSumSubArray = inputSubArray[0];
        int maxSumSubArray = inputSubArray[0];

        for (int i = 1; i < inputSubArray.length; i++) {

            // Decide whether to start a new subarray
            // or continue the existing subarray
            if (inputSubArray[i] > currentSumSubArray + inputSubArray[i]) {
                currentSumSubArray = inputSubArray[i];
            } else {
                currentSumSubArray = currentSumSubArray + inputSubArray[i];
            }

            // Update maximum sum
            if (currentSumSubArray > maxSumSubArray) {
                maxSumSubArray = currentSumSubArray;
            }
        }

        System.out.println("Maximum Subarray Sum: " + maxSumSubArray);

        // Q55: Percistance
        // convert String input ="123" into int result=123
        String persistentInput = "123";
        int persistentInputDigit = 0;
        int persistentInputResult = 0;
        for (char persistentCh : persistentInput.toCharArray()) {
            persistentInputDigit = persistentCh - '0';
            persistentInputResult = persistentInputResult * 10 + persistentInputDigit;
        }
        System.out.println(persistentInputResult);

    }

}
