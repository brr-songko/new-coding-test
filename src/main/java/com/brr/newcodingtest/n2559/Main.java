package com.brr.newcodingtest.n2559;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int cnt = 0;
        int sum = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (cnt < K) {
                sum += arr[i];
                cnt++;
//                System.out.println("-------------");
//                System.out.println("check1");
//                System.out.println("i = " + i);
//                System.out.println("sum = " + sum);
            } else if (cnt == K) {
                max = sum;
//                System.out.println("-------------");
//                System.out.println("check2");
                cnt++;
                i--;
//                System.out.println("i = " + i);
//                System.out.println("sum = " + sum);
            } else {
                sum += arr[i];
                sum -= arr[i - K];
                max = Math.max(max, sum);
//                System.out.println("-------------");
//                System.out.println("check3");
//                System.out.println("i = " + i);
//                System.out.println("sum = " + sum);
            }
        }

        answer = max;

        System.out.println(answer);
    }
}

/*
10 2
3 -2 -4 -9 0 3 7 13 8 -3

21

10 5
3 -2 -4 -9 0 3 7 13 8 -3

31
 */