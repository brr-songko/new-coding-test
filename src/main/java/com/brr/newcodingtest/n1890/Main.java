package com.brr.newcodingtest.n1890;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static long[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dynamicP();

        System.out.println(dp[N - 1][N - 1]);
    }

    static void dynamicP() {
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (dp[i][j] == 0) continue;
                if (i == N - 1 && j == N - 1) continue;

                int k = map[i][j];

                if (i + k < N) dp[i + k][j] += dp[i][j];
                if (j + k < N) dp[i][j + k] += dp[i][j];

            }
        }
    }
}
