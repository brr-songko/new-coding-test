package com.brr.newcodingtest.n11047;

import java.io.*;
import java.util.*;

public class Main3 {
    static int N, K;
    static int[] A;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                count += K/A[i];
                K = K%A[i];
            }
        }

        System.out.println(count);
    }
}

/*
동전 개수가 최소로 되려면 가장 큰
 */