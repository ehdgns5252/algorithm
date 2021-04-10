package com.algorithm;

import java.util.Scanner;

public class Dart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int N = sc.nextInt();
			int point = 0;
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = x * x + y * y;
				for (int p = 1; p <= 10; p++) {
					int radian = 400 * (11 - p) * (11 - p);
					if (radian < dir) {
						point += p - 1;
						break;
					}
					if (radian == dir) {
						point += p;
						break;
					}
					if (dir < 400) {
						point += 10;
						break;
					}
				}
			}
			System.out.println("#" + test + " " + point);
		}
	}
}
