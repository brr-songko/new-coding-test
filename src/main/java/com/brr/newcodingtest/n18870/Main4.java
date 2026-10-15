package com.brr.newcodingtest.n18870;

import java.io.*;
import java.util.*;

public class Main4 {

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

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
