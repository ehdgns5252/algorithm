package com.algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FindMine {
	static int[] dirX = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dirY = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[][] mine;
	static char[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(in.readLine());
			map = new char[N][N];
			mine = new int[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = in.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.')
						mine[i][j] = -1;
					else if (map[i][j] == '*')
						mine[i][j] = -2;
				}

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.' && mine[i][j] == -1) {
						find(j, i);
					}
				}
			}
			int count = 0;
			Queue<int[]> q = new LinkedList<int[]>();
			boolean[][] isVisit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mine[i][j] == 0 && !isVisit[i][j]) {
						isVisit[i][j] = true;
						q.offer(new int[] {j, i});
						count++;
						while (!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.poll()[1];
							for (int cnt = 0; cnt < 8; cnt++) {
								int nx = x + dirX[cnt];
								int ny = y + dirY[cnt];
								if (nx < 0 || nx >= N || ny < 0 || ny >= N)
									continue;
								if (mine[ny][nx] == 0 && !isVisit[ny][nx]) {
									q.offer(new int[] {nx, ny});
								}
								isVisit[ny][nx] = true;
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mine[i][j] >= 0 && !isVisit[i][j])
						count++;
				}
			}
			System.out.println("#" + test + " " + count);
		}
	}

	static void find(int x, int y) {
		int count = 0;
		for (int cnt = 0; cnt < 8; cnt++) {
			int nx = x + dirX[cnt];
			int ny = y + dirY[cnt];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (map[ny][nx] == '*')
				count++;
		}
		mine[y][x] = count;
		if (count == 0) {
			for (int cnt = 0; cnt < 8; cnt++) {
				int nx = x + dirX[cnt];
				int ny = y + dirY[cnt];
				if (nx < 0 || nx >= N || ny < 0 || ny >= 0)
					continue;
				if (mine[ny][nx] == -1)
					find(nx, ny);
			}
		}
	}
}
