package com.brr.newcodingtest.n2098;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] D;
    static int[][][] dp; // dp[cur][maks][cost]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1][N + 1];
        dp = new int[N + 1][1 << N][10];
        for (int[][] a : dp) {
            for (int [] b : a) {
                Arrays.fill(b, -1);
            }
        }

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1;  j <= N; j++) {
                D[i][j] = s.charAt(j - 1) - '0';
            }
        }

        System.out.println(solve(1, 1, 0));
    }

    public static int solve(int cur, int mask, int cost) {
        if (dp[cur][mask][cost] != -1) return -1;

        int best = Integer.bitCount(mask);

        for (int i = 1; i <= N; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0 && D[cur][i] >= cost) {
                best = Math.max(best, solve(i, mask | bit, D[cur][i]));
            }
        }

        return dp[cur][mask][cost] = best;
    }
}
