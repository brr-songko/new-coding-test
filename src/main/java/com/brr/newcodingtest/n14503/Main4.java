package com.brr.newcodingtest.n14503;

import java.io.*;
import java.util.*;

public class Main4 {

    static int N, M;
    static int[][] map;
    static int r, c, d;
    static int answer;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (map[r][c] == 0) {
                answer++;
                map[r][c] = -1;
            }

            boolean check = true;
            int nd = d;
            for (int i = 0; i < 4; i++) {
                nd -= 1;
                if (nd < 0) nd = 3;

                int ny = r + dy[nd];
                int nx = c + dx[nd];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] == 0) {
                    check = false;
                    r = ny;
                    c = nx;
                    d = nd;
                    break;
                }
            }

            if (check) {
                int tempD = (d + 2) % 4;
                int ny = r + dy[tempD];
                int nx = c + dx[tempD];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] == 1) {
                    break;
                } else {
                    r = ny;
                    c = nx;
                }
            }
        }

        System.out.println(answer);
    }
}

/*
3 3
1 1 0
1 1 1
1 0 1
1 1 1

1

11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

57
 */