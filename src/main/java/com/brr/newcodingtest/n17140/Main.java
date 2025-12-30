package com.brr.newcodingtest.n17140;

import java.io.*;
import java.util.*;

class Node {
    int num;
    int count;

    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

public class Main {
    static int[][] arr = new int[101][101];
    static int r, c, k, rowLength, colLength, count, answer;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        rowLength = 3;
        colLength = 3;
        answer = -1;

        while (count <= 100) {
            if (arr[r][c] == k) {
                answer = count;
                break;
            }

            if (rowLength >= colLength) {
                R();
            } else {
                C();
            }

            count++;
        }

        System.out.println(answer);
    }

    public static void R() {
        int[][] copy_arr = new int[101][101];
        int col = 0;

        for (int i = 1; i <= rowLength; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= colLength; j++) {
                if (arr[i][j] == 0) continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }

            List<Node> list = new ArrayList<>();
            for (Integer key : map.keySet()) {
                list.add(new Node(key, map.get(key)));
            }

            col = Math.max(col, list.size() * 2);
            list.sort((o1, o2) -> {
                if (o1.count == o2.count) return o1.num - o2.num;
                return o1.count - o2.count;
            });

            for (int k = 0; k < list.size(); k++) {
                Node node = list.get(k);
                copy_arr[i][2 * k + 1] = node.num;
                copy_arr[i][2 * k + 2] = node.count;
            }

        }
        colLength = col;
        arr = copy_arr;
    }

    public static void C() {
        int[][] copy_arr = new int[101][101];
        int row = 0;

        for (int i = 1; i <= colLength; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= rowLength; j++) {
                if (arr[j][i] == 0) continue;
                map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
            }

            List<Node> list = new ArrayList<>();
            for (Integer key : map.keySet()) {
                list.add(new Node(key, map.get(key)));
            }

            row = Math.max(row, list.size() * 2);
            list.sort((o1, o2) -> {
                if (o1.count == o2.count) return o1.num - o2.num;
                return o1.count - o2.count;
            });

            for (int k = 0; k < list.size(); k++) {
                Node node = list.get(k);
                copy_arr[2 * k + 1][i] = node.num;
                copy_arr[2 * k + 2][i] = node.count;
            }
        }

        rowLength = row;
        arr = copy_arr;
    }
}
