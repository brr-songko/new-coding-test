package com.brr.newcodingtest.n1939;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, s, e, max;
    static long answer;
    static ArrayList<int[]>[] list;
    static boolean[] visited;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new int[]{B, C});
            list[B].add(new int[]{A, C});
            max = Math.max(C, max);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        binarySearch();

        System.out.println(answer);
    }

    static void binarySearch() {
        long left = 0;
        long right = max;
        long mid;

        while (left <= right) {
            mid = (left + right) / 2;
            visited = new boolean[N + 1];
            if (dfs(s, mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

    }

    static boolean dfs(int s, long mid) {
        if (s == e) {
            return true;
        }

        visited[s] = true;

        for (int i = 0; i < list[s].size(); i++) {
            int next = list[s].get(i)[0];
            int weight = list[s].get(i)[1];

            if (!visited[next] && weight >= mid) {
                if(dfs(next, mid)) return true;
            }
        }

        return false;
    }
}
