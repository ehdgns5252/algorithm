package com.algorithm;

import java.io.*;
import java.util.*;

public class IsExpression {
	static int N;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {
			N = Integer.parseInt(in.readLine());
			List<String>[] exp = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++)
				exp[i] = new ArrayList<String>();
			flag = true;
			for (int i = 1; i <= N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				while (st.hasMoreTokens()) {
					exp[i].add(st.nextToken());
				}
			}
			isExp(1, exp);
			if (flag)
				System.out.println("#" + test + " 1");
			else
				System.out.println("#" + test + " 0");
		}
	}

	static void isExp(int index, List<String>[] exp) {
		if (exp[index].size() == 4) {
			if (exp[index].get(1).charAt(0) - '0' >= 0 && exp[index].get(1).charAt(0) - '0' <= 9) {
				flag = false;
				return;
			}
			isExp(Integer.parseInt(exp[index].get(2)), exp);
			isExp(Integer.parseInt(exp[index].get(3)), exp);
		} else {
			if (exp[index].get(1).charAt(0) - '0' < 0 || exp[index].get(1).charAt(0) - '0' > 9) {
				flag = false;
				return;
			}
		}
	}
}
