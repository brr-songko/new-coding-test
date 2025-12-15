package com.brr.newcodingtest.n1026;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            answer += A[i] * B[N - 1 - i];
        }

        System.out.println(answer);
    }
}
