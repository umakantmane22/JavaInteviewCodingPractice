package com.mane.umakant.collections.chatGpt;
import java.util.*;
public class CreateImmutableMapListSet {
    public static void main(String[] args) {
        //In Java, an immutable collection means you cannot modify (add, remove, or update) its elements after creation.
        //Attempting to do so throws an UnsupportedOperationException
        //  🧩 1️⃣ Immutable List
        //✅ Using Collections.unmodifiableList() (Before Java 9)
        List<String> list=new ArrayList<>();
        list.add("Java");
        list.add("Spring");

        List<String> immutableList=Collections.unmodifiableList(list);
        System.out.println("Immutable List: " + immutableList);

        // immutableList.add("Hibernate"); // ❌ Throws UnsupportedOperationException

        //  ✅ Using List.of() (Java 9+)
        List<String> immutableList1=List.of("Java", "Spring", "Hibernate");
        // immutableList1.add("React"); ❌ Throws UnsupportedOperationException

        //  🧩 2️⃣ Immutable Set
        //✅ Using Collections.unmodifiableSet() (Before Java 9)

        Set<String> set=new HashSet<>();
        set.add("Java");
        set.add("Spring");

        Set<String> immutableSet =Collections.unmodifiableSet(set);
        System.out.println("Immutable Set: " + immutableSet);

        //✅ Using Set.of() (Java 9+)
        Set<String> immutableSet1 = Set.of("Java", "Spring", "Hibernate");
        System.out.println(immutableSet1);

        // 🧩 3️⃣ Immutable Map
        //✅ Using Collections.unmodifiableMap() (Before Java 9)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Spring");

        Map<Integer, String> immutableMap = Collections.unmodifiableMap(map);
        System.out.println("Immutable Map: " + immutableMap);

        //✅ Using Map.of() and Map.ofEntries() (Java 9+)
        Map<Integer, String> immutableMap1 = Map.of(
                1, "Java",
                2, "Spring",
                3, "Hibernate"
        );

        System.out.println("Immutable Map: " + immutableMap1);

       // Or for more entries:
        Map<Integer, String> immutableMap2 = Map.ofEntries(
                Map.entry(1, "Java"),
                Map.entry(2, "Spring"),
                Map.entry(3, "Hibernate")
        );
        System.out.println(immutableMap2);

    }
}
