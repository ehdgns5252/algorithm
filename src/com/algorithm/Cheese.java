package com.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Cheese {
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] isAir;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isAir = new boolean[N][M];
		ArrayList<int[]> cheese = new ArrayList<int[]>();
		ArrayList<int[]> air = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheese.add(new int[] { i, j });
				if (i == 0 || i == N - 1) {
					air.add(new int[] {i, j});
					isAir[i][j] = true;
				}
				else if (j == 0 || j == M - 1) {
					air.add(new int[] {i, j});
					isAir[i][j] = true;
				}
			}
		}
		int time = 0;
		int now = 0;
		while (!cheese.isEmpty()) {
			for (int i = 0; i < air.size(); i++) {
				for (int cnt = 0; cnt < 4; cnt++) {
					int x = air.get(i)[1];
					int y = air.get(i)[0];
					int nx = x + dirX[cnt];
					int ny = y + dirY[cnt];
					if (nx < 0 || nx >= M || ny < 0 || ny >= N)
						continue;
					if (!isAir[ny][nx] && map[ny][nx] == 0) {
						isAir[ny][nx] = true;
						air.add(new int[] {ny, nx});
					}
					else {
						continue;
					}
				}
			}
			now = cheese.size();
			time++;
			for (int i = 0; i < cheese.size(); i++) {
				int[] temp = cheese.get(i);
				for (int cnt = 0; cnt < 4; cnt++) {
					int nx = temp[1] + dirX[cnt];
					int ny = temp[0] + dirY[cnt];
					if (nx < 0 || nx >= M || ny < 0 || ny >= N)
						continue;
					if (map[ny][nx] == 0) {
						if (isAir[ny][nx])
							map[temp[0]][temp[1]] = 2;
					}
				}
			}
			for (int i = 0; i < cheese.size(); i++) {
				int[] temp = cheese.get(i);
				if (map[temp[0]][temp[1]] == 2) {
					map[temp[0]][temp[1]] = 0;
					cheese.remove(i);
					i--;
				}
			}
			
		}
		System.out.println(time);
		System.out.println(now);
	}

	
}
