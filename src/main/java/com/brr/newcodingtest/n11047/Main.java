package com.brr.newcodingtest.n11047;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                count += K/A[i];
                K = K % A[i];
            }
        }

        System.out.println(count);
    }
}

/*
1. 아이디어
- 그리디 알고리즘
- for문에서
- 최대한 큰 가격의 동전으로 목표 금액을 나눈다.
- 나눈 몫만큼 count에 +한다.
- 목표 금액은 나눈 나머지로 변경한다.

2. 시간복잡도
- O(N*K) = 10 * 100000000 = O(N)
- 가능

3. 자료구조
- int N, K
- int A[]
- int count
 */