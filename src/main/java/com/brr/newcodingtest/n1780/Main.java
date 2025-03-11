package com.brr.newcodingtest.n1780;

import java.io.*;
import java.util.*;

public class Main {
    static int mCnt, zCnt, oCnt;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(mCnt);
        System.out.println(zCnt);
        System.out.println(oCnt);
    }

    public static void partition(int row, int col, int size) {
        if (isPaper(row, col, size)) {
            if (arr[row][col] == -1) {
                mCnt++;
            } else if (arr[row][col] == 0) {
                zCnt++;
            } else {
                oCnt++;
            }
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + newSize*2, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + newSize*2, newSize);
        partition(row + newSize*2, col, newSize);
        partition(row + newSize*2, col + newSize, newSize);
        partition(row + newSize*2, col + newSize*2, newSize);

    }

    public static boolean isPaper(int row, int col, int size) {
        int paper = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != paper) {
                    return false;
                }
            }
        }

        return true;
    }
}
