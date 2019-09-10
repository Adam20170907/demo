package com.frutacloud.demo;
/**
 * Cite
 */
public class Cite {

    public String name;
    public double  latitude;
    public double  longitude;
}

/**
 * InnerCite
 */
class InnerCite {

    public static void main(String[] args) {
        Cite bj = new Cite();
        bj.name = "北京";
        bj.latitude = 39.903;
        bj.longitude = 116.401;
        System.out.println(bj.name);
        System.out.println("location: " + bj.latitude + ", " + bj.longitude);
        System.out.format("地区, %f, %f %n",bj.latitude, bj.longitude);
    }
}