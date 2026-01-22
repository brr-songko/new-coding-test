package com.brr.newcodingtest.n1600;

import java.io.*;
import java.util.*;

class Node {
    int y, x, k, dist;

    public Node(int y, int x, int k, int dist) {
        this.y = y;
        this.x = x;
        this.k = k;
        this.dist = dist;
    }
}

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] hdy = {-2, -1, 1, 2, 2, -1, 1, -2};
    static int[] hdx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] arr;
    static boolean[][][] visited;
    static int K, W, H, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.y == H - 1 && node.x == W - 1) {
                System.out.println(node.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
                if (arr[ny][nx] == 1) continue;
                if (visited[ny][nx][node.k]) continue;

                visited[ny][nx][node.k] = true;
                q.offer(new Node(ny, nx, node.k, node.dist + 1));
            }

            if (node.k < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = node.y + hdy[i];
                    int nx = node.x + hdx[i];

                    if (ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
                    if (arr[ny][nx] == 1) continue;
                    if (visited[ny][nx][node.k + 1]) continue;

                    visited[ny][nx][node.k + 1] = true;
                    q.offer(new Node(ny, nx, node.k + 1, node.dist + 1));
                }
            }
        }

        System.out.println(-1);
    }
}
