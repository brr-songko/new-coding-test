package com.brr.newcodingtest.n11399;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            answer += sum;
        }

        System.out.println(answer);
    }
}

/*
5
3 1 4 3 2

32
 */