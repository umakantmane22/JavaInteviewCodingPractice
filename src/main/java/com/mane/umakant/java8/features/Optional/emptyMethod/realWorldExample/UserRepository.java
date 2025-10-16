package com.mane.umakant.java8.features.Optional.emptyMethod.realWorldExample;

//✅ Scenario: User Lookup Service
//You want to fetch a user by ID. If no user is found (e.g., not in database), return an empty Optional instead of null.

//🔹 Step 1: User Repository (Simulated)
import java.util.*;

class UserRepository {
    private Map<Integer, String> users = new HashMap<>();

    public UserRepository() {
        users.put(1, "Alice");
        users.put(2, "Bob");
    }

    public Optional<String> findUserById(int id) {
        if (users.containsKey(id)) {
            return Optional.of(users.get(id));
        } else {
            return Optional.empty();  // ✅ Real-world use of empty()
        }
    }
}


