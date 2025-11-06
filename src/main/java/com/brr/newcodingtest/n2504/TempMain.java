package com.brr.newcodingtest.n2504;

import java.io.*;
import java.util.*;

public class TempMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> answerStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {

            }
        }
    }
}
