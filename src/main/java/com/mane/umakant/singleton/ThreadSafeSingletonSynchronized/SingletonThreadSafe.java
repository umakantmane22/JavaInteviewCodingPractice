package com.mane.umakant.singleton.ThreadSafeSingletonSynchronized;

//✅ 2. Thread-Safe Singleton (Synchronized)
public class SingletonThreadSafe {
    private static SingletonThreadSafe instance;

    private SingletonThreadSafe() {
    }

    public static synchronized SingletonThreadSafe getInstance() {
        if (instance == null) {
            instance = new SingletonThreadSafe();
        }
        return instance;
    }
}
//✅ Thread-safe, but synchronization causes performance hit.