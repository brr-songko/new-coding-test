package com.brr.newcodingtest.n12605;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            String[] sList = s.split(" ");

            for (int j = 0; j < sList.length; j++) {
                stack.push(sList[j]);
            }

            sb.append("Case #").append(i).append(": ");
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
