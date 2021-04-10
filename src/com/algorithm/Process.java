package com.algorithm;

import java.io.*;
import java.util.*;

public class Process {
	static int N;
	static char[][] map;
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static boolean[] xVisit;
	static boolean[] yVisit;
	static List<int[]> arr;
	static int max;
	static int len;
	static boolean[][] isVisit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(in.readLine());
			map = new char[N][N];
			arr = new ArrayList<int[]>();
			max = Integer.MIN_VALUE;
			len = Integer.MAX_VALUE;
			isVisit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
					if (map[i][j] == '1' && (i != 0 && j != 0 && i != N - 1 && j != N - 1)) {
						arr.add(new int[] { i, j });
						isVisit[i][j] = true;
					}
				}
			}
			int x = arr.get(0)[1];
			int y = arr.get(0)[0];
			find(0, 0, 0);

			System.out.println("#" + test + " " + len);
		}
	}

	static void find(int n, int c, int sum) {
		if (n == arr.size()) {
			if (c > max) {
				max = c;
				len = sum;
			} else if (c == max) {
				len = Math.min(len, sum);
			}
			return;
		}
		boolean[][] te = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				te[i][j] = isVisit[i][j];

		for (int t = 0; t < 4; t++) {
			int x = arr.get(n)[1];
			int y = arr.get(n)[0];
			int count = 1;
			boolean flag = false;
			while (true) {
				x += dirX[t];
				y += dirY[t];
				if (x < 0 || x >= N || y < 0 || y >= N)
					break;
				if (map[y][x] == '1' || isVisit[y][x])
					break;
				if (x <= 0 || x >= N - 1 || y <= 0 || y >= N - 1 && !isVisit[y][x]) {
					flag = true;
					isVisit[y][x] = true;
					break;
				}
				isVisit[y][x] = true;
				count++;
			}
			if (!flag) for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					isVisit[i][j] = te[i][j];
			if (flag)
				find(n + 1, c + 1, sum + count);
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					isVisit[i][j] = te[i][j];
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				isVisit[i][j] = te[i][j];
		find(n + 1, c, sum);
	}
}
