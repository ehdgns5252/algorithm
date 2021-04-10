package com.algostudy;

import java.io.*;
import java.util.*;

public class CCTV {
	static int[] dirX = { 0, 1, 0, -1 };
	static int[] dirY = { -1, 0, 1, 0 };
	static List<int[]> cctv1;
	static List<int[]> cctv2;
	static List<int[]> cctv3;
	static List<int[]> cctv4;
	static List<int[]> cctv5;
	static int N;
	static int M;
	static int[][] map;
	static int max = 0;
	static int[] change;
	static Stack<int[]> m = new Stack<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		map = new int[N][M];
		cctv1 = new ArrayList<int[]>();
		cctv2 = new ArrayList<int[]>();
		cctv3 = new ArrayList<int[]>();
		cctv4 = new ArrayList<int[]>();
		cctv5 = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = arr[i][j];
				if (arr[i][j] == 1)
					cctv1.add(new int[] { i, j });
				if (arr[i][j] == 2)
					cctv2.add(new int[] { i, j });
				if (arr[i][j] == 3)
					cctv3.add(new int[] { i, j });
				if (arr[i][j] == 4)
					cctv4.add(new int[] { i, j });
				if (arr[i][j] == 5)
					cctv5.add(new int[] { i, j });
			}
		}
		for (int i = 0; i < cctv5.size(); i++) {
			int x = cctv5.get(i)[1];
			int y = cctv5.get(i)[0];
			for (int cnt = 0; cnt < 4; cnt++)
				find(cnt, x, y);
		}
		max = check();
		for (int i = 0; i < cctv4.size(); i++) {
			int x = cctv4.get(i)[1];
			int y = cctv4.get(i)[0];
			com(0, new int[3], 0, 3, x, y);
			for (int e = 0; e < 3; e++) {
				find(change[e], x, y);
			}
		}
		for (int i = 0; i < cctv3.size(); i++) {
			int x = cctv3.get(i)[1];
			int y = cctv3.get(i)[0];
			com(0, new int[2], 0, 2, x, y);
			for (int e = 0; e < 2; e++) {
				find(change[e], x, y);
			}
		}
		for (int i = 0; i < cctv2.size(); i++) {
			int x = cctv2.get(i)[1];
			int y = cctv2.get(i)[0];
			com(0, new int[2], 0, 2, x, y);
			for (int e = 0; e < 2; e++) {
				find(change[e], x, y);
			}
		}
		for (int i = 0; i < cctv1.size(); i++) {
			int x = cctv1.get(i)[1];
			int y = cctv1.get(i)[0];
			com(0, new int[1], 0, 1, x, y);
			for (int e = 0; e < 1; e++) {
				find(change[e], x, y);
			}
		}
		int no = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					no++;
			}
		}
		System.out.println(no);
	}

	static void com(int index, int[] num, int start, int size, int x, int y) {
		if (index == size) {
			int[][] temp = new int[N][M];
			int n = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					temp[i][j] = map[i][j];
			if (size == 2) {
				if (map[y][x] == 2) {
					if (Math.abs(num[0] - num[1]) == 2) {
						find(num[0], x, y);
						find(num[1], x, y);
					}
					n = check();
				} else {
					if (Math.abs(num[0] - num[1]) != 2) {
						find(num[0], x, y);
						find(num[1], x, y);
					}
					n = check();
				}
			} else {
				for (int i = 0; i < size; i++) {
					find(num[i], x, y);
				}
				n = check();
			}
			if (n > max) {
				max = n;
				change = new int[size];
				for (int i = 0; i < size; i++)
					change[i] = num[i];
			}
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					map[i][j] = temp[i][j];

			return;
		}
		for (int i = start; i < 4; i++) {
			num[index] = i;
			com(index + 1, num, i + 1, size, x, y);
		}
	}

	static void find(int cnt, int x, int y) {
		int nx = x;
		int ny = y;
		while (true) {
			nx += dirX[cnt];
			ny += dirY[cnt];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				break;
			if (map[ny][nx] == 6)
				break;
			map[ny][nx] = -1;
		}
	}

	static int check() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1)
					count++;
			}
		}
		return count;
	}
}
