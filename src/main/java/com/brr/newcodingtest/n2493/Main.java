package com.brr.newcodingtest.n2493;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스를 저장, 아래->위로 갈수록 키가 작아지는 상태 유지

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop(); // arr[i]보다 작거나 같은 애는 앞으로 영원히 답이 될 수 없으니 버림
            }
            answer[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}

/*
5
6 9 5 7 4

0 0 2 2 4
 */
