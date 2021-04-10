package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class ColorPaper {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] white = new int[100][100];
		int black = 0;
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int left = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken());
			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 10; x++)
					white[y + bottom][x + left] = 1;
			}
		}
		for (int i = 0; i < 100; i++) 
			for (int j = 0; j < 100; j++)
				if (white[i][j] == 1) black++;
		System.out.println(black);
	}
}
