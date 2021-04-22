package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class HoneyBee {
	static int[][] honey;
	static int N;
	static int M;
	static int C;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			honey = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++)
					honey[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (j + M > N)
						continue;
					int[] bee1 = new int[M];
					for (int cnt = 0; cnt < M; cnt++)
						bee1[cnt] = honey[i][j + cnt];
					find(j, i, bee1);
				}
			}
			System.out.println("#" + test + " " + max);
		}
	}
	static void find(int x, int y, int[] bee1) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == y && (j >= x && j < x + M || j + M <= x + M && j + M > x))
					continue;
				if (j + M > N)
					continue;
				int[] bee2 = new int[M];
				for (int cnt = 0; cnt < M; cnt++)
					bee2[cnt] = honey[i][j + cnt];
				max = Math.max(max, dp(bee1) + dp(bee2));
			}
		}
	}
	static int dp(int[] bee) {
		int[][] dp = new int[M][C + 1];
		for (int i = 0; i < C + 1; i++) 
			if (i >= bee[0])
				dp[0][i] = bee[0] * bee[0];
		for (int i = 1; i < M; i++) {
			for (int j = 0; j < C + 1; j++) {
				if (j - bee[i] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bee[i]] + bee[i] * bee[i]);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < C + 1; j++)
//				System.out.print(dp[i][j] + " ");
//			System.out.println();
//		}
		return dp[M - 1][C];
	}
}
