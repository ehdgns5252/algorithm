package com.algostudy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RestArea {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] rest = new int[N + 1];
		int[] remain = new int[N + 1];
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		int[] temp = new int[N];
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(temp);
		for (int i = 0; i < N; i++) {
			if (i == 0) rest[i] = temp[i];
			else {
				rest[i] = temp[i] - temp[i - 1];
			}
		}
		rest[N] = L - temp[N - 1];
		for (int i = 0; i < M; i++) {
			int max = 0;
			int max_idx = 0;
			for (int j = 0; j < N + 1; j++) {
				int t = rest[j] / (remain[j] + 1);
				if (rest[j] % (remain[j] + 1) != 0)
					t += 1;
				if (max < t) {
					max = t;
					max_idx = j;
				}
			}
			remain[max_idx]++;
		}
		int max = 0;
		for (int i = 0; i < N + 1; i++) {
			int t = rest[i] / (remain[i] + 1);
			if (rest[i] % (remain[i] + 1) != 0)
				t += 1;
			max = Math.max(t, max);
		}
		System.out.println(max);
	}
}
