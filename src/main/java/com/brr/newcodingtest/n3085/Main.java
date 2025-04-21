package com.brr.newcodingtest.n3085;

import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static String[][] arr, tempArr;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        tempArr= new String[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = String.valueOf(s.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < N; l++) {
                        tempArr[l] = Arrays.copyOf(arr[l], arr[l].length);
                    }
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                        continue;
                    }
                    if (tempArr[i][j].equals(tempArr[ny][nx])) {
                        continue;
                    }

                    convertNumber(i, j, ny, nx);
                    compareRow();
                    compareCol();
                }
            }
        }

        System.out.println(answer);
    }

    public static void convertNumber(int i, int j, int ny, int nx) {
        String temp = tempArr[i][j];
        tempArr[i][j] = tempArr[ny][nx];
        tempArr[ny][nx] = temp;
    }

    public static void compareRow() {
        for (int i = 0; i < N; i++) {
            int max = 1;
            for (int j = 1; j < N; j++) {
                if (tempArr[i][j].equals(tempArr[i][j - 1])) {
                    max++;
                }
                if (!tempArr[i][j].equals(tempArr[i][j - 1])) {
                    answer = Math.max(answer, max);
                    max = 1;
                }
            }
            answer = Math.max(answer, max);
        }
    }

    public static void compareCol() {
        for (int i = 0; i < N; i++) {
            int max = 1;
            for (int j = 1; j < N; j++) {
                if (tempArr[j][i].equals(tempArr[j - 1][i])) {
                    max++;
                }
                if (!tempArr[j][i].equals(tempArr[j - 1][i])) {
                    answer = Math.max(answer, max);
                    max = 1;
                }
            }
            answer = Math.max(answer, max);
        }
    }
}
