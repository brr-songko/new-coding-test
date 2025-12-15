package com.brr.newcodingtest.n1931;

import java.io.*;
import java.util.*;

class Node {
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node[] list = new Node[N];
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list[i] = new Node(s, e);
        }

        Arrays.sort(list, (a, b) -> {
            if (a.end == b.end) return Integer.compare(a.start, b.start);
            return Integer.compare(a.end, b.end);
        });

        int e = list[0].end;
        int index = 1;
        answer += 1;

        while (index < N) {
            int ns = list[index].start;

            if (ns < e) {
                index++;
            } else {
                e = list[index].end;
                answer++;
                index++;
            }
        }

        System.out.println(answer);
    }
}