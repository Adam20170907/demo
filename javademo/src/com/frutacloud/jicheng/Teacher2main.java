package com.frutacloud.jicheng;

/**
 * Teacher2main
 */
public class Teacher2main {

    public static void main(String[] args) {
        Teacher teacher01 = new Teacher();

        teacher01.setName("王老师");
        teacher01.setAge(30);
        teacher01.setSchool("xx高中");
        System.out.println("姓名: " + teacher01.getName());
        System.out.println("年龄: " + teacher01.getAge());
        System.out.println("学校: " + teacher01.getSchool());
        teacher01.Teaching();

        System.out.println("=====================================");

        Teacher tercher02 = new Teacher();
        tercher02.name = "刘老师";
        System.out.println("名称: " + tercher02.getName());

    }
}