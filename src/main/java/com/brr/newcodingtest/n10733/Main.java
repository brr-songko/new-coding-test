package com.brr.newcodingtest.n10733;

import java.io.*;
import java.util.*;;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if (num != 0) {
                stack.push(num);
                sum += num;
            } else {
                sum -= stack.pop();
            }
        }

        System.out.println(sum);
    }
}
