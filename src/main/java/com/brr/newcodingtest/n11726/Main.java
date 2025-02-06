package com.brr.newcodingtest.n11726;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[1001];
        D[1] = 1;
        D[2] = 2;
        for (int i = 3; i <= n; i++) {
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }

        System.out.println(D[n]);
    }
}


/*
1. 아이디어
- DP 사용
- D(N) = D(N-1) + D(N-2)
- D(1) = 1, D(2) = 2

2. 시간복잡도
- O(N) = N
- 가능

3. 자료구조
- int n
- int[] D
 */