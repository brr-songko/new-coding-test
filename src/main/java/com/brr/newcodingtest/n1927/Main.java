package com.brr.newcodingtest.n1927;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            long x = sc.nextLong();
            if (x != 0) {
                pq.offer(x);
            } else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());

                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
