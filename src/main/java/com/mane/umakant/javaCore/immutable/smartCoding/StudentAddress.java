package com.mane.umakant.javaCore.immutable.smartCoding;

public class StudentAddress {
    String atPost;
    String tak;
    String district;
    String stat;
    int pin;

    public String getAtPost() {
        return atPost;
    }

    public void setAtPost(String atPost) {
        this.atPost = atPost;
    }

    public String getTak() {
        return tak;
    }

    public void setTak(String tak) {
        this.tak = tak;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public StudentAddress() {
    }

    public StudentAddress(String atPost, String tak, String district, String stat, int pin) {
        this.atPost = atPost;
        this.tak = tak;
        this.district = district;
        this.stat = stat;
        this.pin = pin;
    }
    // copy constructor
    public StudentAddress(StudentAddress studentAddress) {
        this(studentAddress.getAtPost(), studentAddress.getTak(), studentAddress.getDistrict(),
                studentAddress.getStat(), studentAddress.getPin());
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "atPost='" + atPost + '\'' +
                ", tak='" + tak + '\'' +
                ", district='" + district + '\'' +
                ", stat='" + stat + '\'' +
                ", pin=" + pin +
                '}';
    }
}
