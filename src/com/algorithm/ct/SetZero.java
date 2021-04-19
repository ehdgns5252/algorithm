package com.algorithm.ct;

import java.io.*;
import java.util.StringTokenizer;

public class SetZero {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(in.readLine());
			long[] l = new long[N];
			long max = 0;
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				long x = Integer.parseInt(st.nextToken());
				long y = Integer.parseInt(st.nextToken());
				l[i] = (long) Math.abs(x) + (long) Math.abs(y);
				max = Math.max(max, l[i]);
			}
			boolean flag = true;
			long cnt = l[0] % 2;
			for (int i = 0; i < N; i++) {
				if (cnt != l[i] % 2)
					flag = false;
			}
			if (flag) {
				long step = 0;
				while (true) {
					long count = step * (step + 1) / 2;
					if (max == count)
						break;
					else if (max > count) {
						step++;
					} else if (max < count) {
						if ((count - max) % 2 == 1) {
							while (true) {
								step++;
								count = step * (step + 1) / 2;
								if ((count - max) % 2 == 0)
									break;
							}
						}
						break;
					}
				}
				System.out.println("#" + test + " " + step);
			}
			else
				System.out.println("#" + test + " " + -1);
		}
	}
	
	
}
