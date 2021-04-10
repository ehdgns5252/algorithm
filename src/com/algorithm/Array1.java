package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Array1 {
	static int[][]	arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int j = 0;
			while (st.hasMoreTokens())
				arr[i][j++] = Integer.parseInt(st.nextToken());
		}
		int min = Math.min(N, M);
		int step = min / 2;
		for (int r = 0; r < R; r++) 
			for (int i = 0; i < step; i++) 
				turn(i, M - i - 1, i, N - i - 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) 
				sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	static void turn(int x1, int x2, int y1, int y2) {
		int temp = arr[y1][x1];
		int cnt = 0;
		for (int i = y1; i < y2; i++) {
			cnt = arr[i + 1][x1];
			arr[i + 1][x1] = temp;
			temp = cnt;
		}
		for (int i = x1; i < x2; i++) {
			cnt = arr[y2][i + 1];
			arr[y2][i + 1] = temp;
			temp = cnt;
		}
		for (int i = y2; i > y1; i--) {
			cnt = arr[i - 1][x2];
			arr[i - 1][x2] = temp;
			temp = cnt;
		}
		for (int i = x2; i > x1; i--) {
			cnt = arr[y1][i - 1];
			arr[y1][i - 1] = temp;
			temp = cnt;
		}
		
	}
}
