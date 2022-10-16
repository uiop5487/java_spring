package com.sparta.week01homework.prac;

public class Person {
    private String name;
    private int age;
    private String hobby;

    // Getter
    public String getName() {
        return this.name;
    }
    public String getHobby() {
        return this.hobby;
    }
    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
