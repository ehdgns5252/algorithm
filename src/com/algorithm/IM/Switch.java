package com.algorithm.IM;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] s = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			s[i] = sc.nextInt();
		}
		int student = sc.nextInt();
		for (int i = 0; i < student; i++) {
			int gender = sc.nextInt();
			int cnt = sc.nextInt();
			if (gender == 1) {
				for (int j = 1; cnt * j <= N; j++) {
					s[j * cnt] = (s[j * cnt] == 0) ? 1 : 0;
				}
			} else if (gender == 2) {
				int j = 1;
				s[cnt] = (s[cnt] == 0) ? 1 : 0;
				while (true) {
					if (cnt + j > N || cnt - j <= 0)
						break;

					if (s[cnt + j] == s[cnt - j]) {
						s[cnt + j] = (s[cnt + j] == 0) ? 1 : 0;
						s[cnt - j] = (s[cnt - j] == 0) ? 1 : 0;
					} else
						break;
					j++;
				}
			}
		}
		for (int i = 1; i < N; i++) {
			System.out.print(s[i] + " ");
			if (i % 20 == 0)
				System.out.println("");
		}
		System.out.print(s[N]);
	}
}
