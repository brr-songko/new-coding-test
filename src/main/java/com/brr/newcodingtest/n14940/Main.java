package com.brr.newcodingtest.n14940;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        map = new int[n][m];
        visited = new boolean[n][m];
        int s = 0;
        int e = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    s = i;
                    e = j;
                } else if (map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }

        bfs(s, e);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int s, int e) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, e});
        visited[s][e] = true;
        map[s][e] = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 0) continue;

                q.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                map[ny][nx] = map[y][x] + 1;
            }
        }
    }
}
