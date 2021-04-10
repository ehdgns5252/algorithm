package com.algorithm;

import java.io.*;
import java.util.*;

public class Process2 {
	static int max;
	static int min;
	static int totalCnt;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int N;
	static List<int[]>list;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			list= new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
							list.add(new int[] {i, j});
							totalCnt++;
						}
					}
				}
			}
			go(0, 0);
			System.out.println("#" + test + " " + min);
		}
	}
	
	static void go(int index, int cCnt) {
		if (index == totalCnt) {
			int res = getLength();
			
			if (max < cCnt) {
				max = cCnt;
				min = res;
			} else if (max == cCnt) {
				min = Math.min(min, res);
			}
			return ;
		}
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		for (int d = 0; d < 4; d++) {
			if (isAvilable(r, c, d)) {
				setStatus(r, c, d, 2);
				go(index + 1, cCnt + 1);
				setStatus(r, c, d, 0);
			}
		}
		
		go(index + 1, cCnt);
	}
	
	static void setStatus(int r, int c, int d, int n) {
		int nr = r;
		int nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			map[nr][nc] = n;
		}
	}
	static boolean isAvilable(int r, int c, int d) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			if (map[nr][nc] >= 1) return false;
		}
		return true;
	}
	
	static int getLength() {
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0 ; j < N; j++) {
				if (map[i][j] == 2) lCnt++;
			}
		}
		return lCnt;
	}
}
