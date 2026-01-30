package com.brr.newcodingtest.n1965;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
