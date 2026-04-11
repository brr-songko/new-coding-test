package com.brr.newcodingtest.n30412;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long X, answer;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new long[N];
        answer = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        answer = Math.min(answer, Math.max(0L, X - Math.abs(arr[0] - arr[1])));
        for (int i = 0; i < N - 2; i++) {
            findMin(i);
        }
        answer = Math.min(answer, Math.max(0L, X - Math.abs(arr[N - 1] - arr[N - 2])));

        System.out.println(answer);
    }

    static void findMin(int idx) {
        long L = arr[idx];
        long M = arr[idx + 1];
        long R = arr[idx + 2];

        // M만 증가시킬 때
        long dif = Math.max(0L, (Math.max(L, R) + X) - M);
        answer = Math.min(answer, dif);

        // L과 R을 증가시킬 때
        dif = Math.max(M + X - L, 0) + Math.max(M + X - R, 0);
        answer = Math.min(answer, dif);

        // L <= M <= R 순으로 만들 때
        long nm = Math.max(M, L + X);
        long nr = Math.max(R, nm + X);

        dif = (nm - M) + (nr - R);
        answer = Math.min(answer, dif);

        // L >= M >= R 순으로 만들 때
        nm = Math.max(M, R + X);
        long nl = Math.max(L, nm + X);

        dif = (nm - M) + (nl - L);
        answer = Math.min(answer, dif);
    }
}
