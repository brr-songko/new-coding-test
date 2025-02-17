package com.brr.newcodingtest.n1463;

import java.io.*;
import java.util.*;

public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        A = new int[N + 1];
        count = dp(N);

        System.out.println(count);
    }

    public static int dp(int N) {
        for (int i = 2; i <= N; i++) {
            A[i] = A[i - 1] + 1;
            if (i % 2 == 0) {
                A[i] = Math.min(A[i], A[i / 2] + 1);
            }
            if (i % 3 == 0) {
                A[i] = Math.min(A[i], A[i / 3] + 1);
            }
        }

        return A[N];
    }
}
