package com.brr.newcodingtest.n1940;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int cnt = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == M) {
                cnt++;
                start++;
                end--;
            }  else if (sum < M) start++;
            else end--;
        }

        System.out.println(cnt);
    }
}

/*
6
9
2 7 4 1 5 3

1 2 3 4 5 7
 */