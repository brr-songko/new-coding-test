package com.brr.newcodingtest.n2579;

import java.util.*;

public class Main2 {
    static int N;
    static int[] dp, A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1];
        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        dp[1] = A[1];
        if (N >= 2) {
            dp[2] = A[1] + A[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + A[i - 1]) + A[i];
        }

        System.out.println(dp[N]);
    }
}
