package com.brr.newcodingtest.n1715;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        if (pq.size() == 0 || pq.size() == 1) {
            System.out.println(0);
            return;
        }

        while (pq.size() > 1) {
            int sum = pq.poll();
            sum += pq.poll();
            answer += sum;
            pq.offer(sum);
        }

        System.out.println(answer);
    }
}


/*
3
10
20
40

100
 */
