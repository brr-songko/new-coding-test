package com.brr.newcodingtest.n1655;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftPq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (leftPq.isEmpty() || leftPq.peek() >= n) {
                leftPq.offer(n);
            } else {
                rightPq.offer(n);
            }

            if (leftPq.size() - rightPq.size() > 1) {
                rightPq.offer(leftPq.poll());
            } else if (leftPq.size() < rightPq.size()) {
                leftPq.offer(rightPq.poll());
            }

            sb.append(leftPq.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
