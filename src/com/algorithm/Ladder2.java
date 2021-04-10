package com.algorithm;

import java.util.Scanner;

public class Ladder2 {
	static int[] dirX = {-1, 1, 0};
	static int[] dirY = {0, 0, -1};
	
	public static void main(String[] args) {
		int T = 10;
		int[][]	ladder = new int[100][100];
		boolean[][] flag = new boolean[100][100];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < T; i++) {
			int t = sc.nextInt();
			int posX = 0;
			int posY = 0;
			for (int y = 0; y < 100; y++) {
				for (int x = 0; x < 100; x++) {
					ladder[y][x] = sc.nextInt();
					flag[y][x] = false;
					if (ladder[y][x] == 2) {
						posX = x;
						posY = y;
					}
				}
			}
			while (posY != 0) {
				flag[posY][posX] = true;
				for (int cnt = 0; cnt < 3; cnt++) {
					if (posY + dirY[cnt] >= 100 ||posY + dirY[cnt] < 0 ||posX + dirX[cnt] >= 100 ||posX + dirX[cnt] < 0) 
						continue;
					if (ladder[posY + dirY[cnt]][posX + dirX[cnt]] == 1 && flag[posY + dirY[cnt]][posX + dirX[cnt]] == false) {
						posY += dirY[cnt];
						posX += dirX[cnt];
						continue;
					}
				}
			}
			System.out.println("#" + t + " " + posX);
		}
	}
}
