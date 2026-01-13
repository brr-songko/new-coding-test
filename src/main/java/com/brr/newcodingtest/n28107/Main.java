package com.brr.newcodingtest.n28107;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] answerList = new int[N];
        List<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < k; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            list.add(queue);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int food = Integer.parseInt(st.nextToken());
            boolean check = false;
            for (int j = 0; j < N; j++) {
                Queue<Integer> nowQueue = list.get(j);
                for (int k = 0; k < nowQueue.size(); k++) {
                    int order = nowQueue.poll();
                    if (order != food) {
                        nowQueue.offer(order);
                    } else {
                        answerList[j]++;
                        check = true;
                        break;
                    }
                }
                if (check) {
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answerList[i] + " ");
        }
    }
}
