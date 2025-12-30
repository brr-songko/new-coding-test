package com.brr.newcodingtest.n10810;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            for (int j = a; j <= b; j++) {
                arr[j] = c;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
