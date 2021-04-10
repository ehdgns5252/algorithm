package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class FindRoute {
	static int[][] info;
	static int N;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(in.readLine());
			info = new int[N + 2][2];
			min = Integer.MAX_VALUE;
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int i = 0; i < N + 2; i++) {
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
			}
			per(0, new int[N], new boolean[N]);
			System.out.println("#" + test + " " + min);
		}
	}
	static void per(int cnt, int[] num, boolean[] isVisit) {
		if (cnt == N) {
			int sum = Math.abs(info[0][0] - info[num[0]][0]);
			sum += Math.abs(info[0][1] - info[num[0]][1]);
			for (int i = 0 ; i < N - 1; i++) {
				sum += Math.abs(info[num[i]][0] - info[num[i + 1]][0]);
				sum += Math.abs(info[num[i]][1] - info[num[i + 1]][1]);
			}
			sum += Math.abs(info[1][0] - info[num[N - 1]][0]);
			sum += Math.abs(info[1][1] - info[num[N - 1]][1]);
			min = Math.min(sum, min);
			return ;
		}
		for (int i = 2; i <= N + 1; i++) {
			if (!isVisit[i - 2]) {
				isVisit[i - 2] = true;
				num[cnt] = i;
				per(cnt + 1, num, isVisit);
				isVisit[i - 2] = false;
			}
		}
	}
}
