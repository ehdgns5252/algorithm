package com.algorithm;

import java.util.*;

public class BJ15655 {

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
		com(0, new int[M], 0);
		System.out.println(sb.toString());
	}

	static void com(int n, int[] num, int start) {
		if (n == M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N.size(); i++) {
			num[n] = N.get(i);
			com(n + 1, num, i + 1);
		}
	}
}
