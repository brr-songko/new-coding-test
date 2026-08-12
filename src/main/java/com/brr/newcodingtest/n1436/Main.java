package com.brr.newcodingtest.n1436;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int num = 0;
        while (list.size() < 10001) {
            if (String.valueOf(num).contains("666")) {
                list.add(num);
            }

            num++;
        }

        System.out.println(list.get(N - 1));
    }
}

/*
2
1666
 */