package com.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GuGuDan {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] reverse = new int[K];
		for (int i = 1; i <= K; i++) {
			String s = Integer.toString(N * i);
			char[] temp = s.toCharArray();
			for (int j = 0; j < temp.length / 2; j++) {
				char t = temp[j];
				temp[j] = temp[temp.length - 1 - j];
				temp[temp.length - 1 - j] = t;
			}
			s = new String(temp);
			reverse[i - 1] = Integer.parseInt(s);
		}
		Arrays.sort(reverse);
		System.out.println(reverse[K - 1]);
	}
}
