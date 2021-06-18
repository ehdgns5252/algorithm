package com.algostudy;

import java.io.*;

public class UpStep {
	static int[] step;
	static int max;
	static int[][] isVisit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		step = new int[N];
		max = 0;
		isVisit = new int[N][2];
		for (int i = 0; i < N ; i++) {
			step[i] = Integer.parseInt(in.readLine());
			for (int j = 0; j < 2; j++)
				isVisit[i][j] = -1;
		}
		calc(N - 1, 1, 0);
		System.out.println(max);
	}
	static void calc(int idx, int l, int sum) {
		if (idx == 0) {
			int now = sum + step[0];
			max = Math.max(max, now);
			return ;
		} else if (idx < 0) {
			max = Math.max(max, sum);
			return ;
		}
		if (l == 2) {
			if (isVisit[idx][0] < sum) {
				isVisit[idx][0] = sum;
				calc(idx - 2, 1, sum + step[idx]);
			}
		} else {
			if (isVisit[idx][0] < sum) {
				isVisit[idx][0] = sum;
				calc(idx - 2, 1, sum + step[idx]);
			}
			if (isVisit[idx][1] < sum) {
				isVisit[idx][1] = sum;
				calc(idx - 1, l + 1, sum + step[idx]);
			}
		}
	}
}
