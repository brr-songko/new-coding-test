package com.brr.newcodingtest.n3078;

import java.io.*;
import java.util.*;

class Student {
    int index;
    int nameLength;

    public Student(int index, int nameLength) {
        this.index = index;
        this.nameLength = nameLength;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] count = new int[21];
        Long answer = 0L;
        String[] arr = new String[N + 1];
        Queue<Student> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 1; i <= N; i++) {
            String name = arr[i];
            Student student = new Student(i, name.length());

            while (!q.isEmpty() && i - q.peek().index > K) {
                Student student1 = q.poll();
                count[student1.nameLength]--;
            }

            q.offer(student);
            answer += count[student.nameLength];
            count[student.nameLength]++;
        }

        System.out.println(answer);
    }
}
