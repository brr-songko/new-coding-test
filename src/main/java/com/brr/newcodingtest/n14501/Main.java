package com.brr.newcodingtest.n14501;

import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    static int N;
    static int[] T;
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = new int[N];
        P = new int[N];
        int[] d = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (i + T[i] > N) {
                d[i] = d[i + 1];
            } else {
                d[i] = Math.max(d[i + 1], d[i + T[i]] + P[i]);
            }
        }

        System.out.println(d[0]);
    }
}


/*

max 값 정해놓고

for문 돌면서 i번째부터 시작할 때의 값과 비교해서 가장 큰 녀석을 max로 하자.
상담할지 말지 선택하는 조건문
1. Ti값 + 현재 날짜 변수가 N보다 작거나 같은 경우
2.

 */