package com.brr.newcodingtest.n20165;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, answer;
    static int[][] map;
    static String[][] sMap;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        sMap = new String[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sMap[i][j] = "S";
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int ay = Integer.parseInt(st.nextToken()) - 1;
            int ax = Integer.parseInt(st.nextToken()) - 1;
            String d = st.nextToken();
            int end = map[ay][ax];

            while (end > 0) {
                if (ay < 0 || ay >= N || ax < 0 || ax >= M) break;
                if (sMap[ay][ax].equals("S")) {
                    sMap[ay][ax] = "F";
                    answer++;
                    end = Math.max(end, map[ay][ax]);
                }

                end--;

                if (d.equals("E")) {
                    ay += dy[0];
                    ax += dx[0];
                } else if (d.equals("W")) {
                    ay += dy[1];
                    ax += dx[1];
                } else if (d.equals("S")) {
                    ay += dy[2];
                    ax += dx[2];
                } else if (d.equals("N")) {
                    ay += dy[3];
                    ax += dx[3];
                }
            }

//            sb.append("--------------------------atack-------------").append("\n");
//            sb.append("i = ").append(i).append("\n");
//            for (int k = 0; k < N; k++) {
//                for (int j = 0; j < M; j++) {
//                    sb.append(sMap[k][j]).append(" ");
//                }
//                sb.append("\n");
//            }

            st = new StringTokenizer(br.readLine());
            int dy = Integer.parseInt(st.nextToken()) - 1;
            int dx = Integer.parseInt(st.nextToken()) - 1;

            sMap[dy][dx] = "S";

//            sb.append("--------------------------defense-----------------").append("\n");
//            sb.append("i = ").append(i).append("\n");
//            for (int k = 0; k < N; k++) {
//                for (int j = 0; j < M; j++) {
//                    sb.append(sMap[k][j]).append(" ");
//                }
//                sb.append("\n");
//            }
//            sb.append("answer = ").append(answer).append("\n");
        }

        sb.append(answer).append("\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(sMap[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
