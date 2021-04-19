package com.algorithm.ct;

import java.io.*;
import java.util.StringTokenizer;

public class FindnCr {
	static int mod;
	static long[] fact;

	static long pow(long x, long p) {
		if (p == 0)
			return 1;
		long h = pow(x, p / 2);
		if (p % 2 == 0)
			return (h % mod) * (h % mod) % mod;
		else
			return (h * x % mod) * (h % mod) % mod;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			long n = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			mod = Integer.parseInt(st.nextToken());
			fact = new long[mod + 1];
			fact[0] = 1;
			for (int i = 1; i < fact.length; i++)
				fact[i] = (fact[i - 1] * i) % mod;

			long answer = 1;
			while (n > 0 && r > 0) {
				long N = n % mod;
				long R = r % mod;
				if (R > N) {
					answer = 0;
					break;
				}
				answer *= fact[(int) N] * pow(fact[(int) R] * fact[(int) (N - R)], mod - 2) % mod;
				answer %= mod;
				n /= mod;
				r /= mod;
			}
			System.out.println("#" + test + " " + answer);
		}
	}
}
