package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Seat {
	static int[] dirX = {0, 1, 0, -1};
	static int[] dirY = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());
		int[][] arr = new int[R][C];
		int nx = 0;
		int ny = R - 1;
		int count = 1;
		int cnt = 0;
		arr[ny][nx] = 1;
		if (K > R * C) {
			System.out.println(0);
			return ;
		}
		if (K == 1) {
			System.out.println("1 1");
			return ;
		}
		while (true) {
			nx = nx + dirX[cnt];
			ny = ny + dirY[cnt];
			if (nx >= C || nx < 0 || ny >= R || ny < 0) {
				nx -= dirX[cnt];
				ny -= dirY[cnt];
				cnt++;
				if (cnt == 4) cnt = 0;
				continue;
			}
			if (arr[ny][nx] != 0) {
				nx -= dirX[cnt];
				ny -= dirY[cnt];
				cnt++;
				if (cnt == 4) cnt = 0;
				continue;
			}
			arr[ny][nx] = ++count;
			if (count == K) {
				System.out.println((nx + 1) + " " + (R - ny));
				break;
			}
		}
	}
}
