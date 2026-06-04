package com.brr.newcodingtest.test1;

import java.io.*;
import java.util.*;

class Node {
    int y;
    int x;

    public Node (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main3 {

    static int[][] map;
    static ArrayList<Node> isVirus = new ArrayList<>();
    static ArrayList<Node> isEmpty = new ArrayList<>();
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) isVirus.add(new Node(i, j));
                else if (map[i][j] == 0) isEmpty.add(new Node(i, j));
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int start) {
        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = start; i < isEmpty.size(); i++) {
            Node node = isEmpty.get(i);
            map[node.y][node.x] = 1;
            dfs(depth + 1, i + 1);
            map[node.y][node.x] = 0;
        }
    }

    static void spreadVirus() {
        int[][] tempMap = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            tempMap[i] = map[i].clone();
        }

        Queue<Node> q = new LinkedList<>();

        for (Node node : isVirus) {
            q.offer(node);
        }

        while(!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (tempMap[ny][nx] == 1) continue;
                if (visited[ny][nx]) continue;

                tempMap[ny][nx] = 2;
                visited[ny][nx] = true;
                q.offer(new Node(ny, nx));
            }
        }

        int count = countEmpty(tempMap);

        answer = Math.max(answer, count);
    }

    static int countEmpty(int[][] tempMap) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) count++;
            }
        }

        return count;
    }
}

/***
 * 1. 빈 칸 중에 3개를 백 트래킹으로 고른다.
 * 2. 그 상태로 바이러스 퍼뜨린다 BFS
 * 3. 남은 0의 갯수를 센 뒤 최댓값을 찾는다.
 *
 * 7 7
 * 2 0 0 0 1 1 0
 * 0 0 1 0 1 2 0
 * 0 1 1 0 1 0 0
 * 0 1 0 0 0 0 0
 * 0 0 0 0 0 1 1
 * 0 1 0 0 0 0 0
 * 0 1 0 0 0 0 0
 */

