package com.brr.newcodingtest.n11509;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, height;
    static int N, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        height = new int[1_000_001];
        answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int h = arr[i];

            if (height[h] > 0) {
                height[h]--;
            } else {
                answer++;
            }

            height[h - 1]++;
        }

        System.out.println(answer);
    }
}
