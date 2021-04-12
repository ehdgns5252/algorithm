package com.algorithm;

import java.io.*;
import java.util.*;

public class War {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dirX = {0, 0, -1, 1};
		int[] dirY = {-1, 1, 0, 0};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			int[][] time = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = in.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
					time[i][j] = -1;
				}
			}
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] {0, 0});
			time[0][0] = map[0][0];
			while (!q.isEmpty()) {
				int[] now = q.poll();
				for (int cnt = 0; cnt < 4; cnt++) {
					int nx = now[0] + dirX[cnt];
					int ny = now[1] + dirY[cnt];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (time[ny][nx] == -1) {
						time[ny][nx] = time[now[1]][now[0]] + map[ny][nx];
						q.offer(new int[] {nx, ny});
					}
					else if (time[ny][nx] > time[now[1]][now[0]] + map[ny][nx]) {
						time[ny][nx] = time[now[1]][now[0]] + map[ny][nx];
						q.offer(new int[] {nx, ny});
					}
				}
			}
			System.out.println("#" + test + " " + time[N - 1][N - 1]);
		}
	}
}
