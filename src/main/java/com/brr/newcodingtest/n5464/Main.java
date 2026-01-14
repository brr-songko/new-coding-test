package com.brr.newcodingtest.n5464;

import java.io.*;
import java.util.*;

class Park {
    int parkNo;
    int cost;

    public Park(int parkNo, int cost) {
        this.parkNo = parkNo;
        this.cost = cost;
    }
}

class Car {
    int carNo;
    int weight;
    Park park;

    public Car(int carNo, int weight) {
        this.carNo = carNo;
        this.weight = weight;
    }
}

public class Main {
    static int N, M, answer;
    static PriorityQueue<Park> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.parkNo));
    static Queue<Integer> q = new LinkedList<>();
    static Car[] cars;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        cars = new Car[M + 1];
        for (int i = 1; i <= N; i++) {
            pq.offer(new Park(i, sc.nextInt()));
        }
        for (int i = 1; i <= M; i++) {
            cars[i] = new Car(i, sc.nextInt());
        }

        for (int i = 0; i < 2 * M; i++) {
            int n = sc.nextInt();
            if (n > 0) {
                if (!pq.isEmpty()) {
                    cars[n].park = pq.poll();
                } else {
                    q.offer(n);
                }
            } else {
                Park park = cars[-n].park;
                cars[-n].park = null;
                answer += cars[-n].weight * park.cost;
                pq.offer(park);

                if (!q.isEmpty()) {
                    int carNo = q.poll();
                    cars[carNo].park = pq.poll();
                }
            }
        }

        System.out.println(answer);
    }
}
