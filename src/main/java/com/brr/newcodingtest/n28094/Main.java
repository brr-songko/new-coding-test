package com.brr.newcodingtest.n28094;

import java.io.*;
import java.util.*;

public class Main {
    static int[] perm, pos;
    static boolean[] visited;
    static int T, N, M, maxScore, maxNum;
    static StringBuilder sb = new StringBuilder();
    static int[][] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            perm = new int[N + 1];
            pos = new int[N + 1];
            visited = new boolean[N + 1];
            weight = new int[N + 1][N + 1];
            maxScore = 0;
            maxNum = 0;

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                weight[A][B] += V;
            }

            dfs(0, 0);

            sb.append(maxScore).append(" ").append(maxNum).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int score) {
        if (depth == N) {
            if (score == maxScore) {
                maxNum++;
            } else if (score > maxScore) {
                maxScore = score;
                maxNum = 1;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                int gained = 0;

                for (int j = 1; j <= N; j++) {
                    if (!visited[j]) {
                        gained += weight[i][j];
                    }
                }
                visited[i] = true;
                dfs(depth + 1, score + gained);
                visited[i] = false;
            }
        }
    }
}