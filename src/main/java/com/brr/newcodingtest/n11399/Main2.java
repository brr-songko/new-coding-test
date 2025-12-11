package com.brr.newcodingtest.n11399;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, answer, sum;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        answer = 0;
        sum = 0;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            answer += sum;
        }

        System.out.println(answer);
    }
}
