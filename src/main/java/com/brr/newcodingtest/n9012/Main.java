package com.brr.newcodingtest.n9012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    stack.push(s.charAt(j));
                } else if (s.charAt(j) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(j));
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
