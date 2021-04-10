package com.algorithm;

import java.io.*;
import java.util.*;

public class Tomato {
	static int[][][] box;
	static int[] dirX = { 0, 0, -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, 0, 0, -1, 1 };
	static int[] dirZ = { -1, 1, 0, 0, 0, 0 };
	static int M;
	static int N;
	static int H;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		Queue<int[]> find = new LinkedList<int[]>();
		box = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1)
						find.offer(new int[] { i, j, k });
				}
			}
		}
		int count = 0;
		boolean flag = true;
		for (; count < M * N * H / 2; count++) {
			flag = true;
			
			int n = 0;
			int[][] temp = new int[find.size()][3];
			while (!find.isEmpty()) {
				temp[n++] = find.poll();
			}
			for (int t = 0; t < n; t++) {
				int i = temp[t][0];
				int j = temp[t][1];
				int k = temp[t][2];
				for (int cnt = 0; cnt < 6; cnt++) {
					int nz = i + dirZ[cnt];
					int ny = j + dirY[cnt];
					int nx = k + dirX[cnt];
					if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M)
						continue;
					if (box[nz][ny][nx] == 0) {
						flag = false;
						box[nz][ny][nx] = 1;
						find.offer(new int[] {nz, ny, nx});
					}
				}
			}
			if (flag)
				break;
		}
		if(flag) {
			flag = isTomato();
			if (flag)
				System.out.println(count);
			else
				System.out.println(-1);
		}
	}

	static boolean isTomato() {
		boolean flag = true;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0)
						flag = false;
				}
			}
		}
		return flag;
	}
}
