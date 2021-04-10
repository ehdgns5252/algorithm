package com.algorithm;

import java.io.*;

public class Sultang {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int r = N / 5;
		int c = N / 3;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				int sum = 5 * i + 3 * j;
				if (sum == N) {
					if (min > i + j) 
						min = i + j;
				}
			}
		}
		System.out.println((min == Integer.MAX_VALUE)?-1:min);
		
	}
}
