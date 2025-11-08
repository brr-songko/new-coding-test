package com.brr.newcodingtest.n2644;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, s, e, answer;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        check = false;
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list[y].add(x);
            list[x].add(y);
        }

        dfs(s);

        if (check) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    static void dfs(int v) {
        if (v == e) {
            check = true;
            return;
        }

        visited[v] = true;
        answer++;

        for (int i = 0; i < list[v].size(); i++) {
            if (!visited[list[v].get(i)]) {
                dfs(list[v].get(i));
                if (check) {
                    break;
                }
//                visited[v] = false;
                answer--;
            }
        }
    }
}
