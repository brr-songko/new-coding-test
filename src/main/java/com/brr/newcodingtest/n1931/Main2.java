package com.brr.newcodingtest.n1931;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{a, b});
        }

        int answer = 1;
        int[] temp = pq.poll();
        int e = temp[1];

        while (!pq.isEmpty()) {
            temp = pq.poll();
            int ns = temp[0];
            int ne = temp[1];

            if (e <= ns) {
                e = ne;
                answer++;
            }
        }

        System.out.println(answer);
    }
}

/*

 */
