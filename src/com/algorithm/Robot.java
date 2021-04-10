package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Robot {
	static int[] dirX = { 0, 1, 0, -1 };
	static int[] dirY = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		int nowy = Integer.parseInt(st.nextToken());
		int nowx = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		if (arr[nowy][nowx] == 0) {
			count++;
			arr[nowy][nowx] = 2;
		}
		while (true) {
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				int temp = (cnt + 3) % 4;
				int ny = nowy + dirY[temp];
				int nx = nowx + dirX[temp];
				if (arr[ny][nx] == 1 || arr[ny][nx] == 2) {
					cnt = temp;
					continue;
				} else if (arr[ny][nx] == 0){
					flag = true;
					cnt = temp;
					arr[ny][nx] = 2;
					nowy = ny;
					nowx = nx;
					count++;
					break;
				}
			}
			if (!flag) {
				int ny = nowy - dirY[cnt];
				int nx = nowx - dirX[cnt];
				if (arr[ny][nx] == 1)
					break;
				else {
					nowy = ny;
					nowx = nx;
				}
			}
		}
		System.out.println(count);
	}
}
