package com.algorithm.ct;

import java.io.*;
import java.util.StringTokenizer;

public class SW5604 {
	static long[] fact = new long[10];
	static long[] f = new long[16];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int i = 1; i < 10; i++) {
			fact[i] = fact[i - 1] + i;
		}
		f[0] = 0;
		for (int i = 1; i < 16; i++) {
			f[i] = fact[9] * (long) i * (long) Math.pow(10, i - 1);
		}
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			System.out.println("#" + test + " " + (sum(B) - sum((A - 1) >= 0 ? A - 1 : 0)));
		}
	}
	static long sum(long a) {
		if (a < 10) {
			return fact[(int)a];
		}
		long devider = 1;
		long temp = a;
		int idx = 0;
		while (temp >= 10) {
			temp /= 10;
			idx++;
		}
		for (int i = 0; i < idx; i++)
			devider *= 10;
		return temp * f[idx] + fact[(int)temp - 1] * devider + temp * (a % devider + 1) + sum(a % devider);
	}
}
