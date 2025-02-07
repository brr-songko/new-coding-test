package com.brr.newcodingtest.n15649;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[M];
        check = new boolean[N];

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int value : A) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                A[depth] = i + 1;
                dfs(depth + 1);
                check[i] = false;
            }
        }
    }
}

/*
int N, M
int[] A
boolean[] check

dfs() {
    if depth == M
        sb.append
    for i = 1 ~ N
        if !check
            check = true
            A[depth] = i
            dfs(depth + 1)
            check = false

}
sout sb
 */
