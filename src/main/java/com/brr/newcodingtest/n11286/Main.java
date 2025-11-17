package com.brr.newcodingtest.n11286;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if ((a[1] == b[1])) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int absX = Math.abs(x);
            if (x != 0) {
                pq.offer(new int[]{x, absX});
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll()[0]);
                }
            }
        }
    }
}
