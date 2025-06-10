package com.mane.umakant.javaCore.immutable.chatGptExamples;

public class Address {
    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    // Copy constructor
    public Address(Address that) {
        this.city = that.city;
        this.state = that.state;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    // Optional: setters if used in other places, but not in immutable class

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
