package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Runway {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int[][] map1 = new int[N][N];
			int[][] map2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				for (int j = 0; j < N ;j++) {
					map1[i][j] = Integer.parseInt(st.nextToken());
					map2[j][i] = map1[i][j];
				}
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (can(map1[i], X)) {
					count++;
				}
				if (can(map2[i], X))
					count++;
			}
			System.out.println("#" + test + " " + count);
		}
	}
	static boolean can(int[] map, int X) {
		int temp = map[0];
		int count = 1;
		for (int i = 1; i < map.length; i++) {
			if (temp == map[i]) {
				count++;
			} else if (temp == map[i] - 1) {
				if (count >= X) {
					temp = map[i];
					count = 1;
					continue;
				} else 
					return false;
			} else if (temp == map[i] + 1) {
				for (int j = 0; j < X; j++) {
					if (i + j >= map.length)
						return false;
					if (map[i] != map[i + j])
						return false;
				}
				temp = map[i];
				i += X - 1;
				count = 0;
			} else {
				return false;
			}
		}
		return true;
	}
}
