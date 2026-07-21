package com.brr.newcodingtest.autoever4;

import java.util.*;

/**
 * 문제 4: 정비 라인 스케줄링 (난이도: 상대적으로 어려움)
 *
 * 정비 라인이 m개 있다 (라인 번호 0 ~ m-1). 처음엔 모든 라인이 비어 있다.
 * 차량 n대가 arrival(도착시각, 오름차순 정렬되어 주어짐)과 duration(정비 소요시간)을 가지고 순서대로 도착한다.
 *
 * 각 차량이 도착하면 그 시점에 "가장 먼저 비는(=free time이 가장 작은) 라인"에 배정된다.
 * 배정된 시점에 라인이 이미 비어있다면(free time <= arrival) 즉시 정비를 시작하고,
 * 아직 사용 중이라면(free time > arrival) 그 라인이 빌 때까지 기다렸다가 그 시각에 정비를 시작한다.
 * 여러 라인의 free time이 동률이면, "라인 번호가 더 작은" 라인을 우선 배정한다.
 *
 * 각 차량이 정비를 마치는 시각(finish time)을 도착 순서대로 배열에 담아 반환하라.
 *
 * 제약: 1 <= m <= 100,000 / 1 <= n <= 200,000 / 0 <= arrival[i] <= 10^9 (오름차순) / 1 <= duration[i] <= 10^9
 *
 * 예) m=2, arrival=[0,0,1,5], duration=[3,2,4,1]
 *     - 차량0(도착0,소요3): 라인0,1 둘다 free=0 동률 -> 라인0 배정, 시작0,종료3
 *     - 차량1(도착0,소요2): 라인0 free=3, 라인1 free=0 -> 라인1 배정, 시작0,종료2
 *     - 차량2(도착1,소요4): 라인0 free=3, 라인1 free=2 -> 라인1 배정(더 작음), 시작=max(1,2)=2,종료6
 *     - 차량3(도착5,소요1): 라인0 free=3, 라인1 free=6 -> 라인0 배정, 시작=max(5,3)=5,종료6
 *     -> 정답: [3, 2, 6, 6]
 */
public class Solution {

    public int[] solution(int m, int[] arrival, int[] duration) {
        // TODO: 구현하시오.
        throw new UnsupportedOperationException("TODO: 구현하시오");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        runTest(sol, 2, new int[]{0, 0, 1, 5}, new int[]{3, 2, 4, 1}, new int[]{3, 2, 6, 6});
        runTest(sol, 1, new int[]{0, 2, 3}, new int[]{5, 1, 1}, new int[]{5, 6, 7});
        runTest(sol, 3, new int[]{0, 0, 0, 10}, new int[]{2, 2, 2, 1}, new int[]{2, 2, 2, 11});
    }

    private static void runTest(Solution sol, int m, int[] arrival, int[] duration, int[] expected) {
        String input = "m=" + m + ", arrival=" + Arrays.toString(arrival) + ", duration=" + Arrays.toString(duration);
        try {
            int[] actual = sol.solution(m, arrival, duration);
            boolean pass = Arrays.equals(actual, expected);
            System.out.printf("[%s] %s -> expected=%s, actual=%s%n",
                    pass ? "PASS" : "FAIL", input, Arrays.toString(expected), Arrays.toString(actual));
        } catch (UnsupportedOperationException e) {
            System.out.printf("[SKIP] %s -> %s%n", input, e.getMessage());
        }
    }
}
