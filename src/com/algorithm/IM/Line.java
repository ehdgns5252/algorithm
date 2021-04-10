package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Line {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] line = new int[N];
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int temp = line[num];
			int cnt = 0;
			for (int e = num; e < N - 1; e++) {
				cnt = line[e + 1];
				line[e + 1] = temp;
				temp = cnt;
			}
			line[num] = i + 1;
		}
		for (int i = N - 1; i >= 0; i--)
			sb.append(line[i] + " ");
		System.out.println(sb.toString());
	}
}
