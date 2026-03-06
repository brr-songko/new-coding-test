package com.brr.newcodingtest.n1780;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, minusOne, zero, one;
    static int[][] map;

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

        partition(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    static void partition(int row, int col, int size) {
        if (checkMinusOne(row, col, size)) {
            minusOne++;
            return;
        }
        if (checkZero(row, col, size)) {
            zero++;
            return;
        }
        if (checkOne(row, col, size)) {
            one++;
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + newSize * 2, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + newSize * 2, newSize);
        partition(row + newSize * 2, col, newSize);
        partition(row + newSize * 2, col + newSize, newSize);
        partition(row + newSize * 2, col + newSize * 2, newSize);
    }

    static boolean checkMinusOne(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != -1) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean checkZero(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean checkOne(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
