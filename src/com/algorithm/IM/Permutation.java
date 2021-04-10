package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Permutation {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int[] temp = new int[N];
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++)
			temp[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N - K; i++) {
			int sum = 0;
			for (int j = i; j < i + K; j++) 
				sum += temp[j];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
