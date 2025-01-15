package com.brr.newcodingtest.n2178;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
//                A[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        BFS(0, 0);

        System.out.println(A[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = temp[0] + dx[k];
                int y = temp[1] + dy[k];
                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (!visited[x][y] && A[x][y] != 0) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                        A[x][y] = A[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }
    }
}

/*
1. 아이디어
- 필요한 자료구조들 다 입력 받고
- BFS(0, 0)으로 돌린다
- BFS는 Queue를 선언(LinkedList) - int[] 를 받는 Queue 선언
- 0,0 으로 들어온 값을 Queue에 넣어주고, visisted true로
- while문 돌면서 queue 의 값을 poll해서 한개씩 탐색 시작
- 0 <= 이고 각  < N, M 이면서
- visited가 false 이고 배열이 0이 아닐때만
- queue에 추가
- visited true로
- 그리고 A[poll한 값][poll한 값] ++ 해준다

2. 시간복잡도
- O(N * M) = 100 * 100 = 10000
- 가능

3. 자료구조
- dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0}
- A[][]
- Queue<int[]>
- visited[][]
- int N, M

 */