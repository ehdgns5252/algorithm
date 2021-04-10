package com.algorithm.IM;

import java.io.*;
import java.util.Arrays;

public class Seven {
	static int[] h;
	static int[] answer = new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		h = new int[9];
		for (int i = 0; i < 9; i++) 
			h[i] = Integer.parseInt(in.readLine());
		Arrays.sort(h);
		com(0, new int[7], 0);
		for (int i = 0; i < 7; i++)
			System.out.println(answer[i]);
	}
	static void com(int cnt, int[] height, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += height[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++)
					answer[i] = height[i];
			}
			return ;
		}
		for  (int i = start; i < 9; i++) {
			height[cnt] = h[i];
			com(cnt + 1, height, i + 1);
		}
	}
}
