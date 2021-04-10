package com.algorithm;

import java.io.*;

public class LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String A = in.readLine();
		String B = in.readLine();
		int n = A.length();
		int lcs = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i + 1; j++) {
				String temp = A.substring(j, j + i);
				System.out.println(temp);
				if (B.contains(temp))
					lcs = i;
			}
		}
		System.out.println(lcs);
	}
}
