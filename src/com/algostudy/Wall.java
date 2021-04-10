package com.algostudy;

import java.io.*;
import java.util.*;

public class Wall {
	static int[] dirX = { 0, 0, -1, 1 };
	static int[] dirY = { -1, 1, 0, 0 };
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		Queue<int[]> temp = new LinkedList<int[]>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int[][] distance = new int[N][M];
		for (int i = 0; i < N; i++)
			map[i] = in.readLine().toCharArray();
		temp.offer(new int[] { 0, 0 });
		boolean[][] drill = new boolean[N][M];
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++)
				distance[i][j] = Integer.MAX_VALUE;
		distance[0][0] = 1;
		while (!temp.isEmpty()) {
			int[] arr = temp.poll();
			int x = arr[0];
			int y = arr[1];
			if (x == M - 1 && y == N - 1)
				break;
			for (int cnt = 0; cnt < 4; cnt++) {
				int nx = x + dirX[cnt];
				int ny = y + dirY[cnt];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (map[ny][nx] == '1') {
					if (!drill[y][x] && distance[ny][nx] > distance[y][x] + 1) {
						drill[ny][nx] = true;
						distance[ny][nx] = distance[y][x] + 1;
						temp.offer(new int[] {nx, ny});
					}
				} else {
					if (distance[ny][nx] > distance[y][x] + 1) {
						drill[ny][nx] = drill[y][x];
						distance[ny][nx] = distance[y][x] + 1;
						temp.offer(new int[] {nx, ny});
					} else if(drill[ny][nx] && !drill[y][x]) {
						drill[ny][nx] = drill[y][x];
						distance[ny][nx] = distance[y][x] + 1;
						temp.offer(new int[] {nx, ny});
					}
				}
			}
		}
		int answer = 0;
		if (distance[N - 1][M - 1] == Integer.MAX_VALUE) answer = -1;
		else answer = distance[N - 1][M - 1];
		System.out.println(answer);
	}
}
