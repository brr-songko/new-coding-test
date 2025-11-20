package com.brr.newcodingtest.n1655;

import java.util.*;

public class TempMain {
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int now = sc.nextInt();
            pq.offer(now);
            list.clear();
            searchMiddleValue();
        }

        System.out.println(sb);
    }

    static void searchMiddleValue() {
        if (pq.size() % 2 == 1) {
            int index = pq.size() / 2 + 1;
            int i = 1;
            while(!pq.isEmpty()) {
                int a = pq.poll();
                list.add(a);
                if (i == index) {
                    sb.append(a).append("\n");
                }
                i++;
            }
            for (int x : list) {
                pq.offer(x);
            }
        } else {
            int index = pq.size() / 2;
            int i = 1;
            while(!pq.isEmpty()) {
                int a = pq.poll();
                list.add(a);
                if (i == index) {
                    int b = pq.poll();
                    list.add(b);
                    sb.append(Math.min(a, b)).append("\n");
                }
                i++;
            }
            for (int x : list) {
                pq.offer(x);
            }
        }
    }
}
