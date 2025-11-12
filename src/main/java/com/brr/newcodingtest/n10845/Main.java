package com.brr.newcodingtest.n10845;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int temp = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push")) {
                int a = Integer.parseInt(st.nextToken());
                queue.offer(a);
                temp = a;
            } else if (s.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else if (s.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (s.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (s.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            } else if (s.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(temp).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
