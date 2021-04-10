package com.algorithm.A;

import java.io.*;
import java.util.*;

public class Shark {
	static int[] dirX = { 0, -1, 1, 0 };
	static int[] dirY = { -1, 0, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int fish = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] map = new int[N][N];
		int sharkX = 0;
		int sharkY = 0;
		int[][] range = new int[N][N];
		boolean[][] isVisit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 6)
					fish++;
				if (map[i][j] == 9) {
					sharkX = j;
					sharkY = i;
				}
			}
		}
		int time = 0;
		int eat = 0;
		int sharkSize = 2;
		q.offer(new int[] { sharkX, sharkY });
		while (fish != 0) {
			int minRange = 100;
			int minX = 30;
			int minY = 30;
			boolean canEat = false;
			while (!q.isEmpty()) {
				int[] n = q.poll();
				for (int cnt = 0; cnt < 4; cnt++) {
					int x = n[0] + dirX[cnt];
					int y = n[1] + dirY[cnt];
					if (x < 0 || x >= N || y < 0 || y >= N)
						continue;
					else {
						if (range[y][x] != 0 || isVisit[y][x]) continue;
						range[y][x] = range[n[1]][n[0]] + 1;
						isVisit[y][x] = true;
						if (map[y][x] == sharkSize || map[y][x] == 0)
							q.offer(new int[] {x, y});
						else if (map[y][x] < sharkSize && map[y][x] > 0) {
							if (minRange > range[y][x]) {
								minY = y;
								minX = x;
								canEat = true;
								minRange = range[y][x];
							}
							else if (minRange < range[y][x]) {
								continue;
							} else {
								canEat = true;
								if (minY > y) {
									minY = y;
									minX = x;
								} else if (minY == y) {
									if (minX > x) {
										minY = y;
										minX = x;
									}
								}
							}
						}
					}
				}
			}
			if (canEat) {
				eat++;
				fish--;
				map[sharkY][sharkX] = 0;
				sharkY = minY;
				sharkX = minX;
				time += minRange;
				map[sharkY][sharkX] = 9;
				q.offer(new int[] {sharkX, sharkY});
				range = new int[N][N];
				isVisit = new boolean[N][N];
				isVisit[sharkY][sharkX] = true;
				if (eat == sharkSize) {
					eat = 0;
					sharkSize++;
				}
			} else 
				break;
		}
		System.out.println(time);
	}
}
