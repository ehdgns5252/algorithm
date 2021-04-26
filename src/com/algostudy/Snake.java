package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class Snake {
	static int[] dirX = {1, 0, -1, 0};
	static int[] dirY = {0, -1, 0, 1};
	static int[][] map;
	static int N;
	static int[][] snake;
	static int snake_s;
	static int snake_tail;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			map[y][x] = -1;
			
		}
		int L = Integer.parseInt(in.readLine());
		int[] time = new int[L];
		char[] rot = new char[L];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			rot[i] = st.nextToken().charAt(0);
		}
		int idx = 0;
		int t = 0;
		int dir = 0;
		snake = new int[K + 2][2];
		snake[0][0] = 0;
		snake[0][1] = 0;
		snake_s = 1;
		boolean flag = true;
		while (flag) {
			idx++;
			int[] temp = snake[snake_s - 1];
			flag = move(temp[0], temp[1], dir);
			if (t < L && idx == time[t]) {
				if (rot[t] == 'L') {
					dir += 1;
					dir %= 4;
				} else {
					dir -= 1;
					dir %= 4;
					if (dir < 0)
						dir += 4;
				}
				t++;
			}
		}
		System.out.println(idx);
	}
	static boolean move(int x, int y, int dir) {
		int nx = x + dirX[dir];
		int ny = y + dirY[dir];
		if (nx < 0 || nx >= N || ny < 0 || ny >= N)
			return false;
		for (int i = 0; i < snake_s; i++) {
			if (snake[i][0] == nx && snake[i][1] == ny)
				return false;
		}
		if (map[ny][nx] == -1) {
			map[ny][nx] = 0;
			snake_s++;
			snake[snake_s - 1][0] = nx;
			snake[snake_s - 1][1] = ny;
		} else {
			for (int i = 0; i < snake_s - 1; i++) {
				snake[i][0] = snake[i + 1][0];
				snake[i][1] = snake[i + 1][1];
			}
			snake[snake_s - 1][0] = nx;
			snake[snake_s - 1][1] = ny;
		}
		return true;
	}
}
