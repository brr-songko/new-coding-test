package com.brr.newcodingtest.n1325;

import java.util.*;
import java.io.*;

public class Main2 {

    static int N,M;
    static StringTokenizer st;
    static ArrayList<Integer>[] list;
    static boolean [] check;
    static int[] answers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        answers = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
        }
        for(int i=1; i<=N; i++){
            check = new boolean[N+1];
            bfs(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i : answers) {
            if(i > max){
                max = i;
            }
        }
        for(int i=1; i<=N; i++){
            if(answers[i] == max){
                System.out.print(i + " ");
            }
        }

    }

    static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for (Integer i : list[now]) {
                if(!check[i]){
                    answers[i] ++;
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }





}
