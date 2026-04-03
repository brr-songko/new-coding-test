package com.brr.newcodingtest.n5972;

import java.io.*;
import java.util.*;

class Node {
    int num;
    int cowNum;
    int sum;

    public Node(int num, int cowNum, int sum) {
        this.num = num;
        this.cowNum = cowNum;
        this.sum = sum;
    }
}

public class Main {

    static int N, M, answer;
    static ArrayList<Node>[] list;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        arr = new int[N + 1];
        arr[1] = 0;
        Arrays.fill(arr, Integer.MAX_VALUE);

        answer = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B, C, 0));
            list[B].add(new Node(A, C, 0));
        }

        bfs(1);

        System.out.println(answer);
    }

    static void bfs(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            return a.sum - b.sum;
        });
        pq.offer(new Node(s, 0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int num = node.num;
            int sum = node.sum;

            if (num == N) {
                answer = Math.min(answer, sum);
                return;
            }

            for (int i = 0; i < list[node.num].size(); i++) {
                Node nNode = list[node.num].get(i);
                int nNum = nNode.num;
                int nCowNum = nNode.cowNum;

                if (arr[nNum] > sum + nCowNum) {
                    arr[nNum] = sum + nCowNum;
                    pq.offer(new Node(nNum, nCowNum, sum + nCowNum));
                }
            }
        }
    }
}
