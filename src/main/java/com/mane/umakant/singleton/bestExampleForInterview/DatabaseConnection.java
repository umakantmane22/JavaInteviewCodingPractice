package com.mane.umakant.singleton.bestExampleForInterview;

public class DatabaseConnection {
    private static volatile DatabaseConnection databaseConnection;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getDatabaseInstance() {
        if (databaseConnection == null) {
            synchronized (DatabaseConnection.class) {
                if (databaseConnection == null) {
                    databaseConnection = new DatabaseConnection();
                }
            }
        }
        return databaseConnection;
    }
}
