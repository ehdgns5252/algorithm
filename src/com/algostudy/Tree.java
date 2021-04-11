package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class Tree {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] money = new int[N][10001];
		int[] tree = new int[N];
		for (int i = 0; i < N; i++)
			tree[i] = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < 10001; j++) {
				if (j > tree[i]) break;
					money[i][j] = j * (tree[i] / j * W) - (tree[i] - 1) / j * C;
			}
		}
		int max = 0;
		for (int j = 1; j < 10001; j++) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (money[i][j] >= 0)
					count += money[i][j];
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}
}
