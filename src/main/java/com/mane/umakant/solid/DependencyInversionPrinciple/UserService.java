package com.mane.umakant.solid.DependencyInversionPrinciple;

//  Step 3 — High-level module depends on abstraction
public class UserService {
    private Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public void saveUser(String user) {
        database.save(user);
    }

}
