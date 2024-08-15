package com.example.myapplication;

public class User {
    private String name;
    private int age;
    private float height;
    private String email;
    private long phone;

    public User(String name, int age, float height, String email, long phone) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }
}
