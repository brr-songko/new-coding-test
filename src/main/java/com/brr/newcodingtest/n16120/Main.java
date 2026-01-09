package com.brr.newcodingtest.n16120;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);

            while (stack.size() >= 4) {
                int n = stack.size();
                if (stack.get(n - 4) == 'P'
                        && stack.get(n - 3) == 'P'
                        && stack.get(n - 2) == 'A'
                        && stack.get(n - 1) == 'P') {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}

