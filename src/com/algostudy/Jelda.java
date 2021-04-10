package com.algostudy;

import java.io.*;
import java.util.*;


public class Jelda {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int idx = 1;
		int[] dirX = {0, 0, -1, 1};
		int[] dirY = {-1, 1, 0, 0};
		while (N != 0) {
			int[][] map = new int[N][N];
			Queue<int[]> q = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] isVisit = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					isVisit[i][j] = -1;
			q.offer(new int[] {0, 0});
			isVisit[0][0] = map[0][0];
			while (!q.isEmpty()) {
				int[] temp = q.poll();
				for (int cnt = 0; cnt < 4; cnt++) {
					int nx = temp[0] + dirX[cnt];
					int ny = temp[1] + dirY[cnt];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (isVisit[ny][nx] == -1) {
						q.offer(new int[] {nx, ny});
						isVisit[ny][nx] = isVisit[temp[1]][temp[0]] + map[ny][nx];
					} else if (isVisit[ny][nx] > isVisit[temp[1]][temp[0]] + map[ny][nx]) {
						isVisit[ny][nx] = isVisit[temp[1]][temp[0]] + map[ny][nx];
						q.offer(new int[] {nx, ny});
					}
				}
			}
			System.out.println("Problem " + idx++ + ": " + isVisit[N - 1][N - 1]);
			N = Integer.parseInt(in.readLine());
		}
	}
}

