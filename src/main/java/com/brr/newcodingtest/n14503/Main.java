package com.brr.newcodingtest.n14503;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int r, c, d;
    static int cnt;
    static int[] dr, dc;
    static boolean run = true;
    static boolean check;
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
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dr = new int[]{-1, 0, 1, 0};
        dc = new int[]{0, 1, 0, -1};

        while (run) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                cnt++;
            }
//            System.out.println("cnt = " + cnt);

            // 청소되지 않은 칸이 있는 지 확인
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
//                System.out.println("nr = " + nr);
//                System.out.println("nc = " + nc);
                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (map[nr][nc] == 0) {
//                        System.out.println("map[nr][nc] = " + map[nr][nc]);
                        check = true;
                        break;
                    }
                }
            }

            // 청소되지 않은 칸 존재 -> 방향을 반시계 방향으로 돌려가며 전진 가능할 경우 전진
            if (check) {
                int nd = d;
                for (int i = 0; i < 4; i++) {
                    nd -= 1;
                    if (nd < 0) {
                        nd = 3;
                    }
                    int nr = r + dr[nd];
                    int nc = c + dc[nd];
//                    System.out.println("2번째 nr = " + nr);
//                    System.out.println("2번째 nc = " + nc);
                    if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                        if (map[nr][nc] == 0) {
//                            System.out.println("map[nr][nc] == 0 부분 진입");
                            r = nr;
                            c = nc;
                            d = nd;
                            check = false;
                            break;
                        }
                    }
                }
            } else {
//                System.out.println("check false 진입");
                int nd = (d + 2) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (map[nr][nc] == 1) {
                        run = false;
                    } else {
                        r = nr;
                        c = nc;
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}

/*
1. 아이디어
- while(run) 로 무한 반복
- 4 방향을 for 문으로 탐색(dr, dc 방향 벡터 사용) -> boolean check 값으로 청소되지 않은 칸 있는 지 여부 확인
- 청소되지 않은 칸 있을 때 반 시계 방향으로 회전하면서 청소 x 일 경우 전진
- 청소 x일 경우 벽이 아니라면 한 칸 후진
- 청소 x일 경우 벽이라면 run = true

2. 시간 복잡도
- O(NM) : 50 ^ = 2500 < 2억
- 가능

3. 자료구조
- int[][] map
- int N, M
- int r, c, d
- int[] dy, dx
- int cnt
- boolean run, check
 */

/*
1. 아이디어
- while 문으로, 특정조건 종료될때까지 반복
- 4방향을 for문으로 탐색
- 더이상 탐색 불가능할 경우, 뒤로 한칸 후진
- 후진이 불가능하면 종료

2. 시간복잡도
- O(NM) : 50^ = 2500 < 2억
- 가능

3. 자료구조
- map : int[][]
- 로봇청소기 위치, 방향, 전체 청소한 곳 수

 */
