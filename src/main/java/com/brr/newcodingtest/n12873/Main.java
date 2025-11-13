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

        while (queue.size() > 1) {
            for (int t = 1; t <= N; t++) {
                int ts = (int) Math.pow(t, t);
                System.out.println(queue);

                for (int i = 0; i < ts; i++) {
                    if (i == ts - 1) {
                        queue.poll();
                    } else {
                        queue.offer(queue.poll());
                    }
                }
            }
        }

        System.out.println(queue.peek());
    }
}
