package com.brr.newcodingtest.n2578;

import java.io.*;
import java.util.*;

public class Main2 {
    static int answer, bingoCount;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
        visited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean checkBingo = true;
            for (int j = 0; j < 5; j++) {
                checkBingo = false;
                int num = Integer.parseInt(st.nextToken());
                bingoCount = 0;
                checkBingo(num);
                answer++;
                if (bingoCount >= 3) {
                    checkBingo = true;
                    break;
                }
            }
            if (checkBingo) {
                break;
            }
        }

        System.out.println(answer);
    }

    public static void checkBingo(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    visited[i][j] = true;
                    break;
                }
            }
        }
        horizontalAndVerticalCheck(num);
        diagonalCheck(num);
    }

    public static void horizontalAndVerticalCheck(int num) {
        for (int i = 0; i < 5; i++) {
            boolean horizontalCheck = true;
            boolean verticalCheck = true;
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j]) {
                    horizontalCheck = false;
                }
                if (!visited[j][i]) {
                    verticalCheck = false;
                }
            }
            if (horizontalCheck) {
                bingoCount++;
            }
            if (verticalCheck) {
                bingoCount++;
            }
        }
    }

    public static void diagonalCheck(int num) {
        boolean check1 = true;
        boolean check2 = true;
        for (int i = 0; i < 5; i++) {
            if (!visited[i][i]) {
                check1 = false;
            }
            if (!visited[i][4 - i]) {
                check2 = false;
            }
        }
        if (check1) {
            bingoCount++;
        }
        if (check2) {
            bingoCount++;
        }
    }
}
