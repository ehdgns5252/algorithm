package com.algostudy;

import java.io.*;
import java.util.*;

class InfoPanda implements Comparable<InfoPanda> {
	int x;
	int y;
	int val;

	InfoPanda(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(InfoPanda o) {
		// TODO Auto-generated method stub
		return o.val - this.val;
	}
}

public class Panda {
	static int N;
	static int[][] map;
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static boolean[][] isVisit;
	static int m;
	static int[][] count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		isVisit = new boolean[N][N];
		count = new int[N][N];
		PriorityQueue<InfoPanda> pq = new PriorityQueue<InfoPanda>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pq.offer(new InfoPanda(j, i, map[i][j]));
			}
		}
		while (!pq.isEmpty()) {
			InfoPanda temp = pq.poll();
			m = 0;
			dfs(temp.x, temp.y, 1);
			count[temp.y][temp.x] = m;
		}
		int max = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				max = Math.max(max, count[i][j]);
		System.out.println(max);
	}

	static void dfs(int x, int y, int step) {
		m = Math.max(m, step);
		if (isVisit[y][x])
			return;
		isVisit[y][x] = true;
		for (int cnt = 0; cnt < 4; cnt++) {
			int nx = x + dirX[cnt];
			int ny = y + dirY[cnt];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (!isVisit[ny][nx] && map[ny][nx] > map[y][x]) {
				if (count[ny][nx] != 0) {
					m = Math.max(m, count[ny][nx] + step);
				} else
					dfs(nx, ny, step + 1);
			}
		}
		isVisit[y][x] = false;
	}
}
