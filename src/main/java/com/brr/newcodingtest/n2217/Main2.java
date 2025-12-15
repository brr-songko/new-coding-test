package com.brr.newcodingtest.n2217;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = N - 1; i >= 0; i--) {
            answer = Math.max(answer, arr[i] * (N - i));
        }

        System.out.println(answer);
    }
}
