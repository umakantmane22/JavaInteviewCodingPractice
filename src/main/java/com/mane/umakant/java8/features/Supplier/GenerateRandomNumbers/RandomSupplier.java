package com.mane.umakant.java8.features.Supplier.GenerateRandomNumbers;

import java.util.function.Supplier;
import java.util.Random;

public class RandomSupplier {
    public static void main(String[] args) {
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100); // 0 to 99

        for (int i = 0; i < 5; i++) {
            System.out.println(randomSupplier.get());
        }
    }
}
