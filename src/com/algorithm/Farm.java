package com.algorithm;

import java.util.Scanner;

public class Farm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int total = 0;
			int N = sc.nextInt();
			char[][] farm = new char[N][N];
			for (int i = 0; i < N; i++) {
				farm[i] = sc.next().toCharArray();
			}
			int center = N / 2;
			for (int i = 0; i < N; i++) {
				if (i <= center) {
					for (int j = 0; j <= i; j++) {
						total += farm[i][center + j] - '0';
						total += farm[i][center - j] - '0';
					}
					total -= farm[i][center] - '0';
				}
				else {
					for (int j = 0; j < N - i; j++) {
						total += farm[i][center + j] - '0';
						total += farm[i][center - j] - '0';
					}
					total -= farm[i][center] - '0';
				}
			}
			System.out.println("#" + test + " " + total);
		}
	}
}
