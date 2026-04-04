package com.brr.newcodingtest.n1600;

import java.io.*;
import java.util.*;

class Node2 {
    int y;
    int x;
    int k;
    int dist;

    public Node2(int y, int x, int k, int dist) {
        this.y = y;
        this.x = x;
        this.k = k;
        this.dist = dist;
    }
}

public class Main2 {

    static int K, W, H, answer;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] hdy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hdx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] map;
    static int[][][] dist;
    static boolean[][][] visited;

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

        int answer = bfs(0, 0);

        System.out.println(answer);
    }

    static int bfs(int r, int c) {
        dist = new int[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node2> q = new LinkedList<>();
        q.offer(new Node2(r, c, 0, 0));
        visited[r][c][0] = true;
        dist[r][c][0] = 0;

        while (!q.isEmpty()) {
            Node2 node = q.poll();
            int y = node.y;
            int x = node.x;
            int k = node.k;
            int totalDist = node.dist;

            if (y == H - 1 && x == W - 1) {
                return totalDist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if (map[ny][nx] == 1) continue;
                if (visited[ny][nx][k]) continue;

                visited[ny][nx][k] = true;
                q.offer(new Node2(ny, nx, k, totalDist + 1));
//                dist[ny][nx][k] = totalDist + 1;

            }

            if (k < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + hdy[i];
                    int nx = x + hdx[i];

                    if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                    if (map[ny][nx] == 1) continue;
                    if (visited[ny][nx][k + 1]) continue;

                    visited[ny][nx][k + 1] = true;
                    q.offer(new Node2(ny, nx, k + 1, totalDist + 1));
//                    dist[ny][nx][k + 1] = totalDist + 1;
                }
            }

        }

        return -1;
    }
}
