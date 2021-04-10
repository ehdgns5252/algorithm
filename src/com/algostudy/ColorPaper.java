package com.algostudy;

import java.io.*;
import java.util.*;

public class ColorPaper {
	static int[][] map;
	static boolean[][] isColor;
	static int[] num = new int[5];
	static int min = Integer.MAX_VALUE;
	static List<Integer> xy = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		isColor = new boolean[10][10];
		boolean flag = true;
		for (int i = 0; i < 10; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					xy.add(j + i * 10);
					flag = false;
				}
			}
		}
		if (flag)
			System.out.println(0);
		else {
			find(0);
			if (min == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(min);
		}
	}

	static void find(int now) {
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			if (num[i] > 5) return;
		}
		if (now >= xy.size()) {
			int count = 0;
			boolean can = true;
			for (int i = 0; i < 5; i++) {
				if (num[i] > 5)
					can = false;
				count += num[i];
			}
			if (can)
				min = Math.min(min, count);
			return;
		}
		int y = xy.get(now) / 10;
		int x = xy.get(now) % 10;
		for (int n = 5; n >= 1; n--) {
				if (check(x, y, n)) {
					num[n - 1]++;
					make(x, y, n, true);
					find(now + 1);
					make(x, y, n, false);
					num[n - 1]--;
					flag = true;
				}
		}
		if (!flag) {
			find(now + 1);
		}
	}

	static boolean check(int x, int y, int size) {
		int nx = x + size;
		int ny = y + size;
		if (nx > 10 || ny > 10)
			return false;
		for (int i = y; i < ny; i++) {
			for (int j = x; j < nx; j++) {
				if (map[i][j] == 0 || isColor[i][j])
					return false;
			}
		}
		return true;
	}

	static void make(int x, int y, int size, boolean is) {
		int nx = x + size;
		int ny = y + size;
		for (int i = y; i < ny; i++) {
			for (int j = x; j < nx; j++) {
				isColor[i][j] = is;
			}
		}
	}

}
