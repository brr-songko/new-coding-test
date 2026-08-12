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
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int cnt = temp[2];

            if (map[y][x] == 0) {
                map[y][x] = -1;
                cnt++;
            }

            boolean check = true;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] == 1) continue;

                if (map[ny][nx] == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                d = (d + 2) % 4;
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    answer = cnt;
                    return;
                }
                if (map[ny][nx] == 1) {
                    answer = cnt;
                    return;
                }
            } else {
                d = d - 1;
                if (d < 0) d = 3;
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] == 0) {
                    q.offer(new int[]{ny, nx, cnt});
                }
            }
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
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 1 0 0 0 0 0 0 1
1 0 0 0 0 0 0 0 1 1
1 1 0 1 1 0 0 0 1 1
1 0 0 0 1 1 0 0 1 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

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
1. 아직 청소 x 이면 현재칸 청소
2. 현재 칸 주변 4 칸중 청소되지 않은 칸이 없으면
    1. 바라보는 방향 유지한 채로 뒤로 한 칸 후 1번 시작
    2. 갈 수 없다면 동작 멈춤
3. 주변 4칸 중 청소되지 않은 칸이 있다면
    1. 반 시계 방향으로 90도 회전
    2. 앞쪽 칸이 청소되지 않았다면 전진.
    3. 1번으로 돌아감.
 */