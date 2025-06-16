package com.mane.umakant.singleton.PreventSingletonFromReflection;

//✅ 7. Prevent Singleton from Reflection
public class SingletonSecure {
    private static boolean instanceCreated = false;

    private SingletonSecure() {
        if (instanceCreated) {
            throw new RuntimeException("Use getInstance()");
        }
        instanceCreated = true;
    }

    private static final SingletonSecure INSTANCE = new SingletonSecure();

    public static SingletonSecure getInstance() {
        return INSTANCE;
    }
}
//✅ This protects from breaking singleton via reflection.