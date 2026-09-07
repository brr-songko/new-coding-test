package com.brr.newcodingtest.n10773;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (!stack.isEmpty()) {
                    answer -= stack.pop();
                }
            } else {
                answer += n;
                stack.push(n);
            }
        }

        System.out.println(answer);
    }
}

/*
10
1
3
5
4
0
0
7
0
0
6

 */
