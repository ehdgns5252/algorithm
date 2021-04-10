package com.algorithm;

import java.io.*;
import java.util.*;

public class Calculator2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {
			int N = Integer.parseInt(in.readLine());
			Stack<String> exp = new Stack<String>();
			char[] str = in.readLine().toCharArray();
			Queue<String> temp = new LinkedList<String>();
			for (int i = 0; i < N ; i++) {
				if (str[i] - '0' >= 0 && str[i] - '0' <= 9) 
					exp.push(Character.toString(str[i]));
				if (str[i] == '*') {
					StringBuilder sb = new StringBuilder();
					String s = exp.pop();
					
					sb.append(Character.toString(str[i + 1]));
					sb.append(s);
					sb.append(Character.toString(str[i]));
					exp.push(sb.toString());
					i++;
					continue;
				}
				if (str[i] == '+') {
					exp.push(Character.toString(str[i]));
				}
			}
			for (int i = 0; i < exp.size(); i++) {
				if (temp.isEmpty()) temp.offer(exp.get(0));
				if (exp.get(i).equals("+")) {
					temp.offer(exp.get(i + 1));
					temp.offer(exp.get(i));
				}
			}
			StringBuilder sb = new StringBuilder();
			while (!temp.isEmpty())
				sb.append(temp.poll());
			str = sb.toString().toCharArray();
			Stack<Integer> calcul = new Stack<Integer>();
			for (int i = 0; i < str.length; i++) {
				if (str[i] == '*') {
					int a = calcul.pop();
					int b = calcul.pop();
					int num = a * b;
					calcul.push(num);
				}
				else if (str[i] == '+') {
					int a = calcul.pop();
					int b = calcul.pop();
					int num = a + b;
					calcul.push(num);
					
				} else {
					calcul.push(str[i] - '0');
				}
			}
			System.out.println("#" + test + " " + calcul.pop());
		}
	}
}
