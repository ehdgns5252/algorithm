package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class Poly {
	static int[] dirX = {0, 0, -1, 1};
	static int[] dirY = {-1, 1, 0, 0};
	static int max = Integer.MIN_VALUE;
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] is;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		is = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				makeTetro(j, i, 1, arr[i][j]);
				ex(0, new int[3], new boolean[4], j, i);
			}
		}
		System.out.println(max);
	}
	static void makeTetro(int x, int y, int count, int sum) {
		if (count == 4) {
			max = Math.max(max, sum);
			return ;
		}
		if(is[y][x]) return ;
		is[y][x] = true;
		for (int cnt = 0; cnt < 4; cnt++) {
			int nx = x + dirX[cnt];
			int ny = y + dirY[cnt];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;
			if (!is[ny][nx]) {
				makeTetro(nx, ny, count + 1, sum + arr[ny][nx]);
			}
		}
		is[y][x] = false;
	}
	static void ex(int cnt, int[] num, boolean[] isVisit, int x, int y) {
		if (cnt == 3) {
			int sum = arr[y][x];
			for (int i = 0; i < 3; i++) {
				int nx = x + dirX[num[i]];
				int ny = y + dirY[num[i]];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					return;
				sum += arr[ny][nx];
			}
			max = Math.max(max, sum);
			return ;
		}
		for (int i = 0; i < 4; i++) {
			if(!isVisit[i]) {
				isVisit[i] = true;
				num[cnt] = i;
				ex(cnt + 1, num, isVisit, x, y);
				isVisit[i] = false;
			}
		}
	}
}
