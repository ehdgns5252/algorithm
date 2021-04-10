package com.algostudy;

import java.io.*;
import java.util.*;

public class Lab {
	static int N;
	static int M;
	static int[] dirX = {0, 0, -1, 1};
	static int[] dirY = {-1, 1, 0, 0};
	static int[][] map;
	static int max = 0;
	static ArrayList<int[]> q = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) q.add(new int[] {j, i});
			}
		}
		make(0, new int[3], 0);
		System.out.println(max);
	}
	static void make(int index, int[] num, int start) {
		if (index == 3) {
			boolean flag = true;
			for (int i = 0; i < 3; i++) {
				int y = num[i] / M;
				int x = num[i] % M;
				if (map[y][x] != 0)
					flag = false;
			}
			if (!flag)
				return;
			int[][] temp = new int[N][M];
			for (int idy = 0; idy < N; idy++)
				for (int idx = 0; idx < M; idx++)
					temp[idy][idx] = map[idy][idx];
			for (int i = 0; i < 3; i++) {
				int y = num[i] / M;
				int x = num[i] % M;
				temp[y][x] = 1;
			}
			int count = bfs(temp);
			max = Math.max(max, count);
			return;
		}
		for (int i = start; i < N * M; i++) {
			num[index] = i;
			make(index + 1, num, i + 1);
		}
	}
	static int bfs(int[][] info) {
		Queue<int[]> virus = new LinkedList<int[]>();
		boolean[][] isVisit = new boolean[N][M];
		for (int i = 0; i < q.size(); i++) {
			int[] now = q.get(i);
			virus.offer(now);
			isVisit[now[1]][now[0]] = true;
		}
		while (!virus.isEmpty()) {
			int[] now = virus.poll();
			for (int cnt = 0; cnt < 4; cnt++) {
				int nx = now[0] + dirX[cnt];
				int ny = now[1] + dirY[cnt];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (info[ny][nx] == 0 && !isVisit[ny][nx]) {
					info[ny][nx] = 2;
					isVisit[ny][nx] = true;
					virus.offer(new int[] {nx, ny});
				}
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (info[i][j] == 0)
					count++;
		return count;
	}
}
