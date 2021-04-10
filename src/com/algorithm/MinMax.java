package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class MinMax {
	static int[] arr;
	static int N;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		per(0, new int[N], new boolean[N]);
		System.out.println(max);
	}
	static void per(int cnt, int[] num, boolean[] isVisit) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(num[i] - num[i + 1]);
			}
			if (max < sum) max = sum;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				num[cnt] = arr[i];
				per(cnt + 1, num, isVisit);
				isVisit[i] = false;
			}
		}
	}
}
