package com.algorithm;

import java.io.*;
import java.util.Stack;

public class Cal {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] str = in.readLine().toCharArray();
		Stack<Character> exp = new Stack<Character>();
		Stack<Integer> num = new Stack<Integer>();
		boolean flag = true;
		for (int i = 0; i < str.length; i++) {
			if (!exp.isEmpty()) {
				if (str[i] == '(' || str[i] == '[') {
					exp.push(str[i]);
				}
				if (str[i] == ')') {
					char temp = exp.pop();
					if (temp != '(') {
						flag = false;
						break;
					}
				}
				if (str[i] == ']') {
					char temp = exp.pop();
					if (temp != '[') {
						flag = false;
						break;
					}
				}
			} else {
				if (str[i] == ')' || str[i] == ']') {
					flag = false;
					break;
				} else
					exp.push(str[i]);
			}
		}
		if (!flag || !exp.isEmpty()) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(' || str[i] == '[') {
				exp.push(str[i]);
			}
			if (str[i] == ')') {
				char temp = exp.pop();
				if (temp == '0') {
					int n = num.pop();
					while (exp.pop() == '0') {
						n += num.pop();
					}
					num.push(n * 2);
					exp.push('0');
				} else if (temp == '(') {
					exp.push('0');
					num.push(2);
				}
			}
			if (str[i] == ']') {
				char temp = exp.pop();
				if (temp == '0') {
					int n = num.pop();
					while (exp.pop() == '0') {
						n += num.pop();
					}
					num.push(n * 3);
					exp.push('0');
				} else if (temp == '[') {
					exp.push('0');
					num.push(3);
				}
			}
		}
		int sum = 0;
		while (!num.isEmpty()) 
			sum += num.pop();
		System.out.println(sum);

	}
}
