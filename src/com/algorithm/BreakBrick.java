package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BreakBrick {
	static int H;
	static int W;
	static int N;
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				for (int j = 0; j < W; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			per(0, new int[N], map);
			System.out.println("#" + test + " " + min);
		}
	}

	static void per(int index, int[] num, int[][] map) {
		if (index == N) {
			int[][] temp = new int[H][W];
			for (int y = 0; y < H; y++)
				for (int x = 0; x < W; x++)
					temp[y][x] = map[y][x];
			for (int i = 0; i < N; i++) {
				int now = num[i];
				for (int y = 0; y < H; y++) {
					if (temp[y][now] != 0) {
						bumb(temp, now, y, temp[y][now]);
						down(temp);
						break;
					}
				}
			}
			min = Math.min(min, check(temp));
			return;
		}
		for (int i = 0; i < W; i++) {
			num[index] = i;
			per(index + 1, num, map);
		}
	}
	static int check(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0)
					count++;
			}
		}
		return count;
	}
	static void bumb(int[][] map, int x, int y, int step) {
		map[y][x] = 0;
//		System.out.println(step + " " + y + " " + x);
		if (step == 1) {
			return;
		}
		for (int range = 1; range < step; range++) {
			for (int cnt = 0; cnt < 4; cnt++) {
				int nx = x + dirX[cnt] * range;
				int ny = y + dirY[cnt] * range;
//				System.out.println(nx + " " + ny);
				if (nx < 0 || nx >= W || ny < 0 || ny >= H)
					continue;
				int t = map[ny][nx];
				map[ny][nx] = 0;
				if (t >= 1)
					bumb(map, nx, ny, t);
			}
		}
	}

	static void down(int[][] map) {
		for (int x = 0; x < W; x++) {
			for (int y = 0; y < H - 1; y++) {
				if (map[y][x] != 0 && map[y + 1][x] == 0) {
					for (int t = y + 1; t >= 1; t--) {
						map[t][x] = map[t - 1][x];
					}
					map[0][x] = 0;
				}
			}
		}
	}
}
