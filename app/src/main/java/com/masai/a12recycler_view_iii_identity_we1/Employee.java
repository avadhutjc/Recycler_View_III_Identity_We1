package com.masai.a12recycler_view_iii_identity_we1;

public class Employee {
    private String name;
    private int age;
    private String address;

    public Employee(String name, String address, int age ) {
        this.name = name;
        this.address = address;
        this.age = age;

    }

    public String getName() {
        return  name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return  age;
    }
}
