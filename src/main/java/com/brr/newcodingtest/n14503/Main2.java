package com.brr.newcodingtest.n14503;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N, M;
    static int r, c, d;
    static int[][] A;
    static int count;
    static boolean check;
    //북 동 남 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if(A[r][c] == 0) {
                A[r][c] = 2;
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (0 < nr && nr < N && 0 < nc && nc < M) {
                    if (A[nr][nc] == 0) {
                        check = true;
                        break;
                    }
                }
            }

            //청소 가능하다면
            if (check) {
                int nd = d;
                for (int i = 0; i < 4; i++) {
                    nd -= 1;
                    if (nd < 0) {
                        nd = 3;
                    }
                    int nr = r + dr[nd];
                    int nc = c + dc[nd];
                    if (0 < nr && nr < N && 0 < nc && nc < M) {
                        if (A[nr][nc] == 0) {
                            r = nr;
                            c = nc;
                            d = nd;
                            check = false;
                            break;
                        }
                    }
                }
            } else {
                int nd = (d+2) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                if (0 < nr && nr < N && 0 < nc && nc < M) {
                    if (A[nr][nc] == 1) {
                        break;
                    } else {
                        r = nr;
                        c = nc;
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}

/*
if(!visited)
visited = true

0은 청소 안된 칸, 1은 벽, 2는 청소된 칸

북 동 남 서
dy = {-1, 0, 1, 0};
dx = {0, 1, 0, -1};
if(4방향 다 청소 가능 xx && 빈칸 xx)
    if(현재 방향 유지한 채 한 칸 후진 가능 시)
        후진
        break
    else if(벽이라 후진 불가 시)
        break
if(빈칸 있는 경우)
    반시계 방향으로 회전
    if(청소 안된 곳이면)
        전진
        break

청소하는 칸의 갯수니까 visited = true로 바꿀 때마다 count ++
 */
