package com.brr.newcodingtest.n11403;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[][] A;
    static StringBuilder sb;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int oneOrZero = Integer.parseInt(st.nextToken());
                if (oneOrZero == 1) {
                    list[i].add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited = new boolean[N];
                check = false;
                dfs(i, j);
                if (check) {
                    sb.append("1").append(" ");
                } else {
                    sb.append("0").append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int s, int e) {
        for (int i = 0; i < list[s].size(); i++) {
            if (list[s].get(i) == e) {
                check = true;
                return;
            }
        }

        if (visited[s]) {
            return;
         }

        visited[s] = true;

        for (int i = 0; i < list[s].size(); i++) {
            if (!visited[list[s].get(i)]) {
                dfs(list[s].get(i), e);
            }
        }
    }
}
