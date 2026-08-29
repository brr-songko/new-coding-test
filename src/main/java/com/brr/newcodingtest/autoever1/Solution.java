package com.brr.newcodingtest.autoever1;

import java.util.*;

/**
 * 문제 1: 정밀 지도 갱신 (그리드 전체 방문 최단거리, 복귀 불필요)
 *
 * w(2~10), h(2~10), blocks(길이 2~16, 오름차순, 항상 1 포함)
 * 1번 칸에서 출발해 blocks의 모든 칸을 방문하는 최소 이동 횟수를 구한다.
 * (상하좌우 인접 이동, 장애물 없음, 재방문 가능, 시작점 복귀 불필요)
 */
public class Solution {

    int n, fullMask;
    int[][] D;  // D[i][j] = blocks[i]와 blocks[j] 사이 맨해튼 거리 (1-indexed, i/j: 1..n)
    int[][] dp; // dp[mask][cur]

    public int solution(int w, int h, int[] blocks) {
        n = blocks.length;
        fullMask = (1 << n) - 1;

        // 1) blocks[i-1] (1-indexed i=1..n) -> (row, col) 좌표 변환
        int[][] coord = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            int idx = blocks[i - 1] - 1; // 1-indexed 칸 번호 -> 0-indexed idx
            coord[i][0] = idx / w; // row
            coord[i][1] = idx % w; // col
        }

        // 2) blocks끼리의 맨해튼 거리 테이블 (장애물 없음 -> 맨해튼 거리 = 최단거리)
        D = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                D[i][j] = Math.abs(coord[i][0] - coord[j][0]) + Math.abs(coord[i][1] - coord[j][1]);
            }
        }

        // 3) 비트마스크 DP (재귀), 시작점은 항상 blocks[1](=1번 칸)
        dp = new int[1 << n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(1, 1);
    }

    // dp[mask][cur] = mask에 해당하는 blocks들을 모두 방문했고, 현재 cur(1..n)에 있을 때의 최소 이동거리
    public int solve(int mask, int cur) {
        if (mask == fullMask) return 0; // 복귀 불필요 -> 다 방문했으면 끝

        if (dp[mask][cur] != -1) return dp[mask][cur];

        int best = Integer.MAX_VALUE;
        for (int next = 1; next <= n; next++) {
            int bit = 1 << (next - 1);
            if ((mask & bit) != 0) continue; // 이미 방문
            best = Math.min(best, D[cur][next] + solve(mask | bit, next));
        }

        return dp[mask][cur] = best;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        runTest(sol, 5, 2, new int[]{1, 5, 8}, 6);
        runTest(sol, 4, 4, new int[]{1, 8, 10, 16}, 8);
        runTest(sol, 3, 3, new int[]{1, 3, 7, 9}, 6);
    }

    private static void runTest(Solution sol, int w, int h, int[] blocks, int expected) {
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
