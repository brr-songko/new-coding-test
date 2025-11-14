package com.brr.newcodingtest.n12873;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int t = 1;
        while (queue.size() > 1) {
            long ts = (long) t *t*t;
            ts %= queue.size();

            if (ts % queue.size() == 0) {
                ts = queue.size();
            }

            for (int i = 0; i < ts; i++) {
                if (i == ts - 1) {
                    queue.poll();
                } else {
                    queue.offer(queue.poll());
                }
            }
            t++;
        }

        System.out.println(queue.peek());
    }
}
