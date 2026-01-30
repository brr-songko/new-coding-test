package com.brr.newcodingtest.n27964;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String S = br.readLine();
        String[] sList = S.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < sList.length; i++) {
            String s = sList[i];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }


        int count = 0;
        for (String s : map.keySet()) {
            if (map.get(s) >= 1 && s.endsWith("Cheese")) {
                count++;
            }
        }


        if (count >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}
