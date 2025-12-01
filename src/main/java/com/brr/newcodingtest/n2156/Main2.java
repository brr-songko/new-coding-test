package com.brr.newcodingtest.n2156;

import java.io.*;
import java.util.*;

public class Main2 {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = dynamic(n);

        System.out.println(answer);
    }

    static int dynamic(int n) {
        if (n == 1) return arr[1];
        if (n == 2) return arr[1] + arr[2];

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        return dp[n];
    }
}
