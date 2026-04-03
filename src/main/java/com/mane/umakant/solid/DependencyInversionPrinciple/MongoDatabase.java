package com.mane.umakant.solid.DependencyInversionPrinciple;

// Step 2 — Implement concrete classes
public class MongoDatabase implements Database{
    @Override
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}
