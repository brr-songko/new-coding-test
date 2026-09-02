package com.brr.newcodingtest.n17140;

import java.io.*;
import java.util.*;

class Number2 {
    int num;
    int cnt;

    public Number2(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main2 {

    static int[][] arr = new int[100][100];
    static int r, c, k;
    static int rowLength, colLength;
    static int time;

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

        int answer = -1;
        while (time <= 100) {
            if (arr[r][c] == k) {
                answer = time;
                break;
            }

            if (rowLength >= colLength) {
                R();
            } else {
                C();
            }

            time++;
        }

        System.out.println(answer);
    }

    public static void R() {
        int[][] copyArr = new int[100][100];
        int maxLength = 0;
        for (int i = 0; i < rowLength; i++) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < colLength; j++) {
                int num = arr[i][j];
                if (num == 0) continue;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Number2> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new Number2(key, map.get(key)));
            }

            maxLength = Math.max(maxLength, list.size() * 2);
            Collections.sort(list, (o1, o2) -> {
                if (o1.cnt == o2.cnt) return o1.num - o2.num;
                return o1.cnt - o2.cnt;
            });

            for (int j = 0; j < list.size(); j++) {
                Number2 number = list.get(j);
                copyArr[i][2 * j] = number.num;
                copyArr[i][2 * j + 1] = number.cnt;
            }

        }

        colLength = maxLength;
        arr = copyArr;
    }

    public static void C() {
        int[][] copyArr = new int[100][100];
        int row = 0;

        for (int i = 0; i < colLength; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < rowLength; j++) {
                if (arr[j][i] == 0) continue;
                map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
            }

            List<Number2> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new Number2(key, map.get(key)));
            }

            row = Math.max(row, list.size() * 2);
            Collections.sort(list, (a, b) -> {
                if (a.cnt == b.cnt) return a.num - b.num;
                return a.cnt - b.cnt;
            });

            for (int j = 0; j < list.size(); j++) {
                Number2 number = list.get(j);
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
