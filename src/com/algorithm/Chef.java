package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Chef {
	static boolean[] isA;
	static int N;
	static int min;
	static int[][] taste;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(in.readLine());
			taste = new int[N][N];
			isA = new boolean[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++)
					taste[i][j] = Integer.parseInt(st.nextToken());
			}
			com(0, new int[N / 2], 0);
			System.out.println("#" + test + " " + min);
		}
	}
	static void com(int cnt, int[] food, int start) {
		if (cnt == N / 2) {
			for (int i = 0; i < N / 2; i++) {
				isA[food[i]] = true;
			}
			int aSum = 0;
			int bSum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isA[i] && isA[j])
						aSum += taste[i][j];
					if (!isA[i] && !isA[j])
						bSum += taste[i][j];
				}
			}
			int temp = Math.abs(aSum - bSum);
			min = Math.min(min, temp);
			for (int i = 0; i < N / 2; i++) {
				isA[food[i]] = false;
			}
			return ;
		}
		for (int i = start; i < N; i++) {
			food[cnt] = i;
			com(cnt + 1, food, i + 1);
		}
	}
}
