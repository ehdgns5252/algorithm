package com.algorithm;

import java.io.*;
import java.util.*;

public class Square {
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static int N;
	static int[][] square;
	static int count;
	static boolean[][] flag;
	static void find(int x, int y) {
		flag[y][x] = true;
		for (int dir = 0; dir < 4; dir++) {
			if (x + dirX[dir] < 0 || x + dirX[dir] >= N || y + dirY[dir] < 0 || y + dirY[dir] >= N)
				continue;
			if (square[y + dirY[dir]][x + dirX[dir]] - square[y][x] == 1) {
				count++;
				find(x + dirX[dir], y + dirY[dir]);
			}
		}
		return;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(in.readLine());
			square = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				int j = 0;
				while (st.hasMoreTokens()) {
					square[i][j++] = Integer.parseInt(st.nextToken());
				}
			}
			flag = new boolean[N][N];
			int max = 0;
			int maxNum = 0;
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					int x = i;
					int y = j;
					if (flag[y][x])
						continue;
					else {
						count = 0;
						find(x, y);
						int nowNum = square[y][x];
						int now = count;
						if (now >= max) {
							if (max == now) {
								if (nowNum < maxNum)
									maxNum = nowNum;
							} else {
								maxNum = nowNum;
								max = now;
							}
						}
					}
				}
			}
			System.out.println("#" + test + " " + maxNum + " " + (max + 1));
		}
	}
}
