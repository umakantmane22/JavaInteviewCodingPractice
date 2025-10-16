package com.mane.umakant.java8.features.Optional.emptyMethod.realWorldExample;

//🔹 Step 3: Application Runner
public class OptionalEmptyRealWorld {
    public static void main(String[] args) {
        UserService service = new UserService();
        service.printUser(1);  // User found: Alice
        service.printUser(99); // User not found.
    }
}

