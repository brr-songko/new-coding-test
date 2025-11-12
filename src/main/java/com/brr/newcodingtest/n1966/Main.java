package com.brr.newcodingtest.n1966;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int target = 0;
            Queue<Integer> queue = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                queue.offer(temp);
                if (j == M) {
                    target = temp;
                }
            }

            while (!queue.isEmpty()) {
                boolean check = true;
                for (int j = 0; j < N; j++) {
                    int temp = queue.poll();
                    if (temp > max) {
                        max = temp;
                        check = false;
                    }
                    queue.offer(temp);
                }

                if (check) {
                    int temp = queue.poll();
                    answer++;
                    if (temp == target) {
                        System.out.println(answer);
                        break;
                    }
                } else {
                    queue.offer(queue.poll());
                    System.out.println("진입");
                }
            }
        }
    }
}
