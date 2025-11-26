package com.brr.newcodingtest.n2613;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, groupCount, memberCount;
    static long binaryStart, binaryEnd;
    static int[] arr, groupMemberList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        groupMemberList = new int[M];
        st = new StringTokenizer(br.readLine());
        binaryStart = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            binaryStart = Math.min(binaryStart, arr[i]);
            binaryEnd += arr[i];
        }

        long answer = binarySearch();
        sb.append(answer).append("\n");
        for (int i = 0; i < groupMemberList.length; i++) {
            sb.append(groupMemberList[i]).append(" ");
        }

        System.out.println(sb);
    }

    static long binarySearch() {
        long left = binaryStart;
        long right = binaryEnd;
        long mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (memberCheck(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean memberCheck(long mid) {
        groupCount = 1;
        memberCount = 0;
        int memberSum = 0;
        int[] memberCountList = new int[M];
        for (int i = 0; i < N; i++) {
            if (groupCount > M || arr[i] > mid) {
                return false;
            }
            if (memberSum + arr[i] > mid || N - i <= M - groupCount) {
                memberCountList[groupCount - 1] = memberCount;
                groupCount++;
                memberCount = 1;
                memberSum = arr[i];
            } else {
                memberCount++;
                memberSum += arr[i];
            }
        }

        if (groupCount > M) {
            return false;
        }

        memberCountList[groupCount - 1] = memberCount;

        for (int i = 0; i < M; i++) {
            groupMemberList[i] = memberCountList[i];
        }

        return true;
    }
}
