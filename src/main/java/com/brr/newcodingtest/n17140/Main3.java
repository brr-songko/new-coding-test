package com.brr.newcodingtest.n17140;

import java.io.*;
import java.util.*;

class Number3 {
    int num;
    int cnt;

    public Number3(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main3 {

    static int r, c, k;
    static int[][] arr = new int[100][100];
    static int answer, cnt, rowLength, colLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rowLength = 3;
        colLength = 3;
        answer = -1;

        while (cnt <= 100) {
            if (arr[r][c] == k) {
                answer = cnt;
                break;
            }

            if (rowLength >= colLength) R();
            else C();

            cnt++;
        }

        System.out.println(answer);
    }

    public static void R() {
        int[][] copyArr = new int[100][100];
        int col = 0;

        for (int i = 0; i < rowLength; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < colLength; j++) {
                int n = arr[i][j];
                if (n == 0) continue;
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            col = Math.max(col, map.size() * 2);
            List<Number3> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new Number3(key, map.get(key)));
            }
            Collections.sort(list, (a, b) -> {
                if (a.cnt != b.cnt) return a.cnt - b.cnt;
                return a.num - b.num;
            });

            for (int j = 0; j < list.size(); j++) {
                Number3 number = list.get(j);
                copyArr[i][2 * j] = number.num;
                copyArr[i][2 * j + 1] = number.cnt;
            }
        }

        colLength = col;
        arr = copyArr;
    }

    public static void C() {
        int[][] copyArr = new int[100][100];
        int row = 0;

        for (int i = 0; i < colLength; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < rowLength; j++) {
                int n = arr[j][i];
                if (n == 0) continue;
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            row = Math.max(row, map.size() * 2);
            List<Number3> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new Number3(key, map.get(key)));
            }
            Collections.sort(list, (a, b) -> {
                if (a.cnt != b.cnt) return a.cnt - b.cnt;
                return a.num - b.num;
            });

            for (int j = 0; j < list.size(); j++) {
                Number3 number = list.get(j);
                copyArr[2 * j][i] = number.num;
                copyArr[2 * j + 1][i] = number.cnt;
            }
        }

        rowLength = row;
        arr = copyArr;
    }
}

/*
1 2 2
1 2 1
2 1 3
3 3 3

0

1 2 1
1 2 1
2 1 3
3 3 3

1
 */