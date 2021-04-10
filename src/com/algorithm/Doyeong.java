package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Doyeong {
	static int[][] info;
	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		info = new int[N][2];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		cook(0, new boolean[N]);
		System.out.println(min);
	}

	static void cook(int cnt, boolean[] food) {
		if (cnt == N) {
			boolean flag = false;
			for (int i = 0 ; i < N; i++) {
				if(food[i])
					flag = true;
			}
			if (!flag) return ;
			int sour = 1;
			int bitter = 0;
			for (int i = 0; i < N; i++) {
				if (food[i]) {
					sour *= info[i][0];
					bitter += info[i][1];
				}
			}
			int temp = Math.abs((sour - bitter));
			if (min > temp)
				min = temp;
			return ;
		}
		food[cnt] = true;
		cook(cnt + 1, food);
		food[cnt] = false;
		cook(cnt + 1, food);
		
	}
}
