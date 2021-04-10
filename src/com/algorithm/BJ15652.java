package com.algorithm;

import java.util.Scanner;

public class BJ15652 {
	static int[] N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		N = new int[n];
		for (int i = 0; i < n; i++) {
			N[i] = i + 1;
		}
		M = sc.nextInt();
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
		for (int i = start; i < N.length; i++) {
			num[n] = N[i];
			com(n + 1, num, i);
		}
	}
}
