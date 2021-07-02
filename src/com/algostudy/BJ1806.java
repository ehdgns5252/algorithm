package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (end = 0; end < N; end++) {
			if (sum < S) {
				sum += num[end];
			} else {
				end --;
				min = Math.min(min, end - start + 1);
				sum -= num[start++];
			}
		}
		if (sum >= S) {
			do {
				min = Math.min(min, end - start);
				sum -= num[start++];
			} while (sum >= S);
		}
		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}
}
