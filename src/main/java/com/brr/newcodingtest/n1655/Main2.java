package com.brr.newcodingtest.n1655;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftPq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> rightPq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
           int n = Integer.parseInt(br.readLine());

            if (leftPq.isEmpty() || n <= leftPq.peek()) {
                leftPq.offer(n);
            } else {
                rightPq.offer(n);
            }

            if (leftPq.size() - rightPq.size() > 1) {
                rightPq.offer(leftPq.poll());
            } else if (rightPq.size() > leftPq.size()) {
                leftPq.offer(rightPq.poll());
            }

            sb.append(leftPq.peek()).append("\n");
        }

        System.out.println(sb);
    }
}

/*
7
1
5
2
10
-99
7
5

1
1
2
2
2
2
5
 */

/*
pq 두 개 사용한다.
왼쪽 pq 는 내림차순
오른쪽 pq는 오름차순

왼쪽 pq가 비어있으면 무조건 왼쪽 pq에 넣는다.
왼쪽 pq가 오른쪽 pq보다 size가 크면 오른쪽 pq에 넣는다.

1 5 2 10 -99 7 5
  .

leftpq
1 5
rightpq

 */