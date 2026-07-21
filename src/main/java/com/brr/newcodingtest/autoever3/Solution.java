package com.brr.newcodingtest.autoever3;

import java.util.*;

/**
 * -------------------------------------------------------------
 * 프로그래머스
 * 자리	문제	레벨	스킬
 * 1번(쉬운 편)	호텔 대실	Lv2	PQ 기반 다중 자원 배정 그리디
 * 2번(어려운 편)	징검다리	Lv3	이분탐색(파라메트릭 서치) + feasibility 체크
 * 로 3,4회는 대체
 * -------------------------------------------------------------
 */

/**
 * 문제 3: 부품 박스 배차 (난이도: 상대적으로 쉬움)
 *
 * 컨베이어 벨트 위에 부품 박스들이 순서대로 놓여 있다 (boxWeight, 길이 1~100,000, 각 무게 1~10^9).
 * 트럭은 최대 truckCount대(1~boxWeight.length)까지 사용할 수 있다.
 * 각 트럭은 "연속된" 박스들만 실을 수 있고(원래 순서를 바꿀 수 없음), 트럭 한 대는 반드시 1개 이상의 박스를 실어야 한다.
 * 즉, boxWeight 배열을 truckCount개 이하의 연속 구간으로 나눈다.
 *
 * 모든 박스를 truckCount대 이하로 다 실을 수 있도록 하면서,
 * "트럭 한 대가 실어야 하는 무게 합"의 최댓값을 최소화하고 싶다.
 * 그 최솟값(=트럭 용량의 최솟값)을 구하라.
 *
 * 예) boxWeight=[7,2,5,10,8], truckCount=2
 *     -> [7,2,5]=14, [10,8]=18 로 나누면 최댓값 18 (이보다 더 작게 만들 수 없음)
 */
public class Solution {

    public int solution(int[] boxWeight, int truckCount) {
        // TODO: 구현하시오.
        throw new UnsupportedOperationException("TODO: 구현하시오");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        runTest(sol, new int[]{7, 2, 5, 10, 8}, 2, 18);
        runTest(sol, new int[]{1, 2, 3, 4, 5}, 2, 9);
        runTest(sol, new int[]{2, 3, 1, 2, 4, 3}, 5, 4);
        runTest(sol, new int[]{10, 10, 10, 10}, 4, 10);
        runTest(sol, new int[]{5, 5, 5, 5, 5, 5}, 1, 30);
    }

    private static void runTest(Solution sol, int[] boxWeight, int truckCount, int expected) {
        String input = "boxWeight=" + Arrays.toString(boxWeight) + ", truckCount=" + truckCount;
        try {
            int actual = sol.solution(boxWeight, truckCount);
            boolean pass = actual == expected;
            System.out.printf("[%s] %s -> expected=%d, actual=%d%n",
                    pass ? "PASS" : "FAIL", input, expected, actual);
        } catch (UnsupportedOperationException e) {
            System.out.printf("[SKIP] %s -> %s%n", input, e.getMessage());
        }
    }
}
