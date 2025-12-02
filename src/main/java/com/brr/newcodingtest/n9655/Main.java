package com.brr.newcodingtest.n9655;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] dp = new boolean[n + 4];

        dp[1] = true;
        dp[2] = false;
        dp[3] = true;

        for (int i = 4; i <= n; i++) {
            dp[i] = (!dp[i - 1]);
        }

        System.out.println(dp[n] ? "SK" : "CY");
    }
}
