package com.mane.umakant.singleton.EnumSingletonBestPractice;

//✅ 5. Enum Singleton (Best Practice)
public enum SingletonEnum {
    INSTANCE; // This is the singleton instance

    // You can add fields and methods as needed
    private int count = 0;

    public void showMessage() {
        System.out.println("Hello from SingletonEnum! Count: " + count);
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

//✅ Handles serialization and reflection attack safely.
//✅ JVM ensures only one instance.