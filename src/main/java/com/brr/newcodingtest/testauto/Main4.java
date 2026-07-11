package com.brr.newcodingtest.testauto;

import java.io.*;
import java.util.*;
/*
2098 외판원 순회 비트마스트 DP
 */
public class Main4 {

    static int N, answer;
    static int[][] D;
    static int[][] dp; // [mask][cur]

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
                 best = Math.min(best, D[cur][i] + nextResult);
             }
        }

        dp[mask][cur] = best;

        return dp[mask][cur];
    }
}

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
 */