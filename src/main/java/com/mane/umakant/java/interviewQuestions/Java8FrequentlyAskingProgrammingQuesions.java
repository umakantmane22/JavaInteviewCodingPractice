package com.mane.umakant.java.interviewQuestions;

import java.util.*;
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

        // Another way which I have habitual

        Map<String, Long> characterCountString = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Q1:: characterCountString:: " + characterCountString);


        // Q2- Java program to find all duplicates elements from a given string
        // String input = "ilovejavatechie";  output [a, e, v, i]
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
        Set<Character> uniqueElement = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(x -> x.getKey())
                .collect(Collectors.toSet());
        System.out.println("uniqueElement:: " + uniqueElement);

        // Q4: find first non repeated character from a given string
        // e.g. String input = "ilovejavatechie";  output:: l
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
        // refer com.mane.umakant.java.interviewQuestions.SecondHighestNumber.java
        //int[] primitiveArray = {5, 9, 11, 2, 8, 21, 21}; //op: 11
        //Integer[] nonPrimitiveArray = {1, 2, 5, 6, 3, 2, 6};  // OP: 5

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
        int[] numbers = {5, 9, 11, 2, 8, 21, 1};
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
        Set<Integer> thirdWay = elementsList.stream()
                .filter(e -> !dupNum.add(e)).collect(Collectors.toSet());
        System.out.println("duplicate_elements3:: " + thirdWay);

        // Q17 find max and min // op Optional[40] min:: Optional[-1]
        List<Integer> maxMinNumbers = Arrays.asList(-1, 0, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
        // Find the maximum value
        Optional<Integer> max = maxMinNumbers.stream()
                .max(Comparator.naturalOrder());  // Using natural order to find the max

        // Find the minimum value
        Optional<Integer> min = maxMinNumbers.stream()
                .min(Comparator.naturalOrder());  // Using natural order to find the min
        System.out.println("Q17: max:: " + max + " min:: " + min);

        // Q18 sort asc and desc order if given Integer array
        //List<Integer> maxMinNumbers = Arrays.asList(-1, 0, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
        List<Integer> ascSorting = maxMinNumbers.stream()
                .sorted()// Natural ordering (ascending)
                .collect(Collectors.toList());
        List<Integer> descSorting = maxMinNumbers.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
        System.out.println("Q18: ascSorting:: " + ascSorting + " descSorting:: " + descSorting);
        // Q18.1 find second max element
        Optional<Integer> second_max_element = maxMinNumbers.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst();
        System.out.println("Q18.1: second_max_element:: " + second_max_element);

        // Q19 Skip and Limit example
        // here I used elementsList as input
        // List<Integer>
        // List<Integer> elementsList = Arrays.asList(1, 3, 10, 20, 30, 15, 1, 13, 2, 2, 10, 30, 19, 3); //96

        // skip first 5 numbers
        List<Integer> skip_first_5_elements = elementsList.stream().skip(5).collect(Collectors.toList());
        System.out.println("Q19: skip_first_5_elements:: " + skip_first_5_elements);

        // skip first 5 element find sum of remaining elements
        int skip_first_5_element_find_sum_of_remaining_elements = elementsList.stream().skip(5).reduce((a, b) -> a + b).get();
        System.out.println("skip_first_5_element_find_sum_of_remaining_elements:: " + skip_first_5_element_find_sum_of_remaining_elements);
        // get first 5 numbers
        List<Integer> first_5_numbers = elementsList.stream().limit(5).collect(Collectors.toList());
        System.out.println("first_5_numbers:: " + first_5_numbers);
        // sum Of first 5 Elements
        Integer sumOffirst5Elements = elementsList.stream().limit(5).reduce((a, b) -> a + b).get();
        System.out.println("sumOffirst5Elements:: " + sumOffirst5Elements);

        // Q 20: find second highest and lowest number.
        // refer  Q18.1 for second highest number. or below
        // Find the second maximum element
        Optional<Integer> second_max_element1 = maxMinNumbers.stream()
                .distinct()  // Remove duplicates
                .sorted(Comparator.reverseOrder())  // Sort in descending order
                .skip(1)  // Skip the first (maximum) element
                .findFirst();  // Get the second element
        System.out.println("Q20: second_max_element1:: " + second_max_element1);
        // or
        Optional<Integer> second_min_element = maxMinNumbers.stream().distinct().sorted().skip(1).findFirst();
        System.out.println("second_min_element:: " + second_min_element);
        // Find the second minimum element
        Optional<Integer> second_min_element1 = maxMinNumbers.stream()
                .distinct()  // Remove duplicates
                .sorted()    // Sort in ascending order
                .skip(1)     // Skip the first element (the smallest one)
                .findFirst();  // Get the second minimum element
        System.out.println("second_min_element1: " + second_min_element);

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
        //Q 24 C How to check first string contain all charcter from second string. Take below as input
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
        boolean containsAllChars = true;  // default value = false ❌ 2. Local Variables Have NO Default Value ❌ Compile-time error
        System.out.println("default value of boolean :: " + containsAllChars);
        for (char ch : second.toCharArray()) {
            if (first.indexOf(ch) == -1) {
                containsAllChars = false; // if any char missing → return false
            }
        }
        if (containsAllChars)
            System.out.println("Q 24 C:: Yes, every character in second exists inside first");
        else
            System.out.println("Q 24 C:: No, every character in second exists inside first");
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

        // Q 25 Find missing number from given array op:5
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

        // Q 26 Prime Numbers
        // e.g. prime numbers are 2, 3, 5, 7, and so on.
        // refer com.mane.umakant.java.interviewQuestions.PrimeNumbers.java

        // Q 27 Find vowels count in given string.
        //String vowelsString = "Naveen AutomationLabs";
        // refer com.mane.umakant.java.interviewQuestions.FindOwelsAndCountInGivenString.java

        // Q 28 Find given string is Palindrome or not?
        String palindromStr = "aba aba aba";
        // refer com.mane.umakant.java.interviewQuestions.Palindrome.java

        //Q29:  remove perticular character from given string
        // remove c from given string "CloudTech".  op: loudTech
        String strQ29 = "CloudTech";
        String repStr = strQ29.replaceAll("C", "");
        System.out.println("String after removing 'c'::  " + repStr);
        // or
        // Remove all occurrences of 'c' (case insensitive)
        result = strQ29.replace("c", "");
        result = result.replace("C", "");  // Optional if you want case-sensitive removal

        System.out.println("String after removing 'c':: " + result);

        //Q30:  compare two different array is same or not. Order of element is no matter
        int[] arrAccenture1 = { 3, 2, 5, 7 };
        int[] arrAccenture2 = { 2, 3, 7, 5 };
        // op: array same
        // refer com.mane.umakant.java.interviewQuestions.ArraySameOrNot.java

        // Q31:  from given array sort first even numbers and then odd numbers and show it
        //int[] arrEvenOddOrderInput = { 1, 2, 5, 4, 7, 8, 11, 20 };
        // op: 2 4 8 20 1 5 7 11
        // refer com.mane.umakant.java.interviewQuestions.ArraySortFirstEvenNumbersThenOddNumbersAndShowIt.java

        // Q32: Write a Java program to count the number of words present in a string
        // input String s = "Sharma is a good player and he is so punctual";
        // op: 10
        // refer com.mane.umakant.java.interviewQuestions.CountTheNumberOfWordsPresentInString.java

        // Q33: Write a program to find common characters from given two string
        // input 123456, 162, 21 op: common chars from first 2 string:1,2,6 & from all 3 is: 1,2
        // refer com.mane.umakant.java.interviewQuestions.FindCommonCharactersFromGivenTwoString.java

        //Q34: Write a program to find reverse of given string
        // input String start = "123456";
        // OP
        //reverseStringJava7: 654321
        // refer com.mane.umakant.java.interviewQuestions.ReverseString.java

        //Q35: Write a program to find min and max number from given integer" // op: Optional[1] Optional[9]
        // int number1 = 3912578;
        // refer com.mane.umakant.java.interviewQuestions.MinMaxNumberFromGivenInteger.java

        // Q36 : find occurence of each element from given array
        // input int arr[] = { 1, 90000, 9, 455, 90000, 22, 999, 455, 22, 90000 };
        // op: {90000=3, 1=1, 22=2, 999=1, 455=2, 9=1}
        int inputArr[] = {1, 90000, 9, 455, 90000, 22, 999, 455, 22, 90000};
        // refer com.mane.umakant.java.interviewQuestions.OccurenceOfEachElementFromGivenArray.java

        //Q37 : find 2nd highest odd occured number");
        int[] arrIntviewQue = {13, 13, 13, 13, 13, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 11, 11, 11, 11, 11, 11, 11};
        // op:  occurrenceMap: {1=1, 3=3, 5=3, 7=2, 11=7, 13=5}
        //op: The 2nd highest odd occurred number is: 13
        // refer com.mane.umakant.java.interviewQuestions.SecondHighestOddOccuredNumber.java

        // Q 38 input as: int arr[]= {10,15,12,11,18,20};
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
        System.out.println("Q38: previousInputValue using java7:: " + previousInputValue);
        // using Java8
        Optional<Integer> previousInputValue1 = Arrays.stream(arrSyne).boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .filter(x -> x < inputValue)
                .findFirst();
        System.out.println("previousInputValue1 using java8:: " + previousInputValue1);

        // Q 39 Calculate sum of all numbers present in a string. Asked by Epam company
        String inputEpam = "12abc20yz8";
        //Output: 12+20+8=40
        int sum = 0;
        String tempNumber = "0";
        for (int i = 0; i < inputEpam.length(); i++) {
            if (Character.isDigit(inputEpam.charAt(i))) {
                // System.out.println(inputEpam.charAt(i));
                tempNumber = tempNumber + inputEpam.charAt(i);
            } else {
                sum = sum + Integer.parseInt(tempNumber);
                tempNumber = "0";
            }
        }
        sum = sum + Integer.parseInt(tempNumber);

        System.out.println("Q39: sum of all numbers present in a string:: " + sum);

        // ✅ 2. Regex version (very strong in interview)

        sum = 0;
        Matcher m = Pattern.compile("\\d+").matcher("12abc20yz8");

        while (m.find()) {
            sum += Integer.parseInt(m.group());
        }

        System.out.println("Using Matcher and Pattern:: " + sum); // 40

        // Using Java 8

        IntSummaryStatistics summaryStatistics = Pattern.compile("\\d+").matcher("12abc20yz8")
                .results()
                .mapToInt(digit -> Integer.parseInt(digit.group()))
                .summaryStatistics();

        System.out.println("getSum: " + summaryStatistics.getSum());
        System.out.println("getAverage: " + summaryStatistics.getAverage());
        System.out.println("getCount: " + summaryStatistics.getCount());
        System.out.println("getMax: " + summaryStatistics.getMax());
        System.out.println("getMin: " + summaryStatistics.getMin());

    }

}
