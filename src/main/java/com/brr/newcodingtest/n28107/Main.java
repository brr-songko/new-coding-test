package com.brr.newcodingtest.n28107;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] answerList = new int[N + 1];
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int order = Integer.parseInt(st.nextToken());
                if (!map.containsKey(order)) {
                    map.put(order, new LinkedList<>());
                }
                map.get(order).offer(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int food = Integer.parseInt(st.nextToken());
            if (map.containsKey(food)) {
                Queue<Integer> queue = map.get(food);
                if (!queue.isEmpty()) {
                    int now = queue.poll();
                    answerList[now]++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(answerList[i] + " ");
        }
    }
}
