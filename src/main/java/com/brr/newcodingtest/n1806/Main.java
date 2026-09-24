package com.brr.newcodingtest.n1806;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;

        for (int end = 0; end < N; end++) {
            sum += arr[end];

            while (sum >= S) {
                answer = Math.min(answer, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }

        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }
}

/*
10 15
5 1 3 5 10 7 4 9 2 8
 */