package com.brr.newcodingtest.n10971;
/*
10971 외판원 백트래킹
 */
import java.io.*;
import java.util.*;

public class Main2 {

    static int N, answer;
    static ArrayList<int[]>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) continue;
                list[i].add(new int[]{j, val});
            }
        }
//        soutMap();

        visited[1] = true;
        answer = Integer.MAX_VALUE;
        dfs(1, 0);

        System.out.println(answer);
    }

    public static void dfs(int cur, int cost) {
        boolean check = true;
//        soutVisited(visited);
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                check = false;
                break;
            }
        }
        if (check) {
            for (int[] temp : list[cur]) {
                if (temp[0] == 1) {
                    answer = Math.min(answer, cost + temp[1]);
                    return;
                }
            }
        }

        for (int[] temp : list[cur]) {
            if (!visited[temp[0]]) {
                visited[temp[0]] = true;
                dfs(temp[0], cost + temp[1]);
                visited[temp[0]] = false;
            }
        }
    }

    public static void soutMap() {
        for (int i = 1; i <= N; i++) {
            ArrayList<int[]> temp = list[i];
            for (int j = 0; j < temp.size(); j++) {
                System.out.print("i = " + i + " " + temp.get(j)[0] + ", " + temp.get(j)[1]);
                System.out.println(" ");
            }
            System.out.println(" ---- ");
        }
    }

    public static void soutVisited(boolean[] visited) {
        System.out.println("----start------");
        for (int i = 1; i <= N; i++) {
            System.out.print(visited[i] + " ");
        }
        System.out.println(" ");
        System.out.println("----end------");
    }
}

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
 */
