package com.mane.umakant.collections.chatGpt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveElementFrCollection {
    public static void main(String[] args) {
        //In Java, you cannot remove elements directly using a for-each loop — doing so will throw a
        //ConcurrentModificationException.
         //       Instead, you should use an Iterator or removeIf() (Java 8).
        List<String> names = new ArrayList<>(Arrays.asList("java", "spring", "hibernate", "c++"));
        System.out.println("Before removal: " + names);
        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("c++")) {
                iterator.remove(); // ✅ Safe removal using Iterator
            }
        }

        System.out.println("After removal java7: " + names);

        //Using removeIf() in Java 8
        names.removeIf(name -> name.equals("c++")); // ✅ Removes matching elements safely

        System.out.println("After removal java8: " + names);


    }
}
