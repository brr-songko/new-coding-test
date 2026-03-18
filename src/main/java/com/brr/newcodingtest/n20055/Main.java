package com.brr.newcodingtest.n20055;

import java.io.*;
import java.util.*;

public class Main {

    static int[] belt, A;
    static int N, K, zeroCnt, turn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[N + 1];
        A = new int[2 * N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        while (zeroCnt < K) {
            turn++;

            rotate();

            moveRobot();

            putRobot();
        }

        System.out.println(turn);
    }

    static void rotate() {
        int[] tempA = new int[2 * N + 1];
        int[] tempBelt = new int[N + 1];

        for (int i = 1; i <= 2 * N; i++) {
            if (i == 2 * N) {
                tempA[1] = A[2 * N];
            } else {
                tempA[i + 1] = A[i];
            }
        }

        A = tempA;

        for (int i = 1; i < N; i++) {
            if (i == N - 1) {

            } else if (belt[i] == 1) {
                tempBelt[i + 1] = 1;
            }
        }

        belt = tempBelt;
    }

    static void moveRobot() {
        int[] tempBelt = new int[N + 1];
        boolean move = false;

        for (int i = N - 1; i > 0; i--) {
            if (belt[i] == 1 && belt[i + 1] == 0 && A[i + 1] >= 1) {
                move = true;
                belt[i] = 0;
                tempBelt[i + 1] = 1;
                A[i + 1]--;
                if (A[i + 1] == 0) {
                    zeroCnt++;
                }
            } else {
                tempBelt[i] = belt[i];
            }
        }

        tempBelt[N] = 0;

        if (move) {
            belt = tempBelt;
        }
    }

    static void putRobot() {
        if (A[1] != 0) {
            belt[1] = 1;
            A[1]--;
            if (A[1] == 0) {
                zeroCnt++;
            }
        }
    }
}
