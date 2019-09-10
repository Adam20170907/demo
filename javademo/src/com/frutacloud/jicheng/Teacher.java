package com.frutacloud.jicheng;

/**
 * Teacher
 */
public class Teacher extends Person {
    private String school;

    public void Teaching() {
        System.out.println("在教书! ");
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}