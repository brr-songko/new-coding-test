package com.brr.newcodingtest.n24369;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a2 = Long.parseLong(st.nextToken());
        long a1 = Long.parseLong(st.nextToken());
        long a0 = Long.parseLong(st.nextToken());
        long c = Long.parseLong(br.readLine());
        long n0 = Long.parseLong(br.readLine());

        // f(n) = (a2 - c)n^2 + a1n + a0 >= 0 을 만족해야 함
        long b2 = a2 - c;
        long b1 = a1;
        long b0 = a0;

        // 1. 최고차항 계수가 음수면 언젠가 무조건 음수로 발산함
        if (b2 < 0) {
            System.out.println(0);
            return;
        }

        // 2. 최고차항 계수가 0인 경우 (일차함수)
        if (b2 == 0) {
            // 기울기가 음수면 언젠가 음수가 됨.
            // 따라서 기울기가 0 이상이고 시작점 n0에서 0 이상이어야 함.
            if (b1 >= 0 && (b1 * n0 + b0 >= 0)) System.out.println(1);
            else System.out.println(0);
            return;
        }

        // 3. 최고차항 계수가 양수인 경우 (이차함수, 아래로 볼록)
        long fn0 = b2 * n0 * n0 + b1 * n0 + b0; // 시작점 f(n0)
        long D = b1 * b1 - 4 * b2 * b0;         // 판별식

        // [핵심 논리]
        // 일단 시작점(fn0)은 무조건 0 이상이어야 함.
        // 그 상태에서 아래 두 조건 중 하나만 만족하면 됨:
        // (1) 축이 n0보다 왼쪽이라서 n0 이후로는 계속 올라가기만 하거나 (-b1 <= 2 * b2 * n0)
        // (2) 축이 오른쪽에 있어도 그래프가 아예 붕 떠 있어서 바닥조차 0 이상이거나 (D <= 0)
        if (fn0 >= 0 && (-b1 <= 2 * b2 * n0 || D <= 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
