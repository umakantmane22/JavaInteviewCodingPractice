package com.mane.umakant.java.interviewQuestions;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//================= THREAD SAFE SINGLETON =================
class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        // Protection against Reflection
        if (instance != null) {
            throw new RuntimeException("Use getThreadSafeInstance()");
        }
    }

    public static ThreadSafeSingleton getThreadSafeInstance() {

        if (instance == null) { // First check (no lock)
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

//================= SERIALIZATION SAFE SINGLETON =================
class SerializableSafeSingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    private static volatile SerializableSafeSingleton instanceSerializable;

    private SerializableSafeSingleton() {
        if (instanceSerializable != null) {
            throw new RuntimeException("Use getSerializableSafeInstance()");
        }
    }

    public static SerializableSafeSingleton getSerializableSafeInstance() {

        if (instanceSerializable == null) {
            synchronized (SerializableSafeSingleton.class) {
                if (instanceSerializable == null) {
                    instanceSerializable = new SerializableSafeSingleton();
                }
            }
        }
        return instanceSerializable;
    }

    // 🔒 Prevent new object during deserialization
    private Object readResolve() {
        return instanceSerializable;
    }
}

//================= CLONE SAFE SINGLETON =================
class CloneSafeSingleton implements Cloneable {

    private static volatile CloneSafeSingleton instanceClone;

    private CloneSafeSingleton() {
        if (instanceClone != null) {
            throw new RuntimeException("Use getCloneSafeInstance()");
        }
    }

    public static CloneSafeSingleton getCloneSafeInstance() {

        if (instanceClone == null) {
            synchronized (CloneSafeSingleton.class) {
                if (instanceClone == null) {
                    instanceClone = new CloneSafeSingleton();
                }
            }
        }
        return instanceClone;
    }

    // 🔒 Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for Singleton");
        // Alternative (not recommended):
        // return instanceClone;
    }
}

enum EnumSingleton {
    INSTANCE;

    public void showMessage() {
        System.out.println("Enum Singleton Working...");
    }
}

public class SingletonTest {

    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {

        // ===== ThreadSafeSingleton Test =====
        ThreadSafeSingleton obj1 = ThreadSafeSingleton.getThreadSafeInstance();
        ThreadSafeSingleton obj2 = ThreadSafeSingleton.getThreadSafeInstance();

        System.out.println("ThreadSafeSingleton:");
        System.out.println(obj1.hashCode() + " " + obj2.hashCode());

        // ===== SerializableSafeSingleton Test =====
        SerializableSafeSingleton s1 = SerializableSafeSingleton.getSerializableSafeInstance();

        // Serialize
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        oos.writeObject(s1);
        oos.close();

        // Deserialize
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
        SerializableSafeSingleton s2 = (SerializableSafeSingleton) ois.readObject();
        ois.close();

        System.out.println("\nSerializableSafeSingleton:");
        System.out.println(s1.hashCode() + " " + s2.hashCode());

        // ===== CloneSafeSingleton Test =====
        CloneSafeSingleton c1 = CloneSafeSingleton.getCloneSafeInstance();

        System.out.println("\nCloneSafeSingleton:");
        try {
            CloneSafeSingleton c2 = (CloneSafeSingleton) c1.clone();
            System.out.println(c1.hashCode() + " " + c2.hashCode());
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning prevented: " + e.getMessage());
        }

        // ===== EnumSingleton Test =====
        EnumSingleton e1 = EnumSingleton.INSTANCE;
        EnumSingleton e2 = EnumSingleton.INSTANCE;

        System.out.println("\nEnumSingleton:");
        System.out.println(e1.hashCode() + " " + e2.hashCode());

        // Method call test
        e1.showMessage();


    }
}
