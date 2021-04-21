package com.algorithm;

import java.io.*;
import java.util.*;

public class MoonMaze {
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static char[][] maze;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] isVisit = new int[N][M];
		int[][] findkey = new int[N][M];
		boolean[][][] iskey = new boolean[N][M][6];
		maze = new char[N][M];
		for (int i = 0; i < N; i++) {
			maze[i] = in.readLine().toCharArray();
			for (int j = 0; j < M; j++)
				if (maze[i][j] == '0') {
					q.offer(new int[] { j, i });
					isVisit[i][j] = 1;
					maze[i][j] = '.';
				}
		}
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			System.out.println(y + " " + x + " " + findkey[y][x]);
			for (int cnt = 0; cnt < 4; cnt++) {
				int nx = x + dirX[cnt];
				int ny = y + dirY[cnt];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (isVisit[ny][nx] == 0) {
					if (maze[ny][nx] == '#') {
						continue;
					} else if (maze[ny][nx] == '.') {
						for (int i = 0; i < 6; i++)
							iskey[ny][nx][i] = iskey[y][x][i];
						isVisit[ny][nx] = isVisit[y][x] + 1;
						findkey[ny][nx] = findkey[y][x];
						q.offer(new int[] { nx, ny });
					} else if (maze[ny][nx] >= 'a' && maze[ny][nx] <= 'f') {
						for (int i = 0; i < 6; i++)
							iskey[ny][nx][i] = iskey[y][x][i];
						iskey[ny][nx][maze[ny][nx] - 'a'] = true;
						System.out.println(maze[ny][nx]);
						findkey[ny][nx] = findkey[y][x] + 1;
						isVisit[ny][nx] = isVisit[y][x] + 1;
						q.offer(new int[] { nx, ny });
					} else if (maze[ny][nx] >= 'A' && maze[ny][nx] <= 'F') {
						if (iskey[y][x][maze[ny][nx] - 'A']) {
							for (int i = 0; i < 6; i++)
								iskey[ny][nx][i] = iskey[y][x][i];
							findkey[ny][nx] = findkey[y][x];
							isVisit[ny][nx] = isVisit[y][x] + 1;
							q.offer(new int[] { nx, ny });
						}
					} else if (maze[ny][nx] == '1' && isVisit[y][x] != 0) {
						for (int i = 0; i < 6; i++)
							iskey[ny][nx][i] = iskey[y][x][i];
						findkey[ny][nx] = findkey[y][x];
						answer = Math.min(answer, isVisit[y][x]);
					}
				} else if (findkey[y][x] >= findkey[ny][nx] && iscan(iskey[y][x], iskey[ny][nx])) {
					if (maze[ny][nx] == '#') {
						continue;
					} else if (maze[ny][nx] == '.') {
						for (int i = 0; i < 6; i++)
							iskey[ny][nx][i] = iskey[y][x][i];
						isVisit[ny][nx] = isVisit[y][x] + 1;
						findkey[ny][nx] = findkey[y][x];
						q.offer(new int[] { nx, ny });
					} else if (maze[ny][nx] >= 'a' && maze[ny][nx] <= 'f') {
						for (int i = 0; i < 6; i++)
							iskey[ny][nx][i] = iskey[y][x][i];
						iskey[ny][nx][maze[ny][nx] - 'a'] = true;
						findkey[ny][nx] = findkey[y][x] + 1;
						isVisit[ny][nx] = isVisit[y][x] + 1;
						q.offer(new int[] { nx, ny });
					} else if (maze[ny][nx] >= 'A' && maze[ny][nx] <= 'F') {
						if (iskey[y][x][maze[ny][nx] - 'A']) {
							for (int i = 0; i < 6; i++)
								iskey[ny][nx][i] = iskey[y][x][i];
							findkey[ny][nx] = findkey[y][x];
							isVisit[ny][nx] = isVisit[y][x] + 1;
							q.offer(new int[] { nx, ny });
						}
					} else if (maze[ny][nx] == '1' && isVisit[y][x] != 0) {
						for (int i = 0; i < 6; i++)
							iskey[ny][nx][i] = iskey[y][x][i];
						findkey[ny][nx] = findkey[y][x];
						answer = Math.min(answer, isVisit[y][x]);
					}
				}
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	static boolean iscan(boolean[] k1, boolean[] k2) {
		int k1cnt = 0;
		int k2cnt = 0;
		for (int i = 0; i < 6; i++) {
			if (k1[i])
				k1cnt++;
			if (k2[i])
				k2cnt++;
		}
		if (k1cnt < k2cnt) {
			return false;
		} else if (k1cnt > k2cnt) {
			return true;
		} else {
			boolean flag = false;
			for (int i = 0; i < 6; i++) {
				if (k1[i] != k2[i])
					flag = true;
			}
			return flag;
		}
	}
}