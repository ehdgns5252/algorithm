package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1743 {
	static int[] dirX = {0, 0, -1, 1};
	static int[] dirY = {-1, 1, 0, 0};
	static int[][] map;
	static int N;
	static int M;
	static boolean[][] isVisit;
	static int max;
	static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isVisit = new boolean[N][M];
		max = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			map[y][x] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !isVisit[i][j]) {
					size = 1;
					isVisit[i][j] = true;
					dfs(j, i);
					max = Math.max(max, size);
				}
			}
		}
		System.out.println(max);
	}
	static void dfs(int x, int y) {
		for (int cnt = 0; cnt < 4; cnt++) {
			int nx = x + dirX[cnt];
			int ny = y + dirY[cnt];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;
			if (map[ny][nx] == 1 && !isVisit[ny][nx]) {
				isVisit[ny][nx] = true;
				size++;
				dfs(nx, ny);
			}
		}
	}
}
