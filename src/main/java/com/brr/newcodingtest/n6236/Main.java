package com.brr.newcodingtest.n6236;

import java.io.*;
import java.util.*;

public class Main {
    static int min, N, M, current, count;
    static int max = 10000 * 100000;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, arr[i]);
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            current = mid;
            count = 1;

            for (int i = 0; i < N; i++) {
                if (arr[i] > current) {
                    current = mid;
                    count++;
                }
                current -= arr[i];
            }

            if (count > M) min = mid + 1;
            else max = mid - 1;
        }

        System.out.println(min);
    }
}
