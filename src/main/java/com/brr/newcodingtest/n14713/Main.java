package com.brr.newcodingtest.n14713;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Queue<String>> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Queue<String> queue = new LinkedList<>();
            String s = br.readLine();
            String[] sList = s.split(" ");
            for (int j = 0; j < sList.length; j++) {
                queue.offer(sList[j]);
            }
            list.add(queue);
        }

        String target = br.readLine();
        String[] targetList = target.split(" ");

        for (int i = 0; i < targetList.length; i++) {
            String s = targetList[i];
            boolean matched = false;

            for (int j = 0; j < list.size(); j++) {
                Queue<String> tempQueue = list.get(j);
                if (!tempQueue.isEmpty() && tempQueue.peek().equals(s)) {
                    matched = true;
                    tempQueue.poll();
                    break;
                }
            }

            if (!matched) {
                System.out.println("Impossible");
                return;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
