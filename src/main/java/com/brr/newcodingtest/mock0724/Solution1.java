package com.brr.newcodingtest.mock0724;

import java.util.*;

/**
 * 문제 1: 정밀 지도 갱신 (그리드 전체 방문 최단거리, 복귀 불필요)
 *
 * w(2~10), h(2~10), blocks(길이 2~16, 오름차순, 항상 1 포함)
 * 1번 칸에서 출발해 blocks의 모든 칸을 방문하는 최소 이동 횟수를 구한다.
 * (상하좌우 인접 이동, 장애물 없음, 재방문 가능, 시작점 복귀 불필요)
 */
public class Solution1 {

    public int solution(int w, int h, int[] blocks) {
        // TODO: 처음부터 직접 구현
        throw new UnsupportedOperationException("TODO");
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
