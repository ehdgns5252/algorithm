package com.algostudy;

import java.io.*;
import java.util.Stack;

public class Zero {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> num = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0) 
				num.pop();
			else
				num.push(n);
		}
		int result = 0;
		while (!num.isEmpty())
			result += num.pop();
		System.out.println(result);
	}
}
