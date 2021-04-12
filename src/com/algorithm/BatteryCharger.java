package com.algorithm;

import java.io.*;
import java.util.*;

public class BatteryCharger {
	static int[] dirX = { 0, 0, 1, 0, -1 };
	static int[] dirY = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[][] BC = new int[A][4];
			int[][] map = new int[10][10];
			int[][] root = new int[2][M + 1];
			for (int i = 0; i < 2; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				for (int j = 1; j <= M; j++)
					root[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				for (int j = 0; j < 4; j++)
					BC[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(BC, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o2[3] - o1[3];
				}
			});
			int ax = 0;
			int ay = 0;
			int bx = 9;
			int by = 9;
			int sum = 0;
			for (int i = 0; i <= M; i++) {
				ax += dirX[root[0][i]];
				ay += dirY[root[0][i]];
				bx += dirX[root[1][i]];
				by += dirY[root[1][i]];
				ArrayList<int[]> alist = new ArrayList<int[]>();
				ArrayList<int[]> blist = new ArrayList<int[]>();
				for (int a = 0; a < A; a++) {
					int BCx = BC[a][0] - 1;
					int BCy = BC[a][1] - 1;
					int aToBC = Math.abs(ax - BCx) + Math.abs(ay - BCy);
					int bToBC = Math.abs(bx - BCx) + Math.abs(by - BCy);
					if (aToBC <= BC[a][2])
						alist.add(BC[a]);
					if (bToBC <= BC[a][2])
						blist.add(BC[a]);
				}
				int[] afirst = null;
				int[] bfirst = null;
				if (!alist.isEmpty()) {
					afirst = alist.get(0);
				}
				if (!blist.isEmpty()) {
					bfirst = blist.get(0);
				}
				if (afirst != null || bfirst != null) {
					if (afirst != null && bfirst != null) {
						if (isSame(afirst, bfirst)) {
							if (alist.size() > 1 && blist.size() > 1) {
								int anext = alist.get(1)[3];
								int bnext = blist.get(1)[3];
								sum += afirst[3];
								sum += Math.max(anext, bnext);
							} else if (alist.size() > 1 && blist.size() == 1) {
								int anext = alist.get(1)[3];
								sum += anext;
								sum += bfirst[3];
							} else if (blist.size() > 1 && alist.size() == 1) {
								int bnext = blist.get(1)[3];
								sum += bnext;
								sum += afirst[3];
							} else if (alist.size() == 1 && blist.size() == 1) {
								sum += afirst[3];
							}
						} else {
							sum += afirst[3];
							sum += bfirst[3];
						}
					} else if (afirst != null && bfirst == null) {
						sum += afirst[3];
					} else if (bfirst != null && afirst == null) {
						sum += bfirst[3];
					}
				}
			}
			System.out.println("#" + test + " " + sum);
		}
	}

	static boolean isSame(int[] A, int[] B) {
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (A[i] != B[i]) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
