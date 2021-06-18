package com.algostudy;

import java.io.*;
import java.util.StringTokenizer;

public class Bottle {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] num = new int[25];
		int idx = 0;
		if (K > 24)
			System.out.println(0);
		else {
			while (N > 0) {
				num[idx++] = N % 2;
				N /= 2;
			}
			int bottle = 0;
			while (true) {
				int temp = 0;
				boolean flag = false;
				int now = 0;
				for (int i = 0; i < 25; i++) {
					if (num[i] == 1)
						temp++;
					if (!flag && num[i] == 1) {
						flag = true;
						now = i;
					}
				}
				if (temp <= K)
					break;
				bottle += Math.pow(2, now);
				num[now] = 0;
				while (true) {
					num[++now] += 1;
					if (num[now] == 1) 
						break;
					num[now] = 0;
				}
			}
			System.out.println(bottle);
		}
	}
}
