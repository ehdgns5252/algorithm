package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Z {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] num = new int[1 << 15];
		int i = 4;
		num[0] = 0;
		num[1] = 1;
		num[2] = 4;
		num[3] = 5;
		while (i != (1 << 15)) {
			int index = 0;
			int temp = i / 2;
			int cnt = 0;
			while (temp != 0) {
				cnt++;
				temp /= 2;
			}
			i *= 2;
			for (int e = i / 2; e < i; e++) {
				if (index == 0)
					num[e] = num[index++] + 1 << (2 * cnt);
				else {
					num[e] = num[index++] + num[i/2];
				}
			}
		}
		System.out.println(num[r] * 2 + num[c]);
	}
	
}
