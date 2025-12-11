package com.brr.newcodingtest.n14916;

import java.io.*;
import java.util.*;

public class Main3 {
    static int n;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];

        dynamicP();

        if (dp[n] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n]);
    }

    static void dynamicP() {
        if (n >= 1) dp[1] = Integer.MAX_VALUE;
        if (n >= 2) dp[2] = 1;
        if (n >= 3) dp[3] = Integer.MAX_VALUE;
        if (n >= 4) dp[4] = 2;
        if (n >= 5) dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }
    }
}
