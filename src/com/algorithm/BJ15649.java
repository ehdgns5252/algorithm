package com.algorithm;

import java.util.Scanner;

public class BJ15649 {
	static int[] N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		N = new int[n];
		for (int i = 0; i < n; i++) {
			N[i] = i + 1;
		}
		M = sc.nextInt();
		per(0, new int[M], new boolean[N.length]);
	}
	
	static void per(int n, int[] num, boolean[] istrue) {
		if (n == M) {
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println("");
			return;
		}
		for (int i = 0; i < N.length; i++) {
			if (!istrue[i]) {
				istrue[i] = true;
				num[n] = N[i];
				per(n + 1, num, istrue);
				istrue[i] = false;
			}
		}
	}
	
}
