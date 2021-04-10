package com.algorithm;

import java.io.*;
import java.util.*;

public class Restaurant {
	static int[] dirX = { 1, 1, 1 };
	static int[] dirY = { -1, 0, 1 };
	static int R;
	static int C;
	static boolean[][] isVisit;
	static char[][] map;
	static boolean[] isGas;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isVisit = new boolean[R][C];
		isGas = new boolean[R];
		for (int i = 0; i < R; i++) 
			map[i] = in.readLine().toCharArray();
		int count = 0;
		for (int i = 0; i < R; i++) {
			find(0, i, i);
			if (isGas[i])
				count++;
		}
		System.out.println(count);
	}

	static void find(int x, int y, int n) {
		if (x == C - 1) {
			isGas[n] = true;
			return ;
		}
		isVisit[y][x] = true;
		for (int cnt = 0; cnt < 3; cnt++) {
			int nx = x + dirX[cnt];
			int ny = y + dirY[cnt];
			if (nx >= C || ny < 0 || ny >= R)
				continue;
			if (isVisit[ny][nx]) 
				continue;
			if (map[ny][nx] == 'x') 
				continue;
			if (!isGas[n])
				find(nx, ny, n);
		}
	}
}
