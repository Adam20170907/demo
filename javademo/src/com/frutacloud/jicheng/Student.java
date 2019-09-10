package com.frutacloud.jicheng;

/**
 * Student
 */
public class Student extends Person {

    private String score;
    private String school;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setScore(Double score) {
        this.score = score + "";
    }

    public void study() {
        System.out.println(super.getName() + "在学习!");
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

}