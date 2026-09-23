package com.brr.newcodingtest.n14502;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map, copy_map;
    static boolean[][] visited;
    static int[][] target = new int[3][2];
    static int answer = 0;
    static ArrayList<int[]> viruses = new ArrayList<>();
    static ArrayList<int[]> walls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) walls.add(new int[]{i, j});
                if (map[i][j] == 2) viruses.add(new int[]{i, j});
            }
        }

        // 1. 벽 3개 세울 곳을 조합으로 선정한다.
        setWalls(0, 0);

        // 2. 바이러스를 퍼뜨린다.

        // 3. 안전영역을 센다.

        System.out.println(answer);
    }

    public static void setWalls(int depth, int start) {
        if (depth == 3) {
            copy_map = new int[N][M];
            for (int i = 0; i < N; i++) {
                copy_map[i] = map[i].clone();
            }
            spreadViruses();
            countSafetyArea();
            return;
        }

        for (int i = start; i < walls.size(); i++) {
            int[] wall = walls.get(i);
            target[depth][0] = wall[0];
            target[depth][1] = wall[1];
            setWalls(depth + 1, i + 1);
        }
    }

    public static void spreadViruses() {
        for (int[] wall : target) {
            int y = wall[0];
            int x = wall[1];

            copy_map[y][x] = 1;
        }

        bfs();
    }

    public static void bfs() {
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int[] virus : viruses) {
            int y = virus[0];
            int x = virus[1];

            q.offer(new int[]{y, x});
            visited[y][x] = true;
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (copy_map[ny][nx] == 1 || copy_map[ny][nx] == 2) continue;

                q.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                copy_map[ny][nx] = 2;
            }
        }
    }

    public static void countSafetyArea() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy_map[i][j] == 0) cnt++;
            }
        }

        answer = Math.max(answer, cnt);
    }
}
