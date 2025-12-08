package com.brr.newcodingtest.n1261;

import java.io.*;
import java.util.*;

class Node {
    int count;
    int y;
    int x;

    public Node(int count, int y, int x) {
        this.count = count;
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int N, M;
    static int[][] map, wall;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        wall = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s.substring(j, j + 1));
                wall[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra(0, 0);

        System.out.println(wall[N - 1][M - 1]);
    }

    static void dijkstra(int a, int b) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.count));
        pq.offer(new Node(0, a, b));
        wall[a][b] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int y = node.y;
            int x = node.x;
            int count = node.count;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nWall = 0;

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] == 1) nWall = 1;
                if (wall[ny][nx] > count + nWall) {
                    pq.offer(new Node(count + nWall, ny, nx));
                    wall[ny][nx] = count + nWall;
                }
            }

        }
    }
}
