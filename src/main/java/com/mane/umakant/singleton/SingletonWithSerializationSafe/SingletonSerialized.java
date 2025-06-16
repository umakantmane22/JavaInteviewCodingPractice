package com.mane.umakant.singleton.SingletonWithSerializationSafe;
//✅ 6. Singleton with Serialization Safe

import java.io.Serializable;

public class SingletonSerialized implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final SingletonSerialized instance = new SingletonSerialized();

    private SingletonSerialized() {
    }

    public static SingletonSerialized getInstance() {
        return instance;
    }

    // To prevent creating another instance during deserialization
    protected Object readResolve() {
        return instance;
    }
}
