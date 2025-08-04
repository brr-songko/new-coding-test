package com.brr.newcodingtest.n2578;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] A = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] B = new int[25];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                B[index++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 25; i++) {
            count++;
            int bingoCount = 0;
            int number = B[i];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (number == A[j][k]) {
                        visited[j][k] = true;
                        break;
                    }
                }
            }

            for (int j = 0; j < 5; j++) {
                boolean check = true;
                for (int k = 0; k < 5; k++) {
                    if (!visited[j][k]) {
                        check = false;
                    }
                }
                if (check) {
                    bingoCount++;
                }
            }

            for (int j = 0; j < 5; j++) {
                boolean check = true;
                for (int k = 0; k < 5; k++) {
                    if (!visited[k][j]) {
                        check = false;
                    }
                }
                if (check) {
                    bingoCount++;
                }
            }

            boolean checkA = true;
            for (int j = 0; j < 5; j++) {
                if (!visited[j][j]) {
                    checkA = false;
                }
            }
            if (checkA) {
                bingoCount++;
            }

            boolean checkB = true;
            for (int j = 0; j < 5; j++) {
                if (!visited[4 - j][0 + j]) {
                    checkB = false;
                }
            }
            if (checkB) {
                bingoCount++;
            }

            if (bingoCount >= 3) {
                System.out.println(count);
                break;
            }
        }
    }
}
