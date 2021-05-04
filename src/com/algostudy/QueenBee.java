package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class QueenBee {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] bee = new int[M][M];
		int[] plus = new int[M * 2 - 1];
		int[] dirX = { -1, -1, 0 };
		int[] dirY = { 0, -1, -1 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			if (one > 0) {
				for (int n = zero; n < zero + one; n++)
					plus[n] += 1;
			}
			if (two > 0) {
				for (int n = zero + one; n < 2 * M - 1; n++)
					plus[n] += 2;
			}
		}
		for (int i = 0; i < M; i++) {
			bee[M - i - 1][0] = 1 + plus[i];
		}
		for (int i = 0; i < M - 1; i++) {
			bee[0][i + 1] = 1 + plus[i + M];
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (bee[i][j] == 0) {
					bee[i][j] = bee[0][j];
				}
				System.out.print(bee[i][j] + " ");
			}
			System.out.println();
		}
	}
}
