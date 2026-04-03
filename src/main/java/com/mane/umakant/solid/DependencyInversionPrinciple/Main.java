package com.mane.umakant.solid.DependencyInversionPrinciple;

public class Main {
    public static void main(String[] args) {
        Database db=new MySQLDatabase();
        UserService service = new UserService(db);
        service.saveUser("Umakant");
    }
}
