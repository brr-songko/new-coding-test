package com.brr.newcodingtest.n16236;

import java.io.*;
import java.util.*;

public class Main {

    static int N, answer;
    static int[][] map;
    static boolean[][] visited;
    static boolean check;
    static PriorityQueue<int[]> pq;
    static int sharkSize = 2;
    static int eatCnt;
    static int sharkY, sharkX;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            bfs();
            if (pq.size() == 0) {
                break;
            }
            int[] temp = pq.poll();
            sharkY = temp[0];
            sharkX = temp[1];
            map[sharkY][sharkX] = 0;
            eatCnt++;
            if (eatCnt == sharkSize) {
                eatCnt = 0;
                sharkSize += 1;
            }
            answer += temp[2];
        }

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][N];
        visited[sharkY][sharkX] = true;
        q.offer(new int[]{sharkY, sharkX, 0});
        pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2];
            else if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int cnt = temp[2];
//            System.out.println("start y = " + y);
//            System.out.println("start x = " + x);
//            System.out.println("start cnt = " + cnt);
            if (map[y][x] != 0 && map[y][x] < sharkSize) {
                pq.offer(new int[]{y, x, cnt});
//                System.out.println("pq insert");
//                System.out.println("pq insert y, x = " + y + ", " + x + ", " + cnt);
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

//                System.out.println("ny = " + ny);
//                System.out.println("nx = " + nx);

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
//                System.out.println("ny nx 기준통과" +  ny + " " + nx);
                if (visited[ny][nx]) continue;
//                System.out.println("방문통과 " + ny + " " + nx);
                if (map[ny][nx] > sharkSize) continue;
//                System.out.println("값 비교 통과 " + ny + " " + nx);

                q.offer(new int[]{ny, nx, cnt + 1});
                visited[ny][nx] = true;
            }
        }
    }
}

/*
bfs 돌아

 */

/*
3
0 0 0
0 0 0
0 9 0

0

3
0 0 1
0 0 0
0 9 0

3

4
4 3 2 1
0 0 0 0
0 0 9 0
1 2 3 4

14

6
5 4 3 2 3 4
4 3 2 3 4 5
3 2 9 5 6 6
2 1 2 3 4 5
3 2 1 6 5 4
6 6 6 6 6 6

60

6
6 0 6 0 6 1
0 0 0 0 0 2
2 3 4 5 6 6
0 0 0 0 0 2
0 2 0 0 0 0
3 9 3 0 0 1

48

6
1 1 1 1 1 1
2 2 6 2 2 3
2 2 5 2 2 3
2 2 2 4 6 3
0 0 0 0 0 6
0 0 0 0 0 9

39
 */