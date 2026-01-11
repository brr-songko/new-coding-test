package com.brr.newcodingtest.n1325;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] dp;
    static int[] answers;
    static int N, M, max, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        list = new ArrayList[N + 1];
        answers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, answers[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (answers[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    static void dfs(int v) {
        visited[v] = true;

        for (int next : list[v]) {
            if (!visited[next]) {
                answers[next]++;
                dfs(next);
            }
        }
    }
}
