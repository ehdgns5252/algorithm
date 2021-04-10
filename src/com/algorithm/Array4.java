package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Array4 {
	static int[][] arr;
	static int[][] now;
	static int[] num;
	static int[][] info;
	static int N;
	static int M;
	static int K;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		num = new int[K];
		info = new int[K][3];
		for (int i = 0; i < K; i++) {
			num[i] = i;
		}
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int j = 0;
			while (st.hasMoreTokens())
				arr[i][j++] = Integer.parseInt(st.nextToken());
		}
		for (int t = 0; t < K; t++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			info[t][0] = Integer.parseInt(st.nextToken());
			info[t][1] = Integer.parseInt(st.nextToken());
			info[t][2] = Integer.parseInt(st.nextToken());

		}
		per(0, new int[K], new boolean[K]);
		System.out.println(min);
		
	}
	static void turn(int x1, int x2, int y1, int y2) {
		int temp = now[y1][x1];
		int cnt = 0;
		for (int i = x1; i < x2; i++) {
			cnt = now[y1][i + 1];
			now[y1][i + 1] = temp;
			temp = cnt;
		}
		for (int i = y1; i < y2; i++) {
			cnt = now[i + 1][x2];
			now[i + 1][x2] = temp;
			temp = cnt;
		}
		for (int i = x2; i > x1; i--) {
			cnt = now[y2][i - 1];
			now[y2][i - 1] = temp;
			temp = cnt;
		}
		for (int i = y2; i > y1; i--) {
			cnt = now[i - 1][x1];
			now[i - 1][x1] = temp;
			temp = cnt;
		}
		
	}
	static void per(int cnt, int[] temp, boolean[] isVisit) {
		if (cnt == K) {
			now = new int[N][M];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					now[i][j] = arr[i][j];
			for (int i = 0; i < K; i++) {
				int r = info[temp[i]][0];
				int c = info[temp[i]][1];
				int s = info[temp[i]][2];
				for (int e = 0; e < s; e++) 
					turn(c - s + e - 1, c + s - e - 1, r - s + e - 1, r + s - e - 1);
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) 
					sum += now[i][j];
				if (min > sum) min = sum;
			}
		}
		for (int i = 0; i < K; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				temp[cnt] = num[i];
				per(cnt + 1, temp, isVisit);
				isVisit[i] = false;
			}
		}
	}
}
