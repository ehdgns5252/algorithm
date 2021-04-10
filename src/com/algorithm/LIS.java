package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class LIS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int[] num = new int[N];
			for (int i =0; i < N; i++)
				num[i] = Integer.parseInt(st.nextToken());
			int[] lis = new int[N];
			lis[0] = 1;
			for (int i = 0; i < N; i ++) {
				int max = 0;
				for (int j =0; j < i; j++) {
					if (num[i] > num[j]) {
						if (lis[j] > max)
							max = lis[j];
					}
				}
				lis[i] = max + 1;
			}
			int max = 0;
			for (int i = 0; i < N; i++) {
				max = Math.max(max, lis[i]);
			}
			System.out.println("#" + test + " " + max);
		}
	}
}
