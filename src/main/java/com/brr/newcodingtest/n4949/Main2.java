package com.brr.newcodingtest.n4949;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else stack.push(c);
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else stack.push(c);
                }
            }

            if (stack.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.println(sb);
    }
}

/*
So when I die (the [first] I will see in (heaven) is a score list).
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
.

yes
yes
no
no
no
yes
 */
