package com.brr.newcodingtest.n15686;

import java.io.*;
import java.util.*;

class Node {
    int y;
    int x;
    int cost;

    public Node(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
}

public class Main {

    static int N, M;
    static ArrayList<Node> list = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static Node[] nodes;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        nodes = new Node[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) list.add(new Node(i, j, 0));
            }
        }
        answer = Integer.MAX_VALUE;

        solve(0, 0);

        System.out.println(answer);
    }

    public static void solve(int start, int depth) {
        if (depth == M) {
            bfs();
            return;
        }

        for (int i = start; i < list.size(); i++) {
            nodes[depth] = list.get(i);
            solve(i + 1, depth + 1);
        }
    }

    public static void bfs() {
        int[][] tempMap = map.clone();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempMap[i][j] == 2) {
                    boolean check = true;
                    for (int k = 0; k < nodes.length; k++) {
                        if (i == nodes[k].y && j == nodes[k].x){
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        tempMap[i][j] = 0;
                    }
                }
            }
        }
        visited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            q.offer(nodes[i]);
            visited[nodes[i].y][nodes[i].x] = true;
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            int cost = node.cost;

            if (tempMap[y][x] == 1) sum += cost;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;
                if (tempMap[ny][nx] == 2) continue;

                q.offer(new Node(ny, nx, cost + 1));
                visited[ny][nx] = true;
            }

        }

        answer = Math.min(answer, sum);
    }
}
