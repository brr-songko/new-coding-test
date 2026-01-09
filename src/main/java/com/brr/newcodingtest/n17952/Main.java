package com.brr.newcodingtest.n17952;

import java.io.*;
import java.util.*;

class Node {
    int score;
    int time;

    public Node(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                if (time == 1) {
                    answer += score;
                    continue;
                }
                Node node = new Node(score, time - 1);
                stack.push(node);
            } else {
                if (stack.isEmpty()) continue;
                Node node = stack.pop();
                node.time -= 1;
                if (node.time == 0) {
                    answer += node.score;
                } else {
                    stack.push(node);
                }
            }
        }

        System.out.println(answer);
    }
}
