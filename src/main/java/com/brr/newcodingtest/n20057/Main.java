package com.brr.newcodingtest.n20057;

import java.io.*;
import java.util.*;

public class Main {

    static int N, answer;
    static int[][] map;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[] sy = {-1, 1, -1, 1, -2, 2, -1, 1, 0};
    static int[] sx = {1, 1, 0, 0, 0, 0, -1, -1, -2};
    static int[] p = {1, 1, 7, 7, 2, 2, 10, 10, 5};
//    static int[] sy = {-2, -1, -1, -1, 0, 1, 1, 1, 2};
//    static int[] sx = {0, -1, 0, 1, -2, -1, 0, 1, 0};
//    static int[] p  = {2, 10, 7, 1, 5, 10, 7, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        int length = 1;
        int d = 0;
        int y = N / 2;
        int x = N / 2;
        boolean stop = false;

        while (true) {
            for (int i = 0; i < length; i++) {
                y = y + dy[d];
                x = x + dx[d];

                moveSand(d, y, x);

                if (y == 0 && x == 0) {
                    System.out.println(answer);
                    return;
                }
            }

            d = (d + 1) % 4;
            idx++;

            if (stop) break;

            if (idx == 2) {
                idx = 0;
                length++;
            }
        }
    }

    static void moveSand(int d, int y, int x) {
        int sand = map[y][x];
        int spreadSum = 0;

        for (int i = 0; i < 9; i++) {
            int ny = sy[i];
            int nx = sx[i];

            for (int r = 0; r < d; r++) {
//                반시계 회전
//                int temp = ny;
//                ny = nx;
//                nx = -temp;
//                시계 회전
                int temp = ny;
                ny = -nx;
                nx = temp;
            }

            int targetY = y + ny;
            int targetX = x + nx;

            int spread = sand * p[i] / 100;
            spreadSum += spread;

            if (targetY < 0 || targetY >= N || targetX < 0 || targetX >= N) {
                answer += spread;
            } else {
                map[targetY][targetX] += spread;
            }
        }

        int ay = 0;
        int ax = -1;

        for (int r = 0; r < d; r++) {
//            반시계
//            int temp = ay;
            
//            ay = ax;
//            ax = -temp;
//            시계
            int temp = ay;
            ay = -ax;
            ax = temp;
        }

        int targetY = y + ay;
        int targetX = x + ax;

        int a = sand - spreadSum;

        if (targetY < 0 || targetY >= N || targetX < 0 || targetX >= N) {
            answer += a;
        } else {
            map[targetY][targetX] += a;
        }

        map[y][x] = 0;
    }
}
