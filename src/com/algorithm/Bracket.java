package com.algorithm;

import java.io.*;
import java.util.Stack;

public class Bracket {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
			int N = Integer.parseInt(in.readLine());
			Stack<Character> stack = new Stack<>();
			char[] s = new char[N];
			s = in.readLine().toCharArray();
			int isTrue = 0;
			boolean err = false;

			for (int i = 0; i < N; i++) {
				if (s[i] == '(' || s[i] == '{' || s[i] == '<' || s[i] == '[')
					stack.push(s[i]);
				if (stack.isEmpty()) {
					isTrue = 0;
					err = true;
					break;
				}
				if (s[i] == ')') 
					if (stack.pop() != '(') 
						break;
				if (s[i] == '>') 
					if (stack.pop() != '<') 
						break;
				if (s[i] == '}') 
					if (stack.pop() != '{') 
						break;
				if (s[i] == ']') 
					if (stack.pop() != '[') 
						break;
			}
			if (stack.isEmpty() && !err)
				isTrue = 1;
			System.out.println("#" + test + " " + isTrue);
		}

	}
}
