package com.brr.newcodingtest.autoever2;

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
public class Solution {

    public int[] solution(int[] enemy_power) {
        int n = enemy_power.length;
        int[] answer = new int[n];

        // 1) 절댓값 기준 오름차순 정렬 (부호는 원본 값 그대로 유지)
        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) sorted[i] = enemy_power[i];
        Arrays.sort(sorted, (a, b) -> Math.abs(a) - Math.abs(b));

        // k = 1..n 순서로 정렬된 배열의 앞에서부터 하나씩 추가하며 answer[k-1]을 갱신한다.
        // TODO: 아래 상태를 유지하면서 채우시오.
        //   - requiredStart: 지금까지 등장한 양수들만 놓고 봤을 때 필요한 최소 시작 체력(정답 후보)
        //   - posSum: 지금까지 등장한 양수들의 합
        //   - negSum: 지금까지 등장한 음수들의 합 (0 이하 값)
        //
        // 새 원소 v가 추가될 때:
        //   - v > 0 이면:
        //       requiredStart = max(requiredStart, (v - posSum) + 1);
        //       posSum += v;
        //   - v <= 0 이면:
        //       negSum += v;
        //
        // 매 k마다:
        //   answer[k-1] = max(requiredStart, 1 - posSum - negSum);
        //
        // (증명 아이디어: 양수는 오름차순으로 먼저 처리하는 게 항상 최적이고,
        //  음수만 남은 구간의 부분합은 순서와 무관하게 단조감소하므로
        //  최종 누적합만 확인하면 된다.)

        throw new UnsupportedOperationException("TODO: 그리디 로직 구현");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        runTest(sol, new int[]{14, -10, 3, -2}, new int[]{3, 4, 10, 12});
        runTest(sol, new int[]{100, 200, 400, -50}, new int[]{51, 101, 101, 101});
        runTest(sol, new int[]{-999, -1000, -6000, -1000, -1000}, new int[]{1000, 2000, 3000, 4000, 10000});
        runTest(sol, new int[]{5, -1, 20, -3, 8}, new int[]{2, 5, 6, 6, 8});
        runTest(sol, new int[]{10, 1, 5}, new int[]{2, 5, 5});
    }

    private static void runTest(Solution sol, int[] enemyPower, int[] expected) {
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
