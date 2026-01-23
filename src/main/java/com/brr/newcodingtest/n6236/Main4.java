package com.brr.newcodingtest.n6236;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main4 {
    static int N, M;
    static long min, max;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long left = min;
        long right = max;
        long mid;
        long answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    static boolean check(long mid) {
        long money = 0;
        long count = 0;

        for (int i = 0; i < N; i++) {
            if (mid < arr[i]) return false;
            if (money < arr[i]) {
                money = mid;
                count++;
            }

            money -= arr[i];
        }

        return count <= M;
    }
}
