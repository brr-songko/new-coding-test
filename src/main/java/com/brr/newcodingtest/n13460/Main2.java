package com.brr.newcodingtest.n13460;

import java.io.*;
import java.util.*;

class Beads2 {
    int ry, rx, by, bx, cnt;

    public Beads2(int ry, int rx, int by, int bx, int cnt) {
        this.ry = ry;
        this.rx = rx;
        this.by = by;
        this.bx = bx;
        this.cnt = cnt;
    }
}

public class Main2 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M, answer;
    static int ry, rx, by, bx;
    static char[][] arr;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException  {
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

            if (cur.cnt == 10) continue;

            for (int d = 0; d < 4; d++) {
                int mdy = dy[d];
                int mdx = dx[d];

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

                if (bPos[2] == 1) continue;

                if (rPos[2] == 1) {
                    answer = cur.cnt + 1;
                    return;
                }

                int nry = rPos[0];
                int nrx = rPos[1];
                int nby = bPos[0];
                int nbx = bPos[1];

                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    q.offer(new Beads(nry, nrx, nby, nbx, cur.cnt + 1));
                }
            }
        }
    }

    public static int[] roll(int y, int x, int mdy, int mdx, int oy, int ox) {
        while (true) {
            int ny = y + mdy;
            int nx = x + mdx;
            if (arr[ny][nx] == '#') break;
            if (ny == oy && nx == ox) break;
            y = ny;
            x = nx;
            if (arr[y][x] == 'O') return new int[]{y, x, 1};
        }

        return new int[]{y, x, 0};
    }
}
