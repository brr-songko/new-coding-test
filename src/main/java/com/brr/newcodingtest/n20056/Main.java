package com.brr.newcodingtest.n20056;

import java.io.*;
import java.util.*;

class Fireball {
    int m;
    int d;
    int s;

    public Fireball(int m, int d, int s) {
        this.m = m;
        this.d = d;
        this.s = s;
    }
}

public class Main {

    static ArrayList<Fireball>[][] map;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Fireball fireball = new Fireball(m, d, s);
            map[r][c].add(fireball);
        }

        for (int i = 0; i < K; i++) {
            moveFireball();

            makeNewFireball();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 0) {
                    for (Fireball fireball : map[i][j]) {
                        answer += fireball.m;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static void moveFireball() {
        ArrayList<Fireball>[][] newMap = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMap[i][j] = new ArrayList<>();
            }
        }
        boolean move = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() >= 1) {
                    move = true;
                    for (Fireball fireball : map[i][j]) {
                        int ny = ((i + dy[fireball.d] * fireball.s))% N;
                        if (ny < 0) {
                            ny += N;
                        }
                        int nx = ((j + dx[fireball.d] * fireball.s))% N;
                        if (nx < 0) {
                            nx += N;
                        }
                        newMap[ny][nx].add(fireball);
                    }
                }
            }
        }

        if (move) {
            map = newMap;
        }
    }

    static void makeNewFireball() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() >= 2) {
                    int mSum = 0;
                    int sSum = 0;
                    int dSum = 0;
                    int d1 = 0;
                    int d2 = 0;
                    int d3 = 0;
                    int d4 = 0;
                    for (Fireball fireball : map[i][j]) {
                        mSum += fireball.m;
                        sSum += fireball.s;
                        dSum += (fireball.d % 2);
                    }
                    mSum /= 5;
                    sSum /= map[i][j].size();
                    if (dSum == 0 || dSum == map[i][j].size()) {
                        d1 = 0;
                        d2 = 2;
                        d3 = 4;
                        d4 = 6;
                    } else {
                        d1 = 1;
                        d2 = 3;
                        d3 = 5;
                        d4 = 7;
                    }

                    if (mSum == 0) {
                        ArrayList<Fireball> list = new ArrayList<>();
                        map[i][j] = list;
                        continue;
                    }

                    Fireball fireball1 = new Fireball(mSum, d1, sSum);
                    Fireball fireball2 = new Fireball(mSum, d2, sSum);
                    Fireball fireball3 = new Fireball(mSum, d3, sSum);
                    Fireball fireball4 = new Fireball(mSum, d4, sSum);

                    ArrayList<Fireball> list = new ArrayList<>();
                    list.add(fireball1);
                    list.add(fireball2);
                    list.add(fireball3);
                    list.add(fireball4);

                    map[i][j] = list;
                }
            }
        }
    }
}