package com.brr.newcodingtest.n14503;

import java.io.*;
import java.util.*;

public class Main3 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int answer;
    static int r, c, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        int cnt = 0;
        while (true) {
            int nextR = r;
            int nextC = c;
            int nextD = d;
            // 1. 현재 위치를 청소한다.
            if (map[r][c] == 0) {
                map[r][c] = -1;
                cnt++;
            }

            // 2. 왼쪽 방향부터 하나씩 탐색
            // 2-1.왼쪽 방향에 아직 청소 x이면, 그 방향으로 회전하고 한 칸 전진.
            int tempD = d - 1;
            if (tempD == -1) tempD = 3;
            int ny = r + dy[tempD];
            int nx = c + dx[tempD];
            if (ny < 0 || ny > N || nx < 0 || nx >= M) continue;
            if (map[ny][nx] == 0) {
                nextR = ny;
                nextC = nx;
                nextD = tempD;
            } else {
                // 2-2. 왼쪽에 청소할 공간 x이면, 그 방향으로 회전 후 2번으로 돌아감.
                nextD = tempD;
            }

            boolean check = true;
            for (int i = 0; i < 4; i++) {
                ny = r + dy[i];
                nx = c + dx[i];

                if (ny < 0 || ny > N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] == 0) {
                    check = false;
                    break;
                }
            }
            // 네 방향 모두 청소되어있거나 벽일경우,
            if (check) {
                tempD = (d + 2) % 4;
                ny = r + dy[tempD];
                nx = c + dx[tempD];

                if (ny < 0 || ny > N || nx < 0 || nx >= M) continue;

                // 벽이라 후진도 못하면 작동 중지
                if (map[ny][nx] == 1) {
                    answer = cnt;
                    break;
                } else {
                    // 바라보는 방향 유지한 채로 뒤로 한 칸.
                    nextR = ny;
                    nextC = nx;
                    nextD = d;
                }
            }

            r = nextR;
            c = nextC;
            d = nextD;
        }
    }
}

/*
3 3
1 1 0
1 1 1
1 0 1
1 1 1

1

11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

57

57
 */

/*
0 -> 2
1 -> 3
2 -> 0
3 -> 1

d = (d + 2) % 4

0 -> 3
1 -> 0
2 -> 1
3 -> 2

d = (d - 1) +
 */

/*

2. 현재 방향 기준 왼쪽으로 인접칸 탐색
    1. 왼쪽 방향에 청소 x 인 곳이 있으면, 그 방향으로 회전 후 한 칸 전진 후 1번 실행
    2. 왼쪽 방향에 청소할 공간 x 이면, 그 방향으로 회전하고 2번으로 돌아감
    3. 네 방향 모두 청소가 되어있거나 벽이면, 바라보는 방향 유지한 채로 한 칸 후진 후 2번 돌아감
    4. 네 방향 모두 청소가 되어있거나 벽임녀서, 뒤쪽 방향이 벽이라 후진도 할 수 없으면 동작 멈춤.
 */