package com.brr.newcodingtest.n2098;

import java.io.*;
import java.util.*;

public class Main4 {

    static int N, answer;
    static int[][] D;
    static int[][] dp;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1][N + 1];
        dp = new int[N + 1][1 << N];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        answer = solve(1, 1);

        System.out.println(answer);
    }

    public static int solve(int mask, int cur) {
        if (mask == (1 << N) - 1) {
            if (D[cur][1] != 0) return D[cur][1];
            else return INF;
        }

        if (dp[cur][mask] != -1) return dp[cur][mask];

        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0 && D[cur][i] != 0) {
                int val = solve(mask | bit, i);
                if (val == INF) continue;
                int cost = val + D[cur][i];
                best = Math.min(best, cost);
            }
        }

        return dp[cur][mask] = best;
    }
}

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

35
 */