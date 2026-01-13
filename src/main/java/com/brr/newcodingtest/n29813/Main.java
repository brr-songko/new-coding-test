package com.brr.newcodingtest.n29813;

import java.io.*;
import java.util.*;

class Student {
    String name;
    int num;

    public Student(String name, int num) {
        this.name = name;
        this.num = num;
    }
}

public class Main {
    static StringTokenizer st;
    static int N;
    static Queue<Student> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            queue.offer(new Student(name, num));
        }

        while (queue.size() > 1) {
            Student student = queue.poll();

            for (int i = 0; i < student.num - 1; i++) {
                queue.offer(queue.poll());
            }

            queue.poll();
        }

        System.out.println(queue.peek().name);
    }
}
