package com.algostudy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CutRock {
	static int N;
	static ArrayList<int[]> jewelry;
	static ArrayList<int[]> cut;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		jewelry = new ArrayList<int[]>();
		cut = new ArrayList<int[]>();
		for (int i = 0 ; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cut.add(new int[] {j, i});
				else if (map[i][j] == 2)
					jewelry.add(new int[] {j, i});
			}
		}
		if (jewelry.size() - 1 == cut.size()) {
			
		} else
			System.out.println(-1);
	}
	static void per(int index, int[] num, boolean[] isVisit) {
		if (index == N / 2) {
			for (int i = 0; i < N; i++) {
				
			}
			return ;
		}
		for (int i = 0; i < N; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				num[index] = i;
				per(index + 1, num, isVisit);
				isVisit[i] = false;
			}
		}
	}
}
