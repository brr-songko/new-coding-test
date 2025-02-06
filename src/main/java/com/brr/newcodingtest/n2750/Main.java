package com.brr.newcodingtest.n2750;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append("\n");
        }

        System.out.println(sb);
    }
}

/*
1. 시간복잡도
- O(N2) = 1,000,000
- 가능

2. 슈도코드
int N
int[] A
for(~){
A 데이터 입력
}

for i = 0 ~ N {
    for j = 0 ~ N - i{
        스왑
    }
}

 */