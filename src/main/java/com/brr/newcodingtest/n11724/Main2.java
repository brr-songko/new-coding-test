package com.brr.newcodingtest.n11724;

import java.io.*;
import java.util.*;

public class Main2 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int index) {
        if (visited[index]) {
            return;
        }

        visited[index] = true;

        for (int i = 0; i < A[index].size(); i++) {
            int temp = A[index].get(i);
            if (!visited[temp]) {
                dfs(temp);
            }
        }
    }
}
