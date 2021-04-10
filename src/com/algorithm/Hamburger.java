package com.algorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Hamburger {
	static int[] ham;
	static int[] calorie;
	static boolean[] flag;
	static Stack<Integer> sum;
	static int L;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ham = new int[N];
			calorie = new int[N];
			flag = new boolean[N];
			sum = new Stack<Integer>();
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				ham[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}
			com(0);
			int max = 0;
			while (!sum.isEmpty()) {
				int temp = sum.pop();
				if (temp >= max)
					max = temp;
			}
			System.out.println("#" + test + " " + max);
		}
	}

	static void com(int cnt) {
		if (cnt == N) {
			int temp = 0;
			int taste = 0;
			for (int i = 0; i < N; i++) {
				if (flag[i]) {
					temp += calorie[i];
					taste += ham[i];
				}
			}
			if (temp > L) return ;
			sum.push(taste);
			return ;
		}
		flag[cnt] = true;
		com(cnt + 1);
		flag[cnt] = false;
		com(cnt + 1);
	}
}
