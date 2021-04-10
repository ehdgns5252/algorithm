package com.algorithm;

import java.util.Scanner;

public class BJ15650 {
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
		int[] num;
		boolean[] istrue;
		com(0, new int[M], 0);
	}
	
	static void com(int n, int[] num, int start) {
		if (n == M) {
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println("");
			return;
		}
		for (int i = start; i < N.length; i++) {
			num[n] = N[i];
			com(n + 1, num, i + 1);
		}
	}
}

