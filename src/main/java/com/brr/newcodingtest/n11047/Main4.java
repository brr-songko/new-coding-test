package com.brr.newcodingtest.n11047;

import java.io.*;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (K >= arr[i]) {
                answer += K / arr[i];
                K -= (K / arr[i]) * arr[i];
            }
        }

        System.out.println(answer);
    }
}

/*
10 4200
1
5
10
50
100
500
1000
5000
10000
50000

6

10 4790
1
5
10
50
100
500
1000
5000
10000
50000

12
 */