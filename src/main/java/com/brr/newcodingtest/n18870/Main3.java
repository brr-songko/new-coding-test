package com.brr.newcodingtest.n18870;

import java.io.*;
import java.util.*;

public class Main3 {

    static int N;
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        list = new ArrayList<>(set);

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int n = arr[i];

            int answer = lowerBound(n);

            sb.append(answer).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int target) {
        int left = 0;
        int right = list.size();
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}


/*
Map 방식
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sortedArr = arr.clone();

        Arrays.sort(sortedArr);

        int r = 0;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sortedArr[i])) map.put(sortedArr[i], r++);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
 */
/*
5
2 4 -10 4 -9
 */
