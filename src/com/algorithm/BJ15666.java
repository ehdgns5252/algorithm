package com.algorithm;

import java.util.*;

public class BJ15666 {

	static List<Integer> N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder temp = new StringBuilder();
	static List<String> str = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		N = new ArrayList<Integer>();
		M = sc.nextInt();
		for (int i = 0; i < n; i++) {
			N.add(sc.nextInt());
		}
		N.sort(null);
		com(0, new int[M], 0);
		LinkedHashSet<String> str2 = new LinkedHashSet<String>(str);
		List<String> str3 = new ArrayList<String>(str2);
		for (int i = 0; i < str3.size(); i++)
			sb.append(str3.get(i));
		System.out.println(sb.toString());
	}

	static void com(int n, int[] num, int start) {
		if (n == M) {
			temp.setLength(0);
			for (int i = 0; i < num.length; i++) {
				temp.append(num[i] + " ");
			}
			temp.append("\n");
			str.add(temp.toString());
			return;
		}
		for (int i = start; i < N.size(); i++) {
			num[n] = N.get(i);
			com(n + 1, num, i);
		}
	}
}
