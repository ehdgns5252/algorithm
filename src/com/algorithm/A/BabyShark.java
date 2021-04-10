package com.algorithm.A;

import java.io.*;
import java.util.*;

public class BabyShark {
	static int[] dirX = {0, -1, 1, 0};
	static int[] dirY = {-1, 0, 0, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int fish = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] map = new int[N][N];
		int sharkX = 0;
		int sharkY = 0;
		boolean[][] isVisit = new boolean[N][N];
		int[][] range = new int[N][N];
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
		int sharkSize = 2;
		int eat = 0;
		int time = 0;
		isVisit[sharkY][sharkX] = true;
		q.offer(new int[] {sharkX, sharkY});
		boolean can = false;
		int minX = 30;
		int minY = 30;
		while (!q.isEmpty() && fish > 0) {
			int[] now = q.poll();
			int r = range[now[1]][now[0]];
			for (int cnt = 0; cnt < 4; cnt++) {
				int x = now[0] + dirX[cnt];
				int y = now[1] + dirY[cnt];
				if (x < 0 || x >= N || y < 0 || y >= N)
					continue;
				if (!isVisit[y][x]) {
					isVisit[y][x] = true;
					range[y][x] = r + 1;
					if (map[y][x] == sharkSize || map[y][x] == 0) {
						q.offer(new int[] {x, y});
					}
					else if (map[y][x] < sharkSize && map[y][x] > 0) {
						if (minY > y) {
							minY = y;
							minX = x;
						} else if (minY == y) {
							if (minX > x) {
								minX = x;
								minY = y;
							}
						}
						can = true;
					}
				}
			}
			if (can) {
				eat++;
				fish--;
				isVisit = new boolean[N][N];
				q.clear();
				map[sharkY][sharkX] = 0;
				sharkX = minX;
				sharkY = minY;
				minX = 30;
				minY = 30;
				time += range[sharkY][sharkX];
				map[sharkY][sharkX] = 9;
				range = new int[N][N];
				q.offer(new int[] {sharkX, sharkY});
				can = false;
				isVisit[sharkY][sharkX] = true;
				System.out.println(sharkX + " " + sharkY);
				System.out.println(sharkSize + " size " + time + " time " + fish + " fish");
				if (eat == sharkSize) {
					sharkSize++;
					eat = 0;
				}
			}
		}
		System.out.println(time);
	}
}
