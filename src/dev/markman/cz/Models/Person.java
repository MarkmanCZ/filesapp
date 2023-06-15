package dev.markman.cz.Models;

public class Person {
    private String name;
    private String emial;
    private int phoneNum;
    private int age;

    public Person() {

    }

    public Person(String name, String emial, int age) {
        this.name = name;
        this.emial = emial;
        this.age = age;
    }

    public Person(String name, String emial, int age, int phoneNumeber) {
        this.name = name;
        this.emial = emial;
        this.age = age;
        this.phoneNum = phoneNumeber;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
