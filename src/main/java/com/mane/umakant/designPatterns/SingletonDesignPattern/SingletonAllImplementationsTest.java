package com.mane.umakant.designPatterns.SingletonDesignPattern;

// ---------- 1. Eager Initialization ----------
class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

// ---------- 2. Lazy Initialization (Not Thread-Safe) ----------
class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

// ---------- 3. Synchronized Method ----------
class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}

// ---------- 4. Double-Checked Locking ----------
class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {}

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}

// ---------- 5. Static Inner Class ----------
class InnerClassSingleton {

    private InnerClassSingleton() {}

    private static class SingletonHelper {
        private static final InnerClassSingleton INSTANCE =
                new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

// ---------- 6. Enum Singleton ----------
enum EnumSingleton {
    INSTANCE;

    public void show() {
        System.out.println("Enum Singleton method executed");
    }
}

// ---------- Test Class (Runnable Main) ----------
public class SingletonAllImplementationsTest {

    public static void main(String[] args) {

        // Eager
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();

        // Lazy
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();

        // Synchronized
        SynchronizedSingleton sync1 = SynchronizedSingleton.getInstance();
        SynchronizedSingleton sync2 = SynchronizedSingleton.getInstance();

        // Double Checked
        DoubleCheckedSingleton dcl1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton dcl2 = DoubleCheckedSingleton.getInstance();

        // Inner Class
        InnerClassSingleton inner1 = InnerClassSingleton.getInstance();
        InnerClassSingleton inner2 = InnerClassSingleton.getInstance();

        // Enum
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;

        System.out.println("Eager Singleton: " + (eager1 == eager2));
        System.out.println("Lazy Singleton: " + (lazy1 == lazy2));
        System.out.println("Synchronized Singleton: " + (sync1 == sync2));
        System.out.println("Double Checked Singleton: " + (dcl1 == dcl2));
        System.out.println("Inner Class Singleton: " + (inner1 == inner2));
        System.out.println("Enum Singleton: " + (enum1 == enum2));

        enum1.show();
    }
}
