package com.algorithm.ct;

import java.io.*;
import java.util.StringTokenizer;

public class Combination {
	static int mod = 1234567891;
	static long[] fact = new long[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++)
			fact[i] = (fact[i - 1] * i) % mod;
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			long n = Integer.parseInt(st.nextToken());
			long r = Integer.parseInt(st.nextToken());
//			if (r == 0)
//				System.out.println("#" + test + " " + 1);
//			else
				System.out.println("#" + test + " " + nCr(n, r));
		}
	}
	static long nCr(long n, long r) {
		long temp = fact[(int) n];
		long temp2 = fact[(int) (n - r)] * fact[(int) r] % mod;
		return (temp % mod) * (pow(temp2, mod - 2)) % mod;
	}
	static long pow(long x, long p) {
		if (p == 0)
			return 1;
		long h = pow(x, p / 2);
		if (p % 2 == 0)
			return (h % mod) * (h % mod) % mod;
		else
			return (h * x % mod) * (h % mod) % mod;
	}
}
