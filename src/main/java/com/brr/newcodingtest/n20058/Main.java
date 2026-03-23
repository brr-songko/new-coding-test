package com.brr.newcodingtest.n20058;

import java.io.*;
import java.util.*;

public class Main {

    static int N, Q, answerSum, answerBlock, len;
    static int[][] map;
    static boolean[][] visited;
    static int[] L;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        len = 1 << N;
        map = new int[len][len];
        visited = new boolean[len][len];
        L = new int[Q];

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 2N 승만큼 범위 나눠서 for문 -- 이건 범위 for문으로 처리
        for (int k = 0; k < Q; k++) {
            int l = L[k];
            int size = 1 << l;
            for (int i = 0; i < len; i += size) {
                for (int j = 0; j < len; j += size) {
                    // 2. 그 for문마다 회전 실행. 회전은 temp[j][len - 1 - 1] = map[i][j] 로.
                    rotate(size, i, j);
                }
            }

            // 3. 전체 칸 돌면서 상하좌우 비교하고 0 이 아닌 칸 있으면 cnt++ , cnt가 3 미만이면 해당 칸 얼음--
            boolean[][] cnts = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    int cnt = checkIce(i, j);
                    if (cnt < 3) {
                        cnts[i][j] = true;
                    } else {
                        cnts[i][j] = false;
                    }
                }
            }

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (cnts[i][j] && map[i][j] > 0) {
                        map[i][j]--;
                    }
                }
            }
        }

        // 4. 전체 맵 돌면서 sum 구하고, max도 구해
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                answerSum += map[i][j];
                max = Math.max(max, map[i][j]);
            }
        }

        // 5. 얼음양이 max이면서, 방문 안했으면 dfs하면서 dfsMax값 찾아.
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, max);
                }
            }
        }

        System.out.println(answerSum);
        System.out.println(answerBlock);
    }

    static void rotate(int l, int y, int x) {
        int[][] temp = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                temp[j][l - i - 1] = map[i + y][j + x];
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                map[i + y][j + x] = temp[i][j];
            }
        }
    }

    static int checkIce(int y, int x) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= len || nx < 0 || nx >= len) continue;
            if (map[ny][nx] == 0) continue;

            cnt++;
        }

        return cnt;
    }

    static void bfs(int r, int c, int max) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= len || nx < 0 || nx >= len) continue;
                if (map[ny][nx] <= 0) continue;
                if (visited[ny][nx]) continue;

                q.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
                cnt++;
            }
        }

        answerBlock = Math.max(answerBlock, cnt);
    }
}
