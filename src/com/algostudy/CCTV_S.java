package com.algostudy;

import java.io.*;
import java.util.*;

public class CCTV_S {
	static int[] dirX = { 0, -1, 0, 1 };
	static int[] dirY = { -1, 0, 1, 0 };
	static int N;
	static int M;
	static int[][] arr;
	static List<int[]> cctv;
	static List<int[]> cctv5;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cctv = new ArrayList<int[]>();
		cctv5 = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 5) {
					cctv5.add(new int[] { i, j });
				} else if (arr[i][j] >= 1 && arr[i][j] <= 4)
					cctv.add(new int[] { i, j });
			}
		}
		for (int i = 0; i < cctv5.size(); i++)
			for (int cnt = 0; cnt < 4; cnt++)
				find(cnt, cctv5.get(i)[1], cctv5.get(i)[0]);
		Collections.sort(cctv, (n1, n2) -> {
			return arr[n2[0]][n2[1]] - arr[n1[0]][n1[1]];
		});
		min = check();
		if (cctv.size() > 0) {
			int x = cctv.get(0)[1];
			int y = cctv.get(0)[0];
			if (arr[y][x] == 1)
				com(0, new int[1], 0, 1, x, y, 0);
			if (arr[y][x] == 2 || arr[y][x] == 3)
				com(0, new int[2], 0, 2, x, y, 0);
			if (arr[y][x] == 4)
				com(0, new int[3], 0, 3, x, y, 0);
				
		}
		System.out.println(min);
	}
	
	static void com(int index, int[] num, int start, int size, int x, int y, int cctvI) {
		if (cctvI == cctv.size()) {
			int count = check();
			min = Math.min(min, count);
			return;
		}
		int nx = 0;
		int ny = 0;
		int s = 1;
		if (cctvI < cctv.size() - 1) {
			nx = cctv.get(cctvI + 1)[1];
			ny = cctv.get(cctvI + 1)[0];
			s = arr[ny][nx];
			if (s == 2 || s == 3)
				s = 2;
			if (s == 4)
				s = 3;
		}
		if (index == size) {
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					temp[i][j] = arr[i][j];
			if (size == 2) {
				if (arr[y][x] == 2) {
					if (Math.abs(num[0] - num[1]) == 2) {
						find(num[0], x, y);
						find(num[1], x, y);
						com(0, new int[s], 0, s, nx, ny, cctvI + 1);
						for (int i = 0; i < N; i++)
							for (int j = 0; j < M; j++)
								arr[i][j] = temp[i][j];
					}
				} else {
					if (Math.abs(num[0] - num[1]) != 2) {
						find(num[0], x, y);
						find(num[1], x, y);
						com(0, new int[s], 0, s, nx, ny, cctvI + 1);
						for (int i = 0; i < N; i++)
							for (int j = 0; j < M; j++)
								arr[i][j] = temp[i][j];
					}
				}
			} else {
				for (int i = 0; i < size; i++)
					find(num[i], x, y);
				com(0, new int[s], 0, s, nx, ny, cctvI + 1);
				for (int i = 0; i < N; i++)
					for (int j = 0; j < M; j++)
						arr[i][j] = temp[i][j];
			}
			return;
		}
		for (int i = start; i < 4; i++) {
			num[index] = i;
			com(index + 1, num, i + 1, size, x, y, cctvI);
		}
	}

	static int check() {
		int count = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (arr[i][j] == 0)
					count++;
		return count;
	}

	static void find(int cnt, int x, int y) {
		int nx = x;
		int ny = y;
		while (true) {
			nx += dirX[cnt];
			ny += dirY[cnt];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				break;
			if (arr[ny][nx] == 6)
				break;
			if (arr[ny][nx] == 0)
				arr[ny][nx] = 9;
		}
	}
}
