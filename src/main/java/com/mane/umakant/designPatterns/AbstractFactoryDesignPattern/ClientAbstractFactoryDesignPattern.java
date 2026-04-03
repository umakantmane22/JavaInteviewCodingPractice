package com.mane.umakant.designPatterns.AbstractFactoryDesignPattern;

interface Engine {
    void start();
}

interface Tyre {
    void rotate();
}

//  Step 2 Concrete Products (Tata Family)
class TataEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Tata Engine started");
    }
}

class TataTyre implements Tyre {

    @Override
    public void rotate() {
        System.out.println("Tata Tyre rotating");
    }
}

//  Step 2️ Concrete Products (BMW Family)
class BMWEngine implements Engine {

    @Override
    public void start() {
        System.out.println("BMW Engine started");
    }
}

class BMWTyre implements Tyre {

    @Override
    public void rotate() {
        System.out.println("BMW Tyre rotating");
    }
}

//  Step 3 Abstract Factory

interface CarFactory {
    Engine createEngine();

    Tyre createTyre();
}

//  Step 4 Concrete Factories
class TataCarFactory implements CarFactory {

    @Override
    public Engine createEngine() {
        return new TataEngine();
    }

    @Override
    public Tyre createTyre() {
        return new TataTyre();
    }
}

//  Step 4 Concrete Factories
class BMWCarFactory implements CarFactory {

    @Override
    public Engine createEngine() {
        return new BMWEngine();
    }

    @Override
    public Tyre createTyre() {
        return new BMWTyre();
    }
}

// ⭐ Recommended Enhancement (Real-world feel)
/*

⭐ Recommended Enhancement (Real-world feel)
3️⃣ “Car” नावाचा object missing आहे
आत्ता आपण:
Engine
Tyre
वेगळे वापरतो.
खऱ्या जगात client म्हणतो:
“मला Car हवी आहे”
तो engine, tyre वेगळे handle करत नाही.
*/
// ✅ Add a Car class (Highly recommended)
/*⭐ Optional Advanced Improvements (Interview + Framework level)
1️⃣ final keyword (immutability)
👉 Car तयार झाल्यावर engine/tyre बदलता येणार नाही
(Real-world correctness)
*/
class CarR {

    private final Engine engine;
    private final Tyre tyre;

    public CarR(CarFactory factory) {
        this.engine = factory.createEngine();
        this.tyre = factory.createTyre();
    }

    public void drive() {
        engine.start();
        tyre.rotate();
        System.out.println("Car is running...");
    }
}

// 2️⃣ Factory selection external करा (Bonus)
enum Brand {
    TATA, BMW
}

class FactoryProvider {
    static CarFactory getFactory(Brand brand) {
        return switch (brand) {
            case TATA -> new TataCarFactory();
            case BMW -> new BMWCarFactory();
        };
    }
}


//  Step 5 Client Code (खूप clean)
public class ClientAbstractFactoryDesignPattern {
    public static void main(String[] args) {
   /*     CarR tataCar = new CarR(new TataCarFactory());
        tataCar.drive();

        System.out.println("****************");

        CarR bmwCar = new CarR(new BMWCarFactory());
        bmwCar.drive();
*/
        CarR carTata = new CarR(FactoryProvider.getFactory(Brand.TATA));
        carTata.drive();
        CarR carBMW = new CarR(FactoryProvider.getFactory(Brand.BMW));
        carBMW.drive();

    }
}
