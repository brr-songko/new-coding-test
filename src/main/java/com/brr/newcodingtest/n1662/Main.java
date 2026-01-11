package com.brr.newcodingtest.n1662;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(-1);
            } else if (c == ')') {
                int sum = 0;
                while (stack.peek() != -1) {
                    sum += stack.pop();
                }
                stack.pop();
                int k = stack.pop();
                stack.push(sum * k);
            } else if (c >= '0' && c <= '9') {
                if (i + 1 < S.length() && S.charAt(i + 1) == '(') {
                    stack.push(c - '0');
                } else {
                    stack.push(1);
                }
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
