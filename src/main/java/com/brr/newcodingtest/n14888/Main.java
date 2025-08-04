package com.brr.newcodingtest.n14888;

import java.io.*;
import java.util.*;

public class Main {
    static int max, min, N;
    static int[] arr;
    static int[] operators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operators = new int[4];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        cal(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void cal(int num, int depth) {
        if (depth == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                if (i == 0) {
                    cal(num + arr[depth], depth + 1);
                } else if (i == 1) {
                    cal(num - arr[depth], depth + 1);
                } else if (i == 2) {
                    cal(num * arr[depth], depth + 1);
                } else {
                    cal(num / arr[depth], depth + 1);
                }
                operators[i]++;
            }
        }
    }
}
