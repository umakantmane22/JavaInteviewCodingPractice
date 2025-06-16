package com.mane.umakant.singleton.BasicSingletonNotThreadSafe;

//✅ 1. Basic Singleton (Not Thread Safe)
public class SingletonBasic {
    private static SingletonBasic instance;

    private SingletonBasic() {
    }

    public static SingletonBasic getInstance() {
        if (instance == null) {
            instance = new SingletonBasic();
        }
        return instance;
    }
}
//❌ Not thread-safe. Multiple threads can create multiple instances.
