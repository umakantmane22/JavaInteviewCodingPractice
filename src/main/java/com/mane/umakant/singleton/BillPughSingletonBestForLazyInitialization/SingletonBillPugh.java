package com.mane.umakant.singleton.BillPughSingletonBestForLazyInitialization;

//✅ 4. Bill Pugh Singleton (Best for Lazy Initialization)
public class SingletonBillPugh {
    private SingletonBillPugh() {
    }

    private static class Holder {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return Holder.INSTANCE;
    }
}

//✅ Thread-safe, lazy-loaded, and doesn't use synchronization.