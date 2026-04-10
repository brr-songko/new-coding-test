package com.brr.newcodingtest.n32954;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long totalPair = 0; // 전체에서 만들 수 있는 최대 쌍 수
        long g2 = 0; // 쌍 1개 써서 +2 얻을 수 있는 총 횟수
        long even = 0; // 마지막 + 1 가능한 짝수 Ai 개수

        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(st.nextToken());

            totalPair += a / 2;



            g2 += (a - 1) / 2;
            if (a % 2 == 0) even++;
        }

        if (K == 0) {
            // 만들어야 하는 쌍이 0개라는 뜻
            // 젓가락을 아예 안 뽑아도 이미 "항상 0쌍 이상"은 만족
            // 따라서 최소 X는 0
            System.out.println(0);
            return;
        }

        if (totalPair < K) {
            // totalPair = 전체 젓가락들로 만들 수 있는 최대 쌍 수
            // 이것보다 K가 더 크면, 전부 다 뽑아도 K쌍을 못 만듦
            // 즉 어떤 X를 골라도 조건 만족 불가능
            System.out.println(-1);
            return;
        }

        long pairBudget = K - 1;
        // pairBudget = "최대로 K-1쌍까지만 생기게 버티는" 상황에서
        // 사용할 수 있는 쌍의 개수
        //
        // 왜 K-1 이냐?
        // 문제는 "항상 K쌍 이상 생기게 하는 최소 X"를 묻고 있음
        // 그 반대로 생각하면,
        // "아직 K쌍이 안 생기게, 즉 K-1쌍까지만 생기게 하면서
        // 최대 몇 개까지 뽑을 수 있나?"를 구한 뒤 +1 하면 됨

        long maxPick = N
                // 색이 N개 있으니까
                // 각 색에서 1개씩은 쌍 없이 뽑을 수 있음
                // 색이 3개면 1번색 1개, 2번색 1개, 3번색 1개 총 3개 뽑아도 쌍은 0개
                + 2L * Math.min(pairBudget, g2)
                // pairBudget 은 아직 사용할 수 있는 쌍 수
                // g2는 쌍 1개를 써서 젓가락 2개를 더 가져올 수 있는 총 횟수
                // 쌍 예산이 5여도 g2 가 3이면 3번 밖에 못 쓰고, 반대로 g2가 10 이어도 예산이 2면 2번 밖에 못씀
                + Math.min(even, Math.max(0L, pairBudget - g2));
                // Math.max 부분
                // 예를 들어 pairBudget = 5 이고, g2 = 3 일 때,
                // 사용 가능한 쌍 예산에서 3번의 +2를 사용하고도 2의 쌍 예산이 남은 것.
                // 반대로 pairBudget = 2 이고 g2 = 5이면, 예산이 먼저 바닥남. 사용할 수 있는 예산이 안남았기에 남은 예산은 0인데, 음수가 나오니 0으로 처리하기 위해 Math.max로

        System.out.println(maxPick + 1);
    }
}
