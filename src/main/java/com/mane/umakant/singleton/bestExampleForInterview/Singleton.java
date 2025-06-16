package com.mane.umakant.singleton.bestExampleForInterview;

// This pattern is "Bill Pugh Singleton (Best for Lazy Initialization)"
public class Singleton {

    // Private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    // Static inner class - loaded only when getInstance() is called
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Global access point
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
//💡 Why This Is Best for Interviews:
//✅ Lazy Initialization – instance created only when needed.
//✅ Thread-safe – uses class loading mechanism (no need for synchronized).
//✅ Efficient – no performance hit like double-checked locking.
