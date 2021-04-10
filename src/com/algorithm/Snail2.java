package com.algorithm;

import java.util.Scanner;

public class Snail2 {
	static int[] dirX = {1, 0, -1, 0};
	static int[] dirY = {0, 1, 0, -1};
	static int col = 0;
	static int row = 0;
	static int cnt = 0;
	static int[][] snail(int n) {
		if (n == 1) {
			int[][]	array = {{1}};
			return array;
		}
		int[][] snailArray = new int[n][n];
		
		for (int i = 0; i < n; i++)
			snailArray[0][i] = i + 1;
		for (int i = 0; i < n; i++)
			snailArray[i][n - 1] = snailArray[0][n - 1] + i;
		int[][] temp = snail(n - 1);
		int y = 0;
		for (int i = n - 1; i >= 1; i--) {
			int x = 0;
			for (int j = n - 2; j >= 0; j--) {
				snailArray[i][j] = temp[y][x++] + snailArray[n - 1][n - 1];
			}
			y++;
		}
		return snailArray;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] snail = snail(N);
			System.out.println("#" + i);
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++)
					System.out.print(snail[c][r] + " ");
				System.out.println();
			}
		}
	}
}
