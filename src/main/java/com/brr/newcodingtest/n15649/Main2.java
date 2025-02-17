package com.brr.newcodingtest.n15649;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, M;
    static int[] A;
    static boolean[] visited;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[M];
        visited = new boolean[N];

        DFS(0);

        System.out.println(sb);
    }

    public static void DFS(int depth) {
        if (depth == M) {
            for (int value : A) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                A[depth] = i + 1;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}

/*
int[] A N+1
boolean[] visited N+1
int N, M
int count
StringBuilder sb

for( i = 1 ~ N ) {
    DFS(i)

}

DFS(){
    if(visited[]) {
        return
    }
    visited[] = true


    for(int i 1 ~ N){
        if(!visited[]){

        }
    }
}

 */
