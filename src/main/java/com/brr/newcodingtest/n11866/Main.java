package com.brr.newcodingtest.n11866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            if (queue.size() > 1) {
                sb.append(queue.poll()).append(", ");
            } else {
                sb.append(queue.poll());
            }

        }
        sb.append(">");

        System.out.println(sb);
    }
}
