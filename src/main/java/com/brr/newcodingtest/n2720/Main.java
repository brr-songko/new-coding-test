package com.brr.newcodingtest.n2720;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[4];
        StringBuilder sb = new StringBuilder();

        arr[0] = 25;
        arr[1] = 10;
        arr[2] = 5;
        arr[3] = 1;

        for (int i = 0; i < T; i++) {
            int[] answer = new int[4];
            int now = sc.nextInt();

            for (int j = 0; j < 4; j++) {
                if (now >= arr[j]) {
                    answer[j] += now / arr[j];
                    now %= arr[j];
                }
                sb.append(answer[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
