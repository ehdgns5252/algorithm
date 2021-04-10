package com.algorithm;

import java.util.*;

public class BJ15663 {

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
		per(0, new int[M], new boolean[N.size()]);
		LinkedHashSet<String> str2 = new LinkedHashSet<String>(str);
		List<String> str3 = new ArrayList<String>(str2);
		for (int i = 0; i < str3.size(); i++)
			sb.append(str3.get(i));
		System.out.println(sb.toString());
	}

	static void per(int n, int[] num, boolean[] istrue) {
		if (n == M) {
			temp.setLength(0);
			for (int i = 0; i < num.length; i++) {
				temp.append(num[i] + " ");
			}
			temp.append("\n");
			str.add(temp.toString());
			return;
		}
		for (int i = 0; i < N.size(); i++) {
			if (!istrue[i]) {
				istrue[i] = true;
				num[n] = N.get(i);
				per(n + 1, num, istrue);
				istrue[i] = false;
			}
		}
	}
}
