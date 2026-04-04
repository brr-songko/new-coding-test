package com.brr.newcodingtest.n2668;

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static List<Integer> answerList = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }


        Collections.sort(answerList);

        StringBuilder sb = new StringBuilder();
        sb.append(answerList.size()).append("\n");
        for (int n : answerList) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start, int cur) {
        if (!visited[cur]) {
            visited[cur] = true;
            dfs(start, arr[cur]);
        } else {
            if (cur == start) {
                answerList.add(start);
            }
        }
    }
}
