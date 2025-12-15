package com.brr.newcodingtest.n5585;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = 1000 - N;
        int[] arr = new int[6];
        arr[0] = 500;
        arr[1] = 100;
        arr[2] = 50;
        arr[3] = 10;
        arr[4] = 5;
        arr[5] = 1;

        for (int i = 0; i < 6; i++) {
            if (target >= arr[i]) {
                answer += target / arr[i];
                target %= arr[i];
            }
        }

        System.out.println(answer);
    }
}
