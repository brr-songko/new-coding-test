package com.brr.newcodingtest.n1012;

import java.io.*;
import java.util.*;

public class Main3 {
    static int T, N, M, K, count;
    static int[][] A;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                A[y][x] = 1;
            }
            count = 0;
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[k][j] && A[k][j] == 1) {
                        dfs(k, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (A[ny][nx] == 0) continue;
            if (visited[ny][nx]) continue;

            dfs(ny, nx);
        }
    }
}
