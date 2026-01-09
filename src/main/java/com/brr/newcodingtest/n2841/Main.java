package com.brr.newcodingtest.n2841;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int answer = 0;
        List<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            stacks.add(new Stack<>());
        }

        for (int i = 0; i < N; i++) {
            int line = sc.nextInt();
            int fret = sc.nextInt();

            if (stacks.get(line).isEmpty()) {
                stacks.get(line).push(fret);
                answer++;
            } else {
                while (!stacks.get(line).isEmpty() && stacks.get(line).peek() > fret) {
                    stacks.get(line).pop();
                    answer++;
                }
                if (!stacks.get(line).isEmpty() && stacks.get(line).peek() == fret) continue;
                stacks.get(line).push(fret);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
