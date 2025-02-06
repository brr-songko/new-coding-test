package com.brr.newcodingtest.n1427;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] A = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for (int i = 0; i < str.length(); i++) {
            int max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (A[j] > A[max]) {
                    max = j;
                }
            }

            if (max != i) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(A[i]);
        }

        System.out.println(sb);
    }
}

/*
1. 시간복잡도
- O(N2) = 10*10 = 100
- 가능

2. 슈도코드
String str =
String[] A = substring(i, i+1)
for i 0 ~ str.length {
    int max = i
    for j i+1 ~ str.length {
        if(A[j] > A[max]
        max = j
    }
    if max != i {
        swap
    }
}

StringBuilder
append

sout
 */
