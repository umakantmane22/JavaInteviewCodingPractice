package com.mane.umakant.singleton.DoubleCheckedLockingSingletonEfficientAndThreadSafe;

//✅ 3. Double-Checked Locking Singleton (Efficient and Thread-Safe)
public class SingletonDoubleChecked {
    private static volatile SingletonDoubleChecked instance;

    private SingletonDoubleChecked() {
    }

    public static SingletonDoubleChecked getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleChecked.class) {
                if (instance == null) {
                    instance = new SingletonDoubleChecked();
                }
            }
        }
        return instance;
    }
}

//✅ Recommended in multithreaded environments with better performance.