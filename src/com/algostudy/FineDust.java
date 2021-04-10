package com.algostudy;

import java.io.*;
import java.util.*;


public class FineDust {
	static int[] dirX = {1, 0, -1, 0};
	static int[] dirY = {0, -1, 0, 1};
	static int R;
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		List<int[]> air = new ArrayList<int[]>();
		for (int i = 0; i < R; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					air.add(new int[] {i, j});
			}
		}
		for (int i = 0; i < T; i++) {
			int[][] temp = new int[R][C];
			for (int y = 0; y < R; y++) {
				for (int x = 0; x < C; x++) {
					if (map[y][x] > 0) {
						int count = 0;
						for (int cnt = 0; cnt < 4; cnt++) {
							int nx = x + dirX[cnt];
							int ny = y + dirY[cnt];
							if (nx < 0 || nx >= C || ny < 0 || ny >= R)
								continue;
							if (map[ny][nx] == -1) 
								continue;
							else {
								temp[ny][nx] += map[y][x] / 5;
								count++;
							}
						}
						map[y][x] -= (map[y][x] / 5) * count;
					}
				}
			}
			for (int y = 0; y < R; y++)
				for (int x = 0; x < C; x++)
					map[y][x] += temp[y][x];
			cycle(air.get(0)[0], air.get(0)[1], map, true);
			cycle(air.get(1)[0], air.get(1)[1], map, false);
		}
		int fineDust = 0;
		for (int y = 0; y < R; y++)
			for (int x = 0; x < C; x++)
				if (map[y][x] != -1)
					fineDust += map[y][x];
		System.out.println(fineDust);
	}
	static void cycle(int r, int c, int[][] map, boolean is) {
		if (is) {
			int temp = map[r][0];
			int cnt = 0;
			for (int i = 1; i < C; i++) {
				cnt = map[r][i];
				map[r][i] = temp;
				temp = cnt;
			}
			for (int i = r - 1; i >= 0; i--) {
				cnt = map[i][C - 1];
				map[i][C - 1] = temp;
				temp = cnt;
			}
			for (int i = C - 2; i >= 0; i--) {
				cnt = map[0][i];
				map[0][i] = temp;
				temp = cnt;
			}
			for (int i = 1; i <= r; i++) {
				cnt = map[i][0];
				map[i][0] = temp;
				temp = cnt;
			}
			map[r][c] = -1;
			map[r][c + 1] = 0;
		} else {
			int temp = map[r][0];
			int cnt = 0;
			for (int i = 1; i < C; i++) {
				cnt = map[r][i];
				map[r][i] = temp;
				temp = cnt;
			}
			for (int i = r + 1; i < R; i++) {
				cnt = map[i][C - 1];
				map[i][C - 1] = temp;
				temp = cnt;
			}
			for (int i = C - 2; i >= 0; i--) {
				cnt = map[R - 1][i];
				map[R - 1][i] = temp;
				temp = cnt;
			}
			for (int i = R - 2; i >= r; i--) {
				cnt = map[i][0];
				map[i][0] = temp;
				temp = cnt;
			}
			map[r][c] = -1;
			map[r][c + 1] = 0;
		}
	}
}
