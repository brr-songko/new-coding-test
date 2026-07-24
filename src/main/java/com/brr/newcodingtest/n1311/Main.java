package com.brr.newcodingtest.n1311;
/*
1311 할 일 정하기
 */

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] D;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1][N + 1];
        dp = new int[1 << N];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(dp, -1);


        System.out.println(solve(0));
    }

    public static int solve(int mask) {
        int person = Integer.bitCount(mask) + 1;
        if (person > N) return 0;
        if (dp[mask] != -1) return dp[mask];

        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                int cost = D[person][i] + solve(mask | bit);
                best = Math.min(best, cost);
            }
        }

        return dp[mask] = best;
    }
}

/*
3
2 3 3
3 2 3
3 3 2
 */
