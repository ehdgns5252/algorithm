package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class BreakWall {
	static int[] dirX = { -1, 0, 1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static boolean[][] isVisit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++)
			map[i] = in.readLine().toCharArray();
		isVisit = new boolean[N][M];
		move(map, 0, 0, 1, 0);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(min);
	}

	static void move(char[][] map, int x, int y, int count, int wall) {
		if (min == N + M) return;
		if (wall > 1)
			return;
		if (x == M - 1 && y == N - 1) {
			if (min > count)
				min = count;
			return;
		}
		isVisit[y][x] = true;
		int temp = wall;
		if (map[y][x] == '1')
			temp++;
		for (int cnt = 0; cnt < 4; cnt++) {
			if (x + dirX[cnt] < 0 || x + dirX[cnt] >= M || y + dirY[cnt] < 0 || y + dirY[cnt] >= N)
				continue;
			if (isVisit[y + dirY[cnt]][x + dirX[cnt]])
				continue;
			move(map, x + dirX[cnt], y + dirY[cnt], count + 1, temp);
		}
		isVisit[y][x] = false;
	}
}
