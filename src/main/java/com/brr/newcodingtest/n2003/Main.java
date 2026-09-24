package com.brr.newcodingtest.n2003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int sum = 0;
        int answer = 0;

        for (int end = 0; end < N; end++) {
            sum += arr[end];

            while (sum > M) {
                sum -= arr[start];
                start++;
            }

            if (sum == M) answer++;
        }

        System.out.println(answer);
    }
}

/*
4 2
1 1 1 1

3

10 5
1 2 3 4 2 5 3 1 1 2

3
 */
