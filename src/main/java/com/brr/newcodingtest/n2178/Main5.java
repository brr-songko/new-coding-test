package com.brr.newcodingtest.n2178;

import java.io.*;
import java.util.*;
public class Main5 {
    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] A;
    static boolean[][] visited;
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

        BFS();

        System.out.println(A[N - 1][M - 1]);
    }

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (A[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;

                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                A[ny][nx] = A[y][x] + 1;
            }
        }
    }
}
