package com.algostudy;

import java.io.*;

public class BbuYo {
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static char[][] bbuyo;
	static boolean[][] isVisit;
	static int[] color;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		bbuyo = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String str = in.readLine();
			bbuyo[i] = str.toCharArray();
		}
		isVisit = new boolean[12][6];
		System.out.println(isEnd(0));
	}

	static void move(int x, int y, char pre) {
		if (bbuyo[y][x] == pre) {
			color[pre]++;
		} else {
			return;
		}
		isVisit[y][x] = true;
		for (int cnt = 0; cnt < 4; cnt++) {
			if (x + dirX[cnt] < 0 || x + dirX[cnt] >= 6 || y + dirY[cnt] < 0 || y + dirY[cnt] >= 12)
				continue;
			if (!isVisit[y + dirY[cnt]][x + dirX[cnt]]) {
				move(x + dirX[cnt], y + dirY[cnt], pre);
			}
		}
	}

	static int isEnd(int count) {
		boolean flag = false;
		color = new int[1 << 8];
		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (bbuyo[i][j] != '.') {
					isVisit = new boolean[12][6];
					color[bbuyo[i][j]] = 0;
					move(j, i, bbuyo[i][j]);
					if (color[bbuyo[i][j]] >= 4) {
						flag = true;
						char c = bbuyo[i][j];
						for (int y = 0; y < 12; y++) {
							for (int x = 0; x < 6; x++) {
								if (bbuyo[y][x] == c && isVisit[y][x]) {
									bbuyo[y][x] = '.';
								}
							}
						}
					}
				}
			}
		}

		if (!flag)
			return count;
		else {
			for (int i = 10; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (bbuyo[i][j] != '.') {
						for (int y = i; y < 11; y++) {
							if (bbuyo[y + 1][j] == '.') {
								bbuyo[y + 1][j] = bbuyo[y][j];
								bbuyo[y][j] = '.';
							}
						}
					}
				}
			}
			return isEnd(count + 1);
		}
	}
}
