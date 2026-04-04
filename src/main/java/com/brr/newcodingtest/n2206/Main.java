package com.brr.newcodingtest.n2206;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][][] dist;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        dist = new int[N][M][2];
        dist[0][0][0] = 1;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        int answer = 0;

        int dist0 = dist[N - 1][M - 1][0];
        int dist1 = dist[N - 1][M - 1][1];

        if (dist0 != 0 && dist1 != 0) {
            answer = Math.min(dist0, dist1);
        } else if (dist0 == 0 && dist1 != 0) {
            answer = dist1;
        } else if (dist0 != 0 && dist1 == 0) {
            answer = dist0;
        } else {
            answer = -1;
        }

        System.out.println(answer);
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        // 0은 벽 아직 안 부숨, 1은 부숨
        q.offer(new int[]{r, c, 0});
        visited[r][c][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int broken = temp[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                if (map[ny][nx] == 0) {
                    if (!visited[ny][nx][broken]) {
                        visited[ny][nx][broken] = true;
                        dist[ny][nx][broken] = dist[y][x][broken] + 1;
                        q.offer(new int[]{ny, nx, broken});
                    }
                }
                if (map[ny][nx] == 1) {
                    if (broken == 0 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        dist[ny][nx][1] = dist[y][x][0] + 1;
                        q.offer(new int[]{ny, nx, 1});
                    }
                }
            }
        }
    }
}
