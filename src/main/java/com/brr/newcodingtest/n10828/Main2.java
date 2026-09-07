package com.brr.newcodingtest.n10828;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (s.equals("pop")) {
                if (!stack.isEmpty()) sb.append(stack.pop()).append("\n");
                else sb.append(-1).append("\n");
            } else if (s.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (s.equals("empty")) {
                if (stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (s.equals("top")) {
                if (stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}

/*
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top
 */
