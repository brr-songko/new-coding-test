package com.brr.newcodingtest.n1992;

import java.io.*;

public class Main {
    static StringBuilder sb;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }

        partition(0, 0, N);

        System.out.println(sb);
    }

    public static void partition(int row, int col, int size) {
        if (videoCheck(row, col, size)) {
            if (arr[row][col] == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            return;
        }

        int newSize = size / 2;

        sb.append("(");

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row+ newSize, col + newSize, newSize);

        sb.append(")");
    }

    public static boolean videoCheck(int row, int col, int size) {
        int video = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != video) {
                    return false;
                }
            }
        }
        return true;
    }
}
