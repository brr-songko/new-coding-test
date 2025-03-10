package com.brr.newcodingtest.n14501;

import java.io.*;
import java.util.*;

// 완탐 버젼

public class Main3 {
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

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(max);
    }

    public static void dfs(int depth, int sum) {
        if (depth == N) {
            max = Math.max(max, sum);
            return;
        }

        if (depth + T[depth] <= N) {
            dfs(depth + T[depth], sum + P[depth]);
        }
        dfs(depth + 1, sum);
    }
}
