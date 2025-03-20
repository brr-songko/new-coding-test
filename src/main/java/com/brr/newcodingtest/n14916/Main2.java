package com.brr.newcodingtest.n14916;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MAX_VALUE;
        boolean check = false;
        for (int i = 0; i <= n/5; i++) {
            int temp = n;
            int sum = 0;
            sum += i;
            temp -= 5*i;
//            System.out.println("5가 " + i + "개일 때로 나눈 temp = " + temp);
            sum += temp/2;
            temp %= 2;
//            System.out.println("2로 때로 나눈 temp = " + temp);
//            System.out.println("sum = " + sum);
            if (temp == 0) {
                max = Math.min(max, sum);
                check = true;
            }
        }
        if (!check) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }
}
