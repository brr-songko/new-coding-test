package com.brr.newcodingtest.n7785;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String check = st.nextToken();
            if (check.equals("enter")) {
                map.put(name, "enter");
            } else {
                map.put(name, "leave");
            }
        }

        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).equals("enter")) {
                list.add(key);
            }
        }

        list.sort((a, b) -> b.compareTo(a));
        StringBuilder sb = new StringBuilder();
        for (String key : list) {
            sb.append(key).append("\n");
        }

        System.out.println(sb);
    }
}

/*
4
Baha enter
Askar enter
Baha leave
Artem enter
 */