package com.brr.newcodingtest.n2578;

import java.io.*;
import java.util.*;

public class Main3 {
    static int[][] A;
    static int bingoCount, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            boolean checkBingo = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                answer++;
                int number = Integer.parseInt(st.nextToken());
                bingoCount = 0;

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (A[k][l] == number) {
                            A[k][l] = 0;
                        }
                    }
                }

                checkVertical();
                checkHorizontal();
                checkDiagonal();

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

    private static void checkVertical() {
        for (int i = 0; i < 5; i++) {
            boolean check = true;
            for (int j = 0; j < 5; j++) {
                if (A[i][j] != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                bingoCount++;
            }
        }
    }

    private static void checkHorizontal() {
        for (int i = 0; i < 5; i++) {
            boolean check = true;
            for (int j = 0; j < 5; j++) {
                if (A[j][i] != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                bingoCount++;
            }
        }
    }

    private static void checkDiagonal() {
        boolean check1 = true;
        boolean check2 = true;
        for (int i = 0; i < 5; i++) {
            if (A[i][i] != 0) {
                check1 = false;
            }

            if (A[4 - i][i] != 0) {
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
