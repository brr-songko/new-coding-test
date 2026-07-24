package com.brr.newcodingtest.n10971;

import java.io.*;
import java.util.*;

public class Main3 {

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
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 0) continue;
                list[i].add(new int[]{j, c});
            }
        }

        answer = Integer.MAX_VALUE;
        visited[1] = true;
        dfs(1, 0);

        System.out.println(answer);
    }

    public static void dfs(int cur, int cost) {
        boolean check = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                check = false;
            }
        }
        if (check) {
            for (int[] temp : list[cur]) {
                if (temp[0] == 1 && temp[1] != 0) {
                    answer = Math.min(answer, cost + temp[1]);
                }
            }
        }

        for (int[] temp : list[cur]) {
            if (!visited[temp[0]]) {
                visited[temp[0]] = true;
                dfs(temp[0], cost + temp[1]);
                visited[temp[0]] = false;
            }
        }
    }
}
