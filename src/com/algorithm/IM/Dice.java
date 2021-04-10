package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Dice {
	static int N;
	static int[][] info;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		info = new int[N][6];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < 6; j++)
				info[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 6; i++) 
			calc(info[0][i], 0, new int[N]);
		System.out.println(max);
	}
	static void calc(int num, int cnt, int[] arr) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) 
				sum += arr[i];
			max = Math.max(max, sum);
			return ;
		}
		boolean[] flag = new boolean[6];
		int temp = 0;
		for (int i = 0; i < 6; i++) {
			if (info[cnt][i] == num) {
				switch (i) {
					case 0: {
						flag[i] = true;
						flag[5] = true;
						temp = info[cnt][5];
						break;
					}
					case 1: {
						flag[i] = true;
						flag[3] = true;
						temp = info[cnt][3];
						break;
					}
					case 2: {
						flag[i] = true;
						flag[4] = true;
						temp = info[cnt][4];
						break;
					}
					case 3: {
						flag[i] = true;
						flag[1] = true;
						temp = info[cnt][1];
						break;
					}
					case 4: {
						flag[i] = true;
						flag[2] = true;
						temp = info[cnt][2];
						break;
					}
					case 5: {
						flag[i] = true;
						flag[0] = true;
						temp = info[cnt][0];
						break;
					}
					default: break;
				}
				int tempMax = Integer.MIN_VALUE;
				for (int e = 0; e < 6; e++) 
					if (!flag[e])
						tempMax = Math.max(info[cnt][e], tempMax);
				arr[cnt] = tempMax;
				calc(temp, cnt + 1, arr);
				break;
			}
		}
	}
}
