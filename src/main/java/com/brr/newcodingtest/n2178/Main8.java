package com.brr.newcodingtest.n2178;

import java.io.*;
import java.util.*;

public class Main8 {

    static int N, M, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int cnt = temp[2];

            if (y == N - 1 && x == M - 1) {
                answer = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;

                q.offer(new int[]{ny, nx, cnt + 1});
                visited[ny][nx] = true;
            }
        }
    }
}
