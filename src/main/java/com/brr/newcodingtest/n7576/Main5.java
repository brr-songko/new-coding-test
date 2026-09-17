package com.brr.newcodingtest.n7576;

import java.io.*;
import java.util.*;

public class Main5 {

    static int N, M, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static ArrayList<int[]> start = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    start.add(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    answer = -1;
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int[] temp : start) {
            q.offer(new int[]{temp[0], temp[1], 0});
            visited[temp[0]][temp[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int cnt = temp[2];

            answer = Math.max(answer, cnt);

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == -1 || map[ny][nx] == 1) continue;

                q.offer(new int[]{ny, nx, cnt + 1});
                visited[ny][nx] = true;
                map[ny][nx] = 1;
            }
        }
    }
}
