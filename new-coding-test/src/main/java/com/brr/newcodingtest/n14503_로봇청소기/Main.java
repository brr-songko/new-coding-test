package com.brr.newcodingtest.n14503_로봇청소기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int cnt = 0;

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        while (true) {
            if (map[y][x] == 0) {
                map[y][x] = 2;
                cnt += 1;
            }

            int ny = y;
            int nx = x;
            boolean sw = false;
            for (int i = 1; i < 6; i++) {
                System.out.println("d-i는 " + (d - i));
                ny = y + dy[d - i];
                nx = x + dx[d - i];
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (map[ny][nx] == 0) {
//                    그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
                        d = d - i;
                        y = ny;
                        x = nx;
                        sw = true;
                        break;
                    }
                }
            }
//            4방향 모두 있지 않은 경우
            if (!sw) {
//                뒤쪽 방향이 막혀있는 지 확인
                ny = y - dy[d];
                nx = y - dx[d];
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (map[ny][nx] == 1) {
                        break;
                    } else {
                        y = ny;
                        x = nx;
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