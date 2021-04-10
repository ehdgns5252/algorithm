package com.algorithm;

import java.io.*;
import java.util.*;

public class Castle {
	static int N;
	static int M;
	static int D;
	static char[][] map;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++)
				map[i][j] = st.nextToken().charAt(0);
		}
		com(0, new int[3], 0);
		System.out.println(max);
	}

	static void com(int cnt, int[] num, int start) {
		if (cnt == 3) {
			int n = kill(num);
			if (max < n)
				max = n;
			return;
		}
		for (int i = start; i < M; i++) {
			num[cnt] = i;
			com(cnt + 1, num, i + 1);
		}

	}

	static int kill(int[] info) {
		int num = 0;
		char[][] temp = new char[N][M];
		int[][] e = new int[3][2];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				temp[i][j] = map[i][j];

		for (int t = 0; t < N; t++) {
			boolean[] flag = new boolean[3];
			ArrayList<String> is = new ArrayList<String>();
			for (int cnt = 0; cnt < 3; cnt++) {
				StringBuilder sb = new StringBuilder();
				for (int d = 1; d <= D; d++) {
					for (int x = 0; x < M; x++) {
						for (int y = N - 1; y >= 0; y--) {
							if (temp[y][x] == '1') {
								if (Math.abs(info[cnt] - x) + (N - y) <= d) {
									if (!flag[cnt]) {
										flag[cnt] = true;
										e[cnt][0] = y;
										e[cnt][1] = x;
										sb.append(y + " " + x);
										is.add(sb.toString());
										break;
									}
								}
							}
							if (flag[cnt]) break;
						}
						if (flag[cnt]) break;
					}
				}
			}
			LinkedHashSet<String> not = new LinkedHashSet<String>(is);
			is = new ArrayList<String>(not);
			for (int u = 0; u < is.size(); u++) {
				StringTokenizer st = new StringTokenizer(is.get(u), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				temp[y][x] = '0';
			}
			num += is.size();
			for (int i = N - 1; i >= 1; i--)
				for (int j = 0; j < M; j++)
					temp[i][j] = temp[i - 1][j];
			for (int i = 0; i < M; i++)
				temp[0][i] = '0';
		}

		return num;
	}
}
