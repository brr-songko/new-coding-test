package com.brr.newcodingtest.n15649;

import java.io.*;
import java.util.*;

public class Main3 {
    static int N, M;
    static int[] A;
    static int[] answer;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        answer = new int[N];
        visited = new boolean[N];
        for (int i = 1; i <= N; i++) {
            A[i-1] = i;
        }
        sb = new StringBuilder();

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = A[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
