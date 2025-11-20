package com.brr.newcodingtest.n1655;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> leftPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    static PriorityQueue<Integer> rightPq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int now = sc.nextInt();
            if (leftPq.isEmpty() || leftPq.peek() >= now) {
                leftPq.offer(now);
            } else {
                rightPq.offer(now);
            }

            if (leftPq.size() - rightPq.size() > 1) {
                rightPq.offer(leftPq.poll());
            } else if (rightPq.size() - leftPq.size() > 0) {
                leftPq.offer(rightPq.poll());
            }

            sb.append(leftPq.peek()).append("\n");
//            if ((leftPq.size() + rightPq.size()) % 2 == 1) {
//                sb.append(leftPq.peek()).append("\n");
//            } else {
//                sb.append(Math.min(leftPq.peek(), rightPq.peek())).append("\n");
//            }
        }

        System.out.println(sb);
    }
}
