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
		int[] tree = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++)
			tree[i] = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 1; j < 10001; j++) {
				if (j > tree[i]) break;
					int temp = j * (tree[i] / j * W) - (tree[i] - 1) / j * C;
					if (temp >= 0)
						count += temp;
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}
}
