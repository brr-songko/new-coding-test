package com.brr.newcodingtest.n7662;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
            PriorityQueue<Integer> minPq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
            Map<Integer, Integer> map = new HashMap<>();

            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int now = Integer.parseInt(st.nextToken());

                if (s.equals("I")) {
                    maxPq.offer(now);
                    minPq.offer(now);
                    map.put(now, map.getOrDefault(now, 0) + 1);
                } else if (s.equals("D")) {
                    if (now == 1) {
                        while (!maxPq.isEmpty()) {
                            int temp = maxPq.peek();
                            if (map.get(temp) != 0) {
                                map.put(temp, map.get(temp) - 1);
                                maxPq.poll();
                                break;
                            } else {
                                maxPq.poll();
                            }
                        }
                    } else if (now == -1) {
                        while (!minPq.isEmpty()) {
                            int temp = minPq.peek();
                            if (map.get(temp) != 0) {
                                map.put(temp, map.get(temp) - 1);
                                minPq.poll();
                                break;
                            } else {
                                minPq.poll();
                            }
                        }
                    }
                }
            }

            while (!maxPq.isEmpty() && map.get(maxPq.peek()) == 0) {
                maxPq.poll();
            }

            while (!minPq.isEmpty() && map.get(minPq.peek()) == 0) {
                minPq.poll();
            }

            if (minPq.isEmpty() || maxPq.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(maxPq.peek()).append(" ").append(minPq.peek()).append("\n");
            }
        }


        System.out.println(sb);
    }
}
