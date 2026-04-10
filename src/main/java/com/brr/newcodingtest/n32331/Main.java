package com.brr.newcodingtest.n32331;

import java.io.*;
import java.util.*;

class Student {
    String num;
    int mScore;

    public Student(String num, int mScore) {
        this.num = num;
        this.mScore = mScore;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        List<Student> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        String target = st.nextToken();
        int targetScore = Integer.parseInt(st.nextToken());

        List<Integer> o2024totals = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            if (num.startsWith("2024")) {
                int finalScore = Y - (X - score);
                if (finalScore < 0) finalScore = 0;

                int total = score + finalScore;
                o2024totals.add(total);
            }
        }

        if (o2024totals.size() < M) {
            System.out.println("YES");
            System.out.println(0);
            return;
        }

        o2024totals.sort(Collections.reverseOrder());

        int cut = o2024totals.get(M - 1);
        int need = cut - targetScore;
        if (need < 0) need = 0;

        if (need <= Y) {
            System.out.println("YES");
            System.out.println(need);
        } else {
            System.out.println("NO");
        }
    }
}
