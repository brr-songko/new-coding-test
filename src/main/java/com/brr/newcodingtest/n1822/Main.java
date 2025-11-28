package com.brr.newcodingtest.n1822;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            map.put(now, now);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (map.containsKey(now)) {
                map.remove(now);
            }
//            for (int key : map.keySet()) {
//                map.
//                if (key == now) {
//                    map.remove(key);
//                }
//            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        if (map.size() == 0) {
            sb.append(0);
        } else {
            sb.append(map.size()).append("\n");
            for (int key : keySet) {
                sb.append(key).append(" ");
            }
        }

        System.out.println(sb);
    }
}
