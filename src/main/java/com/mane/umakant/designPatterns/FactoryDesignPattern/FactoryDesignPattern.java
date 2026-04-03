package com.mane.umakant.designPatterns.FactoryDesignPattern;


interface Vehicle {
    void drive();
}

class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("running car...");
    }
}

class Bike implements Vehicle {

    @Override
    public void drive() {
        System.out.println("running bike..");
    }
}


/*
⭐ 	Optional Improvement (Interview-level)
	enum based factory (cleaner & safer)
*/

enum VehicleType {
    CAR, BIKE
}

class VehicleFactory {
    private VehicleFactory() {

    }

    public static Vehicle getVehicle(VehicleType type) {
        if (type == null) {
            throw new IllegalArgumentException("VehicleType cannot be null");
        }
        return switch (type) {
            case CAR -> new Car();
            case BIKE -> new Bike();
        };
    }
}


// ---------- Test Class ----------
public class FactoryDesignPattern {

    public static void main(String[] args) {
		/*
        Vehicle car = VehicleFactory.getVehicle("car");
        Vehicle bike = VehicleFactory.getVehicle("bike");

        car.drive();
        bike.drive();
		*/
        Vehicle car = VehicleFactory.getVehicle(VehicleType.CAR);
        Vehicle bike = VehicleFactory.getVehicle(VehicleType.BIKE);
        car.drive();
        bike.drive();
    }
}

