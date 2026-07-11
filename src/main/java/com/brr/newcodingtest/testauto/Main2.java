package com.brr.newcodingtest.testauto;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, answer;
    static ArrayList<int[]>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(String.valueOf(s.charAt(j) - '0'));
                if (v == 0) continue;
                list[i + 1].add(new int[]{j + 1, v});
            }
        }

        visited[1] = true;
        dfs(1, 0, 1);

        System.out.println(answer);
    }

    public static void dfs(int cur, int cost, int depth) {
        answer = Math.max(answer, depth);

        for (int[] temp : list[cur]) {
            int v = temp[0];
            int c = temp[1];

            if (!visited[v] && c >= cost) {
                visited[v] = true;
                dfs(v, c, depth + 1);
                visited[v] = false;
            }
        }
    }
}

/*
1029 그림교환
&& c <= cost
3
022
101
110
 */