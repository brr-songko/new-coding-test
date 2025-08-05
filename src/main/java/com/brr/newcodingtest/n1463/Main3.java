package com.brr.newcodingtest.n1463;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        dp[1] = 0;
        if (X >= 2) {
            dp[2] = 1;
        }
        if (X >= 3) {
            dp[3] = 1;
        }

        for (int i = 4; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        System.out.println(dp[X]);
    }
}
