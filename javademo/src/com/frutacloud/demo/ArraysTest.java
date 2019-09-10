package com.frutacloud.demo;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {

        int[] ns = {1, 4, 9, 16, 25};
        // 倒序打印数组元素:
        for (int i = ns.length - 1; i >= 0; i--) {
            System.out.println(ns[i]);
        }
        System.out.println("-------------------------------------");

        int[] ns2 = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        // 排序前:
        System.out.println(Arrays.toString(ns2));
        for (int i = 0; i < ns2.length - 1; i++) {
            for (int j = 0; j < ns2.length  -i - 1; j++) {
                if (ns2[j] > ns2[j + 1]) {
                    // 交换ns[j]和ns[j+1]:
                    int tmp = ns2[j];
                    ns2[j] = ns2[j + 1];
                    ns2[j + 1] = tmp;
                }
            }
            System.out.println("循环"+i+"次后, 现在的数组"+Arrays.toString(ns2));
        }
        // 排序后:
        System.out.println(Arrays.toString(ns2));
    }
}

