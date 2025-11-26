package com.brr.newcodingtest.n1920;

import java.io.*;
import java.util.*;

public class Main2 {
    static int[] arr, targetArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        targetArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targetArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            if (binarySearch(targetArr[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    static boolean binarySearch(int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] < target) left = mid + 1;
            else if (arr[mid] > target) right = mid - 1;
            else return true;
        }

        return false;
    }
}
