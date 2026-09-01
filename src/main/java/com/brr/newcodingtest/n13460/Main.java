package com.brr.newcodingtest.n13460;

import java.io.*;
import java.util.*;

class Beads {
    int ry, rx, by, bx, cnt;

    public Beads(int ry, int rx, int by, int bx, int cnt) {
        this.ry = ry;
        this.rx = rx;
        this.by = by;
        this.bx = bx;
        this.cnt = cnt;
    }
}

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M, answer;
    static int ry, rx, by, bx;
    static char[][] arr;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'R') {
                    ry = i;
                    rx = j;
                } else if (arr[i][j] == 'B') {
                    by = i;
                    bx = j;
                }
            }
        }

        answer = -1;

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Beads> q = new LinkedList<>();
        q.offer(new Beads(ry, rx, by, bx, 0));
        visited[ry][rx][by][bx] = true;

        while (!q.isEmpty()) {
            Beads cur = q.poll();

            if (cur.cnt == 10) continue; // 이미 10번 기울였으면 더 진행 안 함

            for (int d = 0; d < 4; d++) {
                int mdy = dy[d], mdx = dx[d];

                // 이동 방향으로 더 앞서 있는 공을 먼저 굴려야 함(안 그러면 붙어있는 공끼리 순서에 따라 결과가 달라짐)
                boolean redFirst;
                if (mdy == -1) redFirst = cur.ry < cur.by;
                else if (mdy == 1) redFirst = cur.ry > cur.by;
                else if (mdx == -1) redFirst = cur.rx < cur.bx;
                else redFirst = cur.rx > cur.bx;

                int[] rPos, bPos;
                if (redFirst) {
                    rPos = roll(cur.ry, cur.rx, mdy, mdx, cur.by, cur.bx);
                    bPos = roll(cur.by, cur.bx, mdy, mdx, rPos[0], rPos[1]);
                } else {
                    bPos = roll(cur.by, cur.bx, mdy, mdx, cur.ry, cur.rx);
                    rPos = roll(cur.ry, cur.rx, mdy, mdx, bPos[0], bPos[1]);
                }

                if (bPos[2] == 1) continue; // 파란공이 구멍에 빠지면 이 방향은 무효

                if (rPos[2] == 1) { // 빨간공만 구멍에 빠지면 성공
                    answer = cur.cnt + 1;
                    return;
                }

                int nry = rPos[0], nrx = rPos[1], nby = bPos[0], nbx = bPos[1];
                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    q.offer(new Beads(nry, nrx, nby, nbx, cur.cnt + 1));
                }
            }
        }
    }

    // 벽('#')이나 다른 공(oy,ox) 만나기 전까지 굴러가고, 구멍('O')에 들어가면 즉시 멈춘다.
    // 반환: {y, x, 구멍에 빠졌으면 1 아니면 0}
    static int[] roll(int y, int x, int mdy, int mdx, int oy, int ox) {
        while (true) {
            int ny = y + mdy, nx = x + mdx;
            if (arr[ny][nx] == '#') break;
            if (ny == oy && nx == ox) break;
            y = ny;
            x = nx;
            if (arr[y][x] == 'O') return new int[]{y, x, 1};
        }
        return new int[]{y, x, 0};
    }
}
