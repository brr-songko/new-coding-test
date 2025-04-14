package com.brr.newcodingtest.n11403;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] answer;
    static boolean[][] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                answer[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int x, int y) {
        answer[x][y] = 1;
        visited[x][y] = true;

        for (int i = 0; i < N; i++) {
            if (arr[y][i] == 1 && !visited[x][i]) {
                dfs(x, i);
            }
        }
    }
}

/**
 * 0,1
 * 1,2
 * 2,0
 *
 * 0 -> 1
 * 0 -> 2 ( 1 -> 2 )
 * 0 -> 0 ( 2 -> 0 )
 * 1 -> 2
 * 1 -> 0 ( 2 -> 0 )
 * 0 -> 1
 *
 */


/**
 * package com.brr.newcodingtest.n11403;
 *
 * import java.io.*;
 * import java.util.*;
 *
 * public class Main {
 *     static int[][] A, answer;
 *     static boolean[][] visited;
 *     static ArrayList<Integer>[] list;
 *     static StringBuilder sb;
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         int N = Integer.parseInt(br.readLine());
 *         A = new int[N][N];
 *         answer = new int[N][N];
 *         visited = new boolean[N][N];
 *         list = new ArrayList[N];
 *         for (int i = 0; i < N; i++) {
 *             StringTokenizer st = new StringTokenizer(br.readLine());
 *             list[i] = new ArrayList<>();
 *             for (int j = 0; j < N; j++) {
 *                 A[i][j] = Integer.parseInt(st.nextToken());
 *                 answer[i][j] = 0;
 *             }
 *         }
 *         for (int i = 0; i < N; i++) {
 *             for (int j = 0; j < N; j++) {
 *                 if (A[i][j] == 1) {
 *                     list[i].add(j);
 *                 }
 *             }
 *         }
 *
 *         for (int i = 0; i < N; i++) {
 *             for (int j = 0; j < N; j++) {
 *                 dfs(i, j, i);
 *             }
 *         }
 *
 *         for (int i = 0; i < N; i++) {
 *             for (int j = 0; j < N; j++) {
 *                 System.out.print(answer[i][j]);
 *                 System.out.print(" ");
 *             }
 *             System.out.print("\n");
 *         }
 *     }
 *
 *     public static void dfs(int x, int y, int newX) {
 *         for (int i = 0; i < list[newX].size(); i++) {
 *             if (list[newX].get(i) == y) {
 *                 answer[x][y] = 1;
 *                 return;
 *             }
 *         }
 *
 *         for (int i = 0; i < list[newX].size(); i++) {
 *             dfs(x, y, list[newX].get(i));
 *         }
 *     }
 * }
 *
 * /***
 *  * 0,1
 *  * 1,2
 *  * 2,0
 *  *
 *  * 0 -> 1
 *  * 0 -> 2 ( 1 -> 2 )
 *  * 0 -> 0 ( 2 -> 0 )
 *  * 1 -> 2
 *  * 1 -> 0 ( 2 -> 0 )
 *  * 0 -> 1
 *  *
 *  */