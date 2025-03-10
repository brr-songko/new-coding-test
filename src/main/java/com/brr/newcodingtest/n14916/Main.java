package com.brr.newcodingtest.n14916;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(calculate(n));
    }

    static int calculate(int n) {
        int min = 0;
        boolean check = false;


        for (int i = n/5; i >= 0; i--) {
            int temp = n - (5 * i);
            if (temp % 2 == 0) {
                min += i;
                min += temp/2;
                check = true;
                break;
            }

        }

        if (!check) {
            min = -1;
        }

        return min;
    }
}
