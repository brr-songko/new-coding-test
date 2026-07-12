package com.brr.newcodingtest.n2098;

import java.io.*;
import java.util.*;

public class Main {

    static int N, answer;
    static int[][] D;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1][N + 1];
        dp = new int[1 << N][N + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = solve(1, 1);

        System.out.println(answer);
    }

    public static int solve(int mask, int cur) {
        if (mask == (1 << N) - 1) {
            if (D[cur][1] == 0) return Integer.MAX_VALUE;
            else return D[cur][1];
        }
        if (dp[mask][cur] != -1) return dp[mask][cur];

        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0 && D[cur][i] != 0) {
                int nextResult = solve(mask | bit, i);
                if (nextResult == Integer.MAX_VALUE) continue;
                best = Math.min(best, nextResult + D[cur][i]);
            }
        }

        dp[mask][cur] = best;

        return dp[mask][cur];
    }
}
