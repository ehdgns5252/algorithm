package com.algorithm;

import java.io.*;
import java.util.*;

public class GCD {
	static int N;
	static int[] arr;
	static long sum;
	static ArrayList<int[]> is = new ArrayList<int[]>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 0; test < T; test++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			sum = 0;
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			com(0, new int[2], 0);
			System.out.println(sum);
		}
	}

	static void com(int cnt, int[] num, int start) {
		if (cnt == 2) {
			for (int i = num[0]; i >= 1; i--) {
				if (num[0] % i == 0 && num[1] % i == 0) {
					sum += i;
					return;
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			num[cnt] = arr[i];
			com(cnt + 1, num, i + 1);
		}
	}
}
