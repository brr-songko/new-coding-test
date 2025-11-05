package com.brr.newcodingtest.n2504;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Map<String, Integer>> mapStack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) == ')' || s.charAt(0) == ']') {
                System.out.println("check1");
                stack.push(')');
                System.out.println("stack = " + stack);
                break;
            }
            if (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == '[') {
                System.out.println("check2");
                stack.push('(');
                System.out.println("stack = " + stack);
                break;
            }
            if (s.charAt(i) == '(') {
                System.out.println("check3");
                System.out.println("stack = " + stack);
                stack.push(s.charAt(i));
                if (s.charAt(i + 1) == '(' || s.charAt(i + 1) == '[') {
                    System.out.println("check4");
                    Map<String, Integer> map = new HashMap<>();
                    map.put("*", 2);
                    mapStack.push(map);
                    System.out.println("mapStack = " + mapStack);
                }
            } else if (s.charAt(i) == '[') {
                System.out.println("check5");
                stack.push(s.charAt(i));
                System.out.println("stack = " + stack);
                if (s.charAt(i + 1) == '(' || s.charAt(i + 1) == '[') {
                    System.out.println("check6");
                    Map<String, Integer> map = new HashMap<>();
                    map.put("*", 3);
                    mapStack.push(map);
                    System.out.println("mapStack = " + mapStack);
                }
            } else if (s.charAt(i) == ')') {
                System.out.println("check7");
                if (s.charAt(i - 1) == '(') {
                    System.out.println("check8");
                    stack.pop();
                    System.out.println("stack = " + stack);
                    Map<String, Integer> map = new HashMap<>();
                    map.put("+", 2);
                    mapStack.push(map);
                    System.out.println("mapStack = " + mapStack);
                } else if (!stack.isEmpty() && stack.peek() == '(') {
                    System.out.println("check9");
                    stack.pop();
                    System.out.println("stack = " + stack);
                } else {
                    System.out.println("check10");
                    stack.push(s.charAt(i));
                    System.out.println("stack = " + stack);
                }
            } else if (s.charAt(i) == ']') {
                System.out.println("check11");
                if (s.charAt(i - 1) == '[') {
                    System.out.println("check12");
                    stack.pop();
                    System.out.println("stack = " + stack);
                    Map<String, Integer> map = new HashMap<>();
                    map.put("+", 3);
                    mapStack.push(map);
                    System.out.println("mapStack = " + mapStack);
                } else if (!stack.isEmpty() && stack.peek() == '[') {
                    System.out.println("check13");
                    stack.pop();
                    System.out.println("stack = " + stack);
                } else {
                    System.out.println("check14");
                    stack.push(s.charAt(i));
                    System.out.println("stack = " + stack);
                }
            }

            if (stack.isEmpty()) {
                int temp = 0;
                System.out.println("최종 mapStack = " + mapStack);
                while (!mapStack.isEmpty()) {
                    Map<String, Integer> map = mapStack.pop();
                    System.out.println("map = " + map);
                    if (map.containsKey("+")) {
                        temp += map.get("+");
                    } else if (map.containsKey("*")) {
                        temp *= map.get("*");
                    }
                }
                System.out.println("temp = " + temp);
                System.out.println("mapStack = " + mapStack);
                System.out.println("stack = " + stack);
                answer += temp;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }
}
