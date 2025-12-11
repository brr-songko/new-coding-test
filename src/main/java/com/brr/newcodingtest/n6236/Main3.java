package com.brr.newcodingtest.n6236;

import java.io.*;
import java.util.*;

public class Main3 {
    static int[] arr;
    static int N, M;
    static long answer;
    static int min = Integer.MIN_VALUE;
    static int max = 100000 * 10000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        long left = min;
        long right = max;
        long mid;
        long answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (canUse(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    static boolean canUse(long mid) {
        long nowCost = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (mid < arr[i]) return false;
            if (nowCost < arr[i]){
                nowCost = mid;
                count++;
            }
            nowCost -= arr[i];
        }

        if (count > M) {
            return false;
        }

        return true;
    }
}
