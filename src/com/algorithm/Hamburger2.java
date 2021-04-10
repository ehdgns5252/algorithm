package com.algorithm;


import java.io.*;
import java.util.*;

public class Hamburger2 {
	static int[] ham;
	static int[] calorie;
	static boolean[] flag;
	static int L;
	static int N;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ham = new int[N];
			calorie = new int[N];
			flag = new boolean[N];
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				ham[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			com(0, 0, 0);
			System.out.println("#" + test + " " + max);
		}
	}

	static void com(int cnt, int sum, int cal) {
		if (cnt == N) {
			if (cal > L) return ;
			if (sum > max) max = sum;
			return ;
		}
		flag[cnt] = true;
		com(cnt + 1, sum + ham[cnt], cal + calorie[cnt]);
		flag[cnt] = false;
		com(cnt + 1, sum, cal);
	}
	
}

