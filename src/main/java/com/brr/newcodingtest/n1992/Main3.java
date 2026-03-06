package com.brr.newcodingtest.n1992;

import java.io.*;
import java.util.*;

public class Main3 {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) -'0';
            }
        }

        partition(0, 0, N);

        System.out.println(sb);
    }

    static void partition(int row, int col, int size) {
        if (checkOne(row, col, size)) {
            sb.append(1);
            return;
        }

        if (checkZero(row, col, size)) {
            sb.append(0);
            return;
        }

        int newSize = size / 2;

        sb.append("(");

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);

        sb.append(")");
    }

    static boolean checkOne(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean checkZero(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
