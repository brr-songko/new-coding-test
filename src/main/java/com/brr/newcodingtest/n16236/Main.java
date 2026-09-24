package com.brr.newcodingtest.n16236;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int sharkSize = 2;
    static int eatCnt, answer, N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int sharkY, sharkX;

    public static void main(String[] args) throws IOException {
        /*
        풀이법
        1. 먹을 수 있는 물고기가 있는지 판별. -- 거리가 같은 애들은
        2. 판별 과정은 추후
        3. 해당 칸 물고기 먹고, 칸 및 상어 위치 갱신.
        4. 이동하면서 시간 갱신, sharkSize 및 eatCnt 갱신
         */
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
                }
            }
        }

        while(true) {
            System.out.println("check1");
            visited = new boolean[N][N];
            // bfs 돌면서 가장가까운 먹을 수 있는 놈 있는지 없는지 bfs.
            // bfs 도는 중에 발견하면 return true, 없다면 끝나고 return false
            boolean check = bfs();
            System.out.println("bfs out");
            if (!check) {
                break;
            }
        }


        System.out.println(answer);
    }

    public static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sharkY, sharkX, 0});
        visited[sharkY][sharkX] = true;

        while (!q.isEmpty()) {
//            System.out.println("check2");
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int cnt = temp[2];

            if (map[y][x] != 9 && map[y][x] != 0 && map[y][x] < sharkSize) {
                map[sharkY][sharkX] = 0;
                sharkY = y;
                sharkX = x;
                map[sharkY][sharkX] = 9;
                answer += cnt;
                eatCnt++;
                if (eatCnt == sharkSize) {
                    sharkSize++;
                    eatCnt = 0;
                }
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] > sharkSize) continue;

                q.offer(new int[]{ny, nx, cnt + 1});
                visited[ny][nx] = true;
            }
        }

        return false;
    }
}

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

/*
아기 상어는 본인보다 큰 사이즈 물고기가 있는 칸에 갈 수 없다. 나머지 칸은 모두 가능.
자신의 크기보다 작은 물고기만 먹을 수 있다. 크기가 같은 녀석이 있으면, 지나갈 수는 있으나 먹을 수는 없다.

1. 먹을 수 있는 물고기가 한 마리라면, 그 물고기를 먹으러 간다.
2. 먹을 수 있는 물고기가 한 마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
    거리는 아기상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값
    거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면 가장 왼쪽에 있는 물고기를 먹는다.
아기 상어의 이동은 1초가 걸리고, 먹는데 걸리는 시간은 x
아기 상어가 먹을 수 있는 칸으로 이동했다면, 그 칸은 빈칸이 된다.

아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1 증가한다.
 */

