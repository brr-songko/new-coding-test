package com.brr.newcodingtest.n2504;

import java.io.*;
import java.util.*;

public class TempMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (i == 0 && c1 == ')' || c1 == ']') {
                System.out.println(0);
                break;
            }
            if (i == s.length() - 1 && c1 == '(' || c1 == '[') {
                System.out.println(0);
                break;
            }
            if (c1 == '(') {
                if (c2 == ')') {
                    intStack.push(2);
                    stringStack.push("+");
                } else if (c2 == ']') {
                    System.out.println(0);
                    break;
                } else {
                    intStack.push(2);
                    stringStack.push("*");
                }
            } else if (c1 == '[' && c2 == ']') {
                intStack.push(3);
                stringStack.push("+");
            } else if (c1 == '(') {

            }
        }
    }
}
