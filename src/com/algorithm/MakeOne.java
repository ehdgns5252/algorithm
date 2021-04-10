package com.algorithm;

import java.io.*;

public class MakeOne {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N + 1];
		if (N == 1) {
			arr[1] = 0;
		}
		else if (N == 2) {
			arr[1] = 0;
			arr[2] = 1;
		} else {
			arr[1] = 0;
			arr[2] = 1;
			arr[3] = 1;
			if (N >= 4) {
				for (int i = 4; i < N + 1; i++) {
					int d3 = Integer.MAX_VALUE;
					int d2 = Integer.MAX_VALUE;
					int m1 = Integer.MAX_VALUE;
					if (i % 3 == 0) {
						d3 = arr[i / 3] + 1;
					}
					if (i % 2 == 0) {
						d2 = arr[i / 2] + 1;
					}
					m1 = arr[i - 1] + 1;
					arr[i] = Math.min(Math.min(d3, d2), m1);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(arr[N]);
		sb.append("\n");
		System.out.println(sb.toString());
	}
}
