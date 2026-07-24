package com.brr.newcodingtest.mock0724;

import java.util.*;

/**
 * 문제 2: 최소 시작 체력
 *
 * enemy_power (길이 3~200,000, 절댓값 1~10^9)
 * n = 1..N 각각에 대해, 전체 중 n마리를 골라(순서도 자유) 모두 이기기 위한
 * 최소 시작 체력을 구한다.
 * - 체력 <= 0 이면 패배
 * - 내 체력 > 적 전투력(부호 그대로) 일 때만 이길 수 있음
 * - 이기면 내 체력 += 적 전투력 (양수면 증가, 음수면 감소)
 */
public class Solution2 {

    public int[] solution(int[] enemy_power) {
        // TODO: 처음부터 직접 구현
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        runTest(sol, new int[]{14, -10, 3, -2}, new int[]{3, 4, 10, 12});
        runTest(sol, new int[]{100, 200, 400, -50}, new int[]{51, 101, 101, 101});
        runTest(sol, new int[]{-999, -1000, -6000, -1000, -1000}, new int[]{1000, 2000, 3000, 4000, 10000});
        runTest(sol, new int[]{5, -1, 20, -3, 8}, new int[]{2, 5, 6, 6, 8});
        runTest(sol, new int[]{10, 1, 5}, new int[]{2, 5, 5});
    }

    private static void runTest(Solution2 sol, int[] enemyPower, int[] expected) {
        String input = "enemy_power=" + Arrays.toString(enemyPower);
        try {
            int[] actual = sol.solution(enemyPower);
            boolean pass = Arrays.equals(actual, expected);
            System.out.printf("[%s] %s -> expected=%s, actual=%s%n",
                    pass ? "PASS" : "FAIL", input, Arrays.toString(expected), Arrays.toString(actual));
        } catch (UnsupportedOperationException e) {
            System.out.printf("[SKIP] %s -> %s%n", input, e.getMessage());
        }
    }
}
