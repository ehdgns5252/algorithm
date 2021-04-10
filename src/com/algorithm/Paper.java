package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Paper {
	static int cut = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		char[][] paper = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				paper[i][j++] = st.nextToken().charAt(0);
			}
			
		}
		int result = isBlue(N, paper);
		System.out.println(cut);
		System.out.println(result);
	}

	static int isBlue(int N, char[][] paper) {
		if (N == 1) {
			if (paper[0][0] == '1')
				return 1;
			else {
				cut++;
				return 0;
			}
		}
		boolean flag = true;
		boolean have = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (paper[i][j] == '0') 
					flag = false;
				if (paper[i][j] == '1')
					have = true;
			}
		}
		if (!flag && have) {
			int x = N / 2;
			char[][] p1 = new char[x][x];
			char[][] p2 = new char[x][x];
			char[][] p3 = new char[x][x];
			char[][] p4 = new char[x][x];
			for (int c = 0; c < x; c++) {
				for (int l = 0; l < x; l++) {
					p1[c][l] = paper[c][l];
					p2[c][l] = paper[c][l + x];
					p3[c][l] = paper[c + x][l];
					p4[c][l] = paper[c + x][l + x];
				}
			}
			return isBlue(x, p1) + isBlue(x, p2) + isBlue(x, p3) + isBlue(x, p4);
		}
		if (!flag && !have) {
			cut++;
			return 0;
		}
		return 1;
	}

}
