package com.brr.newcodingtest.n1966;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            // 1️⃣ 문서 정보 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{priority, i});
                pq.offer(priority); // 중요도만 저장
            }

            int answer = 0;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                if (now[0] == pq.peek()) {
                    pq.poll();
                    answer++;

                    if (M == now[1]) {
                        System.out.println(answer);
                        break;
                    }

                } else {
                    queue.offer(now);
                }
            }
        }
    }
}
