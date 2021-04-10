package com.algorithm;

import java.io.*;
import java.util.*;

public class Bomber {
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Queue<int[]> bomb1 = new LinkedList<int[]>();
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < C; j++)
				if (map[i][j] == 'O') {
					bomb1.offer(new int[] { i, j });
					for (int cnt = 0; cnt < 4; cnt++) {
						if (i + dirY[cnt] < 0 || i + dirY[cnt] >= R || j + dirX[cnt] < 0
								|| j + dirX[cnt] >= C)
							continue;
						bomb1.offer(new int[] {i + dirY[cnt], j + dirX[cnt]});
					}
				}
		}
		if (N == 1) {
		}
		else if (N % 4 == 3) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = 'O';
				}
			}
			while (!bomb1.isEmpty()) {
				int[] temp = bomb1.poll();
				map[temp[0]][temp[1]] = '.';
			}

		} else if (N % 4 == 0 || N % 4 == 2) {
			for (int i = 0; i < R; i++)
				for (int j = 0; j < C; j++) 
					map[i][j] = 'O';
		} else {
			boolean[][]	bomb = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = 'O';
				}
			}
			while (!bomb1.isEmpty()) {
				int[] temp = bomb1.poll();
				bomb[temp[0]][temp[1]] =true;
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!bomb[i][j]) {
						for (int cnt = 0; cnt < 4; cnt++) {
							if (i + dirY[cnt] < 0 || i + dirY[cnt] >= R || j + dirX[cnt] < 0
									|| j + dirX[cnt] >= C)
								continue;
							map[i][j] = '.';
							map[i + dirY[cnt]][j + dirX[cnt]] = '.';
						}
					}
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
}
