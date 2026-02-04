package com.brr.newcodingtest.n2917;

import java.io.*;
import java.util.*;

class Node {
    int y;
    int x;
    int dist;

    public Node(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

public class Main {
    static int N, M, answer, vs, ve, js, je;
    static Character[][] map;
    static int[][] D;
    static int[][] best;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Character[N][M];
        D = new int[N][M];
        best = new int[N][M];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                D[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '+') {
                    queue.offer(new Node(i, j, 0));
                    D[i][j] = 0;
                } else if (map[i][j] == 'V') {
                    vs = i;
                    ve = j;
                } else if (map[i][j] == 'J') {
                    js = i;
                    je = j;
                }
            }
        }

        distBfs(queue);

        bfs(vs, ve);

        System.out.println(answer);
    }

    static void distBfs(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (map[ny][nx] == '+') continue;

                if (D[ny][nx] > D[y][x] + 1) {
                    queue.offer(new Node(ny, nx, D[y][x] + 1));
                    D[ny][nx] = D[y][x] + 1;
                }
            }
        }
    }

    static void bfs(int vs, int ve) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.dist - o1.dist);
        pq.offer(new Node(vs, ve, D[vs][ve]));
        best[vs][ve] = D[vs][ve];

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int y = node.y;
            int x = node.x;

            if (y == js && x == js) {
                answer = node.dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

                int nDist = Math.min(node.dist, D[ny][nx]);
                if (nDist > best[ny][nx]) {
                    best[ny][nx] = nDist;
                    pq.offer(new Node(ny, nx, nDist));
                }

            }
        }
    }
}
