package com.brr.newcodingtest.n2156;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] A, dp;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        A = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
        }


        dp[1] = A[1];
        if (n > 1) {
            dp[2] = A[1] + A[2];
        }

        dynamicP();

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(dp[i - 1], dp[i]);
        }

        System.out.println(answer);
    }

    private static void dynamicP() {
        for (int i = 3; i <= n; i++) {
//            dp[i] = Math.max(dp[i-1], Math.max(dp[i - 2] + A[i], dp[i - 3] + A[i - 1] + A[i]));
            dp[i] = Math.max(dp[i - 2] + A[i], dp[i - 3] + A[i - 1] + A[i]);
        }
    }
}
