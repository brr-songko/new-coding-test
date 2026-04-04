package com.brr.newcodingtest.n1600;

import java.io.*;
import java.util.*;

public class Main3 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] hdy = {-2, -1, 1, 2, 2, -1, 1, -2};
    static int[] hdx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] map;
    static int[][] dist;
    static boolean[][][] visited;
    static int K, W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0, 0});
        visited[r][c][0] = true;
        dist = new int[H][W];
        dist[r][c] = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int k = temp[2];
            int dist = temp[3];

            if (y == H - 1 && x == W - 1) {
                System.out.println(dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if (map[ny][nx] == 1) continue;
                if (visited[ny][nx][k]) continue;

                visited[ny][nx][k] = true;
                q.offer(new int[]{ny, nx, k, dist + 1});
            }

            if (k < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + hdy[i];
                    int nx = x + hdx[i];

                    if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                    if (map[ny][nx] == 1) continue;
                    if (visited[ny][nx][k + 1]) continue;

                    visited[ny][nx][k + 1] = true;
                    q.offer(new int[]{ny, nx, k + 1, dist + 1});
                }
            }
        }

        System.out.println(-1);
    }
}
