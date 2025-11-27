package com.brr.newcodingtest.n6209;

import java.io.*;
import java.util.*;

public class Main {
    static int d, n, m;
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    static int[] islands;
    static ArrayList<Integer> removedIslands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        islands = new int[n + 2];
        removedIslands = new ArrayList<>();
        islands[0] = 0;
        islands[islands.length - 1] = d;
        for (int i = 1; i <= n; i++) {
            islands[i] = Integer.parseInt(br.readLine());
            min = Math.min(islands[i], min);
            max = Math.max(islands[i], max);
        }
        Arrays.sort(islands);

        long answer = binarySearch();

        System.out.println(answer);
    }

    static long binarySearch() {
        long left = 1;
        long right = d;
        long mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (removeIslands(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    static boolean removeIslands(long mid) {
        int removeCount = 0;
        int lastIndex = 0;

        for (int i = 1; i < islands.length; i++) {
            if (islands[i] - islands[lastIndex] < mid) {
                removeCount++;
            } else {
                lastIndex = i;
            }
        }

        if (removeCount > m) {
            return false;
        }
        return true;
    }
}
