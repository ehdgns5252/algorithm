package com.algorithm;

import java.util.Scanner;

public class Battle {
	static int[] shootX = {0, 0, -1, 1};
	static int[] shootY = {-1, 1, 0, 0};
	static char[] dir = {'^', 'v', '<', '>'};
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] field = new char[H][W];
			int tankX = 0;
			int tankY = 0;
			for (int y = 0; y < H; y++) {
				field[y] = sc.next().toCharArray();
				for (int x = 0; x < W; x++) {
					if (field[y][x] == '>') {
						cnt = 3;
						tankX = x;
						tankY = y;
					}
					if (field[y][x] == '^') {
						cnt = 0;
						tankX = x;
						tankY = y;
					}
					if (field[y][x] == 'v') {
						cnt = 1;
						tankX = x;
						tankY = y;
					}
					if (field[y][x] == '<') {
						cnt = 2;
						tankX = x;
						tankY = y;
					}
				}
			}
			int round = sc.nextInt();
			String active = sc.next();
			for (int i = 0; i < round; i++) {
				if (active.charAt(i) == 'S') {
					int x = tankX;
					int y = tankY;
					while(true) {
						x += shootX[cnt];
						y += shootY[cnt];
						if (y < 0 || y >= H || x < 0 || x >= W)
							break;
						if (field[y][x] == '*') {
							field[y][x] = '.';
							break;
						}
						if (field[y][x] == '#')
							break;
					}
					continue;
				}
				if (active.charAt(i) == 'U') {
					cnt = 0;
				}
				if (active.charAt(i) == 'D') {
					cnt = 1;
				}
				if (active.charAt(i) == 'L') {
					cnt = 2;
				}
				if (active.charAt(i) == 'R') {
					cnt = 3;
				}
				field[tankY][tankX] = dir[cnt];
				if (tankY + shootY[cnt] < 0 || tankY + shootY[cnt] >= H || tankX + shootX[cnt] < 0 || tankX + shootX[cnt] >= W) {
					continue;
				}
				if (field[tankY + shootY[cnt]][tankX + shootX[cnt]] == '.') {
					field[tankY][tankX] = '.';
					tankX += shootX[cnt];
					tankY += shootY[cnt];
					field[tankY][tankX] = dir[cnt];
					continue;
				}
			}
			System.out.print("#" + t + " ");
			for (int e = 0; e < H; e++) {
				for (int j = 0; j < W; j++)
					System.out.print(field[e][j]);
				System.out.println();
			}
		}
	}
}
