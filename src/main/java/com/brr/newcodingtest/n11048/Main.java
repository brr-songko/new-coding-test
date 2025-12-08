package com.brr.newcodingtest.n11048;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map, dp;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dynamicP();

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N - 1][M - 1]);
    }

    static void dynamicP() {
        dp[0][0] = map[0][0];
        if (N > 1) {
            for (int i = 1; i < N; i++) {
                dp[i][0] = dp[i - 1][0] + map[i][0];
            }
        }
        if (M > 1) {
            for (int i = 1; i < M; i++) {
                dp[0][i] = dp[0][i - 1] + map[0][i];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = map[i][j] + Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
            }
        }
    }
}
