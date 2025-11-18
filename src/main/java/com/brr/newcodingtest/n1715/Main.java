package com.brr.newcodingtest.n1715;

import java.io.*;
import java.util.*;

public class Main {
    static int N, a, b, answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            pq.offer(sc.nextInt());
        }

        findSum();

        System.out.println(answer);
    }

    static void findSum() {
        if (pq.size() <= 1) {
            return;
        }

        a = pq.poll();
        b = pq.poll();
        int temp = a + b;
        pq.offer(temp);
        answer+= temp;

        findSum();
    }
}
