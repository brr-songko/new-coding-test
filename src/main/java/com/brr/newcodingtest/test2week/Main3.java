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
        StringBuilder sb = new StringBuilder();
        Map<String, Tree> map = new HashMap<>();
        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            if (!map.containsKey(s)) {
                map.put(s, new Tree(s, 0));
            }
            map.get(s).num += 1;
            System.out.println("sdf");
        }

        double sum = 0.0;
        for (Tree tree : map.values()) {
            sum += tree.num;
        }

        List<Tree> list = new ArrayList<>(map.values());
        Collections.sort(list, new Comparator<Tree>() {
            @Override
            public int compare(Tree t1, Tree t2) {
                return t1.name.compareTo(t2.name);
            }
        });

        for (Tree tree : list) {
            sb.append(tree.name).append(" ");
            double value = Math.round((tree.num / sum) * 10000) / 10000.0;
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }
}

/**
 * Red Alder
 * Ash
 * Aspen
 * Basswood
 * Ash
 * Beech
 * Yellow Birch
 * Ash
 * Cherry
 * Cottonwood
 * Ash
 * Cypress
 * Red Elm
 * Gum
 * Hackberry
 * White Oak
 * Hickory
 * Pecan
 * Hard Maple
 * White Oak
 * Soft Maple
 * Red Oak
 * Red Oak
 * White Oak
 * Poplan
 * Sassafras
 * Sycamore
 * Black Walnut
 * Willow
 */