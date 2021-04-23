package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Magnetic {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			int K = Integer.parseInt(in.readLine());
			int[][] mag = new int[4][8];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 8; j++)
					mag[i][j] = Integer.parseInt(st.nextToken());
			}
			int sum = 0;
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int start = Integer.parseInt(st.nextToken()) - 1;
				int rot = Integer.parseInt(st.nextToken());
				int[] isRot = new int[4];
				isRot[start] = rot;
				for (int n = start; n < 3; n++) {
					if (mag[n][2] != mag[n + 1][6])
						isRot[n + 1] = isRot[n] * -1;
					else
						break;
				}
				if (start > 0 && mag[start][6] != mag[start - 1][2]) {
					isRot[start - 1] = isRot[start] * -1;
					for (int n = start - 1; n > 0; n--) {
						if (mag[n][6] != mag[n - 1][2])
							isRot[n - 1] = isRot[n] * -1;
						else
							break;
					}
				}
				for (int m = 0; m < 4; m++) {
					if (isRot[m] != 0) {
						if (isRot[m] == 1) {
							int temp = mag[m][0];
							int now = 0;
							for (int j = 0; j < 7; j++) {
								now = mag[m][j + 1];
								mag[m][j + 1] = temp;
								temp = now;
							}
							mag[m][0] = temp;
						} else if (isRot[m] == -1) {
							int temp = mag[m][7];
							int now = 0;
							for (int j = 7; j > 0; j--) {
								now = mag[m][j - 1];
								mag[m][j - 1] = temp;
								temp = now;
							}
							mag[m][7] = temp;
						}
					}
				}
			}
			for (int i = 0; i < 4; i++)
				sum += mag[i][0] * Math.pow(2, i);
			System.out.println("#" + test + " " + sum);
		}
	}
}
