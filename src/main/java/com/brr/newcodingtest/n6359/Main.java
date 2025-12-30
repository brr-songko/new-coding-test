package com.brr.newcodingtest.n6359;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int answer = 0;
            boolean[] arr = new boolean[n + 1];

            // true가 열린거, false가 잠긴거
            for (int k = 1; k <= n; k++) {
                for (int j = 1; j <= n; j++) {
                    if (k * j > n) break;
                        if (arr[k * j]) arr[k * j] = false;
                        else arr[k * j] = true;
                }
            }

            for (int j = 1; j <= n; j++) {
                if (arr[j]) answer++;
            }

            System.out.println(answer);
        }
    }
}
