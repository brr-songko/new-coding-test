package com.brr.newcodingtest.n2589;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer, max;
    static String[][] arr;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] sList = s.split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = sList[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j].equals("L")) {
                    visited = new boolean[N][M];
                    dist = new int[N][M];
                    bfs(i, j);
                    answer = Math.max(answer, max);
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (arr[ny][nx].equals("W")) continue;

                dist[ny][nx] += dist[y][x] + 1;
                max = Math.max(max, dist[ny][nx]);
                q.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }
    }
}
