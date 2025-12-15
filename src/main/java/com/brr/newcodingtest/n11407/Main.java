package com.brr.newcodingtest.n11407;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= K) {
                int temp = K / arr[i];
                K -= temp * arr[i];
                answer += temp;
            }
            if (K == 0) {
                break;
            }
        }

        System.out.println(answer);
    }
}
