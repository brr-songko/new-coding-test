package com.brr.newcodingtest.n14501;

import java.io.*;
import java.util.*;

public class Main4 {
    static int[] T, P, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dynamic(N);

        System.out.println(answer);
    }

    static int dynamic(int N) {
        for (int i = 1; i <= N; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        return dp[N + 1];
    }
}
