package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class Floyd {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		int[][] bus = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++)
			for (int j = 1; j < n + 1; j++)
					bus[i][j] = 100000000;
		for (int i = 0; i < m; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			bus[start][end] = Math.min(value, bus[start][end]);
		}
		int[][] answer = new int[n][n + 1];

		for (int i = 0; i < n; i++) {
			int[] start = new int[n + 1];
			for (int temp = 0; temp < n + 1; temp++)
				start[temp] = bus[i + 1][temp];
			boolean[] isVisit = new boolean[n + 1];
			isVisit[0] = true;
			isVisit[i + 1] = true;
			for (int idx = 1; idx < n + 1; idx++) {
				int min = 100000000;
				int min_idx = 1;
				for (int j = 1; j < n + 1; j++) {
					if (!isVisit[j] && min > start[j] && start[j] != 100000000) {
						min = start[j];
						min_idx = j;
					}
				}
				isVisit[min_idx] = true;
				for (int j = 1; j < n + 1; j++) {
					if (bus[min_idx][j] != 100000000 && start[j] > bus[min_idx][j] + start[min_idx] && j != i + 1)
						start[j] = bus[min_idx][j] + start[min_idx];
				}
			}
			for (int temp = 0; temp < n + 1; temp++)
				answer[i][temp] = start[temp];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (answer[i][j] == 100000000)
					answer[i][j] = 0;
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}
}
