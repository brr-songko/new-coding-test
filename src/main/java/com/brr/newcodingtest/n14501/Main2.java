package com.brr.newcodingtest.n14501;

import java.io.*;
import java.util.*;

// dp 앞에서부터 시작하는 버전

public class Main2 {
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

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) {
                d[i + T[i]] = Math.max(d[i + T[i]], d[i] + P[i]);
            }
            d[i+1] = Math.max(d[i], d[i+1]);
        }

        System.out.println(d[N]);
    }
}
