package com.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Chicken {
	static int N;
	static int M;
	static ArrayList<int[]> chicken;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chicken = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		com(0, new int[M][2], 0);
		System.out.println(min);
	}
	static void com(int cnt, int[][] now, int start) {
		if (cnt == M) {
			int temp = calChicken(now);
			if (min > temp)
				min = temp;
			return ;
		}
		for (int i = start; i < chicken.size(); i++) {
			now[cnt] = chicken.get(i);
			com(cnt + 1, now, i + 1);
		}
	}
	
	static int calChicken(int[][] info) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					int t = Integer.MAX_VALUE;
					for (int cnt = 0; cnt < M; cnt++) {
						int y = Math.abs(i - info[cnt][0]);
						int x = Math.abs(j - info[cnt][1]);
						if (t > y + x)
							t = y + x;
					}
					sum += t;
				}
			}
		}
		
		return sum;
	}
}
