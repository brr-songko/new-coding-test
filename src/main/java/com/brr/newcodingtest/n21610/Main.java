package com.brr.newcodingtest.n21610;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] A;
    static boolean[][] isCloud;
    static List<int[]> list;
//                    좌 좌상 상 우상 우 우하 하 좌하
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isCloud = new boolean[N][N];
        isCloud[N-1][0] = true;
        isCloud[N-1][1] = true;
        isCloud[N-2][0] = true;
        isCloud[N-2][1] = true;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
//            System.out.println("d = " + d);
//            System.out.println("s = " + s);

//            printIsCloud("before moveCloud");
            moveCloud(d, s);
//            printIsCloud("after moveCloud");

//            printIsCloudAndMap("before increaseWater");
            increaseWater();
//            printIsCloudAndMap("after increaseWater");

//            printMap("before copyWater");
            copyWater();
//            printMap("after copyWater");

//            printIsCloudAndMap("before decreaseWater");
            decreaseWater();
//            printIsCloudAndMap("after decreaseWater");
        }

        int answer = calculateTotalWater();

        System.out.println(answer);
    }
    static void printIsCloudAndMap(String s) {
        System.out.println("----------------------------------------------------");
        System.out.println(s);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println(" ");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(isCloud[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("----------------------------------------------------");
    }

    static void printIsCloud(String s) {
        System.out.println(s);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(isCloud[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static void printMap(String s) {
        System.out.println(s);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static void moveCloud(int d, int s) {
        boolean[][] tempCloud = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isCloud[i][j]) {
                    int ny = (i + (dy[d] * s)) % N;
                    if (ny < 0) {
                        ny += N;
                    }
                    int nx = (j + (dx[d] * s)) % N;
                    if (nx < 0) {
                        nx += N;
                    }
                    tempCloud[ny][nx] = true;
                }
            }
        }

        isCloud = tempCloud;
    }

    static void increaseWater() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isCloud[i][j]) {
                    A[i][j]++;
                    list.add(new int[]{i, j});
                    isCloud[i][j] = false;
                }
            }
        }
    }

    static void copyWater() {
        for (int[] temp : list) {
            int cnt = 0;
            int y = temp[0];
            int x = temp[1];
            for (int i = 1; i < 8; i += 2) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                if (A[ny][nx] > 0) cnt++;
            }

            A[y][x] += cnt;
        }
    }

    static void decreaseWater() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] >= 2 && checkList(i, j)) {
                    isCloud[i][j] = true;
                    A[i][j] -= 2;
                }
            }
        }
    }

    static boolean checkList(int r, int c) {
        boolean check = true;
        for (int[] temp : list) {
            if (temp[0] == r && temp[1] == c) {
                check = false;
                break;
            }
        }

        return check;
    }

    static int calculateTotalWater() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += A[i][j];
            }
        }

        return sum;
    }
}
