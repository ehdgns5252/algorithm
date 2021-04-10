package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class ColorPaper2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[101][101];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int[] p1 = new int[2];
			int[] p2 = new int[2];
			p1[0] = Integer.parseInt(st.nextToken());
			p1[1] = Integer.parseInt(st.nextToken());
			p2[0] = Integer.parseInt(st.nextToken());
			p2[1] = Integer.parseInt(st.nextToken());
			for (int e = p1[0]; e < p1[0] +p2[0]; e++)
				for (int j = p1[1]; j < p1[1] + p2[1]; j++)
					map[e][j] = i + 1;

		}
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int y = 0; y < 101; y++)
				for (int x = 0; x < 101; x++)
					if (map[y][x] == i + 1)
						sum++;
			System.out.println(sum);
		}

	}
}
