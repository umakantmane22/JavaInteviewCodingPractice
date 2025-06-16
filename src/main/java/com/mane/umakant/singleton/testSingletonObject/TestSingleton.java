package com.mane.umakant.singleton.testSingletonObject;

import com.mane.umakant.singleton.BasicSingletonNotThreadSafe.SingletonBasic;
import com.mane.umakant.singleton.BillPughSingletonBestForLazyInitialization.SingletonBillPugh;
import com.mane.umakant.singleton.DoubleCheckedLockingSingletonEfficientAndThreadSafe.SingletonDoubleChecked;
import com.mane.umakant.singleton.EnumSingletonBestPractice.SingletonEnum;
import com.mane.umakant.singleton.PreventSingletonFromReflection.SingletonSecure;
import com.mane.umakant.singleton.SingletonWithSerializationSafe.SingletonSerialized;
import com.mane.umakant.singleton.ThreadSafeSingletonSynchronized.SingletonThreadSafe;
import com.mane.umakant.singleton.bestExampleForInterview.DatabaseConnection;
import com.mane.umakant.singleton.bestExampleForInterview.Singleton;

public class TestSingleton {
    public static void main(String[] args) {

        SingletonBasic singletonBasic1 = SingletonBasic.getInstance();
        SingletonBasic singletonBasic2 = SingletonBasic.getInstance();
        System.out.println("singletonBasic1:: " + singletonBasic1.hashCode() + " singletonBasic2:: " + singletonBasic2.hashCode());

        DatabaseConnection databaseConnection1 = DatabaseConnection.getDatabaseInstance();
        DatabaseConnection databaseConnection2 = DatabaseConnection.getDatabaseInstance();
        System.out.println("databaseConnection1:: " + databaseConnection1.hashCode() + " databaseConnection2:: " + databaseConnection2.hashCode());

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("Singleton1:: " + singleton1.hashCode() + " Singleton2:: " + singleton2.hashCode());

        SingletonBillPugh singletonBillPugh1 = SingletonBillPugh.getInstance();
        SingletonBillPugh singletonBillPugh2 = SingletonBillPugh.getInstance();
        System.out.println("singletonBillPugh1:: " + singletonBillPugh1.hashCode() + " singletonBillPugh2:: " + singletonBillPugh2.hashCode());

        SingletonDoubleChecked singletonDoubleChecked1 = SingletonDoubleChecked.getInstance();
        SingletonDoubleChecked singletonDoubleChecked2 = SingletonDoubleChecked.getInstance();
        System.out.println("singletonDoubleChecked1:: " + singletonDoubleChecked1.hashCode() + " singletonDoubleChecked2:: " + singletonDoubleChecked2.hashCode());

        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        singletonEnum1.increment();
        singletonEnum1.showMessage();// Count: 1
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        singletonEnum2.increment();
        singletonEnum2.showMessage();// Count: 2
        System.out.println(singletonEnum1 == singletonEnum2); // true
        System.out.println("singletonEnum1:: " + singletonEnum1.hashCode() + " singletonEnum2:: " + singletonEnum2.hashCode());

        SingletonSecure singletonSecure1 = SingletonSecure.getInstance();
        SingletonSecure singletonSecure2 = SingletonSecure.getInstance();
        System.out.println("singletonSecure1:: " + singletonSecure1.hashCode() + " singletonSecure2:: " + singletonSecure2.hashCode());

        SingletonSerialized singletonSerialized1 = SingletonSerialized.getInstance();
        SingletonSerialized singletonSerialized2 = SingletonSerialized.getInstance();
        System.out.println("singletonSerialized1:: " + singletonSerialized1.hashCode() + " singletonSerialized2:: " + singletonSerialized2.hashCode());

        SingletonThreadSafe singletonThreadSafe1 = SingletonThreadSafe.getInstance();
        SingletonThreadSafe singletonThreadSafe2 = SingletonThreadSafe.getInstance();
        System.out.println("singletonThreadSafe1:: " + singletonSerialized1.hashCode() + " singletonSerialized2:: " + singletonSerialized2.hashCode());
    }
}
