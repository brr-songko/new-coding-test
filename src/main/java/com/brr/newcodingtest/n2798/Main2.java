package com.brr.newcodingtest.n2798;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, M, answer;
    static int[] arr;
    static int[] temp = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);

        System.out.println(answer);
    }

    public static void solve(int start, int depth) {
        if (depth == 3) {
            checkAnswer();
            return;
        }

        for (int i = start; i < N; i++) {
            temp[depth] = arr[i];
            solve(i + 1, depth + 1);
        }
    }

    public static void checkAnswer() {
        int sum = 0;
        for (int n : temp) {
            sum += n;
        }
        if (sum <= M) {
            answer = Math.max(answer, sum);
        }
    }
}

/*
5 21
5 6 7 8 9

21

10 500
93 181 245 214 315 36 185 138 216 295

497
 */
