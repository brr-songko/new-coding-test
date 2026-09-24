package com.brr.newcodingtest.n7569;

import java.io.*;
import java.util.*;

public class Main {

    static int[][][] map;
    static boolean[][][] visited;
//                     북  동  남  서  상  하
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int N, M, H, answer;
    static ArrayList<int[]> tomato = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) tomato.add(new int[]{i, j, k});
                }
            }
        }

        bfs();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        answer = -1;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int[] temp : tomato) {
            int z = temp[0];
            int y = temp[1];
            int x = temp[2];

            q.offer(new int[]{z, y, x, 0});
            visited[z][y][x] = true;
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int z = temp[0];
            int y = temp[1];
            int x = temp[2];
            int cnt = temp[3];

            answer = Math.max(answer, cnt);

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[nz][ny][nx]) continue;
                if (map[nz][ny][nx] == 1 || map[nz][ny][nx] == -1) continue;

                q.offer(new int[]{nz, ny, nx, cnt + 1});
                map[nz][ny][nx] = 1;
                visited[nz][ny][nx] = true;
            }
        }
    }
}
