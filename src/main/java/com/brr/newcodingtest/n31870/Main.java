package com.brr.newcodingtest.n31870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int inversion = 0; // 바로 오름차순 만들기
        int reverseInversion = 1; // 내림차순 만들었다가 reverse 하기

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (i < j && arr[i] > arr[j]) {
                    inversion++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (i < j && arr[i] < arr[j]) {
                    reverseInversion++;
                }
            }
        }

        int answer = Math.min(inversion, reverseInversion);

        System.out.println(answer);
    }
}
