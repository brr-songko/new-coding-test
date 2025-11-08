package com.brr.newcodingtest.n4963;

import java.io.*;
import java.util.*;

public class Main {
    static int w, h, answer;
    static int[][] A;
    static boolean[][] visited;
                    //북 북동 동 남동 남 남서 서 북서
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            answer = 0;
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            A = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (A[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
            if (A[ny][nx] == 0) continue;
            if (visited[ny][nx]) continue;

            dfs(ny, nx);
        }
    }
}
