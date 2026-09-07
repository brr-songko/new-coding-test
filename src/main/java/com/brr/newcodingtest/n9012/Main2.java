package com.brr.newcodingtest.n9012;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') stack.push(c);
                else {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (stack.peek() == '(') stack.pop();
                        else {
                            stack.push(c);
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }

        }

        System.out.println(sb);
    }
}

/*
6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())())(

NO
NO
YES
NO
YES
NO
 */
