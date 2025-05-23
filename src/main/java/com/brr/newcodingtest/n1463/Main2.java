package com.brr.newcodingtest.n1463;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];


        dp[1] = 0;
        if (N >= 2) {
            dp[2] = 1;
        }
        if (N >= 3) {
            dp[3] = 1;
        }

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
