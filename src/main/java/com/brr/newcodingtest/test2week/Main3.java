package com.brr.newcodingtest.test2week;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();

        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int total = 0;
        for (int n : map.values()) {
            total += n;
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String key : list) {
            double value = (double) map.get(key) / total * 100;

            sb.append(key).append(" ").append(String.format("%.4f", value)).append("\n");
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