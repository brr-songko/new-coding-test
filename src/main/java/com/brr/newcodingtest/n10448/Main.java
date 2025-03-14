package com.brr.newcodingtest.n10448;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static boolean check;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        arr = new int[1001];
        sb = new StringBuilder();
        for (int i = 1; i <= 1000; i++) {
            arr[i] += arr[i-1] + i;
        }
        for (int i = 0; i < T; i++) {
            check = false;
            dfs(sc.nextInt(), 0, 0);
            if (check) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int K, int depth, int sum) {
        if (depth == 3) {
            if (K == sum) {
                check = true;
            }
            return;
        }
        for (int i = 1; i <= K; i++) {
            if (check) {
                break;
            }
            dfs(K, depth + 1, sum + arr[i]);
        }
    }
}
