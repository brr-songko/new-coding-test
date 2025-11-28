package com.brr.newcodingtest.n7785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String work = st.nextToken();
            if (work.equals("enter")) {
                map.put(name, 0);
            } else {
                map.remove(name);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(Collections.reverseOrder());

        for (String s : keySet) {
            System.out.println(s);
        }
    }
}
