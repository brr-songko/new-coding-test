package com.brr.newcodingtest.n2161;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            sb.append(queue.poll()).append(" ");
            queue.offer(queue.poll());
        }
        sb.append(queue.peek());

        System.out.println(sb);
    }
}
