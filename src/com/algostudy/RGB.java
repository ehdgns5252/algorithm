package com.algostudy;

import java.io.*;

public class RGB {
	static char[][] rgb;
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static boolean[][] isVisit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		rgb = new char[N][N];
		isVisit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			rgb[i] = str.toCharArray();
		}
		int rgbNum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!isVisit[i][j]) {
					rgbNum++;
					find(j, i, N, rgb[i][j]);
				}
			}
		}
		isVisit = new boolean[N][N];
		int rgNum = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (rgb[i][j] == 'G')
					rgb[i][j] = 'R';
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisit[i][j]) {
					rgNum++;
					find(j, i, N, rgb[i][j]);
				}
			}
		}
		System.out.println(rgbNum + " " + rgNum);
	}

	static void find(int x, int y, int N, char color) {
		if (isVisit[y][x])
			return;
		isVisit[y][x] = true;
		for (int cnt = 0; cnt < 4; cnt++) {
			int nx = x + dirX[cnt];
			int ny = y + dirY[cnt];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (!isVisit[ny][nx]) {
				if (rgb[ny][nx] == color)
					find(nx, ny, N, color);
			}
		}
	}

}
