package com.brr.newcodingtest.n14888;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N, min, max;
    static int[] arr;
    static ArrayList<String> list = new ArrayList<>();
    static String[] targets;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        arr = new int[N];
        visited = new boolean[N - 1];
        targets = new String[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    list.add("+");
                } else if (i == 1) {
                    list.add("-");
                } else if (i == 2) {
                    list.add("*");
                } else {
                    list.add("/");
                }
            }
        }

        solve(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void solve(int depth) {
        if (depth == N - 1) {
            check();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                targets[depth] = list.get(i);
                solve(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void check() {
        int sum = arr[0];

        for (int i = 0; i < N - 1; i++) {
            String s = targets[i];
            int num = arr[i + 1];
            if (s.equals("+")) {
                sum += num;
            } else if (s.equals("-")) {
                sum -= num;
            } else if (s.equals("*")) {
                sum *= num;
            } else {
                sum /= num;
            }
        }

        min = Math.min(min, sum);
        max = Math.max(max, sum);
    }
}

/*
2
5 6
0 0 1 0

30
30

3
3 4 5
1 0 1 0

35
17

6
1 2 3 4 5 6
2 1 1 1

54
-24
 */
