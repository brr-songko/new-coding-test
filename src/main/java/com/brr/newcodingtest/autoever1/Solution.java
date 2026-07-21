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

    public int solution(int w, int h, int[] blocks) {
        int n = blocks.length;

        // 1) block 번호 -> (row, col) 좌표 변환 (row-major, 1-indexed 입력 -> 0-indexed 좌표)
        int[][] coord = new int[n][2];
        for (int i = 0; i < n; i++) {
            int idx = blocks[i] - 1;
            coord[i][0] = idx / w; // row
            coord[i][1] = idx % w; // col
        }

        // 2) 두 지점 간 최단거리 테이블 (장애물이 없으므로 맨해튼 거리 = BFS 최단거리)
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Math.abs(coord[i][0] - coord[j][0]) + Math.abs(coord[i][1] - coord[j][1]);
            }
        }

        // 3) 비트마스크 DP
        //    dp[mask][last] = mask에 해당하는 지점들을 모두 방문했고, 현재 last(인덱스)에 있을 때의 최소 이동거리
        //    시작점은 항상 blocks[0] (= 1번 칸) 이므로 index 0
        final int INF = Integer.MAX_VALUE / 2;
        int fullMask = (1 << n) - 1;
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) Arrays.fill(row, INF);

        dp[1][0] = 0; // 시작점(index 0)만 방문한 상태, 이동거리 0

        for (int mask = 1; mask <= fullMask; mask++) {
            for (int last = 0; last < n; last++) {
                if ((mask & (1 << last)) == 0) continue;
                if (dp[mask][last] == INF) continue;

                // TODO: mask에서 아직 방문하지 않은 next로 이동하는 전이를 작성하시오.
                // 힌트:
                //   for (int next = 0; next < n; next++) {
                //       if ((mask & (1 << next)) != 0) continue; // 이미 방문
                //       int nextMask = mask | (1 << next);
                //       dp[nextMask][next] = Math.min(dp[nextMask][next], dp[mask][last] + dist[last][next]);
                //   }
            }
        }

        // TODO: 정답 = min(dp[fullMask][last]) for all last (시작점으로 복귀할 필요 없음)
        // int answer = INF;
        // for (int last = 0; last < n; last++) answer = Math.min(answer, dp[fullMask][last]);
        // return answer;

        throw new UnsupportedOperationException("TODO: 비트마스크 DP 전이 및 정답 계산 구현");
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
