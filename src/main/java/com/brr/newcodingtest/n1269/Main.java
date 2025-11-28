package com.brr.newcodingtest.n1269;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> A = new HashMap<>();
        Map<Integer, Integer> B = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A.put(Integer.parseInt(st.nextToken()), 0);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B.put(Integer.parseInt(st.nextToken()), 0);
        }

        List<Integer> AKeySet = new ArrayList<>(A.keySet());
        List<Integer> BKeySet = new ArrayList<>(B.keySet());

        for (int now : AKeySet) {
            if (B.containsKey(now)) {
                B.remove(now);
            }
        }

        for (int now : BKeySet) {
            if (A.containsKey(now)) {
                A.remove(now);
            }
        }

        System.out.println(A.size() + B.size());
    }
}
