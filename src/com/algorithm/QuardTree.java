package com.algorithm;

import java.io.*;

public class QuardTree {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] str = in.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str[j] - '0';
			}
		}
		quard(arr, N);
		System.out.println(sb.toString());
	}
	static void quard(int[][] map, int n) {
		if (n == 1) {
			sb.append(map[0][0]);
			return ;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0) {
			sb.append("0");
		}
		else if (sum == n * n){
			sb.append("1");
		} else {
			int t = n / 2;
			int[][] map1 = new int[t][t];
			int[][] map2 = new int[t][t];
			int[][] map3 = new int[t][t];
			int[][] map4 = new int[t][t];
			for (int i = 0; i < t; i++) {
				for (int j = 0; j < t; j++) {
					map1[i][j] = map[i][j];
					map2[i][j] = map[i][j + t];
					map3[i][j] = map[i + t][j];
					map4[i][j] = map[i + t][j + t];
				}
			}
			sb.append("(");
			quard(map1, t);
			quard(map2, t);
			quard(map3, t);
			quard(map4, t);
			sb.append(")");
		}
	}
}
