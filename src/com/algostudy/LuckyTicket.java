package com.algostudy;

import java.io.*;

public class LuckyTicket {
	static char[] num;
	public static void main(String[] args) throws IOException {
		int max = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		num = in.readLine().toCharArray();
		int size = num.length;
		for (int i = 2; i <= size; i += 2) {
			int N = i / 2;
			for (int start = 0; start < size; start++) {
				if (i + start > size)
					break;
				int sumA = 0;
				int sumB = 0;
				for (int idx = 0; idx < N; idx++) {
					sumA += num[idx + start] - '0';
					sumB += num[idx + start + N] - '0';
				}
				if (sumA == sumB)
					max = Math.max(max, i);
			}
		}
		System.out.println(max);
	}
	
}
