package com.frutacloud.method;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * MethodOverLoad
 */
public class MethodOverLoad {

    public static void main(String[] args) {
        // 方法重載
        Person03 ming = new Person03();
        ming.setName("小明");
        ming.setAge(22);
        System.out.println("名称: " + ming.getName());
        System.out.println("年龄: " + ming.getAge());

        System.out.println("==================================================");
        Person03 hong = new Person03();
        hong.setName("小", "红");
        hong.setAge(23.5);
        System.out.println("名称: " + hong.getName());
        System.out.println("年龄: " + hong.getAge());

        System.out.println("==================================================");
        Person03 jun = new Person03();
        jun.setName("小", "军");
        jun.setAge("26");
        System.out.println("名称: " + jun.getName());
        System.out.println("年龄: " + jun.getAge());

    }

}

class Person03 {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String name1, String name2) {
        this.name = name1 + name2;
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
        this.age = age+"";
    }
}