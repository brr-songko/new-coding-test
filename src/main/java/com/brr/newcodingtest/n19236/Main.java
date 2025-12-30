package com.brr.newcodingtest.n19236;

import java.io.*;
import java.util.*;

class Fish {
    int num;
    int dir;
    int y, x;
    boolean isAlive;

    public Fish(int num, int dir, int y, int x, boolean isAlive) {
        this.num = num;
        this.dir = dir;
        this.y = y;
        this.x = x;
        this.isAlive = isAlive;
    }
}

public class Main {
//                     북 북서 서 남서 남 남동 동 북동
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int maxSum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] map = new int[4][4];
        List<Fish> fishes = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = sc.nextInt();
                int dir = sc.nextInt() - 1;
                map[i][j] = num;
                fishes.add(new Fish(num, dir, i, j, true));
            }
        }

        Collections.sort(fishes, (o1, o2) -> o1.num - o2.num);

        // 상어 초기 진입: (0, 0) 물고기 먹음
        Fish firstFish = fishes.get(map[0][0] - 1);
        int sharkDir = firstFish.dir;
        firstFish.isAlive = false;
        map[0][0] = -1;

        dfs(map, 0, 0, sharkDir, firstFish.num, fishes);

        System.out.println(maxSum);
    }

    public static void dfs(int[][] map, int sharkY, int sharkX, int sharkDir, int sum, List<Fish> fishes) {
        maxSum = Math.max(maxSum, sum);

        int[][] copyMap = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        List<Fish> copyFishes = new ArrayList<>();
        for (Fish f : fishes) {
            copyFishes.add(new Fish(f.num, f.dir, f.y, f.x, f.isAlive));
        }

        moveFishes(copyMap, copyFishes);

        for (int i = 1; i <= 3; i++) {
            int ny = sharkY + dy[sharkDir] * i;
            int nx = sharkX + dx[sharkDir] * i;

            if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) break;

            if (copyMap[ny][nx] > 0) {
                int fishNum = copyMap[ny][nx];
                int nextDir = copyFishes.get(fishNum - 1 ).dir;

                copyMap[sharkY][sharkX] = 0;
                copyMap[ny][nx] = -1;
                copyFishes.get(fishNum - 1).isAlive = false;

                dfs(copyMap, ny, nx, nextDir, sum + fishNum, copyFishes);

                copyFishes.get(fishNum - 1).isAlive = true;
                copyMap[ny][nx] = fishNum;
                copyMap[sharkY][sharkX] = -1;
            }
        }
    }

    public static void moveFishes (int[][] map, List<Fish> fishes) {
        for (Fish fish : fishes) {
            if (!fish.isAlive) continue;

            for (int i = 0; i < 8; i++) {
                int nextDir = (fish.dir + i) % 8;
                int ny = fish.y + dy[nextDir];
                int nx = fish.x + dx[nextDir];

                if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4) continue;
                if (map[ny][nx] == -1) continue;

                fish.dir = nextDir;

                if (map[ny][nx] == 0) {
                    map[fish.y][fish.x] = 0;
                    fish.y = ny;
                    fish.x = nx;
                    map[ny][nx] = fish.num;
                } else {
                    int tempNum = map[ny][nx];
                    Fish tempFish = fishes.get(tempNum - 1);

                    tempFish.y = fish.y;
                    tempFish.x = fish.x;
                    map[fish.y][fish.x] = tempNum;

                    fish.y = ny;
                    fish.x = nx;
                    map[ny][nx] = fish.num;
                }
                break;
            }
        }
    }
}
