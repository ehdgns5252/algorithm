package com.algorithm;

import java.util.Scanner;

public class Omok {
	static int[] dirX = {1, 1, 0, -1};
	static int[] dirY = {0, 1, 1, 1};
	static int N;
	static String[] plate;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			String result = "NO";
			N = sc.nextInt();
			int x = 0;
			int y = 0;
			plate = new String[N];
			for (int i = 0; i < N; i++) 
				plate[i] = sc.next();
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (plate[i].charAt(j) == 'o') {
						for (int cnt = 0; cnt < 4; cnt++) {
							if (flag = omok(1, cnt, j, i)) {
								break;
							}
						}
					}
					if (flag) break;
				}
				if (flag) break;
			}
			if (flag) result = "YES";
			System.out.println("#" + test + " " + result);	
		}
		return;
	}
	private static boolean omok(int n, int cnt, int x, int y) {
		if (n == 5) return true;
		if (y + dirY[cnt] >= N || x + dirX[cnt] >= N || x + dirX[cnt] < 0) return false;
		if (plate[y + dirY[cnt]].charAt(x + dirX[cnt]) == 'o') {
			return omok(n + 1, cnt, x + dirX[cnt], y + dirY[cnt]);
		}
		return false;
	}
}
