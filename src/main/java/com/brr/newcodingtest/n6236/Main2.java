package com.brr.newcodingtest.n6236;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, M, totalMoney, count, min;
    static int max = 10000 * 100000;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, money[i]);
        }

        while (min <= max) {
            int mid = (min + max) / 2;

            totalMoney = mid;
            count = 1;
            for (int i = 0; i < N; i++) {
                if (totalMoney < money[i]) {
                    totalMoney = mid;
                    count++;
                }
                totalMoney -= money[i];
            }

            if (count > M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(min);
    }
}
