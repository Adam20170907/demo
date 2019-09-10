package com.frutacloud.jicheng;
/**
 * Person
 */

public class Person {

    protected String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age + "";
    }

    public void setAge(Double age) {
        this.age = age + "";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age+"";
    }

    public Person(String name) {
        this(name, 18);
    }

    public Person() {
        this("Unnamed");
    }

}