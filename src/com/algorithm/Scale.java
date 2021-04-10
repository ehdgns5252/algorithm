package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Scale {
	static int[] scale;
	static int N;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			scale = new int[N];
			count = 0;
			for (int i = 0 ; i < N; i++) {
				scale[i] = Integer.parseInt(st.nextToken());
			}
			calc(0, new int[N], new boolean[N]);
			System.out.println("#" + test + " " + count);
		}
	}
	static void calc(int cnt, int[] num, boolean[] is) {
		if (cnt == N) {
			isOn(0, num, 0, 0);
			return ;
		}
		for (int i = 0; i < N; i++) {
			if (!is[i]) {
				is[i] = true;
				num[cnt] = scale[i];
				calc(cnt + 1, num, is);
				is[i] = false;
			}
		}
	}
	static void isOn(int cnt, int[] num, int wl, int wr) {
		if (wl < wr) return;
		if (cnt == N) {
			if (wl >= wr)
				count++;
			return ;
		}
		isOn(cnt + 1, num, wl + num[cnt], wr);
		isOn(cnt + 1, num, wl, wr + num[cnt]);
	}
}
