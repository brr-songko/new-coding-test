package com.brr.newcodingtest.n1654;

import java.io.*;
import java.util.*;

public class Main4 {

    static int K, N;
    static long[] arr;
    static long answer, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        answer = lowerBound(N);

        System.out.println(answer);
    }

    public static long lowerBound(long target) {
        long left = 1;
        long right = max + 1;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (possible(mid) < target) {
                right = mid;
            }  else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    public static long possible(long mid) {
        long cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i] / mid;
        }

        return cnt;
    }
}

/*
4 11
802
743
457
539

200
 */

/*
N개를 만들 수 있는 랜선의 최대 길이.
mid 는 랜선 길이
lowerBound
if (N개 이상 안 만들어지면) right = mid;
else left = mid + 1;
 */
