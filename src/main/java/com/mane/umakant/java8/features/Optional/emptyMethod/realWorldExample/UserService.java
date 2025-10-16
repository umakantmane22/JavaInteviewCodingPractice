package com.mane.umakant.java8.features.Optional.emptyMethod.realWorldExample;

import java.util.Optional;

//🔹 Step 2: Service Layer
class UserService {
    private UserRepository repo = new UserRepository();

    public void printUser(int userId) {
        Optional<String> userOpt = repo.findUserById(userId);

        userOpt.ifPresentOrElse(
                name -> System.out.println("User found: " + name),
                () -> System.out.println("User not found.")
        );
    }
}
