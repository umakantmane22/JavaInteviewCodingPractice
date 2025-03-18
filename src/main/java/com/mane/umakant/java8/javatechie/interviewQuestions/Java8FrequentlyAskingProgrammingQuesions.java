package com.mane.umakant.java8.javatechie.interviewQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8FrequentlyAskingProgrammingQuesions {
    public static void main(String args[]) {
        // Q1- Java program to count the occurrence of each character in a string
        // input: ilovejavatechie, output {a=2, c=1, t=1, e=3, v=2, h=1, i=2, j=1, l=1, o=1}
        String input = "ilovejavatechie";
        // Count the occurrence of each character
        Map<Character, Long> characterCount = input.chars() // Convert string to IntStream of characters
                .mapToObj(c -> (char) c)                   // Convert each int to char
                .collect(Collectors.groupingBy(            // Group by each character
                        Function.identity(),               // Use the character itself as the key
                        Collectors.counting()              // Count occurrences of each character
                ));

        // Print the occurrence of each character
        // characterCount.forEach((character, count) ->
        //       System.out.println("Character: " + character + ", Occurrence: " + count));
        System.out.println("Q1:: characterCount:: " + characterCount);

        // Q2- Java program to find all duplicates elements from a given string
        // String input = "ilovejavatechie"; [a, e, v, i]
        List<Map.Entry<Character, Long>> duplicatesElementsWithCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toList());
        System.out.println("Q2:: duplicatesElementsWithCount:: " + duplicatesElementsWithCount);
        Set<Character> duplicatesElements = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("duplicatesElements:: " + duplicatesElements);

        // Q3-  find all uniqueElement elements from a given string");
        // iString input = "Ilovejavatechie"; output  [c, t, h, j, l, o]
        Set<Map.Entry<Character, Long>> uniqueElementWithCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .collect(Collectors.toSet());
        System.out.println("Q3:: uniqueElementWithCount:: " + uniqueElementWithCount);
        Set<Object> uniqueElement = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(x -> x.getKey())
                .collect(Collectors.toSet());
        System.out.println("uniqueElement:: " + uniqueElement);

        // Q4: find first non repeated character from a given string
        // e.g. String input = "ilovejavatechie";  output:: 0
        List<Character> first_non_repeated_characterWithCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy
                        (Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Q4:: first_non_repeated_characterWithCount:: " + first_non_repeated_characterWithCount);
        Optional<Character> first_non_repeated_character = input.chars() // Convert the string to IntStream of characters
                .mapToObj(c -> (char) c)// Convert each int to char
                .collect(Collectors.groupingBy( // Group by character and count occurrences
                        Function.identity(),
                        LinkedHashMap::new, // Maintain insertion order
                        Collectors.counting()))// Count occurrences of each character
                .entrySet().stream()// Convert the map to a stream
                .filter(entry -> entry.getValue() == 1)// Filter for characters that appear only once
                // .map(entry -> entry.getKey())// Get the character (key)
                .map(Map.Entry::getKey)                          // Get the character (key)
                .findFirst(); // Get the first non-repeated character
        System.out.println("first_non_repeated_character:: " + first_non_repeated_character);

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

        // Q6: find second highest number from given array.
        // input as int[] numbers={5,9,11,2,8,21,1}  op: 11
        int[] numbers = {5, 9, 11, 2, 8, 21, 1};
        // Find the second highest number
        Optional<Integer> secondHighestNumber = Arrays.stream(numbers)               // Convert the array to an IntStream
                .boxed()                                         // Convert IntStream to Stream<Integer>
                .sorted((a, b) -> b - a)                         // Sort in descending order
                .distinct()                                      // Remove duplicates
                .skip(1)                                         // Skip the highest number
                .findFirst();                                   // Find the second highest number

        System.out.println("Q6:: " + secondHighestNumber);

        // find second highest and lowest number. op: secHigh: 30, secLow: 0
        List<Integer> maxMinNumbers20 = Arrays.asList(-1, 0, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
        int secHigh = maxMinNumbers20.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
        System.out.println("secHigh:: " + secHigh);
        int secHigh1 = maxMinNumbers20.stream()
                .sorted((a, b) -> b - a)
                .distinct().skip(1).findFirst().get();
        System.out.println("secHigh1:: " + secHigh1);

        int secLow = maxMinNumbers20.stream()
                .sorted().distinct().skip(1).findFirst().get();
        System.out.println("secLow:: " + secLow);
        int secLow1 = maxMinNumbers20.stream()
                .sorted((a, b) -> a - b).distinct().skip(1).findFirst().get();
        System.out.println("secLow1:: " + secLow1);

        // Variables to hold the highest and second highest numbers
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        // Iterate through the list
        for (int number : maxMinNumbers20) {
            // If the current number is greater than the highest, update both highest and second highest
            if (number > highest) {
                secondHighest = highest;
                highest = number;
            }
            // If the current number is less than the highest but greater than second highest
            else if (number > secondHighest && number < highest) {
                secondHighest = number;
            }
        }
        // Check if secondHighest is updated
        if (secondHighest == Integer.MIN_VALUE) {
            System.out.println("There is no second highest number.");
        } else {
            System.out.println("Second highest number: " + secondHighest);
        }
        // using java 7
        Integer[] arr = {1, 2, 5, 6, 3, 2};
        // OP: 5
        int temp = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        int secodHighestNumJava7 = arr[arr.length - 2];
        System.out.println("secodHighestNumJava7:: " + secodHighestNumJava7);

        // Q7: find largest string from given array
        // input: String[] strArray={"java","techie","springboot","microservices"}
        // op:: microservices

        String[] strArray = {"java", "techie", "springboot", "microservices"};
        // Initialize a variable to store the largest string
        String largestString = "";
        // Iterate through the array
        for (String str : strArray) {
            // Compare the length of the current string with the largest string
            if (str.length() > largestString.length()) {
                largestString = str;
            }
        }
        // Output the largest string
        System.out.println("Q7:: largestString: " + largestString);
        // or
        // Find the largest string (based on length) using Java 8 streams
        String largestString1 = String.valueOf(Arrays.stream(strArray)
                        .max((str1, str2) -> Integer.compare(str1.length(), str2.length())))  // Compare by length
                .toString();
        System.out.println("largestString1: " + largestString1);
        // or
        String largestString2 = Arrays.stream(strArray)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
        System.out.println("llargestString2:: " + largestString2);

        // Q8: Find all element from array who start with 1
        // reuse int[] numbers= {5,9,11,2,8,21,1}; op: [11, 1]
        List<Integer> all_element_from_array_who_start_with_1 = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .filter(s -> s.startsWith("1"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
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
        // or
        String joinWithDelimiter = String.join("-", nos);
        System.out.println("join_given_string_with1-: " + joinWithDelimiter);

        // Q 10: skip and limit example(2-9)
        // print value from 3 to 8
        List<Integer> value_from_3_to_8 = IntStream.rangeClosed(2, 8).boxed().skip(1).limit(8)
                // .forEach(System.out::println);
                .collect(Collectors.toList());
        System.out.println("Q10:: value_from_3_to_8: " + value_from_3_to_8);

        // Q11 find sum of all numbers from given int arraylist
        // input: List<Integer> list=Arrays.asList(1,2,3,4,5); OP: 15
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // Using stream and reduce to calculate the sum
        int sum_of_all_numbers_from_given_int_arraylist = list.stream()
                .reduce(0, Integer::sum);

        System.out.println("Q11: sum_of_all_numbers_from_given_int_arraylist:: " + sum_of_all_numbers_from_given_int_arraylist);
        //or
        int sum_of_all_numbers_from_given_int_arraylist1 = list.stream().reduce((a, b) -> a + b).get();
        System.out.println("sum_of_all_numbers_from_given_int_arraylist1: " + sum_of_all_numbers_from_given_int_arraylist1);

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
                .mapToInt(i -> i).average().getAsDouble();
        System.out.println("average_of_given_int_array1:: " + average_of_given_int_array1);

        // Q13 find square of each element take value >100 and find average.
        // e.g. input: List<Integer> list1=Arrays.asList(10,20,30,15);
        // 100,400,900,225
        // 400,900,225
        // 1525/3=508.33333

        List<Integer> list1 = Arrays.asList(10, 20, 30, 15);
        double square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average = list1.stream()
                .map(i -> i * i)
                .filter(i -> i > 100)
                .mapToInt(i -> i).average().getAsDouble();
        System.out.println("Q13: square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average:: " + square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average);
        // or
        OptionalDouble square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average1 = list1.stream()
                .map(x -> x * x)                   // Square each element
                .filter(x -> x > 100)               // Filter values greater than 100
                .mapToInt(Integer::intValue)        // Convert back to int
                .average();                         // Calculate the average
        if (square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average1.isPresent()) {
            System.out.println("square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average1:: " + square_of_each_element_then_filter_those_greater_than_100_then_calculate_the_average1);
        }

        // Q14 find odd and even numbers op: oddNumbers:: [11, 3, 45, 67, 9, 87] evenNumbers:: [2, 90, 8, 2, 0]
        List<Integer> oddEvenNumbers = Arrays.asList(11, 2, 3, 45, 67, 9, 90, 87, 8, 2, 0);
        List<Integer> oddNumbers = oddEvenNumbers.stream()
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toList());
        List<Integer> evenNumbers = oddEvenNumbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Q14: oddNumbers:: " + oddNumbers + " evenNumbers:: " + evenNumbers);
        Map<Boolean, List<Integer>> partitioned = oddEvenNumbers.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
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
                .map(x -> x + "")
                .filter(x -> x.startsWith("2") || x.startsWith("-2"))
                .collect(Collectors.toList());
        System.out.println("Q15: numbers_which_start_with_two:: " + numbers_which_start_with_two);
        // or
        List<Integer> numbers_which_start_with_two2 = numbers1.stream()
                .filter(num -> String.valueOf(num).startsWith("2"))  // Convert number to string and check if it starts with '2'
                .collect(Collectors.toList());
        System.out.println("numbers_which_start_with_two2:: " + numbers_which_start_with_two2);
        // or
        List<Integer> numbers_which_start_with_two3 = numbers1.stream().map(n -> n + "")
                .filter(n -> n.startsWith("2"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println("numbers_which_start_with_two3:: " + numbers_which_start_with_two3);

        // Q16 find duplicate elements [1, 2, 3, 10, 30]
        List<Integer> elementsList = Arrays.asList(1, 3, 10, 20, 30, 15, 1, 13, 2, 2, 10, 30, 19, 3);
        List<Integer> duplicate_elements = elementsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Q16: duplicate_elements:: " + duplicate_elements);
        // or
        Set<Integer> secondWay = elementsList.stream()
                .filter(e -> Collections.frequency(elementsList, e) > 1)
                .collect(Collectors.toSet());
        System.out.println("duplicate_elements1:: " + secondWay);

        Set<Integer> dupNum = new HashSet<>();
        Set<Integer> thirsWay = elementsList.stream()
                .filter(e -> !dupNum.add(e)).collect(Collectors.toSet());
        System.out.println("duplicate_elements3:: " + thirsWay);

        // Q17 find max and min // op Optional[40] min:: Optional[-1]
        List<Integer> maxMinNumbers = Arrays.asList(-1, 0, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
        // Find the maximum value
        Optional<Integer> max = maxMinNumbers.stream()
                .max(Comparator.naturalOrder());  // Using natural order to find the max

        // Find the minimum value
        Optional<Integer> min = maxMinNumbers.stream()
                .min(Comparator.naturalOrder());  // Using natural order to find the min
        System.out.println("Q17: max:: "+max+" min:: "+min);

        // Q18 sort asc and desc order if given Integer array
        //List<Integer> maxMinNumbers = Arrays.asList(-1, 0, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
        List<Integer>ascSorting=maxMinNumbers.stream()
                .sorted()// Natural ordering (ascending)
                .collect(Collectors.toList());
        List<Integer>descSorting=maxMinNumbers.stream()
                .sorted((a,b)->b-a)
                .collect(Collectors.toList());
        System.out.println("Q18: ascSorting:: "+ascSorting+" descSorting:: "+descSorting);
    }

}
