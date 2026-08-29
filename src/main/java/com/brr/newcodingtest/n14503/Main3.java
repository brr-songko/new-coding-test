package com.brr.newcodingtest.n14503;

import java.io.*;
import java.util.*;

public class Main3 {

    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int r, c, d, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (true) {
            boolean check = false;
            if (map[r][c] == 0) {
                map[r][c] = -1;
                answer++;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dy[i];
                int nc = c + dx[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 0) {
                    check = true;
                    break;
                }
            }

            if (check) {
                int nd = d;
                for (int i = 0; i < 4; i++) {
                    nd -= 1;
                    if (nd < 0) {
                        nd = 3;
                    }
                    int nr = r + dy[nd];
                    int nc = c + dx[nd];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        d = nd;
                        check = false;
                        break;
                    }
                }
            } else {
                int nd = (d + 2) % 4;
                int nr = r + dy[nd];
                int nc = c + dx[nd];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 1) {
                    break;
                } else {
                    r = nr;
                    c = nc;
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