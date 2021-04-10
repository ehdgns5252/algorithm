package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class Bus {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int[][] map = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++)
			for (int j = 0; j < N + 1; j++)
				map[i][j] = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if (map[start][end] > value)
				map[start][end] = value;
		}
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] startmap = map[start];
		boolean[] isVisit = new boolean[N + 1];
		isVisit[start] = true;
		for (int i = 1; i < N + 1; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 1;
			for (int j = 1; j < N + 1; j++) {
				if (startmap[j] != Integer.MAX_VALUE && startmap[j] < min && !isVisit[j]) {
					min = startmap[j];
					minIndex = j;
				}
			}
			isVisit[minIndex] = true;
			if (isVisit[end])
				break;
			for (int j = 1; j < N + 1; j++) {
				if (min != Integer.MAX_VALUE && map[minIndex][j] != Integer.MAX_VALUE) {
					if (startmap[j] > map[minIndex][j] + startmap[minIndex])
						startmap[j] = map[minIndex][j] + startmap[minIndex];

				}
			}
		}
		System.out.println(startmap[end]);
	}
}
