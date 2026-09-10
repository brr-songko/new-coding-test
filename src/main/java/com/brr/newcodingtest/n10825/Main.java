package com.brr.newcodingtest.n10825;

import java.io.*;
import java.util.*;

class Student {
    String name;
    int kScore;
    int eScore;
    int mScore;

    public Student(String name, int kScore, int eScore, int mScore) {
        this.name = name;
        this.kScore = kScore;
        this.eScore = eScore;
        this.mScore = mScore;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list.add(new Student(name, k, e, m));
        }

        Collections.sort(list, (a, b) -> {
            if (a.kScore == b.kScore && a.eScore == b.eScore && a.mScore == b.mScore) return a.name.compareTo(b.name);
            if (a.kScore == b.kScore && a.eScore == b.eScore) return b.mScore - a.mScore;
            if (a.kScore == b.kScore) return a.eScore - b.eScore;
            return b.kScore - a.kScore;

        });

        StringBuilder sb = new StringBuilder();
        for (Student student : list) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }
}
