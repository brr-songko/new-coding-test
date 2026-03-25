package com.brr.newcodingtest.n21608;

import java.io.*;
import java.util.*;

class Node {
    int y, x, like, empty;

    public Node(int y, int x, int like, int empty) {
        this.y = y;
        this.x = x;
        this.like = like;
        this.empty = empty;
    }
}

public class Main {

    static int N;
    static int[][] arr;
    static Map<Integer,int[]> map = new HashMap<>();
    static int[] order;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        order = new int[N * N];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;

            int[] fav = new int[4];
            for (int j = 0; j < 4; j++) {
                fav[j] = Integer.parseInt(st.nextToken());
            }
            map.put(student, fav);
        }

        for (int i = 0; i < N * N; i++) {
            int student = order[i];
            int[] fav = map.get(student);

            List<Node> list = new ArrayList<>();

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {

                    if (arr[y][x] != 0) continue;

                    int like = 0;
                    int empty = 0;

                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];

                        if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                        if (arr[ny][nx] == 0) empty++;
                        else {
                            for (int f : fav) {
                                if (arr[ny][nx] == f) like++;
                            }
                        }
                    }
                    list.add(new Node(y, x, like, empty));
                }
            }

            Collections.sort(list, (a,b) -> {
                if (a.like != b.like) return b.like - a.like;
                if (a.empty != b.empty) return b.empty - a.empty;
                if (a.y != b.y) return a.y - b.y;
                return a.x - b.x;
            });

            Node best = list.get(0);
            arr[best.y][best.x] = student;
        }

        int answer = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int student = arr[y][x];
                int[] fav = map.get(student);

                int like = 0;

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                    for (int f : fav) {
                        if (arr[ny][nx] == f) like++;
                    }

                }
                if (like == 1) answer += 1;
                else if (like == 2) answer += 10;
                else if (like == 3) answer += 100;
                else if (like == 4) answer += 1000;
            }
        }

        System.out.println(answer);
    }
}
