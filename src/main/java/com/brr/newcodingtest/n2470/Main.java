package com.brr.newcodingtest.n2470;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long[] answer = new long[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        long minSum = Integer.MAX_VALUE;

        while (start < end) {
            long sum = arr[start] + arr[end];
            long absSum = Math.abs(sum);

            // 이 sum이 0에 가장 가까운 값을 출력해야 함.
            if (absSum < minSum) {
                minSum = absSum;
                answer[0] = arr[start];
                answer[1] = arr[end];
            }

            if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            } else {
                break;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}


/*
5
-2 4 -99 -1 98

-99 98
 */
