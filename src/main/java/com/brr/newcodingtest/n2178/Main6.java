package com.brr.newcodingtest.n2178;

import java.io.*;
import java.util.*;

public class Main6 {
    static int N, M, answer;
    static int[][] A;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }

        dfs(0, 0);

        System.out.println(A[N- 1][M - 1]);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (A[ny][nx] == 0) continue;
            if (visited[ny][nx]) continue;
            if (A[ny][nx] != 1 && A[ny][nx] <= A[y][x] + 1) continue;

            A[ny][nx] = A[y][x] + 1;
            dfs(ny, nx);
            visited[ny][nx] = false;

        }
    }
}
