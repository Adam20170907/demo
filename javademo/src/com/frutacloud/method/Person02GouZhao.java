package com.frutacloud.method;

/**
 * Person02GouZhaoMain
 */
class Person02GouZhaoMain {
    public static void main(String[] args) {
        // 调用构造方法
        Person02GouZhao ming = new Person02GouZhao("小明", 18);
        System.out.println("ming.名稱: " + ming.getName());
        System.out.println("ming.年齡: " + ming.getAge());
        Person02GouZhao hong = new Person02GouZhao();
        System.out.println("========================================");
        System.out.println("hong.名称: " + hong.getName());
        System.out.println("hong.年龄: " + hong.getAge());
        hong.setAge(20);
        hong.setName("小红");
        System.out.println("========================================");
        System.out.println("hong.名称: " + hong.getName());
        System.out.println("hong.年龄: " + hong.getAge());
        Person02GouZhao jun = new Person02GouZhao("小军");
        System.out.println("========================================");
        System.out.println("jun.名称: " + jun.getName());
        System.out.println("jun.年龄: " + jun.getAge());

    }

}

/**
 * Person02GouZhao
 */
public class Person02GouZhao {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    // 构造方法重载
    public Person02GouZhao(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 构造方法重载
    public Person02GouZhao(String name) {
        this(name, 18);
    }

    // 构造方法重载
    public Person02GouZhao() {
        this("Unnamed");
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}