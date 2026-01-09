package com.brr.newcodingtest.n10812;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 시작
            int a = Integer.parseInt(st.nextToken());
            // 끝
            int b = Integer.parseInt(st.nextToken());
            // 기준
            int c = Integer.parseInt(st.nextToken());

            for (int j = c; j <= b; j++) {
                queue.add(arr[j]);
            }
            for (int j = a; j < c; j++) {
                queue.add(arr[j]);
            }

            int index = a;
            while (!queue.isEmpty()) {
                arr[index++] = queue.poll();
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
