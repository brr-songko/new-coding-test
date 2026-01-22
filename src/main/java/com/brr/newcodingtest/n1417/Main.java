package com.brr.newcodingtest.n1417;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty() && pq.peek() >= target) {
            int now = pq.poll();
            if (now >= target) {
                pq.offer(now - 1);
                answer++;
                target++;
            }
        }

        System.out.println(answer);
    }
}
