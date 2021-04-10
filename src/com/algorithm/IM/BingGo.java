package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class BingGo {
	static int[] dirX = { 1, 0, 1, -1 };
	static int[] dirY = { 0, 1, 1, 1 };
	static int num = 0;
	static boolean[][] isBinggo;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[5][5];
		isBinggo = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < 5; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 5; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < 5; j++) {
				num = 0;
				int n = Integer.parseInt(st.nextToken());
				for (int y = 0; y < 5; y++) {
					for (int x = 0; x < 5; x++) {
						if (arr[y][x] == n) {
							isBinggo[y][x] = true;
						}
					}
				}
				for (int y = 0; y < 5; y++) 
					for (int x = 0; x < 5; x++) 
							for (int cnt = 0; cnt < 4; cnt++) {
								if (isBinggo[y][x])
									binggo(1, x, y, cnt);
							}
				if (num >= 3) {
					System.out.println((i * 5 + j + 1));
					return;
				}
			}
		}
	}

	static void binggo(int count, int x, int y, int cnt) {
		if (count == 5) {
			num++;
			return;
		}
		int nx = x + dirX[cnt];
		int ny = y + dirY[cnt];
		if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
			return;
		if (isBinggo[ny][nx])
			binggo(count + 1, nx, ny, cnt);
	}
}
