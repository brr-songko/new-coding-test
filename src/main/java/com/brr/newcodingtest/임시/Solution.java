package com.brr.newcodingtest.임시;

import java.util.*;

public class Solution {
    HashSet<Integer> numberSet = new HashSet<>();

    public void recursive(String comb, String others) {
        if (!comb.equals("")) {
            numberSet.add(Integer.valueOf(comb));
        }

        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }

    public int solution(String numbers) {
        int count = 0;

        recursive("", numbers);

        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        int lim = (int) Math.sqrt(number);

        for (int i = 2; i < lim; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.print(sol.solution("17"));
    }
}
