package com.brr.newcodingtest.n2178;

import java.io.*;
import java.util.*;

public class Main3 {
    static int N, M;
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

        bfs();

        System.out.println(A[N-1][M-1]);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (A[ny][nx] == 0) continue;
                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                A[ny][nx] = A[temp[0]][temp[1]] + 1;
            }
        }
    }
}