package com.brr.newcodingtest.n2206;

import java.io.*;
import java.util.*;

public class Main3 {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[][][] dist;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        int answer = Math.min(dist[N - 1][M - 1][0], dist[N - 1][M - 1][1]);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int broken = temp[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx][broken]) continue;

                if (map[ny][nx] == 1) {
                    if (broken == 0) {
                        dist[ny][nx][1] = dist[y][x][broken] + 1;
                        visited[ny][nx][1] = true;
                        q.offer(new int[]{ny, nx, 1});
                    }
                } else if (map[ny][nx] == 0) {
                    dist[ny][nx][broken] = dist[y][x][broken] + 1;
                    visited[ny][nx][broken] = true;
                    q.offer(new int[]{ny, nx, broken});
                }
            }
        }
    }
}
