//package com.brr.newcodingtest.n14503;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class test {
//        public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        int y = Integer.parseInt(st.nextToken());
//        int x = Integer.parseInt(st.nextToken());
//        int d = Integer.parseInt(st.nextToken());
//        int cnt = 0;
//
//        int[][] map = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int[] dy = {-1, 0, 1, 0};
//        int[] dx = {0, 1, 0, -1};
//
//        boolean run =true;
//        while (run) {
//            if (map[y][x] == 0) {
//                map[y][x] = 2;
//                cnt++;
//            }
//
//            boolean check = false;
//            for (int i = 0; i < 4; i++) {
//                int ny = y + dy[d];
//                int nx = x + dx[d];
//                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
//                    if (map[ny][nx] == 0) {
//                        check = true;
//                    }
//                }
//            }
//
//            if (check) {
//                if (d > 0) {
//                    d -= 1;
//                } else {
//                    d = 3;
//                }
//                int ny = y + dy[d];
//                int nx = x + dx[d];
//
//                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
//                    if (map[ny][nx] == 0) {
//                        y = ny;
//                        x = nx;
//                    }
//                }
//            } else {
//                int bd = (d + 2) % 4;
//
//                int by = y + dy[bd];
//                int bx = x + dx[bd];
//                if (0 <= by && by < N && 0 <= bx && bx < M) {
//                    if (map[by][bx] != 1) {
//                        y = by;
//                        x = bx;
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//
//        System.out.println(cnt);
//    }
//}
//}
