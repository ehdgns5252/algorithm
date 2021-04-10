package com.algorithm;

import java.util.Scanner;

public class Snail {

	static int[] dirX = {1, 0, -1, 0};
	static int[] dirY = {0, 1, 0, -1};
	static int col = 0;
	static int row = 0;
	static int cnt = 0;
	static void direct() {
		col -= dirY[cnt];
		row -= dirX[cnt];
		if (cnt == 3) cnt = 0;
		else cnt++;
		col += dirY[cnt];
		row += dirX[cnt];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			col = 0;
			row = 0;
			cnt = 0;
			for (int n = 0; n < N * N; n++) {
				if (snail[col][row] == 0) {
					snail[col][row] = n + 1;
					col += dirY[cnt];
					row += dirX[cnt];
					if (row >= N || row < 0 || col >= N || col <0) {
						direct();
					}
				} else {
					direct();
					n--;
				}
			}
			System.out.println("#" + i);
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++)
					System.out.print(snail[c][r] + " ");
				System.out.println();
			}
		}
	}
}
