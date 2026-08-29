package com.brr.newcodingtest.n2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList<Integer>[] list = new ArrayList[1000053];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
//            System.out.println("----------");
            int temp = i;
            int sum = temp;
//            System.out.println("i = " + i);
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
//                System.out.println("check");
//                System.out.println(temp);
            }
//            System.out.println("sum = " + sum);
            list[sum].add(i);
        }

//        System.out.println("list[N] 값 ");
//        for (int i = 0; i < list[N].size(); i++) {
//            System.out.println(list[N]);
//        }

        Collections.sort(list[N]);

        if (list[N].size() == 0) System.out.println(0);
        else System.out.println(list[N].get(0));
    }
}

/*
216

198
 */

/*
245 245 + 2 + 4 + 5 = 256
245는 256의 생성자
N의 가장 작은 생성자
1은 1 + 1 2의 생성자
2는 2 + 2 4의 생성자
3은 3 + 3 6의 생성자
4는 4 + 4 8의 생성자
5는 5 + 5 10의 생성자
6은 6 + 6 12의 생성자
7은 7 + 7 14의 생성자
8은 8 + 8 16의 생성자
9는 9 + 9 18의 생성자
10은 10 + 1 + 0 11의 생성자
11은 11 + 1 + 1 14의 생성자
12는 12 + 1 + 2 15의 생성자

1000002
1,000,000
999,999
9 * 6 = 54
 */
