package com.brr.newcodingtest.n21609;

import java.io.*;
import java.util.*;

class BlockGroup {
    int blockSize;
    int rainbowSize;
    int y;
    int x;
    List<int[]> blocks;

    public BlockGroup(int blockSize, int rainbowSize, int y, int x, List<int[]> blocks) {
        this.blockSize = blockSize;
        this.rainbowSize = rainbowSize;
        this. y = y;
        this. x = x;
        this.blocks = blocks;
    }
}

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N, M, score;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static ArrayList<BlockGroup> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 1. 블록 그룹 생성
            list = new ArrayList<>();
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 한 그룹에는 적어도 하나의 일반 블록 존재. -> bfs 진입 조건으로 체크
                    if (!visited[i][j] && map[i][j] > 0) {
                        makeBlockGroup(i, j);
                    }
                }
            }

            if (list.size() == 0) break;

            // 2. 게임 플레이
            // 2-1. 블록 선택. 크기 가장 큰, 무지개 블록 수 순, 기준 블록 행 큰 순, 열 큰 순.
            Collections.sort(list, (a, b) -> {
                if (a.blockSize != b.blockSize) return b.blockSize - a.blockSize;
                if (a.rainbowSize != b.rainbowSize) return b.rainbowSize - a.rainbowSize;
                if (a.y != b.y) return b.y - a.y;
                return b.x - a.x;
            });

            BlockGroup blockGroup = list.get(0);

            // 2-2. 2-1에서 찾은 블록 그룹의 모든 블록을 제거한다. 그리고 블록그룹 갯수 제곱만큼 점수 획득한다.
            removeBlocks(blockGroup);

            // 2-3. 중력 작용
            gravityAction();

            // 2-4. 90도 반시계 방향 회전
            rotate();

            // 2-5. 중력 작용
            gravityAction();
        }

        System.out.println(score);
    }

    static void makeBlockGroup(int r, int c) {
        // 여기에 방문하는 y, x 값 전부 넣고 다 넣었으면 정렬해서 기준 y, x 탐색
        List<int[]> rcList = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] localVisited = new boolean[N][N];
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        localVisited[r][c] = true;
        rcList.add(new int[]{r, c});
        int minY = r;
        int minX = c;
        int color = map[r][c];
        int rainbowSize = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (map[ny][nx] == -1 || map[ny][nx] == -2) continue;
                if (localVisited[ny][nx]) continue;

                if (map[ny][nx] == color || map[ny][nx] == 0) {
                    q.offer(new int[]{ny, nx});
                    rcList.add(new int[]{ny, nx});
                    localVisited[ny][nx] = true;
                    if (map[ny][nx] == color) {
                        visited[ny][nx] = true;

                        if (ny < minY || (ny == minY && nx < minX)) {
                            minY = ny;
                            minX = nx;
                        }
                    } else rainbowSize++;
                }
            }
        }

        if (rcList.size() < 2) return;

        list.add(new BlockGroup(rcList.size(), rainbowSize, rcList.get(0)[0], rcList.get(0)[1], rcList));

        // minY , minX (기준행 열 값 선언)
        // 일반 블록 색은 while 문 진입 전 colorBlock으로 선언.
        // 일반 블록 색은 모두 같아야 함. -> bfs 내에서 q 진입 조건으로 체크
        // 검은색 블록은 bfs 내에서 continue
        // 0 이어도 bfs q진입
        // 기준 행과 열로 사용할 칸의 y와 x 값은 명시해두고.
    }

    static void removeBlocks(BlockGroup blockGroup) {
        int cnt = 0;
        for (int[] temp : blockGroup.blocks) {
            int y = temp[0];
            int x = temp[1];

            map[y][x] = -2;
            cnt++;
        }

        score += (cnt * cnt);
    }

    static void gravityAction() {
        /**
         * 검은색 블록은 continue or -2는 continue 즉 0 보다 작을때는 continue
         * 행의 번호가 큰 칸으로 이동. 즉  y에 계속 ++ 해주는 것
         * 언제까지 ++해주냐? y + 1 칸이 -1보다 크면 continue, 경계선, 즉 y + 1 값이 N이면 continue
         */
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 0) {
                    moveBlock(i, j);
                }
            }
        }
    }

    static void moveBlock(int r, int c) {
        while (true) {
            if ((r + 1) == N) break;
            if (map[r + 1][c] >= -1) break;

            map[r + 1][c] = map[r][c];
            map[r][c] = -2;

            r++;
        }
    }

    static void rotate() {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[N - 1 - j][i] = map[i][j];
            }
        }

        map = temp;
    }
}