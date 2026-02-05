package com.brr.newcodingtest.n11952;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, S; // 도시 수, 도로 수, 점령 도시 개수, 위험 거리 기준
    static int p, q; // 안전 도시, 위험 도시 숙박 비용
    static ArrayList<Integer>[] list; // 도시 그래프
    static boolean[] isZombie; // 해당 도시가 점령 도시인지
    static boolean[] isDanger; // 해당 도시가 위험 도시인지
    static int[] cost; // 각 도시의 숙박 비용
    static int[] dist; // 좀비 도시로부터의 최단 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        isZombie = new boolean[N + 1];
        isDanger = new boolean[N + 1];
        cost = new int[N + 1];
        dist = new int[N + 1];


    }
}
