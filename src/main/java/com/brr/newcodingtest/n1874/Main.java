package com.brr.newcodingtest.n1874;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        boolean[] visited = new boolean[n + 1];
        int[] A = new int[n+1];
        int index = 1;

        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+").append("\n");

            while (!stack.isEmpty() && stack.peek() == A[index]) {
                stack.pop();
                index++;
                sb.append("-").append("\n");
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
