package com.brr.newcodingtest.n5427;

import java.io.*;
import java.util.*;

public class Main {
    static int w, h, max;
    static boolean[][] visited;
    static Queue<int[]> fireQ = new LinkedList<>();
    static Queue<int[]> personQ = new LinkedList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static String[][] arr;
    static int[][] dist;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new String[h][w];
            visited = new boolean[h][w];
            dist = new int[h][w];
            max = 0;
            check = false;
            fireQ.clear();
            personQ.clear();

            for (int j = 0; j < h; j++) {
                String s = br.readLine();
                String[] sList = s.split("");
                for (int k = 0; k < w; k++) {
                    arr[j][k] = sList[k];
                    if (arr[j][k].equals("@")) {
                        personQ.offer(new int[]{j, k});
                        visited[j][k] = true;
                    } else if (arr[j][k].equals("*")) {
                        fireQ.offer(new int[]{j, k});
                    }
                }
            }

            bfs();

            if (check) {
                sb.append(max).append("\n");
            } else {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }

        System.out.println(sb);
    }

    static void bfs() {
        int time = 0;
        while (!personQ.isEmpty()) {
            time++;
            int fireQueueSize = fireQ.size();
            for (int j = 0; j < fireQueueSize; j++) {
                int[] fire = fireQ.poll();
                int fy = fire[0];
                int fx = fire[1];

                for (int k = 0; k < 4; k++) {
                    int nfy = fy + dy[k];
                    int nfx = fx + dx[k];

                    if (nfy < 0 || nfx < 0 || nfy >= h || nfx >= w) continue;

                    if (arr[nfy][nfx].equals(".") || arr[nfy][nfx].equals("@")) {
                        arr[nfy][nfx] = "*";
                        fireQ.offer(new int[]{nfy, nfx});
                    }
                }
            }

            int personQueueSize = personQ.size();
            for (int j = 0; j < personQueueSize; j++) {
                int[] temp = personQ.poll();
                int y = temp[0];
                int x = temp[1];

                if (y == 0 || x == 0 || y == h - 1 || x == w - 1) {
                    max = time;
                    check = true;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
                    if (visited[ny][nx]) continue;
                    if (arr[ny][nx].equals("#")) continue;
                    if (arr[ny][nx].equals("*")) continue;

                    personQ.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
