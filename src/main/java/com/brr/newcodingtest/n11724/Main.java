package com.brr.newcodingtest.n11724;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}

/*
1. 아이디어
- DFS 사용
- for {
        int i = 1 ~ n 까지
        if(방문하지 않은 배열이라면){
            visited[i] = true;
            count++
            DFS
        }
    }
- DFS {
        if (방문한 배열이라면){
            return
        }
        for {
            int i = 1 ~ n
            if(A[v]의 1번째 요소부터 ~ n번째 요소까지의 visited[i]의 값이 방문하지 않은 배열이라면){
                DFS(i)
            }
        }
    }

2. 시간복잡도
- O(N2) = 1000 * 1000 = 1,000,000
- 가능

3. 자료구조
- int N,M
- ArrayList<ArrayList<Integer>> A
- boolean[] visited
- int count
 */