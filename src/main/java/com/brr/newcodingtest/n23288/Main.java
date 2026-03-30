package com.brr.newcodingtest.n23288;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, d, y, x, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
//                       top bottom north south east west
    static int[] dice = {1, 6, 2, 5, 3, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        d = 1;
        y = 0;
        x = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        printMap();
        for (int i = 0; i < K; i++) {
//            printDice("before moveDice");
            moveDice(y, x);
//            printDice("after moveDice");

//            printScore("before getScore");
            getScore(y, x);
//            printScore("after getScore");

//            printDir("before decideDir");
            decideDir();
//            printDir("after decideDir");
        }

        System.out.println(answer);
    }
    static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static void printDir(String s) {
        System.out.println("--------------------------------------------------");
        System.out.println(s);
        System.out.println("d = " + d);

        System.out.println("--------------------------------------------------");
    }

    static void printScore(String s) {
        System.out.println("--------------------------------------------------");
        System.out.println(s);
        System.out.println("answer = " + answer);


        System.out.println("--------------------------------------------------");
    }

    static void printDice(String s) {
        System.out.println("--------------------------------------------------");
        System.out.println(s);
        System.out.println("y = " + y);
        System.out.println("x = " + x);
        System.out.println("d = " + d);

        System.out.println("dice");
        for (int i = 0; i < 6; i++) {
            System.out.print(dice[i] + " ");
        }

        System.out.println("--------------------------------------------------");
    }

    static void moveDice(int r, int c) {
        int ny = r + dy[d];
        int nx = c + dx[d];

        if (ny < 0 || ny >= N || nx < 0 || nx >= M){
            d = (d + 2) % 4;
            ny = r + dy[d];
            nx = c + dx[d];
        }

        y = ny;
        x = nx;

        int top = dice[0];
        int bottom = dice[1];
        int north = dice[2];
        int south = dice[3];
        int east = dice[4];
        int west = dice[5];

        if (d == 0) {
            dice[0] = south;
            dice[1] = north;
            dice[2] = top;
            dice[3] = bottom;
            dice[4] = east;
            dice[5] = west;
        } else if (d == 1) {
            dice[0] = west;
            dice[1] = east;
            dice[2] = north;
            dice[3] = south;
            dice[4] = top;
            dice[5] = bottom;
        } else if (d == 2) {
            dice[0] = north;
            dice[1] = south;
            dice[2] = bottom;
            dice[3] = top;
            dice[4] = east;
            dice[5] = west;
        } else if (d == 3) {
            dice[0] = east;
            dice[1] = west;
            dice[2] = north;
            dice[3] = south;
            dice[4] = bottom;
            dice[5] = top;
        }
    }

    static void getScore(int r, int c) {
        visited = new boolean[N][M];
        int B = map[r][c];
        int C = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int yy = temp[0];
            int xx = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = yy + dy[i];
                int nx = xx + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] != B) continue;

                q.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                C++;
            }
        }

        answer += B * C;
    }

    static void decideDir() {
        int A = dice[1];
        int B = map[y][x];

        if (A > B) {
            d = (d + 1) % 4;
        } else if (A < B) {
            d = (d + 3) % 4;
        }
    }
}
