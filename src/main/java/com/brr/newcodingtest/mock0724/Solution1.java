package com.brr.newcodingtest.mock0724;

import java.io.*;
import java.util.*;

/**
 * 문제 1: 정밀 지도 갱신 (그리드 전체 방문 최단거리, 복귀 불필요)
 *
 * w(2~10), h(2~10), blocks(길이 2~16, 오름차순, 항상 1 포함)
 * 1번 칸에서 출발해 blocks의 모든 칸을 방문하는 최소 이동 횟수를 구한다.
 * (상하좌우 인접 이동, 장애물 없음, 재방문 가능, 시작점 복귀 불필요)
 */
public class Solution1 {

    static int[][] dp; // dp[mask][cur]
    static int[][] D;
    static int n, fullMask;

    public int solution(int w, int h, int[] blocks) {
        n = blocks.length;
        fullMask = (1 << n) - 1;

        int[][] coord = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            int idx = blocks[i - 1] - 1;
            coord[i][0] = idx / w;
            coord[i][1] = idx % w;
        }

        D = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                D[i][j] = Math.abs(coord[i][0] - coord[j][0]) + Math.abs(coord[i][1] - coord[j][1]);
            }
        }

        dp = new int[1 << n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(1, 1);
    }

    public int solve(int mask, int cur) {
        if (mask == fullMask) return 0;

        if (dp[mask][cur] != -1) return dp[mask][cur];

        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                best = Math.min(best, solve(mask | bit, i) + D[cur][i]);
            }
        }

        return dp[mask][cur] = best;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        runTest(sol, 5, 2, new int[]{1, 5, 8}, 6);
        runTest(sol, 4, 4, new int[]{1, 8, 10, 16}, 8);
        runTest(sol, 3, 3, new int[]{1, 3, 7, 9}, 6);
    }

    private static void runTest(Solution1 sol, int w, int h, int[] blocks, int expected) {
        String input = String.format("w=%d, h=%d, blocks=%s", w, h, Arrays.toString(blocks));
        try {
            int actual = sol.solution(w, h, blocks);
            boolean pass = actual == expected;
            System.out.printf("[%s] %s -> expected=%d, actual=%d%n",
                    pass ? "PASS" : "FAIL", input, expected, actual);
        } catch (UnsupportedOperationException e) {
            System.out.printf("[SKIP] %s -> %s%n", input, e.getMessage());
        }
    }
}
