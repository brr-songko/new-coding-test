package com.brr.newcodingtest.n31001;

import java.io.*;
import java.util.*;

class Company {
    String name;
    long price;
    int stock;
    int groupNum;

    public Company(String name, long price, int stock, int groupNum) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.groupNum = groupNum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        Map<String, Company> nameMap = new HashMap<>();
        Map<Integer, List<Company>> groupMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken());
            String H = st.nextToken();
            int P = Integer.parseInt(st.nextToken());
            Company c = new Company(H, P, 0, G);
            nameMap.put(H, c);
            if (!groupMap.containsKey(G)) {
                groupMap.put(G, new ArrayList<>());
            }
            groupMap.get(G).add(c);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String a = "";
            int b = 0;
            int c = 0;
            int d = 0;
            double e = 0;

            if (n == 1 || n == 2) {
                a = st.nextToken();
                b = Integer.parseInt(st.nextToken());
            }
            if (n == 3) {
                a = st.nextToken();
                c = Integer.parseInt(st.nextToken());
            }
            if (n == 4) {
                d = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
            }
            if (n == 5) {
                d = Integer.parseInt(st.nextToken());
                e = Double.parseDouble(st.nextToken());
            }

            if (n == 1) {
                Company company = nameMap.get(a);
                long buyCount = company.price == 0 ? b : Math.min(b, M / company.price);
                company.stock += (int)buyCount;
                M -= buyCount * company.price;

            } else if (n == 2) {
                Company company = nameMap.get(a);
                if (company.stock < b) {
                    M += company.price * (long) company.stock;
                    company.stock = 0;
                } else {
                    M += company.price * (long) b;
                    company.stock -= b;
                }


            } else if (n == 3) {
                Company company = nameMap.get(a);
                company.price += c;
            } else if (n == 4) {
                List<Company> list = groupMap.get(d);
                if (list != null) {
                    for (Company company : list) {
                        company.price += c;
                    }
                }
            } else if (n == 5) {
                List<Company> list = groupMap.get(d);
                if (list != null) {
                    for (Company company : list) {
                        if (company.groupNum == d) {
                            long newPrice = (long)((company.price * (100.0 + e)) / 100.0);
                            newPrice = (newPrice / 10) * 10;
                            company.price = newPrice;
                        }
                    }
                }
            } else if (n == 6) {
                System.out.println(M);
            } else if (n == 7) {
                long total = M;
                for (Company company : nameMap.values()) {
                    total += (long) company.stock * company.price;
                }
                System.out.println(total);
            }
        }
    }
}