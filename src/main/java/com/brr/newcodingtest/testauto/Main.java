package com.brr.newcodingtest.testauto;

import java.io.*;
import java.util.*;

class City {
    int v;
    int cost;

    public City (int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main {

    static int N, answer;
    static ArrayList<City>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;

        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 0) continue;
                list[i + 1].add(new City(j + 1, v));
            }
        }

        visited[1] = true;
        dfs(1, 0);

        System.out.println(answer);
    }

    static public void dfs(int cur, int cost) {
        boolean check = true;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                check = false;
                break;
            }
        }
        if (check) {
            for (City city : list[cur]) {
                if (city.v == 1) {
                    answer = Math.min(answer, cost + city.cost);
                }
            }
            return;
        }


        for (City city : list[cur]) {
            if (!visited[city.v]) {
                visited[city.v] = true;
                dfs(city.v, cost + city.cost);
                visited[city.v] = false;
            }
        }
    }
}

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
 */