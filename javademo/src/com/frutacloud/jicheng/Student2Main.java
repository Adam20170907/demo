package com.frutacloud.jicheng;

/**
 * Student2Main
 */
public class Student2Main {

    public static void main(String[] args) {
        Student stu01 = new Student();
        stu01.setName("小明");
        stu01.setAge(22);
        stu01.setScore("95");

        System.out.println("名称: "+stu01.getName());
        System.out.println("年龄: "+stu01.getAge());
        System.out.println("成绩: "+stu01.getScore());
        stu01.study();

    }
}