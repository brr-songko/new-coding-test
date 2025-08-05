package com.brr.newcodingtest.n8979;

import java.io.*;
import java.util.*;

public class Main2 {
    static class Country implements Comparable<Country> {
        int id, gold, silver, bronze;

        Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo (Country o) {
            if (this.gold != o.gold) {
                return o.gold - this.gold;
            } else if (this.silver != o.silver) {
                return o.silver - this.silver;
            } else {
                return o.bronze - this.bronze;
            }
        }

        public boolean checkSameMedals(Country o) {
            return o.gold == this.gold &&
                    o.silver == this.silver &&
                    o.bronze == this.bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            list.add(new Country(id, gold, silver, bronze));
        }

        Collections.sort(list);

        int rank = 1;
        int[] ranks = new int[N + 1];
        ranks[list.get(0).id] = rank;

        for (int i = 1; i < N; i++) {
            Country prev = list.get(i - 1);
            Country curr = list.get(i);

            if (curr.checkSameMedals(prev)) {
                ranks[curr.id] = rank;
            } else {
                rank = i + 1;
                ranks[curr.id] = rank;
            }
        }

        System.out.println(ranks[K]);
    }
}
