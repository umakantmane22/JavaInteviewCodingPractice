package com.mane.umakant.deepCopy;

//  1. Address class (Mutable + Copy Constructor):
public class Address {
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    // Deep copy constructor
    public Address(Address other) {
        this.city = other.city;
        this.country = other.country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}
