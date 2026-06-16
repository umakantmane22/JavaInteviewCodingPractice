package com.mane.umakant.java.interviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//1. Predicate Equivalent
@FunctionalInterface
interface NumberValidator {
    boolean valid(int t);
}

@FunctionalInterface
interface MyCondition {
    boolean testMyCondition(int a, int b);
}

//2. Function Equivalent
@FunctionalInterface
interface StringProcessor {
    String process(String input);
}
@FunctionalInterface
interface CalculatorGeneric<T>{
    T calculate(T a, T b);
}

// 3. Consumer Equivalent
@FunctionalInterface
interface MessagePrinter {
    void print(String message);
}

//4. Supplier Equivalent
@FunctionalInterface
interface MessageProvider {
    String getMessage();
}

// 5. Comparator Equivalent
@FunctionalInterface
interface NumberComparator {
    int compare(int a, int b);
}

// 6. Runnable Equivalent
@FunctionalInterface
interface Task {
    void execute();
}

public class CustomFunctionalInterfaceDemo {
    public static void main(String args[]) {

        // 1. Predicate Equivalent
        System.out.println(" 1. Predicate Equivalent");

        // Default Predicate interface
        Predicate<Integer> isEvenPredicate = num -> num % 2 == 0;
        System.out.println("Default predicate interface:: " + isEvenPredicate.test(10));
        System.out.println("Default predicate interface:: " + isEvenPredicate.test(5));

        Predicate<Integer> greaterThan10 = x -> x > 10;
        Predicate<Integer> lessThan50 = x -> x < 50;
        Predicate<Integer> combined = greaterThan10.and(lessThan50);
        System.out.println("combined predicate:: " + combined.test(40)); // true
        System.out.println("combined predicate:: " + combined.test(51)); // false

        List<String> names = Arrays.asList("Ram", "Shyam", "Mohan", "Ravi");
        Predicate<String> namesStartWithR = name -> name.startsWith("R");
        List<String> listStartWithR_names = names.stream().filter(namesStartWithR).toList();
        System.out.println("listStartWithR_names:: " + listStartWithR_names);

        // Custom Predicate interface
        NumberValidator isEvenCustomPredicate = num -> num % 2 == 0;
        MyCondition myTestCondition = (a, b) -> a > b;
        System.out.println("Custom predicate interface 'isEvenCustomPredicate':: " + isEvenCustomPredicate.valid(10));
        System.out.println("Custom predicate interface 'isEvenCustomPredicate':: " + isEvenCustomPredicate.valid(5));
        System.out.println("Custom predicate interface 'myTestCondition':: " + myTestCondition.testMyCondition(10, 20));

        // 2. Function Equivalent
        System.out.println("");
        System.out.println("2. Custom Function Equivalent");

        // Default Function interface
        Function<Integer, Integer> square = n -> n * n;
        System.out.println("Default Function interface 'square of 5 is ':: " + square.apply(5));
        Function<String, Integer> getLength = str -> str.length();
        System.out.println("Default Function interface 'getLength of mane':: " + getLength.apply("mane"));
        // @formatter:off
		/*
		 f1.andThen(f2) // first f1, then f2
		 f1.compose(f2) // first f2, then f1
		 */
        // @formatter:on
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add3 = x -> x + 3;
        System.out.println("'multiplyBy2.andThen(add3):: '" + multiplyBy2.andThen(add3).apply(5)); // Op: 13
        System.out.println("'multiplyBy2.compose(add3):: '" + multiplyBy2.compose(add3).apply(5)); // Op: 16
        // Custom Function interface
        StringProcessor upperCase = str -> str.toUpperCase();
        System.out.println("Custom Function:: " + upperCase.process("umakant"));

        // Integer Addition
        CalculatorGeneric<Integer> add = (a, b) -> a + b;
        System.out.println("Addition: " + add.calculate(10, 5)); // 15

        // Double Subtraction
        CalculatorGeneric<Double> subtract = (a, b) -> a - b;
        System.out.println("Subtraction: " + subtract.calculate(20.5, 5.2)); // 15.3

        // String Concatenation
        CalculatorGeneric<String> concat = (a, b) -> a + b;
        System.out.println("Concat: " + concat.calculate("Hello ", "World")); // Hello World

        // 3. Consumer Equivalent
        System.out.println("");
        System.out.println("3. Consumer Equivalent");
        // Default Consumer interface
        Consumer<String> printName = name -> System.out.println(name);
        printName.accept("string 'umakant' is consumed");
        List<String> listConsumer1 = Arrays.asList("A", "B", "C");
        Consumer<String> print = System.out::println;
        listConsumer1.forEach(print);
        // @formatter:off
		/*
		 Imp methods:
		 c1.andThen(c2)
		 */
        // @formatter:on
        Consumer<String> c1 = s -> System.out.println("Hello " + s);
        Consumer<String> c2 = s -> System.out.println("Welcome " + s);
        c1.andThen(c2).accept("c1 and c2 instance");
        // Custom Consumer interface
        MessagePrinter printer = message -> System.out.println(message);
        printer.print("Hello MessagePrinter");

        // 4. Supplier Equivalent
        System.out.println("");
        System.out.println("4. Supplier Equivalent");
        // Default Supplier interface
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Default Supplier interface 'randomValue':: " + randomValue.get());
        Supplier<UUID> randomUUID = () -> UUID.randomUUID();
        System.out.println("Default Supplier interface 'randomValue':: " + randomUUID.get());
        Supplier<String> messageSupplier = () -> "Hello from supplier";
        System.out.println(messageSupplier.get());
        // Custom Supplier interface
        MessageProvider provider = () -> "Welcome to Java";
        System.out.println("custom supplier 'provider':: " + provider.getMessage());

        // 5. Comparator Equivalent
        System.out.println("");
        System.out.println("5. Comparator Equivalent");
        NumberComparator comparator = (a, b) -> a - b;
        System.out.println("Comparator Equivalent:: " + comparator.compare(20, 15));

        // 6. Runnable Equivalent
        System.out.println("");
        System.out.println("6. Runnable Equivalent");
        Task task = () -> System.out.println("Task Running");
        task.execute();

    }
}
