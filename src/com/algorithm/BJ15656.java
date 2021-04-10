package com.algorithm;

import java.util.*;

public class BJ15656 {

	static List<Integer> N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		N = new ArrayList<Integer>();
		M = sc.nextInt();
		for (int i = 0; i < n; i++) {
			N.add(sc.nextInt());
		}
		N.sort(null);
		per(0, new int[M]);
		System.out.println(sb.toString());
	}

	static void per(int n, int[] num) {
		if (n == M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N.size(); i++) {
			num[n] = N.get(i);
			per(n + 1, num);
		}
	}
}