package com.brr.newcodingtest.test6;

import java.io.*;
import java.util.*;

public class Main {

    static int[] cash = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int target = 1000 - n;

        for (int i = 0; i < cash.length; i++) {
            if (target >= cash[i]) {
                int cnt = target / cash[i];
                answer += cnt;
                target -= cnt * cash[i];
            }
        }

        System.out.println(answer);
    }
}

/*
620
500 1개
120
100 1개
20

 */

/*
잔돈 500엔, 100엔, 50엔, 5엔, 1엔
거스름돈 개수가 가장 적게 잔돈
1000엔 지폐를 냈을 때
잔돈에 포함된 잔돈 갯수

380
4

1
15
 */

