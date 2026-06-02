package com.brr.newcodingtest.test2week;

import java.io.*;
import java.util.*;

class Tree {
    String name;
    double num;

    public Tree (String name, double num) {
        this.name = name;
        this.num = num;
    }
}

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Tree> map = new HashMap<>();
        String s;
        while ((s = br.readLine()) != null) {
            map.put(s, map.getOrDefault(s, new Tree(s, 0.0)));
        }

        double sum = 0.0;
        for (double n : map.values()) {
            sum += n;
        }

        List<Tree> list = map.
    }
}
