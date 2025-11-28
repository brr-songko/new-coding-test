package com.brr.newcodingtest.n11652;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Long, Long> map = new HashMap<>();
        long maxKey = 0;
        long maxValue = 0;

        for (int i = 0; i < N; i++) {
            long now = sc.nextLong();
            map.put(now, map.getOrDefault(now, 0L) + 1);
        }

        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            } else if (entry.getValue() == maxValue) {
                maxKey = Math.min(entry.getKey(), maxKey);
            }
        }

        System.out.println(maxKey);
    }
}
