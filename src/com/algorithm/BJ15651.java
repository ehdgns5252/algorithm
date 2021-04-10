package com.algorithm;

import java.util.Scanner;

public class BJ15651 {
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
		int[] num;
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
		for (int i = 0; i < N.length; i++) {
			num[n] = N[i];
			per(n + 1, num);
		}
	}
}
