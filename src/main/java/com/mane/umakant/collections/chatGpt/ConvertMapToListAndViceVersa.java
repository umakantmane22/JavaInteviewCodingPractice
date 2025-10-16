package com.mane.umakant.collections.chatGpt;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertMapToListAndViceVersa {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(11, "Java");
        map.put(12, "Spring");
        map.put(13, "Hibernate");
        System.out.println("map:: "+map);

        //🧩 1️⃣ Convert Map → List
        System.out.println("");
        System.out.println("Convert Map → List");
        System.out.println("");
        //✅ a) Convert Map Keys to List
        List<Integer> keyList=new ArrayList<>(map.keySet());
        System.out.println("Keys List: " + keyList);
       // ✅ b) Convert Map Values to List
        List<String> valueList = new ArrayList<>(map.values());
        System.out.println("Values List: " + valueList);
        //✅ c) Convert Map Entries to List
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(map.entrySet());
        System.out.println("Entries List: " + entryList);
        //✅ d) Using Java 8 Streams
        List<String> values = map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .toList();
        System.out.println("Values List (Streams): " + values);

        //  🧩 2️⃣ Convert List → Map
        System.out.println("");
        System.out.println("Convert List → Map");
        System.out.println("");
        List<String> techList= Arrays.asList("Java", "Spring", "Hibernate");
        System.out.println("techList:: "+techList);
        //✅ a) Using Java 8 Streams
        Map<Integer, String> listToMap = techList.stream()
                .collect(Collectors.toMap(
                        techList::indexOf,  // Key = index
                        name -> name));     // Value = element

        System.out.println("List to Map: " + listToMap);

        //✅ b) Using a For Loop (Before Java 8)
        Map<Integer, String> mapFromList = new HashMap<>();
        for (int i = 0; i < techList.size(); i++) {
            mapFromList.put(i, techList.get(i));
        }
        System.out.println("List to Map (Loop): " + mapFromList);

    }
}
