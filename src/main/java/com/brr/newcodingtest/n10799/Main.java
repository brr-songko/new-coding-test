package com.brr.newcodingtest.n10799;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int lines = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                if (s.charAt(i + 1) != ')') {
                    lines++;
                    answer++;
                }
            } else if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    answer += lines;
                } else {
                    lines--;
                    stack.pop();
                }
            }
        }

        System.out.println(answer);
    }
}