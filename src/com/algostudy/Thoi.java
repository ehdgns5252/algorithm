package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class Thoi {
	static int N;
	static int max = 0;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		find(1 + arr[1][0], arr[1][1]);
		find(1, 0);
		System.out.println(max);
	}
	static void find(int cnt, int sum) {
		if (cnt > N + 1)
			return ;
		if (cnt == N + 1) {
			max = Math.max(max, sum);
			return ;
		}
		find(cnt + 1, sum);
		find (cnt + arr[cnt][0], sum + arr[cnt][1]);
	}
}
