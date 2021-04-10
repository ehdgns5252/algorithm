package com.algorithm.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Cham {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		int maxC = Integer.MIN_VALUE;
		int maxR = Integer.MIN_VALUE;
		int[][] info = new int[6][2];
		for (int i = 0; i < 6; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			if (n == 4 || n == 3) {
				maxC = Math.max(maxC, l);
			} else {
				maxR = Math.max(maxR, l);
			}
			info[i][0] = n;
			info[i][1] = l;
		}
		int cham = 0;
		for (int i = 0; i < 6; i++) {
			if (info[i][0] == 3 || info[i][0] == 4) {
				if (info[i][1] == maxC) {
					if (info[(i + 1) % 6][1] != maxR) {
						cham += info[(i + 1) % 6][1] * info[(i + 2) % 6][1];
						cham += info[(i + 3) % 6][1] * info[(i + 4) % 6][1];
						cham += info[(i + 1) % 6][1] * info[(i + 4) % 6][1];
					} else {
						cham += info[(i + 2) % 6][1] * info[(i + 3) % 6][1];
						cham += info[(i + 4) % 6][1] * info[(i + 5) % 6][1];
						cham += info[(i + 2) % 6][1] * info[(i + 5) % 6][1];
					}
					break;
				}
			}
		}
		cham *= K;
		System.out.println(cham);
	}
}
