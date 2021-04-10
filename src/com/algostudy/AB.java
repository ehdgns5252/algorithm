package com.algostudy;

import java.io.*;


// pi[i]; ->> A를 B랑 비교

// B < A

// T(s)T == (T.len = pi[T.len + 1 + T.len]);

public class AB {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] A = in.readLine().toCharArray();
		char[] B = in.readLine().toCharArray();
		char[] ab = in.readLine().toCharArray();
		int[] pi = getPi(ab);
		int j = 0;
		int n1 = A.length;
		int n2 = B.length;
		int m = ab.length;
		boolean isA = false;
		boolean isB = false;
		
		for (int i = 0; i < n1; i++) {
			while (j > 0 && A[i] != ab[j])
				j = pi[j - 1];
			if (A[i] == ab[j])
				if (j == m - 1) {
					isA = true;
					break;
				} else 
					j++;
		}
		j = 0;
		for (int i = 0; i < n2; i++) {
			while (j > 0 && B[i] != ab[j])
				j = pi[j - 1];
			if (B[i] == ab[j])
				if (j == m - 1) {
					isB = true;
					break;
				} else 
					j++;
		}
		if (isA && isB)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static int[] getPi (char[] pattern) {
		int m = pattern.length;
		int j = 0;
		int[] pi = new int[m];
		for (int i = 1; i < m; i++) {
			while (j > 0 && pattern[i] != pattern[j])
				j = pi[j - 1];
			if (pattern[i] == pattern[j])
				pi[i] = ++j;
		}
		
		return pi;
	}
}
