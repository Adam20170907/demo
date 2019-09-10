package com.frutacloud.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Person
 */

class Person {
    private String Name;
    // private int Age;
    private int birth;

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return calcAge() - getBirth();
    }

    // public void setAge(int age) {
    // this.Age = age;
    // }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    private int calcAge() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
        int year = Integer.parseInt(simpleDateFormat.format(date));
        return year;

    }

}

public class Person2shixian {

    public static void main(String[] args) {
        Person xiaoming = new Person();
        xiaoming.setName("小明");
        xiaoming.setBirth(1992);

        System.out.println("名称: " + xiaoming.getName());
        System.out.println("年龄: " + xiaoming.getAge());
        Person hong = new Person();
        hong.setName("小红");
        hong.setBirth(1993);
        System.out.println("名称: " + hong.getName());
        System.out.println("年龄: " + hong.getAge());
    }
}
