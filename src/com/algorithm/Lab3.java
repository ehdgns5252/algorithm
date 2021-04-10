package com.algorithm;

import java.io.*;
import java.util.*;

public class Lab3 {
	static ArrayList<int[]> virus;
	static int N;
	static int[][] lab;
	static int[] dirX = {0, 0, -1, 1};
	static int[] dirY = {-1, 1, 0, 0};
	static int min = Integer.MAX_VALUE;
	static int nonV;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		virus = new ArrayList<int[]>();
		lab = new int[N][N];
		nonV = 0;
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2)
					virus.add(new int[] {j, i});
				if (lab[i][j] == 0)
					nonV++;
					
			}
		}
		com(0, new int[M], 0, M, virus.size());
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	static void com(int index, int[] num, int start, int M, int v) {
		if (index == M) {
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					map[i][j] = lab[i][j];
			int[][] isVisit = new int[N][N];
			Queue<int[]> q = new LinkedList<int[]>();
			for (int i = 0; i < M; i++) {
				q.offer(virus.get(num[i]));
				isVisit[virus.get(num[i])[1]][virus.get(num[i])[0]] = 1;
			}
			int can = 0;
			int time = 1;
			while (!q.isEmpty()) {
				if (time - 1 > min)
					return ;
				if (can == nonV)
					break;
				int[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				if (isVisit[y][x] > min - 1) return;
				for (int cnt = 0; cnt < 4; cnt++) {
					int nx = x + dirX[cnt];
					int ny = y + dirY[cnt];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (map[ny][nx] != 1 && isVisit[ny][nx] == 0) {
						isVisit[ny][nx] = isVisit[y][x] + 1;
						q.offer(new int[] {nx, ny});
						if (map[ny][nx] == 0) {
							can++;
							time = isVisit[ny][nx];
						}
					}
				}
			}
			if (can == nonV)
				min = Math.min(min, time - 1);
			return;
		}
		for (int i = start; i < v; i++) {
			num[index] = i;
			com(index + 1, num, i + 1, M, v);
		}
	}
}
