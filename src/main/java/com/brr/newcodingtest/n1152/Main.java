package com.brr.newcodingtest.n1152;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Map<String, Integer> map = new HashMap<>();
        String[] sList = s.split(" ");
        for (int i = 0; i < sList.length; i++) {
            String key = sList[i];
            if (key.equals("")) continue;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int answer = 0;

        for (int n : map.values()) {
            answer += n;
        }

        System.out.println(answer);
    }
}
