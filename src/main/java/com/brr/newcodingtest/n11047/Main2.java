package com.brr.newcodingtest.n11047;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, K;
    static int[] A;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i >= 0; i--) {
            if (A[i] <= K) {
                cnt = cnt + (K/A[i]);
                K = K%A[i];
            }
        }

        System.out.println(cnt);
    }
}

/*
1. 아이디어
- 필요 동전 개수의 최솟값 구하는 프로그램 -> 최대한 큰 금액의 동전을 사용하면 됨.
- for 문을 돌면서 K보다 한 단계 작은 값의 동전 찾기, 오름차순이니까 N-1 부터 0까지로
- 찾으면 K를 해당 값으로 나눈 몫을 count +, K 는 나눈 나머지로 바꿔주기

2. 시간복잡도
- N * M = 10 * 100,000,000 = 100,000,000
- O(N) 가능

3. 자료구조
- int N, K
- int[] A
- int count

 */
